package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import com.tiket.git.R;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(14)
class ImageViewUtilsApi14 implements ImageViewUtilsImpl {
    ImageViewUtilsApi14() {
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    public void animateTransform(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    public void reserveEndAnimateTransform(ImageView imageView, Animator animator) {
        animator.addListener(new AnimatorListenerAdapter(this, imageView) { // from class: android.support.transition.ImageViewUtilsApi14.1
            final ImageViewUtilsApi14 this$0;
            final ImageView val$view;

            {
                this.this$0 = this;
                this.val$view = imageView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ImageView.ScaleType scaleType = (ImageView.ScaleType) this.val$view.getTag(R.id.save_scale_type);
                this.val$view.setScaleType(scaleType);
                this.val$view.setTag(R.id.save_scale_type, null);
                if (scaleType == ImageView.ScaleType.MATRIX) {
                    this.val$view.setImageMatrix((Matrix) this.val$view.getTag(R.id.save_image_matrix));
                    this.val$view.setTag(R.id.save_image_matrix, null);
                }
                animator2.removeListener(this);
            }
        });
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    public void startAnimateTransform(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        imageView.setTag(R.id.save_scale_type, scaleType);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            imageView.setTag(R.id.save_image_matrix, imageView.getImageMatrix());
        } else {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
        imageView.setImageMatrix(MatrixUtils.IDENTITY_MATRIX);
    }
}
