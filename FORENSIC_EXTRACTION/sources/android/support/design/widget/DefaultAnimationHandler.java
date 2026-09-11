package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Point;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAnimationHandler extends MenuAnimationHandler {
    protected static final int DURATION = 500;
    protected static final int LAG_BETWEEN_ITEMS = 20;
    private boolean animating;

    public DefaultAnimationHandler() {
        setAnimating(false);
    }

    @Override // android.support.design.widget.MenuAnimationHandler
    public void animateMenuOpening(Point point) {
        super.animateMenuOpening(point);
        setAnimating(true);
        ObjectAnimator objectAnimator = null;
        int i = 0;
        while (i < this.menu.getSubActionItems().size()) {
            this.menu.getSubActionItems().get(i).view.setScaleX(0.0f);
            this.menu.getSubActionItems().get(i).view.setScaleY(0.0f);
            this.menu.getSubActionItems().get(i).view.setAlpha(0.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.menu.getSubActionItems().get(i).view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, (this.menu.getSubActionItems().get(i).width / 2) + (this.menu.getSubActionItems().get(i).x - point.x)), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, (this.menu.getSubActionItems().get(i).height / 2) + (this.menu.getSubActionItems().get(i).y - point.y)), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ROTATION, 720.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(500L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new OvershootInterpolator(0.9f));
            objectAnimatorOfPropertyValuesHolder.addListener(new SubActionItemAnimationListener(this.menu.getSubActionItems().get(i), MenuAnimationHandler.ActionType.OPENING));
            ObjectAnimator objectAnimator2 = i == 0 ? objectAnimatorOfPropertyValuesHolder : objectAnimator;
            objectAnimatorOfPropertyValuesHolder.setStartDelay((this.menu.getSubActionItems().size() - i) * 20);
            objectAnimatorOfPropertyValuesHolder.start();
            i++;
            objectAnimator = objectAnimator2;
        }
        if (objectAnimator != null) {
            objectAnimator.addListener(new MenuAnimationHandler.LastAnimationListener());
        }
    }

    @Override // android.support.design.widget.MenuAnimationHandler
    public void animateMenuClosing(Point point) {
        super.animateMenuOpening(point);
        setAnimating(true);
        ObjectAnimator objectAnimator = null;
        int i = 0;
        while (i < this.menu.getSubActionItems().size()) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.menu.getSubActionItems().get(i).view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, -((this.menu.getSubActionItems().get(i).width / 2) + (this.menu.getSubActionItems().get(i).x - point.x))), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, -((this.menu.getSubActionItems().get(i).height / 2) + (this.menu.getSubActionItems().get(i).y - point.y))), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ROTATION, -720.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(500L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.addListener(new SubActionItemAnimationListener(this.menu.getSubActionItems().get(i), MenuAnimationHandler.ActionType.CLOSING));
            ObjectAnimator objectAnimator2 = i == 0 ? objectAnimatorOfPropertyValuesHolder : objectAnimator;
            objectAnimatorOfPropertyValuesHolder.setStartDelay((this.menu.getSubActionItems().size() - i) * 20);
            objectAnimatorOfPropertyValuesHolder.start();
            i++;
            objectAnimator = objectAnimator2;
        }
        if (objectAnimator != null) {
            objectAnimator.addListener(new MenuAnimationHandler.LastAnimationListener());
        }
    }

    @Override // android.support.design.widget.MenuAnimationHandler
    public boolean isAnimating() {
        return this.animating;
    }

    @Override // android.support.design.widget.MenuAnimationHandler
    protected void setAnimating(boolean z) {
        this.animating = z;
    }

    protected class SubActionItemAnimationListener implements Animator.AnimatorListener {
        private MenuAnimationHandler.ActionType actionType;
        private FloatingMenu.Item subActionItem;

        public SubActionItemAnimationListener(FloatingMenu.Item item, MenuAnimationHandler.ActionType actionType) {
            this.subActionItem = item;
            this.actionType = actionType;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DefaultAnimationHandler.this.restoreSubActionViewAfterAnimation(this.subActionItem, this.actionType);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            DefaultAnimationHandler.this.restoreSubActionViewAfterAnimation(this.subActionItem, this.actionType);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
