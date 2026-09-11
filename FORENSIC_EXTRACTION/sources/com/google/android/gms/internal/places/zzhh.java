package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzhh extends IOException {
    private zzih zzto;

    public zzhh(String str) {
        super(str);
        this.zzto = null;
    }

    static zzhh zzdz() {
        return new zzhh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzhh zzea() {
        return new zzhh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzhh zzeb() {
        return new zzhh("CodedInputStream encountered a malformed varint.");
    }

    static zzhh zzec() {
        return new zzhh("Protocol message end-group tag did not match expected tag.");
    }

    static zzhi zzed() {
        return new zzhi("Protocol message tag had invalid wire type.");
    }

    static zzhh zzee() {
        return new zzhh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzhh zzef() {
        return new zzhh("Failed to parse the message.");
    }

    static zzhh zzeg() {
        return new zzhh("Protocol message had invalid UTF-8.");
    }

    public final zzhh zzh(zzih zzihVar) {
        this.zzto = zzihVar;
        return this;
    }
}
