package com.google.android.gms.common.server.response;

/* JADX INFO: loaded from: classes.dex */
final class zab implements FastParser.zaa<Long> {
    zab() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.common.server.response.FastParser.zab(com.google.android.gms.common.server.response.FastParser, java.io.BufferedReader):long
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:80)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 9
        	at java.base/java.util.ArrayList.add(ArrayList.java:484)
        	at java.base/java.util.ArrayList.add(ArrayList.java:496)
        	at jadx.core.utils.ListUtils.safeReplace(ListUtils.java:150)
        	at jadx.core.dex.visitors.InlineMethods.replaceClsUsage(InlineMethods.java:194)
        	at jadx.core.dex.visitors.InlineMethods.lambda$updateUsageInfo$0(InlineMethods.java:173)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:301)
        	at jadx.core.dex.visitors.InlineMethods.updateUsageInfo(InlineMethods.java:164)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:93)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
        	... 1 more
        */
    @Override // com.google.android.gms.common.server.response.FastParser.zaa
    public final /* synthetic */ java.lang.Long zah(com.google.android.gms.common.server.response.FastParser r3, java.io.BufferedReader r4) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r2 = this;
            long r0 = com.google.android.gms.common.server.response.FastParser.zab(r3, r4)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.zab.zah(com.google.android.gms.common.server.response.FastParser, java.io.BufferedReader):java.lang.Object");
    }
}
