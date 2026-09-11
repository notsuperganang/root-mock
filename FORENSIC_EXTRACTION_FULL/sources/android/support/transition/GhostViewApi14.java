package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(14)
@SuppressLint({"ViewConstructor"})
class GhostViewApi14 extends View implements GhostViewImpl {
    Matrix mCurrentMatrix;
    private int mDeltaX;
    private int mDeltaY;
    private final Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    static class Creator implements GhostViewImpl.Creator {
        Creator() {
        }

        private static FrameLayout findFrameLayout(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            while (!(viewGroup2 instanceof FrameLayout)) {
                ViewParent parent = viewGroup2.getParent();
                if (!(parent instanceof ViewGroup)) {
                    return null;
                }
                viewGroup2 = (ViewGroup) parent;
            }
            return (FrameLayout) viewGroup2;
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        public GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
            GhostViewApi14 ghostView = GhostViewApi14.getGhostView(view);
            if (ghostView == null) {
                FrameLayout frameLayoutFindFrameLayout = findFrameLayout(viewGroup);
                if (frameLayoutFindFrameLayout == null) {
                    return null;
                }
                ghostView = new GhostViewApi14(view);
                frameLayoutFindFrameLayout.addView(ghostView);
            }
            ghostView.mReferences++;
            return ghostView;
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        public void removeGhost(View view) {
            GhostViewApi14 ghostView = GhostViewApi14.getGhostView(view);
            if (ghostView != null) {
                ghostView.mReferences--;
                if (ghostView.mReferences <= 0) {
                    ViewParent parent = ghostView.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.endViewTransition(ghostView);
                        viewGroup.removeView(ghostView);
                    }
                }
            }
        }
    }

    GhostViewApi14(View view) {
        super(view.getContext());
        this.mMatrix = new Matrix();
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this) { // from class: android.support.transition.GhostViewApi14.1
            final GhostViewApi14 this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.this$0.mCurrentMatrix = this.this$0.mView.getMatrix();
                ViewCompat.postInvalidateOnAnimation(this.this$0);
                if (this.this$0.mStartParent == null || this.this$0.mStartView == null) {
                    return true;
                }
                this.this$0.mStartParent.endViewTransition(this.this$0.mStartView);
                ViewCompat.postInvalidateOnAnimation(this.this$0.mStartParent);
                this.this$0.mStartParent = null;
                this.this$0.mStartView = null;
                return true;
            }
        };
        this.mView = view;
        setLayerType(2, null);
    }

    static GhostViewApi14 getGhostView(@NonNull View view) {
        return (GhostViewApi14) view.getTag(R.id.ghost_view);
    }

    private static void setGhostView(@NonNull View view, GhostViewApi14 ghostViewApi14) {
        view.setTag(R.id.ghost_view, ghostViewApi14);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.mView.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (iArr2[0] - this.mView.getTranslationX());
        iArr2[1] = (int) (iArr2[1] - this.mView.getTranslationY());
        this.mDeltaX = iArr2[0] - iArr[0];
        this.mDeltaY = iArr2[1] - iArr[1];
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        this.mView.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.mView.setVisibility(0);
        setGhostView(this.mView, null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mMatrix.set(this.mCurrentMatrix);
        this.mMatrix.postTranslate(this.mDeltaX, this.mDeltaY);
        canvas.setMatrix(this.mMatrix);
        this.mView.draw(canvas);
    }

    @Override // android.support.transition.GhostViewImpl
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    @Override // android.view.View, android.support.transition.GhostViewImpl
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mView.setVisibility(i == 0 ? 4 : 0);
    }
}
