package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
public class SubButton extends FrameLayout {
    public static final int THEME_DARK = 1;
    public static final int THEME_DARKER = 3;
    public static final int THEME_LIGHT = 0;
    public static final int THEME_LIGHTER = 2;

    public SubButton(Context context, FrameLayout.LayoutParams layoutParams, int i, Drawable drawable, View view, FrameLayout.LayoutParams layoutParams2) {
        Drawable drawableNewDrawable;
        super(context);
        setLayoutParams(layoutParams);
        if (drawable == null) {
            if (i == 0) {
                drawableNewDrawable = context.getResources().getDrawable(R.drawable.button_sub_action_selector);
            } else if (i == 1) {
                drawableNewDrawable = context.getResources().getDrawable(R.drawable.button_sub_action_dark_selector);
            } else if (i == 2) {
                drawableNewDrawable = context.getResources().getDrawable(R.drawable.button_action_selector);
            } else if (i == 3) {
                drawableNewDrawable = context.getResources().getDrawable(R.drawable.button_action_dark_selector);
            } else {
                throw new RuntimeException("Unknown SubButton theme: " + i);
            }
        } else {
            drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        }
        setBackgroundResource(drawableNewDrawable);
        if (view != null) {
            setContentView(view, layoutParams2);
        }
        setClickable(true);
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sub_action_button_content_margin);
            layoutParams.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
        view.setClickable(false);
        addView(view, layoutParams);
    }

    public void setContentView(View view) {
        setContentView(view, null);
    }

    private void setBackgroundResource(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public static class Builder {
        private Drawable backgroundDrawable;
        private FrameLayout.LayoutParams contentParams;
        private View contentView;
        private Context context;
        private FrameLayout.LayoutParams layoutParams;
        private int theme;

        public Builder(Context context) {
            this.context = context;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.sub_action_button_size);
            setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 51));
            setTheme(0);
        }

        public Builder setLayoutParams(FrameLayout.LayoutParams layoutParams) {
            this.layoutParams = layoutParams;
            return this;
        }

        public Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public Builder setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
            return this;
        }

        public Builder setContentView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setContentView(View view, FrameLayout.LayoutParams layoutParams) {
            this.contentView = view;
            this.contentParams = layoutParams;
            return this;
        }

        public SubButton build() {
            return new SubButton(this.context, this.layoutParams, this.theme, this.backgroundDrawable, this.contentView, this.contentParams);
        }
    }
}
