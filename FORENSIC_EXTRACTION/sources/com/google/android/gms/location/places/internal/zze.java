package com.google.android.gms.location.places.internal;

import android.support.annotation.Nullable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zze extends zzav implements AutocompletePrediction {
    public zze(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private final String zzaa() {
        return zzc("ap_description", "");
    }

    private final String zzab() {
        return zzc("ap_primary_text", "");
    }

    private final String zzac() {
        return zzc("ap_secondary_text", "");
    }

    private final List<zzc> zzad() {
        return zzb("ap_matched_subscriptions", zzc.CREATOR, Collections.emptyList());
    }

    private final List<zzc> zzae() {
        return zzb("ap_primary_text_matched", zzc.CREATOR, Collections.emptyList());
    }

    private final List<zzc> zzaf() {
        return zzb("ap_secondary_text_matched", zzc.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ AutocompletePrediction freeze() {
        String placeId = getPlaceId();
        List<Integer> placeTypes = getPlaceTypes();
        int iZzc = zzc("ap_personalization_type", 6);
        String strZzaa = zzaa();
        return new zzb(placeId, placeTypes, iZzc, (String) Preconditions.checkNotNull(strZzaa), zzad(), zzab(), zzae(), zzac(), zzaf());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(zzaa(), zzad(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final String getPlaceId() {
        return zzc("ap_place_id", (String) null);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final List<Integer> getPlaceTypes() {
        return zzb("ap_place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(zzab(), zzae(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzh.zzb(zzac(), zzaf(), characterStyle);
    }
}
