package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public class PlaceAutocomplete extends zzb {
    public static final int MODE_FULLSCREEN = 1;
    public static final int MODE_OVERLAY = 2;
    public static final int RESULT_ERROR = 2;

    public static class IntentBuilder extends zzc {
        public IntentBuilder(int i) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.intent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            this.intent.putExtra("mode", i);
            this.intent.putExtra(FirebaseAnalytics.Param.ORIGIN, 2);
        }

        @Override // com.google.android.gms.location.places.ui.zzc
        public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.build(activity);
        }

        public IntentBuilder setBoundsBias(@Nullable LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.intent.putExtra("bounds", latLngBounds);
            } else {
                this.intent.removeExtra("bounds");
            }
            return this;
        }

        public IntentBuilder setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.intent.putExtra("filter", autocompleteFilter);
            } else {
                this.intent.removeExtra("filter");
            }
            return this;
        }

        public final IntentBuilder zzg(int i) {
            this.intent.putExtra(FirebaseAnalytics.Param.ORIGIN, 1);
            return this;
        }

        public final IntentBuilder zzh(@Nullable String str) {
            if (str != null) {
                this.intent.putExtra("initial_query", str);
            } else {
                this.intent.removeExtra("initial_query");
            }
            return this;
        }
    }

    private PlaceAutocomplete() {
    }

    public static Place getPlace(Context context, Intent intent) {
        return zzb.getPlace(context, intent);
    }

    public static Status getStatus(Context context, Intent intent) {
        return zzb.getStatus(context, intent);
    }
}
