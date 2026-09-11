package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzkt extends IOException {
    public zzkt(String str) {
        super(str);
    }

    static zzkt zzhg() {
        return new zzkt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzkt zzhh() {
        return new zzkt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkt zzhi() {
        return new zzkt("CodedInputStream encountered a malformed varint.");
    }

    static zzkt zzhj() {
        return new zzkt("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
