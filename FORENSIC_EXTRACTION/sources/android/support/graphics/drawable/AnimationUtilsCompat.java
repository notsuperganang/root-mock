package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtilsCompat {
    private static Interpolator createInterpolatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator linearInterpolator = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                String name = xmlPullParser.getName();
                if (name.equals("linearInterpolator")) {
                    linearInterpolator = new LinearInterpolator();
                } else if (name.equals("accelerateInterpolator")) {
                    linearInterpolator = new AccelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("decelerateInterpolator")) {
                    linearInterpolator = new DecelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("accelerateDecelerateInterpolator")) {
                    linearInterpolator = new AccelerateDecelerateInterpolator();
                } else if (name.equals("cycleInterpolator")) {
                    linearInterpolator = new CycleInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateInterpolator")) {
                    linearInterpolator = new AnticipateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("overshootInterpolator")) {
                    linearInterpolator = new OvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateOvershootInterpolator")) {
                    linearInterpolator = new AnticipateOvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("bounceInterpolator")) {
                    linearInterpolator = new BounceInterpolator();
                } else {
                    if (!name.equals("pathInterpolator")) {
                        throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    }
                    linearInterpolator = new PathInterpolatorCompat(context, attributeSetAsAttributeSet, xmlPullParser);
                }
            }
        }
        return linearInterpolator;
    }

    public static Interpolator loadInterpolator(Context context, int i) throws Resources.NotFoundException {
        Interpolator interpolatorCreateInterpolatorFromXml;
        XmlResourceParser animation = null;
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        try {
            try {
                if (i == 17563663) {
                    interpolatorCreateInterpolatorFromXml = new FastOutLinearInInterpolator();
                } else if (i == 17563661) {
                    interpolatorCreateInterpolatorFromXml = new FastOutSlowInInterpolator();
                } else if (i == 17563662) {
                    interpolatorCreateInterpolatorFromXml = new LinearOutSlowInInterpolator();
                } else {
                    animation = context.getResources().getAnimation(i);
                    interpolatorCreateInterpolatorFromXml = createInterpolatorFromXml(context, context.getResources(), context.getTheme(), animation);
                    if (animation != null) {
                        animation.close();
                    }
                }
                return interpolatorCreateInterpolatorFromXml;
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }
}
