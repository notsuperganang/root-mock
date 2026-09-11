package android.support.design.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FloatingMenu {
    private boolean animated;
    private MenuAnimationHandler animationHandler;
    private int endAngle;
    private View mainActionView;
    private boolean open = false;
    private OrientationEventListener orientationListener;
    private FrameLayout overlayContainer;
    private int radius;
    private int startAngle;
    private MenuStateChangeListener stateChangeListener;
    private List<Item> subActionItems;
    private boolean systemOverlay;

    public interface MenuStateChangeListener {
        void onMenuClosed(FloatingMenu floatingMenu);

        void onMenuOpened(FloatingMenu floatingMenu);
    }

    public FloatingMenu(View view, int i, int i2, int i3, List<Item> list, MenuAnimationHandler menuAnimationHandler, boolean z, MenuStateChangeListener menuStateChangeListener, boolean z2) {
        this.mainActionView = view;
        this.startAngle = i;
        this.endAngle = i2;
        this.radius = i3;
        this.subActionItems = list;
        this.animationHandler = menuAnimationHandler;
        this.animated = z;
        this.systemOverlay = z2;
        this.stateChangeListener = menuStateChangeListener;
        this.mainActionView.setClickable(true);
        this.mainActionView.setOnClickListener(new ActionViewClickListener());
        if (menuAnimationHandler != null) {
            menuAnimationHandler.setMenu(this);
        }
        if (z2) {
            this.overlayContainer = new FrameLayout(view.getContext());
        } else {
            this.overlayContainer = null;
        }
        for (Item item : list) {
            if (item.width == 0 || item.height == 0) {
                if (z2) {
                    throw new RuntimeException("Sub action views cannot be added without definite width and height.");
                }
                addViewToCurrentContainer(item.view);
                item.view.setAlpha(0.0f);
                item.view.post(new ItemViewQueueListener(item));
            }
        }
        if (z2) {
            this.orientationListener = new OrientationEventListener(view.getContext(), 2) { // from class: android.support.design.widget.FloatingMenu.1
                private int lastState = -1;

                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i4) {
                    Display defaultDisplay = FloatingMenu.this.getWindowManager().getDefaultDisplay();
                    if (defaultDisplay.getRotation() != this.lastState) {
                        this.lastState = defaultDisplay.getRotation();
                        if (FloatingMenu.this.isOpen()) {
                            FloatingMenu.this.close(false);
                        }
                    }
                }
            };
            this.orientationListener.enable();
        }
    }

    public void open(boolean z) {
        WindowManager.LayoutParams layoutParams;
        Point pointCalculateItemPositions = calculateItemPositions();
        if (!this.systemOverlay) {
            layoutParams = null;
        } else {
            attachOverlayContainer();
            layoutParams = (WindowManager.LayoutParams) this.overlayContainer.getLayoutParams();
        }
        if (z && this.animationHandler != null) {
            if (!this.animationHandler.isAnimating()) {
                for (int i = 0; i < this.subActionItems.size(); i++) {
                    if (this.subActionItems.get(i).view.getParent() != null) {
                        throw new RuntimeException("All of the sub action items have to be independent from a parent.");
                    }
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.subActionItems.get(i).width, this.subActionItems.get(i).height, 51);
                    if (this.systemOverlay) {
                        layoutParams2.setMargins((pointCalculateItemPositions.x - layoutParams.x) - (this.subActionItems.get(i).width / 2), (pointCalculateItemPositions.y - layoutParams.y) - (this.subActionItems.get(i).height / 2), 0, 0);
                    } else {
                        layoutParams2.setMargins(pointCalculateItemPositions.x - (this.subActionItems.get(i).width / 2), pointCalculateItemPositions.y - (this.subActionItems.get(i).height / 2), 0, 0);
                    }
                    addViewToCurrentContainer(this.subActionItems.get(i).view, layoutParams2);
                }
                this.animationHandler.animateMenuOpening(pointCalculateItemPositions);
            } else {
                return;
            }
        } else {
            for (int i2 = 0; i2 < this.subActionItems.size(); i2++) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.subActionItems.get(i2).width, this.subActionItems.get(i2).height, 51);
                if (this.systemOverlay) {
                    layoutParams3.setMargins(this.subActionItems.get(i2).x - layoutParams.x, this.subActionItems.get(i2).y - layoutParams.y, 0, 0);
                    this.subActionItems.get(i2).view.setLayoutParams(layoutParams3);
                } else {
                    layoutParams3.setMargins(this.subActionItems.get(i2).x, this.subActionItems.get(i2).y, 0, 0);
                    this.subActionItems.get(i2).view.setLayoutParams(layoutParams3);
                }
                addViewToCurrentContainer(this.subActionItems.get(i2).view, layoutParams3);
            }
        }
        this.open = true;
        if (this.stateChangeListener != null) {
            this.stateChangeListener.onMenuOpened(this);
        }
    }

    public void close(boolean z) {
        if (z && this.animationHandler != null) {
            if (!this.animationHandler.isAnimating()) {
                this.animationHandler.animateMenuClosing(getActionViewCenter());
            } else {
                return;
            }
        } else {
            for (int i = 0; i < this.subActionItems.size(); i++) {
                removeViewFromCurrentContainer(this.subActionItems.get(i).view);
            }
            detachOverlayContainer();
        }
        this.open = false;
        if (this.stateChangeListener != null) {
            this.stateChangeListener.onMenuClosed(this);
        }
    }

    public void toggle(boolean z) {
        if (this.open) {
            close(z);
        } else {
            open(z);
        }
    }

    public boolean isOpen() {
        return this.open;
    }

    public boolean isSystemOverlay() {
        return this.systemOverlay;
    }

    public FrameLayout getOverlayContainer() {
        return this.overlayContainer;
    }

    public void updateItemPositions() {
        if (isOpen()) {
            calculateItemPositions();
            for (int i = 0; i < this.subActionItems.size(); i++) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.subActionItems.get(i).width, this.subActionItems.get(i).height, 51);
                layoutParams.setMargins(this.subActionItems.get(i).x, this.subActionItems.get(i).y, 0, 0);
                this.subActionItems.get(i).view.setLayoutParams(layoutParams);
            }
        }
    }

    private Point getActionViewCoordinates() {
        int[] iArr = new int[2];
        this.mainActionView.getLocationOnScreen(iArr);
        if (this.systemOverlay) {
            iArr[1] = iArr[1] - getStatusBarHeight();
        } else {
            Rect rect = new Rect();
            getActivityContentView().getWindowVisibleDisplayFrame(rect);
            iArr[0] = iArr[0] - (getScreenSize().x - getActivityContentView().getMeasuredWidth());
            iArr[1] = iArr[1] - ((rect.top + rect.height()) - getActivityContentView().getMeasuredHeight());
        }
        return new Point(iArr[0], iArr[1]);
    }

    public Point getActionViewCenter() {
        Point actionViewCoordinates = getActionViewCoordinates();
        actionViewCoordinates.x += this.mainActionView.getMeasuredWidth() / 2;
        actionViewCoordinates.y += this.mainActionView.getMeasuredHeight() / 2;
        return actionViewCoordinates;
    }

    private Point calculateItemPositions() {
        int size;
        Point actionViewCenter = getActionViewCenter();
        RectF rectF = new RectF(actionViewCenter.x - this.radius, actionViewCenter.y - this.radius, actionViewCenter.x + this.radius, actionViewCenter.y + this.radius);
        Path path = new Path();
        path.addArc(rectF, this.startAngle, this.endAngle - this.startAngle);
        PathMeasure pathMeasure = new PathMeasure(path, false);
        if (Math.abs(this.endAngle - this.startAngle) >= 360 || this.subActionItems.size() <= 1) {
            size = this.subActionItems.size();
        } else {
            size = this.subActionItems.size() - 1;
        }
        for (int i = 0; i < this.subActionItems.size(); i++) {
            float[] fArr = {0.0f, 0.0f};
            pathMeasure.getPosTan((i * pathMeasure.getLength()) / size, fArr, null);
            this.subActionItems.get(i).x = ((int) fArr[0]) - (this.subActionItems.get(i).width / 2);
            this.subActionItems.get(i).y = ((int) fArr[1]) - (this.subActionItems.get(i).height / 2);
        }
        return actionViewCenter;
    }

    public int getRadius() {
        return this.radius;
    }

    public List<Item> getSubActionItems() {
        return this.subActionItems;
    }

    public View getActivityContentView() {
        try {
            return ((Activity) this.mainActionView.getContext()).getWindow().getDecorView().findViewById(R.id.content);
        } catch (ClassCastException e) {
            throw new ClassCastException("Please provide an Activity context for this FloatingMenu.");
        }
    }

    public WindowManager getWindowManager() {
        return (WindowManager) this.mainActionView.getContext().getSystemService("window");
    }

    private void addViewToCurrentContainer(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.systemOverlay) {
            this.overlayContainer.addView(view, layoutParams);
            return;
        }
        try {
            if (layoutParams != null) {
                ((ViewGroup) getActivityContentView()).addView(view, (FrameLayout.LayoutParams) layoutParams);
            } else {
                ((ViewGroup) getActivityContentView()).addView(view);
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("layoutParams must be an instance of FrameLayout.LayoutParams.");
        }
    }

    public void attachOverlayContainer() {
        try {
            WindowManager.LayoutParams layoutParamsCalculateOverlayContainerParams = calculateOverlayContainerParams();
            this.overlayContainer.setLayoutParams(layoutParamsCalculateOverlayContainerParams);
            if (this.overlayContainer.getParent() == null) {
                getWindowManager().addView(this.overlayContainer, layoutParamsCalculateOverlayContainerParams);
            }
            getWindowManager().updateViewLayout(this.mainActionView, this.mainActionView.getLayoutParams());
        } catch (SecurityException e) {
            throw new SecurityException("Your application must have SYSTEM_ALERT_WINDOW permission to create a system window.");
        }
    }

    private WindowManager.LayoutParams calculateOverlayContainerParams() {
        WindowManager.LayoutParams defaultSystemWindowParams = getDefaultSystemWindowParams();
        int i = 0;
        int i2 = 0;
        int i3 = 9999;
        int i4 = 0;
        int i5 = 9999;
        while (i < this.subActionItems.size()) {
            int i6 = this.subActionItems.get(i).x;
            int i7 = this.subActionItems.get(i).y;
            if (i6 < i5) {
                i5 = i6;
            }
            if (i7 < i3) {
                i3 = i7;
            }
            int i8 = this.subActionItems.get(i).width + i6 > i4 ? i6 + this.subActionItems.get(i).width : i4;
            if (this.subActionItems.get(i).height + i7 > i2) {
                i2 = i7 + this.subActionItems.get(i).height;
            }
            i++;
            i4 = i8;
        }
        defaultSystemWindowParams.width = i4 - i5;
        defaultSystemWindowParams.height = i2 - i3;
        defaultSystemWindowParams.x = i5;
        defaultSystemWindowParams.y = i3;
        defaultSystemWindowParams.gravity = 51;
        return defaultSystemWindowParams;
    }

    public void detachOverlayContainer() {
        getWindowManager().removeView(this.overlayContainer);
    }

    public int getStatusBarHeight() {
        int identifier = this.mainActionView.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return this.mainActionView.getContext().getResources().getDimensionPixelSize(identifier);
    }

    public void addViewToCurrentContainer(View view) {
        addViewToCurrentContainer(view, null);
    }

    public void removeViewFromCurrentContainer(View view) {
        if (this.systemOverlay) {
            this.overlayContainer.removeView(view);
        } else {
            ((ViewGroup) getActivityContentView()).removeView(view);
        }
    }

    private Point getScreenSize() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    public void setStateChangeListener(MenuStateChangeListener menuStateChangeListener) {
        this.stateChangeListener = menuStateChangeListener;
    }

    public class ActionViewClickListener implements View.OnClickListener {
        public ActionViewClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatingMenu.this.toggle(FloatingMenu.this.animated);
        }
    }

    private class ItemViewQueueListener implements Runnable {
        private static final int MAX_TRIES = 10;
        private Item item;
        private int tries = 0;

        public ItemViewQueueListener(Item item) {
            this.item = item;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.item.view.getMeasuredWidth() == 0 && this.tries < 10) {
                this.item.view.post(this);
                return;
            }
            this.item.width = this.item.view.getMeasuredWidth();
            this.item.height = this.item.view.getMeasuredHeight();
            this.item.view.setAlpha(this.item.alpha);
            FloatingMenu.this.removeViewFromCurrentContainer(this.item.view);
        }
    }

    public static class Item {
        public float alpha;
        public int height;
        public View view;
        public int width;
        public int x = 0;
        public int y = 0;

        public Item(View view, int i, int i2) {
            this.view = view;
            this.width = i;
            this.height = i2;
            this.alpha = view.getAlpha();
        }
    }

    public static class Builder {
        private View actionView;
        private boolean animated;
        private MenuAnimationHandler animationHandler;
        private int endAngle;
        private int radius;
        private int startAngle;
        private MenuStateChangeListener stateChangeListener;
        private List<Item> subActionItems;
        private boolean systemOverlay;

        public Builder(Context context, boolean z) {
            this.subActionItems = new ArrayList();
            this.radius = context.getResources().getDimensionPixelSize(com.tiket.git.R.dimen.action_menu_radius);
            this.startAngle = 180;
            this.endAngle = 270;
            this.animationHandler = new DefaultAnimationHandler();
            this.animated = true;
            this.systemOverlay = z;
        }

        public Builder(Context context) {
            this(context, false);
        }

        public Builder setStartAngle(int i) {
            this.startAngle = i;
            return this;
        }

        public Builder setEndAngle(int i) {
            this.endAngle = i;
            return this;
        }

        public Builder setRadius(int i) {
            this.radius = i;
            return this;
        }

        public Builder addSubActionView(View view, int i, int i2) {
            this.subActionItems.add(new Item(view, i, i2));
            return this;
        }

        public Builder addSubActionView(View view) {
            if (this.systemOverlay) {
                throw new RuntimeException("Sub action views cannot be added without definite width and height. Please use other methods named addSubActionView");
            }
            return addSubActionView(view, 0, 0);
        }

        public Builder addSubActionView(int i, Context context) {
            View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, (ViewGroup) null, false);
            viewInflate.measure(0, 0);
            return addSubActionView(viewInflate, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
        }

        public Builder setAnimationHandler(MenuAnimationHandler menuAnimationHandler) {
            this.animationHandler = menuAnimationHandler;
            return this;
        }

        public Builder enableAnimations() {
            this.animated = true;
            return this;
        }

        public Builder disableAnimations() {
            this.animated = false;
            return this;
        }

        public Builder setStateChangeListener(MenuStateChangeListener menuStateChangeListener) {
            this.stateChangeListener = menuStateChangeListener;
            return this;
        }

        public Builder setSystemOverlay(boolean z) {
            this.systemOverlay = z;
            return this;
        }

        public Builder attachTo(View view) {
            this.actionView = view;
            return this;
        }

        public FloatingMenu build() {
            return new FloatingMenu(this.actionView, this.startAngle, this.endAngle, this.radius, this.subActionItems, this.animationHandler, this.animated, this.stateChangeListener, this.systemOverlay);
        }
    }

    public static WindowManager.LayoutParams getDefaultSystemWindowParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2002, 40, -3);
        layoutParams.format = 1;
        layoutParams.gravity = 51;
        return layoutParams;
    }
}
