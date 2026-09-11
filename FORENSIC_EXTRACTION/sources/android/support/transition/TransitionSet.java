package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mCurrentListeners;
    private boolean mPlayTogether;
    private boolean mStarted;
    private ArrayList<Transition> mTransitions;

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet.access$106(this.mTransitionSet);
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            if (this.mTransitionSet.mStarted) {
                return;
            }
            this.mTransitionSet.start();
            this.mTransitionSet.mStarted = true;
        }
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    static /* synthetic */ int access$106(TransitionSet transitionSet) {
        int i = transitionSet.mCurrentListeners - 1;
        transitionSet.mCurrentListeners = i;
        return i;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(i);
            }
            this.mTransitions.get(i3).addTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(view);
            }
            this.mTransitions.get(i2).addTarget(view);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(cls);
            }
            this.mTransitions.get(i2).addTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(str);
            }
            this.mTransitions.get(i2).addTarget(str);
            i = i2 + 1;
        }
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        return this;
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).cancel();
        }
    }

    @Override // android.support.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            for (Transition transition : this.mTransitions) {
                if (transition.isValidTarget(transitionValues.view)) {
                    transition.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).capturePropagationValues(transitionValues);
        }
    }

    @Override // android.support.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            for (Transition transition : this.mTransitions) {
                if (transition.isValidTarget(transitionValues.view)) {
                    transition.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: clone */
    public Transition mo0clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo0clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSet.addTransition(this.mTransitions.get(i).mo0clone());
        }
        return transitionSet;
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.mTransitions.get(i);
            if (startDelay > 0 && (this.mPlayTogether || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return super.excludeTarget(i, z);
            }
            this.mTransitions.get(i3).excludeTarget(i, z);
            i2 = i3 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(view, z);
            }
            this.mTransitions.get(i2).excludeTarget(view, z);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class cls, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(cls, z);
            }
            this.mTransitions.get(i2).excludeTarget(cls, z);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(str, z);
            }
            this.mTransitions.get(i2).excludeTarget(str, z);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ? 0 : 1;
    }

    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).pause(view);
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(i);
            }
            this.mTransitions.get(i3).removeTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(view);
            }
            this.mTransitions.get(i2).removeTarget(view);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(cls);
            }
            this.mTransitions.get(i2).removeTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(str);
            }
            this.mTransitions.get(i2).removeTarget(str);
            i = i2 + 1;
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).resume(view);
        }
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                break;
            }
            this.mTransitions.get(i2 - 1).addListener(new TransitionListenerAdapter(this, this.mTransitions.get(i2)) { // from class: android.support.transition.TransitionSet.1
                final TransitionSet this$0;
                final Transition val$nextTransition;

                {
                    this.this$0 = this;
                    this.val$nextTransition = transition;
                }

                @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    this.val$nextTransition.runAnimators();
                    transition.removeListener(this);
                }
            });
            i = i2 + 1;
        }
        Transition transition = this.mTransitions.get(0);
        if (transition != null) {
            transition.runAnimators();
        }
    }

    @Override // android.support.transition.Transition
    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setCanRemoveViews(z);
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // android.support.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
        switch (i) {
            case 0:
                this.mPlayTogether = true;
                return this;
            case 1:
                this.mPlayTogether = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    @Override // android.support.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return;
            }
            this.mTransitions.get(i2).setPathMotion(pathMotion);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    @Override // android.support.transition.Transition
    String toString(String str) {
        String string = super.toString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return string;
            }
            string = string + "\n" + this.mTransitions.get(i2).toString(str + "  ");
            i = i2 + 1;
        }
    }
}
