package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.R;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public class SupportPlaceAutocompleteFragment extends Fragment {
    private View zzhn;
    private View zzho;
    private EditText zzhp;
    private boolean zzhq;

    @Nullable
    private LatLngBounds zzhr;

    @Nullable
    private AutocompleteFilter zzhs;

    @Nullable
    private PlaceSelectionListener zzht;

    private final void zzaj() {
        this.zzho.setVisibility(!this.zzhp.getText().toString().isEmpty() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak() {
        int i;
        try {
            Intent intentBuild = new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.zzhr).setFilter(this.zzhs).zzh(this.zzhp.getText().toString()).zzg(1).build(getActivity());
            this.zzhq = true;
            startActivityForResult(intentBuild, 30421);
            i = -1;
        } catch (GooglePlayServicesNotAvailableException e) {
            int i2 = e.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e);
            i = i2;
        } catch (GooglePlayServicesRepairableException e2) {
            int connectionStatusCode = e2.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e2);
            i = connectionStatusCode;
        }
        if (i != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i, 30422);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        this.zzhq = false;
        if (i == 30421) {
            if (i2 == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), intent);
                if (this.zzht != null) {
                    this.zzht.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (i2 == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), intent);
                if (this.zzht != null) {
                    this.zzht.onError(status);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.zzhn = viewInflate.findViewById(R.id.place_autocomplete_search_button);
        this.zzho = viewInflate.findViewById(R.id.place_autocomplete_clear_button);
        this.zzhp = (EditText) viewInflate.findViewById(R.id.place_autocomplete_search_input);
        zzf zzfVar = new zzf(this);
        this.zzhn.setOnClickListener(zzfVar);
        this.zzhp.setOnClickListener(zzfVar);
        this.zzho.setOnClickListener(new zzg(this));
        zzaj();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.zzhn = null;
        this.zzho = null;
        this.zzhp = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds latLngBounds) {
        this.zzhr = latLngBounds;
    }

    public void setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
        this.zzhs = autocompleteFilter;
    }

    public void setHint(CharSequence charSequence) {
        this.zzhp.setHint(charSequence);
        this.zzhn.setContentDescription(charSequence);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.zzht = placeSelectionListener;
    }

    public void setText(CharSequence charSequence) {
        this.zzhp.setText(charSequence);
        zzaj();
    }
}
