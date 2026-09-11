package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import com.tiket.git.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationViews extends BottomNavigationView {
    private final int CURVE_CIRCLE_RADIUS;
    private Point mFirstCurveControlPoint1;
    private Point mFirstCurveControlPoint2;
    private Point mFirstCurveEndPoint;
    private Point mFirstCurveStartPoint;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private Paint mPaint;
    private Path mPath;
    private Point mSecondCurveControlPoint1;
    private Point mSecondCurveControlPoint2;
    private Point mSecondCurveEndPoint;
    private Point mSecondCurveStartPoint;

    public BottomNavigationViews(Context context) {
        super(context);
        this.CURVE_CIRCLE_RADIUS = 64;
        this.mFirstCurveStartPoint = new Point();
        this.mFirstCurveEndPoint = new Point();
        this.mFirstCurveControlPoint1 = new Point();
        this.mFirstCurveControlPoint2 = new Point();
        this.mSecondCurveStartPoint = new Point();
        this.mSecondCurveEndPoint = new Point();
        this.mSecondCurveControlPoint1 = new Point();
        this.mSecondCurveControlPoint2 = new Point();
        init();
    }

    public BottomNavigationViews(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CURVE_CIRCLE_RADIUS = 64;
        this.mFirstCurveStartPoint = new Point();
        this.mFirstCurveEndPoint = new Point();
        this.mFirstCurveControlPoint1 = new Point();
        this.mFirstCurveControlPoint2 = new Point();
        this.mSecondCurveStartPoint = new Point();
        this.mSecondCurveEndPoint = new Point();
        this.mSecondCurveControlPoint1 = new Point();
        this.mSecondCurveControlPoint2 = new Point();
        init();
    }

    public BottomNavigationViews(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.CURVE_CIRCLE_RADIUS = 64;
        this.mFirstCurveStartPoint = new Point();
        this.mFirstCurveEndPoint = new Point();
        this.mFirstCurveControlPoint1 = new Point();
        this.mFirstCurveControlPoint2 = new Point();
        this.mSecondCurveStartPoint = new Point();
        this.mSecondCurveEndPoint = new Point();
        this.mSecondCurveControlPoint1 = new Point();
        this.mSecondCurveControlPoint2 = new Point();
        init();
    }

    private void init() {
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        int[][] iArr = {new int[]{-16842910}, new int[]{android.R.attr.state_enabled}, new int[]{-16842912}, new int[]{android.R.attr.state_pressed}};
        int[][] iArr2 = {new int[]{-16842910}, new int[]{android.R.attr.state_enabled}, new int[]{-16842912}, new int[]{android.R.attr.state_pressed}};
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{-7829368, -1, -7829368, -7829368});
        ColorStateList colorStateList2 = new ColorStateList(iArr2, new int[]{-7829368, -1, -7829368, -7829368});
        setBackgroundColor(0);
        setItemTextColor(colorStateList);
        setItemIconTintList(colorStateList2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mNavigationBarWidth = getWidth();
        this.mNavigationBarHeight = getHeight();
        this.mFirstCurveStartPoint.set(((this.mNavigationBarWidth / 2) - 128) - 21, 0);
        this.mFirstCurveEndPoint.set(this.mNavigationBarWidth / 2, 80);
        this.mSecondCurveStartPoint = this.mFirstCurveEndPoint;
        this.mSecondCurveEndPoint.set((this.mNavigationBarWidth / 2) + 128 + 21, 0);
        this.mFirstCurveControlPoint1.set(this.mFirstCurveStartPoint.x + 64 + 16, this.mFirstCurveStartPoint.y);
        this.mFirstCurveControlPoint2.set((this.mFirstCurveEndPoint.x - 128) + 64, this.mFirstCurveEndPoint.y);
        this.mSecondCurveControlPoint1.set((this.mSecondCurveStartPoint.x + 128) - 64, this.mSecondCurveStartPoint.y);
        this.mSecondCurveControlPoint2.set(this.mSecondCurveEndPoint.x - 80, this.mSecondCurveEndPoint.y);
        this.mPath.reset();
        this.mPath.moveTo(0.0f, 0.0f);
        this.mPath.lineTo(this.mFirstCurveStartPoint.x, this.mFirstCurveStartPoint.y);
        this.mPath.cubicTo(this.mFirstCurveControlPoint1.x, this.mFirstCurveControlPoint1.y, this.mFirstCurveControlPoint2.x, this.mFirstCurveControlPoint2.y, this.mFirstCurveEndPoint.x, this.mFirstCurveEndPoint.y);
        this.mPath.cubicTo(this.mSecondCurveControlPoint1.x, this.mSecondCurveControlPoint1.y, this.mSecondCurveControlPoint2.x, this.mSecondCurveControlPoint2.y, this.mSecondCurveEndPoint.x, this.mSecondCurveEndPoint.y);
        this.mPath.lineTo(this.mNavigationBarWidth, 0.0f);
        this.mPath.lineTo(this.mNavigationBarWidth, this.mNavigationBarHeight);
        this.mPath.lineTo(0.0f, this.mNavigationBarHeight);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static void disable(BottomNavigationViews bottomNavigationViews) {
        int i = 0;
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationViews.getChildAt(0);
        try {
            Field declaredField = bottomNavigationMenuView.getClass().getDeclaredField("mShiftingMode");
            declaredField.setAccessible(true);
            declaredField.setBoolean(bottomNavigationMenuView, false);
            declaredField.setAccessible(false);
            while (true) {
                int i2 = i;
                if (i2 < bottomNavigationMenuView.getChildCount()) {
                    BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i2);
                    bottomNavigationItemView.setShiftingMode(false);
                    bottomNavigationItemView.setChecked(bottomNavigationItemView.getItemData().isChecked());
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        } catch (NoSuchFieldException e2) {
            Log.e("BNVHelper", "Unable to get shift mode field", e2);
        }
    }
}
