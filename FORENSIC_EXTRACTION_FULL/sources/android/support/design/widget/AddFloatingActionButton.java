package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
public class AddFloatingActionButton extends FloatingActionButtons {
    int mPlusColor;

    public AddFloatingActionButton(Context context) {
        this(context, null);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.support.design.widget.FloatingActionButtons
    void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AddFloatingActionButton, 0, 0);
        this.mPlusColor = typedArrayObtainStyledAttributes.getColor(0, getColor(android.R.color.white));
        typedArrayObtainStyledAttributes.recycle();
        super.init(context, attributeSet);
    }

    public int getPlusColor() {
        return this.mPlusColor;
    }

    public void setPlusColorResId(@ColorRes int i) {
        setPlusColor(getColor(i));
    }

    public void setPlusColor(int i) {
        if (this.mPlusColor != i) {
            this.mPlusColor = i;
            updateBackground();
        }
    }

    @Override // android.support.design.widget.FloatingActionButtons
    public void setIcon(@DrawableRes int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    @Override // android.support.design.widget.FloatingActionButtons
    Drawable getIconDrawable() {
        final float dimension = getDimension(R.dimen.fab_icon_size);
        final float f = dimension / 2.0f;
        float dimension2 = getDimension(R.dimen.fab_plus_icon_size);
        final float dimension3 = getDimension(R.dimen.fab_plus_icon_stroke) / 2.0f;
        final float f2 = (dimension - dimension2) / 2.0f;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() { // from class: android.support.design.widget.AddFloatingActionButton.1
            @Override // android.graphics.drawable.shapes.Shape
            public void draw(Canvas canvas, Paint paint) {
                canvas.drawRect(f2, f - dimension3, dimension - f2, dimension3 + f, paint);
                canvas.drawRect(f - dimension3, f2, dimension3 + f, dimension - f2, paint);
            }
        });
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.mPlusColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }
}
