package com.google.android.gms.location.places;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.places.zzdo;
import com.google.android.gms.location.places.internal.zzz;

/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzz {
    private static final String TAG = zzm.class.getSimpleName();
    private final zze zzex;
    private final zzb zzey;
    private final zzf zzez;
    private final zzg zzfa;
    private final zzd zzfb;

    public static abstract class zzb<A extends Api.Client> extends zzc<AutocompletePredictionBuffer, A> {
        public zzb(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected /* synthetic */ Result createFailedResult(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.empty(status.getStatusCode()));
        }
    }

    public static abstract class zzc<R extends Result, A extends Api.Client> extends BaseImplementation.ApiMethodImpl<R, A> {
        public zzc(Api api, GoogleApiClient googleApiClient) {
            super((Api<?>) api, googleApiClient);
        }
    }

    public static abstract class zzd<A extends Api.Client> extends zzc<PlaceBuffer, A> {
        public zzd(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected /* synthetic */ Result createFailedResult(Status status) {
            return new PlaceBuffer(DataHolder.empty(status.getStatusCode()));
        }
    }

    public static abstract class zze<A extends Api.Client> extends zzc<PlaceLikelihoodBuffer, A> {
        public zze(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected /* synthetic */ Result createFailedResult(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.empty(status.getStatusCode()), 100);
        }
    }

    @Deprecated
    public static abstract class zzf<A extends Api.Client> extends zzc<zzdo, A> {
    }

    public static abstract class zzg<A extends Api.Client> extends zzc<Status, A> {
        public zzg(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }
    }

    public zzm(zzb zzbVar) {
        this.zzex = null;
        this.zzey = zzbVar;
        this.zzez = null;
        this.zzfa = null;
        this.zzfb = null;
    }

    public zzm(zzd zzdVar) {
        this.zzex = null;
        this.zzey = null;
        this.zzez = null;
        this.zzfa = null;
        this.zzfb = zzdVar;
    }

    public zzm(zze zzeVar) {
        this.zzex = zzeVar;
        this.zzey = null;
        this.zzez = null;
        this.zzfa = null;
        this.zzfb = null;
    }

    public zzm(zzg zzgVar) {
        this.zzex = null;
        this.zzey = null;
        this.zzez = null;
        this.zzfa = zzgVar;
        this.zzfb = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzy
    public final void zzb(DataHolder dataHolder) throws RemoteException {
        Preconditions.checkState(this.zzex != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            Bundle metadata = dataHolder.getMetadata();
            this.zzex.setResult(new PlaceLikelihoodBuffer(dataHolder, metadata == null ? 100 : PlaceLikelihoodBuffer.zzb(metadata)));
        } else {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder", new Throwable());
            }
            this.zzex.setFailedResult(Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzy
    public final void zzc(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.zzey.setResult(new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onAutocompletePrediction received null DataHolder", new Throwable());
        }
        this.zzey.setFailedResult(Status.RESULT_INTERNAL_ERROR);
    }

    @Override // com.google.android.gms.location.places.internal.zzy
    public final void zzd(DataHolder dataHolder) throws RemoteException {
        BasePendingResult basePendingResult = null;
        BaseImplementation.ResultHolder resultHolder = null;
        if (dataHolder != null) {
            basePendingResult.setResult(new zzdo(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onPlaceUserDataFetched received null DataHolder", new Throwable());
        }
        resultHolder.setFailedResult(Status.RESULT_INTERNAL_ERROR);
    }

    @Override // com.google.android.gms.location.places.internal.zzy
    public final void zze(Status status) throws RemoteException {
        this.zzfa.setResult(status);
    }

    @Override // com.google.android.gms.location.places.internal.zzy
    public final void zze(DataHolder dataHolder) throws RemoteException {
        this.zzfb.setResult(new PlaceBuffer(dataHolder));
    }
}
