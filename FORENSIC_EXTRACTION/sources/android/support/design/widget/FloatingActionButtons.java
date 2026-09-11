package android.support.design.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tiket.git.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButtons extends ImageButton {
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private float mCircleSize;
    int mColorDisabled;
    int mColorNormal;
    int mColorPressed;
    private int mDrawableSize;

    @DrawableRes
    private int mIcon;
    private Drawable mIconDrawable;
    private float mShadowOffset;
    private float mShadowRadius;
    private int mSize;
    boolean mStrokeVisible;
    String mTitle;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FAB_SIZE {
    }

    public FloatingActionButtons(Context context) {
        this(context, null);
    }

    public FloatingActionButtons(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FloatingActionButtons(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, 0, 0);
        this.mColorNormal = typedArrayObtainStyledAttributes.getColor(2, getColor(R.color.colorPrimary));
        this.mColorPressed = typedArrayObtainStyledAttributes.getColor(0, getColor(R.color.colorPrimaryDark));
        this.mColorDisabled = typedArrayObtainStyledAttributes.getColor(1, getColor(R.color.colorPrimary));
        this.mSize = typedArrayObtainStyledAttributes.getInt(4, 0);
        this.mIcon = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.mTitle = typedArrayObtainStyledAttributes.getString(5);
        this.mStrokeVisible = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.recycle();
        updateCircleSize();
        this.mShadowRadius = getDimension(R.dimen.fab_shadow_radius);
        this.mShadowOffset = getDimension(R.dimen.fab_shadow_offset);
        updateDrawableSize();
        updateBackground();
    }

    private void updateDrawableSize() {
        this.mDrawableSize = (int) (this.mCircleSize + (2.0f * this.mShadowRadius));
    }

    private void updateCircleSize() {
        this.mCircleSize = getDimension(this.mSize == 0 ? R.dimen.fab_size_normal : R.dimen.fab_size_mini);
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        }
        if (this.mSize != i) {
            this.mSize = i;
            updateCircleSize();
            updateDrawableSize();
            updateBackground();
        }
    }

    public int getSize() {
        return this.mSize;
    }

    public void setIcon(@DrawableRes int i) {
        if (this.mIcon != i) {
            this.mIcon = i;
            this.mIconDrawable = null;
            updateBackground();
        }
    }

    public void setIconDrawable(@NonNull Drawable drawable) {
        if (this.mIconDrawable != drawable) {
            this.mIcon = 0;
            this.mIconDrawable = drawable;
            updateBackground();
        }
    }

    public int getColorNormal() {
        return this.mColorNormal;
    }

    public void setColorNormalResId(@ColorRes int i) {
        setColorNormal(getColor(i));
    }

    public void setColorNormal(int i) {
        if (this.mColorNormal != i) {
            this.mColorNormal = i;
            updateBackground();
        }
    }

    public int getColorPressed() {
        return this.mColorPressed;
    }

    public void setColorPressedResId(@ColorRes int i) {
        setColorPressed(getColor(i));
    }

    public void setColorPressed(int i) {
        if (this.mColorPressed != i) {
            this.mColorPressed = i;
            updateBackground();
        }
    }

    public int getColorDisabled() {
        return this.mColorDisabled;
    }

    public void setColorDisabledResId(@ColorRes int i) {
        setColorDisabled(getColor(i));
    }

    public void setColorDisabled(int i) {
        if (this.mColorDisabled != i) {
            this.mColorDisabled = i;
            updateBackground();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.mStrokeVisible != z) {
            this.mStrokeVisible = z;
            updateBackground();
        }
    }

    public boolean isStrokeVisible() {
        return this.mStrokeVisible;
    }

    int getColor(@ColorRes int i) {
        return getResources().getColor(i);
    }

    float getDimension(@DimenRes int i) {
        return getResources().getDimension(i);
    }

    public void setTitle(String str) {
        this.mTitle = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    TextView getLabelView() {
        return (TextView) getTag(R.id.fab_label);
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mDrawableSize, this.mDrawableSize);
    }

    void updateBackground() {
        float dimension = getDimension(R.dimen.fab_stroke_width);
        float f = dimension / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.mSize == 0 ? R.drawable.fab_bg_normal : R.drawable.fab_bg_mini);
        drawableArr[1] = createFillDrawable(dimension);
        drawableArr[2] = createOuterStrokeDrawable(dimension);
        drawableArr[3] = getIconDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int dimension2 = ((int) (this.mCircleSize - getDimension(R.dimen.fab_icon_size))) / 2;
        int i = (int) this.mShadowRadius;
        int i2 = (int) (this.mShadowRadius - this.mShadowOffset);
        int i3 = (int) (this.mShadowRadius + this.mShadowOffset);
        layerDrawable.setLayerInset(1, i, i2, i, i3);
        layerDrawable.setLayerInset(2, (int) (i - f), (int) (i2 - f), (int) (i - f), (int) (i3 - f));
        layerDrawable.setLayerInset(3, i + dimension2, i2 + dimension2, i + dimension2, i3 + dimension2);
        setBackgroundCompat(layerDrawable);
    }

    Drawable getIconDrawable() {
        if (this.mIconDrawable != null) {
            return this.mIconDrawable;
        }
        if (this.mIcon != 0) {
            return getResources().getDrawable(this.mIcon);
        }
        return new ColorDrawable(0);
    }

    private StateListDrawable createFillDrawable(float f) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, createCircleDrawable(this.mColorDisabled, f));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createCircleDrawable(this.mColorPressed, f));
        stateListDrawable.addState(new int[0], createCircleDrawable(this.mColorNormal, f));
        return stateListDrawable;
    }

    private Drawable createCircleDrawable(int i, float f) {
        LayerDrawable layerDrawable;
        int iAlpha = Color.alpha(i);
        int iOpaque = opaque(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(iOpaque);
        Drawable[] drawableArr = {shapeDrawable, createInnerStrokesDrawable(iOpaque, f)};
        if (iAlpha == 255 || !this.mStrokeVisible) {
            layerDrawable = new LayerDrawable(drawableArr);
        } else {
            layerDrawable = new TranslucentLayerDrawable(iAlpha, drawableArr);
        }
        int i2 = (int) (f / 2.0f);
        layerDrawable.setLayerInset(1, i2, i2, i2, i2);
        return layerDrawable;
    }

    private static class TranslucentLayerDrawable extends LayerDrawable {
        private final int mAlpha;

        public TranslucentLayerDrawable(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.mAlpha = i;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mAlpha, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    private Drawable createOuterStrokeDrawable(float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setAlpha(opacityToAlpha(0.02f));
        return shapeDrawable;
    }

    private int opacityToAlpha(float f) {
        return (int) (255.0f * f);
    }

    private int darkenColor(int i) {
        return adjustColorBrightness(i, 0.9f);
    }

    private int lightenColor(int i) {
        return adjustColorBrightness(i, 1.1f);
    }

    private int adjustColorBrightness(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = Math.min(fArr[2] * f, 1.0f);
        return Color.HSVToColor(Color.alpha(i), fArr);
    }

    private int halfTransparent(int i) {
        return Color.argb(Color.alpha(i) / 2, Color.red(i), Color.green(i), Color.blue(i));
    }

    private int opaque(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    private Drawable createInnerStrokesDrawable(final int i, float f) {
        if (!this.mStrokeVisible) {
            return new ColorDrawable(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final int iDarkenColor = darkenColor(i);
        final int iHalfTransparent = halfTransparent(iDarkenColor);
        final int iLightenColor = lightenColor(i);
        final int iHalfTransparent2 = halfTransparent(iLightenColor);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.STROKE);
        shapeDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() { // from class: android.support.design.widget.FloatingActionButtons.1
            @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
            public Shader resize(int i2, int i3) {
                return new LinearGradient(i2 / 2, 0.0f, i2 / 2, i3, new int[]{iLightenColor, iHalfTransparent2, i, iHalfTransparent, iDarkenColor}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
            }
        });
        return shapeDrawable;
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }
}
