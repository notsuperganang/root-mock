package com.google.android.gms.location.places.ui;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class zze implements View.OnClickListener {
    private final /* synthetic */ PlaceAutocompleteFragment zzhu;

    zze(PlaceAutocompleteFragment placeAutocompleteFragment) {
        this.zzhu = placeAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzhu.setText("");
    }
}
