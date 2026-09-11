package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzav implements Place {
    private final String placeId;
    private final zzah zzgo;

    public zzas(DataHolder dataHolder, int i) {
        zzah zzahVar;
        super(dataHolder, i);
        this.placeId = zzc("place_id", "");
        if (getPlaceTypes().size() > 0 || (getPhoneNumber() != null && getPhoneNumber().length() > 0) || (!(getWebsiteUri() == null || getWebsiteUri().equals(Uri.EMPTY)) || getRating() >= 0.0f || getPriceLevel() >= 0)) {
            zzahVar = new zzah(getPlaceTypes(), getPhoneNumber() != null ? getPhoneNumber().toString() : null, getWebsiteUri(), getRating(), getPriceLevel());
        } else {
            zzahVar = null;
        }
        this.zzgo = zzahVar;
    }

    private final List<String> zzai() {
        return zzc("place_attributions", Collections.emptyList());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Place freeze() {
        PlaceEntity placeEntityZzag = new PlaceEntity.zzb().zze(getAddress().toString()).zzd(zzai()).zzc(getId()).zzb((!hasColumn("place_is_permanently_closed") || hasNull("place_is_permanently_closed")) ? false : getBoolean("place_is_permanently_closed")).zzb(getLatLng()).zzb(zzb("place_level_number", 0.0f)).zzd(getName().toString()).zzf(getPhoneNumber().toString()).zzf(getPriceLevel()).zzc(getRating()).zzc(getPlaceTypes()).zzb(getViewport()).zzb(getWebsiteUri()).zzb((zzam) zzb("place_opening_hours", zzam.CREATOR)).zzb(this.zzgo).zzg(zzc("place_adr_address", "")).zzag();
        placeEntityZzag.setLocale(getLocale());
        return placeEntityZzag;
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getAddress() {
        return zzc("place_address", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getAttributions() {
        return zzh.zzg(zzai());
    }

    @Override // com.google.android.gms.location.places.Place
    public final String getId() {
        return this.placeId;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLng getLatLng() {
        return (LatLng) zzb("place_lat_lng", LatLng.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public final Locale getLocale() {
        String strZzc = zzc("place_locale_language", "");
        if (!TextUtils.isEmpty(strZzc)) {
            return new Locale(strZzc, zzc("place_locale_country", ""));
        }
        String strZzc2 = zzc("place_locale", "");
        return !TextUtils.isEmpty(strZzc2) ? new Locale(strZzc2) : Locale.getDefault();
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getName() {
        return zzc("place_name", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getPhoneNumber() {
        return zzc("place_phone_number", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final List<Integer> getPlaceTypes() {
        return zzb("place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.Place
    public final int getPriceLevel() {
        return zzc("place_price_level", -1);
    }

    @Override // com.google.android.gms.location.places.Place
    public final float getRating() {
        return zzb("place_rating", -1.0f);
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLngBounds getViewport() {
        return (LatLngBounds) zzb("place_viewport", LatLngBounds.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public final Uri getWebsiteUri() {
        String strZzc = zzc("place_website_uri", (String) null);
        if (strZzc == null) {
            return null;
        }
        return Uri.parse(strZzc);
    }
}
