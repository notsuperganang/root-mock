package com.google.android.gms.location.places.ui;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class zzf implements View.OnClickListener {
    private final /* synthetic */ SupportPlaceAutocompleteFragment zzhv;

    zzf(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.zzhv = supportPlaceAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zzhv.zzhq) {
            return;
        }
        this.zzhv.zzak();
    }
}
