package android.support.v4.graphics;

import android.graphics.Rect;
import android.support.v4.util.Pair;

/* JADX INFO: loaded from: classes.dex */
class PaintCompatApi14 {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<>();

    PaintCompatApi14() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r6 < r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean hasGlyph(@android.support.annotation.NonNull android.graphics.Paint r9, @android.support.annotation.NonNull java.lang.String r10) {
        /*
            r3 = 0
            r1 = 1
            r2 = 0
            int r4 = r10.length()
            if (r4 != r1) goto L15
            char r0 = r10.charAt(r2)
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L15
            r0 = r1
        L14:
            return r0
        L15:
            java.lang.String r0 = "\udfffd"
            float r5 = r9.measureText(r0)
            java.lang.String r0 = "m"
            float r0 = r9.measureText(r0)
            float r6 = r9.measureText(r10)
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 == 0) goto L82
            int r7 = r10.length()
            int r7 = r10.codePointCount(r2, r7)
            if (r7 <= r1) goto L52
            r7 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 * r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L82
            r0 = r2
        L3b:
            if (r0 >= r4) goto L4e
            int r7 = r10.codePointAt(r0)
            int r7 = java.lang.Character.charCount(r7)
            int r8 = r0 + r7
            float r8 = r9.measureText(r10, r0, r8)
            float r3 = r3 + r8
            int r0 = r0 + r7
            goto L3b
        L4e:
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 >= 0) goto L82
        L52:
            int r0 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r0 == 0) goto L58
            r0 = r1
            goto L14
        L58:
            android.support.v4.util.Pair r3 = obtainEmptyRects()
            java.lang.String r5 = "\udfffd"
            java.lang.String r0 = "\udfffd"
            int r6 = r0.length()
            F r0 = r3.first
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            r9.getTextBounds(r5, r2, r6, r0)
            S r0 = r3.second
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            r9.getTextBounds(r10, r2, r4, r0)
            F r0 = r3.first
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            S r3 = r3.second
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L80
            r0 = r1
            goto L14
        L80:
            r0 = r2
            goto L14
        L82:
            r0 = r2
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.PaintCompatApi14.hasGlyph(android.graphics.Paint, java.lang.String):boolean");
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Pair<Rect, Rect> pair = sRectThreadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            sRectThreadLocal.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }
}
