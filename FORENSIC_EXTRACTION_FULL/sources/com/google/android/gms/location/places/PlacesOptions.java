package com.google.android.gms.location.places;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {

    @Nullable
    private final Locale locale;

    @Nullable
    public final String zzcx;

    @Nullable
    public final String zzfc;

    @Nullable
    public final String zzfd;
    public final int zzfe;

    public static class Builder {
        private int zzfe = 0;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzfc = null;
        this.zzfd = null;
        this.zzfe = 0;
        this.zzcx = null;
        this.locale = null;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof PlacesOptions) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(0, 0) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(null, null, 0, null, null);
    }
}
