package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzjm {
    public static final zzjm zzara = new zzjm();

    @VisibleForTesting
    protected zzjm() {
    }

    public static zzjj zza(Context context, zzlw zzlwVar) {
        Date birthday = zzlwVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzlwVar.getContentUrl();
        int gender = zzlwVar.getGender();
        Set<String> keywords = zzlwVar.getKeywords();
        List listUnmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean zIsTestDevice = zzlwVar.isTestDevice(context);
        int iZzit = zzlwVar.zzit();
        Location location = zzlwVar.getLocation();
        Bundle networkExtrasBundle = zzlwVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzlwVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzlwVar.getPublisherProvidedId();
        SearchAdRequest searchAdRequestZziq = zzlwVar.zziq();
        zzmq zzmqVar = searchAdRequestZziq != null ? new zzmq(searchAdRequestZziq) : null;
        String strZza = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzkb.zzif();
            strZza = zzamu.zza(Thread.currentThread().getStackTrace(), packageName);
        }
        return new zzjj(7, time, networkExtrasBundle, gender, listUnmodifiableList, zIsTestDevice, iZzit, manualImpressionsEnabled, publisherProvidedId, zzmqVar, location, contentUrl, zzlwVar.zzis(), zzlwVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzlwVar.zziu())), zzlwVar.zzip(), strZza, zzlwVar.isDesignedForFamilies());
    }
}
