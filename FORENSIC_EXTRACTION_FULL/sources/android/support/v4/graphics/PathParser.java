package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.util.Log;
import com.tiket.git.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public float[] mParams;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c2) {
                case 'A':
                case R.styleable.AppCompatTheme_alertDialogTheme /* 97 */:
                    i = 7;
                    break;
                case 'C':
                case R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /* 99 */:
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case R.styleable.AppCompatTheme_colorError /* 118 */:
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case R.styleable.AppCompatTheme_tooltipFrameBackground /* 116 */:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case R.styleable.AppCompatTheme_spinnerStyle /* 113 */:
                case R.styleable.AppCompatTheme_listMenuViewStyle /* 115 */:
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    i = 2;
                    f13 = f15;
                    f12 = f14;
                    f11 = f15;
                    f10 = f14;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i2 = 0;
            float f16 = f14;
            float f17 = f15;
            float f18 = f11;
            float f19 = f10;
            while (i2 < fArr2.length) {
                switch (c2) {
                    case 'A':
                        drawArc(path, f19, f18, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f20 = fArr2[i2 + 5];
                        float f21 = fArr2[i2 + 6];
                        f = f16;
                        f2 = f17;
                        f13 = f21;
                        f12 = f20;
                        f3 = f20;
                        f4 = f21;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f22 = fArr2[i2 + 4];
                        float f23 = fArr2[i2 + 5];
                        f12 = fArr2[i2 + 2];
                        f13 = fArr2[i2 + 3];
                        f = f16;
                        f2 = f17;
                        f3 = f22;
                        f4 = f23;
                        break;
                    case 'H':
                        path.lineTo(fArr2[i2 + 0], f18);
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0];
                        f4 = f18;
                        break;
                    case 'L':
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        break;
                    case 'M':
                        float f24 = fArr2[i2 + 0];
                        float f25 = fArr2[i2 + 1];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f = f24;
                            f2 = f25;
                            f3 = f24;
                            f4 = f25;
                        } else {
                            path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f = f16;
                            f2 = f17;
                            f3 = f24;
                            f4 = f25;
                        }
                        break;
                    case 'Q':
                        path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f12 = fArr2[i2 + 0];
                        f13 = fArr2[i2 + 1];
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 2];
                        f4 = fArr2[i2 + 3];
                        break;
                    case 'S':
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f6 = (2.0f * f18) - f13;
                            f7 = (2.0f * f19) - f12;
                        } else {
                            f7 = f19;
                            f6 = f18;
                        }
                        path.cubicTo(f7, f6, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f12 = fArr2[i2 + 0];
                        f13 = fArr2[i2 + 1];
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 2];
                        f4 = fArr2[i2 + 3];
                        break;
                    case 'T':
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f12 = (2.0f * f19) - f12;
                            f13 = (2.0f * f18) - f13;
                        } else {
                            f13 = f18;
                            f12 = f19;
                        }
                        path.quadTo(f12, f13, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        break;
                    case 'V':
                        path.lineTo(f19, fArr2[i2 + 0]);
                        f = f16;
                        f2 = f17;
                        f3 = f19;
                        f4 = fArr2[i2 + 0];
                        break;
                    case R.styleable.AppCompatTheme_alertDialogTheme /* 97 */:
                        drawArc(path, f19, f18, fArr2[i2 + 5] + f19, fArr2[i2 + 6] + f18, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f26 = f19 + fArr2[i2 + 5];
                        float f27 = fArr2[i2 + 6] + f18;
                        f = f16;
                        f2 = f17;
                        f13 = f27;
                        f12 = f26;
                        f3 = f26;
                        f4 = f27;
                        break;
                    case R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /* 99 */:
                        path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f12 = f19 + fArr2[i2 + 2];
                        f13 = fArr2[i2 + 3] + f18;
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 4] + f19;
                        f4 = f18 + fArr2[i2 + 5];
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i2 + 0], 0.0f);
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0] + f19;
                        f4 = f18;
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0] + f19;
                        f4 = f18 + fArr2[i2 + 1];
                        break;
                    case 'm':
                        float f28 = fArr2[i2 + 0] + f19;
                        float f29 = f18 + fArr2[i2 + 1];
                        if (i2 <= 0) {
                            path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f = f28;
                            f2 = f29;
                            f3 = f28;
                            f4 = f29;
                        } else {
                            path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f = f16;
                            f2 = f17;
                            f3 = f28;
                            f4 = f29;
                        }
                        break;
                    case R.styleable.AppCompatTheme_spinnerStyle /* 113 */:
                        path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f12 = f19 + fArr2[i2 + 0];
                        f13 = fArr2[i2 + 1] + f18;
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 2] + f19;
                        f4 = f18 + fArr2[i2 + 3];
                        break;
                    case R.styleable.AppCompatTheme_listMenuViewStyle /* 115 */:
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f8 = f18 - f13;
                            f9 = f19 - f12;
                        } else {
                            f8 = 0.0f;
                            f9 = 0.0f;
                        }
                        path.rCubicTo(f9, f8, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f12 = f19 + fArr2[i2 + 0];
                        f13 = fArr2[i2 + 1] + f18;
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 2] + f19;
                        f4 = f18 + fArr2[i2 + 3];
                        break;
                    case R.styleable.AppCompatTheme_tooltipFrameBackground /* 116 */:
                        float f30 = 0.0f;
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f30 = f18 - f13;
                            f5 = f19 - f12;
                        } else {
                            f5 = 0.0f;
                        }
                        path.rQuadTo(f5, f30, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f12 = f19 + f5;
                        f13 = f18 + f30;
                        f = f16;
                        f2 = f17;
                        f3 = fArr2[i2 + 0] + f19;
                        f4 = f18 + fArr2[i2 + 1];
                        break;
                    case R.styleable.AppCompatTheme_colorError /* 118 */:
                        path.rLineTo(0.0f, fArr2[i2 + 0]);
                        f = f16;
                        f2 = f17;
                        f3 = f19;
                        f4 = f18 + fArr2[i2 + 0];
                        break;
                    default:
                        f = f16;
                        f2 = f17;
                        f3 = f19;
                        f4 = f18;
                        break;
                }
                i2 += i;
                f16 = f;
                f17 = f2;
                f18 = f4;
                f19 = f3;
                c = c2;
            }
            fArr[0] = f19;
            fArr[1] = f18;
            fArr[2] = f12;
            fArr[3] = f13;
            fArr[4] = f16;
            fArr[5] = f17;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int iCeil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d10 = (((-d3) * dCos) * dSin2) - ((d4 * dSin) * dCos2);
            double d11 = (dSin2 * (-d3) * dSin) + (dCos2 * d4 * dCos);
            double d12 = d9 / ((double) iCeil);
            int i = 0;
            while (i < iCeil) {
                double d13 = d8 + d12;
                double dSin3 = Math.sin(d13);
                double dCos3 = Math.cos(d13);
                double d14 = (((d3 * dCos) * dCos3) + d) - ((d4 * dSin) * dSin3);
                double d15 = (d4 * dCos * dSin3) + (d3 * dSin * dCos3) + d2;
                double d16 = (((-d3) * dCos) * dSin3) - ((d4 * dSin) * dCos3);
                double d17 = (dCos3 * d4 * dCos) + (dSin3 * (-d3) * dSin);
                double dTan = Math.tan((d13 - d8) / 2.0d);
                double dSqrt = ((Math.sqrt((dTan * (3.0d * dTan)) + 4.0d) - 1.0d) * Math.sin(d13 - d8)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((dSqrt * d10) + d5), (float) ((d11 * dSqrt) + d6), (float) (d14 - (dSqrt * d16)), (float) (d15 - (dSqrt * d17)), (float) d14, (float) d15);
                i++;
                d8 = d13;
                d10 = d16;
                d11 = d17;
                d6 = d15;
                d5 = d14;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = ((((double) f) * dCos) + (((double) f2) * dSin)) / ((double) f5);
            double d4 = ((((double) (-f)) * dSin) + (((double) f2) * dCos)) / ((double) f6);
            double d5 = ((((double) f3) * dCos) + (((double) f4) * dSin)) / ((double) f5);
            double d6 = ((((double) (-f3)) * dSin) + (((double) f4) * dCos)) / ((double) f6);
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9 = (d3 + d5) / 2.0d;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d7 * d7) + (d8 * d8);
            if (d11 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d12 = (1.0d / d11) - 0.25d;
            if (d12 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d11);
                float fSqrt = (float) (Math.sqrt(d11) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d12);
            double d13 = d7 * dSqrt;
            double d14 = d8 * dSqrt;
            if (z == z2) {
                d = d9 - d14;
                d2 = d13 + d10;
            } else {
                d = d14 + d9;
                d2 = d10 - d13;
            }
            double dAtan2 = Math.atan2(d4 - d2, d3 - d);
            double dAtan3 = Math.atan2(d6 - d2, d5 - d) - dAtan2;
            if (z2 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d15 = ((double) f5) * d;
            double d16 = d2 * ((double) f6);
            arcToBezier(path, (d15 * dCos) - (d16 * dSin), (d15 * dSin) + (d16 * dCos), f5, f6, f, f2, radians, dAtan2, dAtan3);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            for (int i = 0; i < pathDataNode.mParams.length; i++) {
                this.mParams[i] = (pathDataNode.mParams[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
            }
        }
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        while (i2 < str.length()) {
            int iNextStart = nextStart(str, i2);
            String strTrim = str.substring(i, iNextStart).trim();
            if (strTrim.length() > 0) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i2 = iNextStart + 1;
            i = iNextStart;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] pathDataNodeArrCreateNodesFromPathData = createNodesFromPathData(str);
        if (pathDataNodeArrCreateNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(pathDataNodeArrCreateNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z = true;
                    z3 = false;
                    break;
                case '-':
                    if (i2 == i || z3) {
                        z3 = false;
                    } else {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = true;
                        z3 = false;
                    }
                    break;
                case '.':
                    if (z2) {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = true;
                        z3 = false;
                    } else {
                        z2 = true;
                        z3 = false;
                    }
                    break;
                case 'E':
                case R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /* 101 */:
                    z3 = true;
                    break;
                default:
                    z3 = false;
                    break;
            }
            if (z) {
                extractFloatResult.mEndPosition = i2;
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            int i = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    i2++;
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                } else {
                    i2 = i2;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
