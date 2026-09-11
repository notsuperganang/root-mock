package com.google.android.gms.internal.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.PlacesStatusCodes;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzdo extends DataBufferSafeParcelable<zzdn> implements Result {
    private final Status zzdz;

    public zzdo(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.zze(dataHolder.getStatusCode()));
    }

    private zzdo(DataHolder dataHolder, Status status) {
        super(dataHolder, zzdn.CREATOR);
        Preconditions.checkArgument(dataHolder == null || dataHolder.getStatusCode() == status.getStatusCode());
        this.zzdz = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdz;
    }
}
