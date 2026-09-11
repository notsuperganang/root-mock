package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionsMenu extends ViewGroup {
    private static final int ANIMATION_DURATION = 300;
    private static final float COLLAPSED_PLUS_ROTATION = 0.0f;
    private static final float EXPANDED_PLUS_ROTATION = 135.0f;
    public static final int EXPAND_DOWN = 1;
    public static final int EXPAND_LEFT = 2;
    public static final int EXPAND_RIGHT = 3;
    public static final int EXPAND_UP = 0;
    public static final int LABELS_ON_LEFT_SIDE = 0;
    public static final int LABELS_ON_RIGHT_SIDE = 1;
    private AddFloatingActionButton mAddButton;
    private int mAddButtonColorNormal;
    private int mAddButtonColorPressed;
    private int mAddButtonPlusColor;
    private int mAddButtonSize;
    private boolean mAddButtonStrokeVisible;
    private int mButtonSpacing;
    private int mButtonsCount;
    private AnimatorSet mCollapseAnimation;
    private AnimatorSet mExpandAnimation;
    private int mExpandDirection;
    private boolean mExpanded;
    private int mLabelsMargin;
    private int mLabelsPosition;
    private int mLabelsStyle;
    private int mLabelsVerticalOffset;
    private OnFloatingActionsMenuUpdateListener mListener;
    private int mMaxButtonHeight;
    private int mMaxButtonWidth;
    private RotatingDrawable mRotatingDrawable;
    private TouchDelegateGroup mTouchDelegateGroup;
    private static Interpolator sExpandInterpolator = new OvershootInterpolator();
    private static Interpolator sCollapseInterpolator = new DecelerateInterpolator(3.0f);
    private static Interpolator sAlphaExpandInterpolator = new DecelerateInterpolator();

    public interface OnFloatingActionsMenuUpdateListener {
        void onMenuCollapsed();

        void onMenuExpanded();
    }

    public FloatingActionsMenu(Context context) {
        this(context, null);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExpandAnimation = new AnimatorSet().setDuration(300L);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300L);
        init(context, attributeSet);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExpandAnimation = new AnimatorSet().setDuration(300L);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300L);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mButtonSpacing = (int) ((getResources().getDimension(R.dimen.fab_actions_spacing) - getResources().getDimension(R.dimen.fab_shadow_radius)) - getResources().getDimension(R.dimen.fab_shadow_offset));
        this.mLabelsMargin = getResources().getDimensionPixelSize(R.dimen.fab_labels_margin);
        this.mLabelsVerticalOffset = getResources().getDimensionPixelSize(R.dimen.fab_shadow_offset);
        this.mTouchDelegateGroup = new TouchDelegateGroup(this);
        setTouchDelegate(this.mTouchDelegateGroup);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionsMenu, 0, 0);
        this.mAddButtonPlusColor = typedArrayObtainStyledAttributes.getColor(3, getColor(android.R.color.white));
        this.mAddButtonColorNormal = typedArrayObtainStyledAttributes.getColor(1, getColor(R.color.colorPrimary));
        this.mAddButtonColorPressed = typedArrayObtainStyledAttributes.getColor(0, getColor(R.color.colorPrimaryDark));
        this.mAddButtonSize = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.mAddButtonStrokeVisible = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.mExpandDirection = typedArrayObtainStyledAttributes.getInt(7, 0);
        this.mLabelsStyle = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.mLabelsPosition = typedArrayObtainStyledAttributes.getInt(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (this.mLabelsStyle != 0 && expandsHorizontally()) {
            throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
        }
        createAddButton(context);
    }

    public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener) {
        this.mListener = onFloatingActionsMenuUpdateListener;
    }

    private boolean expandsHorizontally() {
        return this.mExpandDirection == 2 || this.mExpandDirection == 3;
    }

    private static class RotatingDrawable extends LayerDrawable {
        private float mRotation;

        public RotatingDrawable(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.mRotation, getBounds().centerX(), getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }
    }

    private void createAddButton(Context context) {
        this.mAddButton = new AddFloatingActionButton(context) { // from class: android.support.design.widget.FloatingActionsMenu.1
            @Override // android.support.design.widget.FloatingActionButtons
            void updateBackground() {
                this.mPlusColor = FloatingActionsMenu.this.mAddButtonPlusColor;
                this.mColorNormal = FloatingActionsMenu.this.mAddButtonColorNormal;
                this.mColorPressed = FloatingActionsMenu.this.mAddButtonColorPressed;
                this.mStrokeVisible = FloatingActionsMenu.this.mAddButtonStrokeVisible;
                super.updateBackground();
            }

            @Override // android.support.design.widget.AddFloatingActionButton, android.support.design.widget.FloatingActionButtons
            Drawable getIconDrawable() {
                RotatingDrawable rotatingDrawable = new RotatingDrawable(super.getIconDrawable());
                FloatingActionsMenu.this.mRotatingDrawable = rotatingDrawable;
                OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", FloatingActionsMenu.EXPANDED_PLUS_ROTATION, 0.0f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", 0.0f, FloatingActionsMenu.EXPANDED_PLUS_ROTATION);
                objectAnimatorOfFloat.setInterpolator(overshootInterpolator);
                objectAnimatorOfFloat2.setInterpolator(overshootInterpolator);
                FloatingActionsMenu.this.mExpandAnimation.play(objectAnimatorOfFloat2);
                FloatingActionsMenu.this.mCollapseAnimation.play(objectAnimatorOfFloat);
                return rotatingDrawable;
            }
        };
        this.mAddButton.setId(R.id.fab_expand_menu_button);
        this.mAddButton.setSize(this.mAddButtonSize);
        this.mAddButton.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.FloatingActionsMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FloatingActionsMenu.this.toggle();
            }
        });
        addView(this.mAddButton, super.generateDefaultLayoutParams());
        this.mButtonsCount++;
    }

    public void addButton(FloatingActionButtons floatingActionButtons) {
        addView(floatingActionButtons, this.mButtonsCount - 1);
        this.mButtonsCount++;
        if (this.mLabelsStyle != 0) {
            createLabels();
        }
    }

    public void removeButton(FloatingActionButtons floatingActionButtons) {
        removeView(floatingActionButtons.getLabelView());
        removeView(floatingActionButtons);
        floatingActionButtons.setTag(R.id.fab_label, null);
        this.mButtonsCount--;
    }

    private int getColor(@ColorRes int i) {
        return getResources().getColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        TextView textView;
        measureChildren(i, i2);
        this.mMaxButtonWidth = 0;
        this.mMaxButtonHeight = 0;
        int iMax = 0;
        int iAdjustForOvershoot = 0;
        int iAdjustForOvershoot2 = 0;
        for (int i3 = 0; i3 < this.mButtonsCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                switch (this.mExpandDirection) {
                    case 0:
                    case 1:
                        this.mMaxButtonWidth = Math.max(this.mMaxButtonWidth, childAt.getMeasuredWidth());
                        iAdjustForOvershoot += childAt.getMeasuredHeight();
                        break;
                    case 2:
                    case 3:
                        iAdjustForOvershoot2 += childAt.getMeasuredWidth();
                        this.mMaxButtonHeight = Math.max(this.mMaxButtonHeight, childAt.getMeasuredHeight());
                        break;
                }
                if (!expandsHorizontally() && (textView = (TextView) childAt.getTag(R.id.fab_label)) != null) {
                    iMax = Math.max(iMax, textView.getMeasuredWidth());
                }
            }
        }
        if (!expandsHorizontally()) {
            iAdjustForOvershoot2 = this.mMaxButtonWidth + (iMax > 0 ? iMax + this.mLabelsMargin : 0);
        } else {
            iAdjustForOvershoot = this.mMaxButtonHeight;
        }
        switch (this.mExpandDirection) {
            case 0:
            case 1:
                iAdjustForOvershoot = adjustForOvershoot((this.mButtonSpacing * (this.mButtonsCount - 1)) + iAdjustForOvershoot);
                break;
            case 2:
            case 3:
                iAdjustForOvershoot2 = adjustForOvershoot((this.mButtonSpacing * (this.mButtonsCount - 1)) + iAdjustForOvershoot2);
                break;
        }
        setMeasuredDimension(iAdjustForOvershoot2, iAdjustForOvershoot);
    }

    private int adjustForOvershoot(int i) {
        return (i * 12) / 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int i6;
        int measuredHeight;
        int measuredWidth2;
        switch (this.mExpandDirection) {
            case 0:
            case 1:
                boolean z2 = this.mExpandDirection == 0;
                if (z) {
                    this.mTouchDelegateGroup.clearTouchDelegates();
                }
                int measuredHeight2 = z2 ? (i4 - i2) - this.mAddButton.getMeasuredHeight() : 0;
                if (this.mLabelsPosition == 0) {
                    i5 = (i3 - i) - (this.mMaxButtonWidth / 2);
                } else {
                    i5 = this.mMaxButtonWidth / 2;
                }
                int measuredWidth3 = i5 - (this.mAddButton.getMeasuredWidth() / 2);
                this.mAddButton.layout(measuredWidth3, measuredHeight2, this.mAddButton.getMeasuredWidth() + measuredWidth3, this.mAddButton.getMeasuredHeight() + measuredHeight2);
                int i7 = (this.mMaxButtonWidth / 2) + this.mLabelsMargin;
                if (this.mLabelsPosition == 0) {
                    i6 = i5 - i7;
                } else {
                    i6 = i5 + i7;
                }
                if (z2) {
                    measuredHeight = measuredHeight2 - this.mButtonSpacing;
                } else {
                    measuredHeight = this.mAddButton.getMeasuredHeight() + measuredHeight2 + this.mButtonSpacing;
                }
                for (int i8 = this.mButtonsCount - 1; i8 >= 0; i8--) {
                    View childAt = getChildAt(i8);
                    if (childAt != this.mAddButton && childAt.getVisibility() != 8) {
                        int measuredWidth4 = i5 - (childAt.getMeasuredWidth() / 2);
                        int measuredHeight3 = z2 ? measuredHeight - childAt.getMeasuredHeight() : measuredHeight;
                        childAt.layout(measuredWidth4, measuredHeight3, childAt.getMeasuredWidth() + measuredWidth4, childAt.getMeasuredHeight() + measuredHeight3);
                        float f = measuredHeight2 - measuredHeight3;
                        childAt.setTranslationY(this.mExpanded ? 0.0f : f);
                        childAt.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.mCollapseDir.setFloatValues(0.0f, f);
                        layoutParams.mExpandDir.setFloatValues(f, 0.0f);
                        layoutParams.setAnimationsTarget(childAt);
                        View view = (View) childAt.getTag(R.id.fab_label);
                        if (view != null) {
                            if (this.mLabelsPosition == 0) {
                                measuredWidth2 = i6 - view.getMeasuredWidth();
                            } else {
                                measuredWidth2 = view.getMeasuredWidth() + i6;
                            }
                            int i9 = this.mLabelsPosition == 0 ? measuredWidth2 : i6;
                            if (this.mLabelsPosition == 0) {
                                measuredWidth2 = i6;
                            }
                            int measuredHeight4 = (measuredHeight3 - this.mLabelsVerticalOffset) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                            view.layout(i9, measuredHeight4, measuredWidth2, view.getMeasuredHeight() + measuredHeight4);
                            this.mTouchDelegateGroup.addTouchDelegate(new TouchDelegate(new Rect(Math.min(measuredWidth4, i9), measuredHeight3 - (this.mButtonSpacing / 2), Math.max(measuredWidth4 + childAt.getMeasuredWidth(), measuredWidth2), childAt.getMeasuredHeight() + measuredHeight3 + (this.mButtonSpacing / 2)), childAt));
                            view.setTranslationY(this.mExpanded ? 0.0f : f);
                            view.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                            layoutParams2.mCollapseDir.setFloatValues(0.0f, f);
                            layoutParams2.mExpandDir.setFloatValues(f, 0.0f);
                            layoutParams2.setAnimationsTarget(view);
                        }
                        if (z2) {
                            measuredHeight = measuredHeight3 - this.mButtonSpacing;
                        } else {
                            measuredHeight = childAt.getMeasuredHeight() + measuredHeight3 + this.mButtonSpacing;
                        }
                    }
                }
                break;
            case 2:
            case 3:
                boolean z3 = this.mExpandDirection == 2;
                int measuredWidth5 = z3 ? (i3 - i) - this.mAddButton.getMeasuredWidth() : 0;
                int measuredHeight5 = ((i4 - i2) - this.mMaxButtonHeight) + ((this.mMaxButtonHeight - this.mAddButton.getMeasuredHeight()) / 2);
                this.mAddButton.layout(measuredWidth5, measuredHeight5, this.mAddButton.getMeasuredWidth() + measuredWidth5, this.mAddButton.getMeasuredHeight() + measuredHeight5);
                if (z3) {
                    measuredWidth = measuredWidth5 - this.mButtonSpacing;
                } else {
                    measuredWidth = this.mAddButton.getMeasuredWidth() + measuredWidth5 + this.mButtonSpacing;
                }
                for (int i10 = this.mButtonsCount - 1; i10 >= 0; i10--) {
                    View childAt2 = getChildAt(i10);
                    if (childAt2 != this.mAddButton && childAt2.getVisibility() != 8) {
                        int measuredWidth6 = z3 ? measuredWidth - childAt2.getMeasuredWidth() : measuredWidth;
                        int measuredHeight6 = ((this.mAddButton.getMeasuredHeight() - childAt2.getMeasuredHeight()) / 2) + measuredHeight5;
                        childAt2.layout(measuredWidth6, measuredHeight6, childAt2.getMeasuredWidth() + measuredWidth6, childAt2.getMeasuredHeight() + measuredHeight6);
                        float f2 = measuredWidth5 - measuredWidth6;
                        childAt2.setTranslationX(this.mExpanded ? 0.0f : f2);
                        childAt2.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                        LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                        layoutParams3.mCollapseDir.setFloatValues(0.0f, f2);
                        layoutParams3.mExpandDir.setFloatValues(f2, 0.0f);
                        layoutParams3.setAnimationsTarget(childAt2);
                        if (z3) {
                            measuredWidth = measuredWidth6 - this.mButtonSpacing;
                        } else {
                            measuredWidth = childAt2.getMeasuredWidth() + measuredWidth6 + this.mButtonSpacing;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(super.generateLayoutParams(attributeSet));
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(super.generateLayoutParams(layoutParams));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    private class LayoutParams extends ViewGroup.LayoutParams {
        private boolean animationsSetToPlay;
        private ObjectAnimator mCollapseAlpha;
        private ObjectAnimator mCollapseDir;
        private ObjectAnimator mExpandAlpha;
        private ObjectAnimator mExpandDir;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mExpandDir = new ObjectAnimator();
            this.mExpandAlpha = new ObjectAnimator();
            this.mCollapseDir = new ObjectAnimator();
            this.mCollapseAlpha = new ObjectAnimator();
            this.mExpandDir.setInterpolator(FloatingActionsMenu.sExpandInterpolator);
            this.mExpandAlpha.setInterpolator(FloatingActionsMenu.sAlphaExpandInterpolator);
            this.mCollapseDir.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setProperty(View.ALPHA);
            this.mCollapseAlpha.setFloatValues(1.0f, 0.0f);
            this.mExpandAlpha.setProperty(View.ALPHA);
            this.mExpandAlpha.setFloatValues(0.0f, 1.0f);
            switch (FloatingActionsMenu.this.mExpandDirection) {
                case 0:
                case 1:
                    this.mCollapseDir.setProperty(View.TRANSLATION_Y);
                    this.mExpandDir.setProperty(View.TRANSLATION_Y);
                    break;
                case 2:
                case 3:
                    this.mCollapseDir.setProperty(View.TRANSLATION_X);
                    this.mExpandDir.setProperty(View.TRANSLATION_X);
                    break;
            }
        }

        public void setAnimationsTarget(View view) {
            this.mCollapseAlpha.setTarget(view);
            this.mCollapseDir.setTarget(view);
            this.mExpandAlpha.setTarget(view);
            this.mExpandDir.setTarget(view);
            if (!this.animationsSetToPlay) {
                addLayerTypeListener(this.mExpandDir, view);
                addLayerTypeListener(this.mCollapseDir, view);
                FloatingActionsMenu.this.mCollapseAnimation.play(this.mCollapseAlpha);
                FloatingActionsMenu.this.mCollapseAnimation.play(this.mCollapseDir);
                FloatingActionsMenu.this.mExpandAnimation.play(this.mExpandAlpha);
                FloatingActionsMenu.this.mExpandAnimation.play(this.mExpandDir);
                this.animationsSetToPlay = true;
            }
        }

        private void addLayerTypeListener(Animator animator, final View view) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.FloatingActionsMenu.LayoutParams.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    view.setLayerType(0, null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    view.setLayerType(2, null);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.mAddButton);
        this.mButtonsCount = getChildCount();
        if (this.mLabelsStyle != 0) {
            createLabels();
        }
    }

    private void createLabels() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.mLabelsStyle);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mButtonsCount) {
                FloatingActionButtons floatingActionButtons = (FloatingActionButtons) getChildAt(i2);
                String title = floatingActionButtons.getTitle();
                if (floatingActionButtons != this.mAddButton && title != null && floatingActionButtons.getTag(R.id.fab_label) == null) {
                    TextView textView = new TextView(contextThemeWrapper);
                    textView.setTextAppearance(getContext(), this.mLabelsStyle);
                    textView.setText(floatingActionButtons.getTitle());
                    addView(textView);
                    floatingActionButtons.setTag(R.id.fab_label, textView);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void collapse() {
        collapse(false);
    }

    public void collapseImmediately() {
        collapse(true);
    }

    private void collapse(boolean z) {
        if (this.mExpanded) {
            this.mExpanded = false;
            this.mTouchDelegateGroup.setEnabled(false);
            this.mCollapseAnimation.setDuration(z ? 0 : ANIMATION_DURATION);
            this.mCollapseAnimation.start();
            this.mExpandAnimation.cancel();
            if (this.mListener != null) {
                this.mListener.onMenuCollapsed();
            }
        }
    }

    public void toggle() {
        if (this.mExpanded) {
            collapse();
        } else {
            expand();
        }
    }

    public void expand() {
        if (!this.mExpanded) {
            this.mExpanded = true;
            this.mTouchDelegateGroup.setEnabled(true);
            this.mCollapseAnimation.cancel();
            this.mExpandAnimation.start();
            if (this.mListener != null) {
                this.mListener.onMenuExpanded();
            }
        }
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mAddButton.setEnabled(z);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mExpanded = this.mExpanded;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mExpanded = savedState.mExpanded;
            this.mTouchDelegateGroup.setEnabled(this.mExpanded);
            if (this.mRotatingDrawable != null) {
                this.mRotatingDrawable.setRotation(this.mExpanded ? EXPANDED_PLUS_ROTATION : 0.0f);
            }
            super.onRestoreInstanceState(savedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.design.widget.FloatingActionsMenu.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean mExpanded;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mExpanded = parcel.readInt() == 1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mExpanded ? 1 : 0);
        }
    }
}
