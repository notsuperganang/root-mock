package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq implements PlacePhotoMetadata {
    private final int index;
    private final int maxHeight;
    private final int maxWidth;
    private final String zzhd;
    private final CharSequence zzhe;

    public zzaq(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzhd = str;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.zzhe = charSequence;
        this.index = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaq)) {
            return false;
        }
        zzaq zzaqVar = (zzaq) obj;
        return zzaqVar.maxWidth == this.maxWidth && zzaqVar.maxHeight == this.maxHeight && Objects.equal(zzaqVar.zzhd, this.zzhd) && Objects.equal(zzaqVar.zzhe, this.zzhe);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlacePhotoMetadata freeze() {
        if (this == null) {
            throw null;
        }
        return this;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final CharSequence getAttributions() {
        return this.zzhe;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, int i, int i2) {
        return ((zzi) Places.GeoDataApi).zzb(googleApiClient, this, i, i2);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxWidth), Integer.valueOf(this.maxHeight), this.zzhd, this.zzhe);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String zzah() {
        return this.zzhd;
    }
}
