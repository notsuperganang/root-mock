package com.google.android.gms.location.places;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.location.places.internal.zzaj;
import com.google.android.gms.location.places.internal.zzal;
import com.tiket.git.R;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private static final Comparator<zzaj> zzem = new zzj();
    private final Status zzdz;
    private final String zzea;
    private final int zzen;
    private final boolean zzeo;

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i) {
        this(dataHolder, false, i);
    }

    private PlaceLikelihoodBuffer(DataHolder dataHolder, boolean z, int i) {
        super(dataHolder);
        this.zzdz = PlacesStatusCodes.zze(dataHolder.getStatusCode());
        switch (i) {
            case 100:
            case R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /* 101 */:
            case 102:
            case R.styleable.AppCompatTheme_buttonStyle /* 103 */:
            case 104:
            case 105:
            case R.styleable.AppCompatTheme_checkedTextViewStyle /* 106 */:
            case R.styleable.AppCompatTheme_editTextStyle /* 107 */:
            case 108:
                this.zzen = i;
                this.zzeo = false;
                if (dataHolder == null || dataHolder.getMetadata() == null) {
                    this.zzea = null;
                    return;
                } else {
                    this.zzea = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
                    return;
                }
            default:
                throw new IllegalArgumentException(new StringBuilder(27).append("invalid source: ").append(i).toString());
        }
    }

    public static int zzb(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlaceLikelihood get(int i) {
        return new zzal(this.mDataHolder, i);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.zzea;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzdz;
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, getStatus()).add("attributions", this.zzea).toString();
    }
}
