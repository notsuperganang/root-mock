package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
@zzadh
public final class zzpl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpl> CREATOR = new zzpm();

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 2)
    public final boolean zzbjn;

    @SafeParcelable.Field(id = 3)
    public final int zzbjo;

    @SafeParcelable.Field(id = 4)
    public final boolean zzbjp;

    @SafeParcelable.Field(id = 5)
    public final int zzbjq;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final zzmu zzbjr;

    @SafeParcelable.Constructor
    public zzpl(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) zzmu zzmuVar) {
        this.versionCode = i;
        this.zzbjn = z;
        this.zzbjo = i2;
        this.zzbjp = z2;
        this.zzbjq = i3;
        this.zzbjr = zzmuVar;
    }

    public zzpl(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzmu(nativeAdOptions.getVideoOptions()) : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbjn);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbjo);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbjp);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbjq);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzbjr, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
