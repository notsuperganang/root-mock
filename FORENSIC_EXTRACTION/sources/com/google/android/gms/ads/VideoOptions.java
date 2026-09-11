package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzmu;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class VideoOptions {
    private final boolean zzuz;
    private final boolean zzva;
    private final boolean zzvb;

    public static final class Builder {
        private boolean zzuz = true;
        private boolean zzva = false;
        private boolean zzvb = false;

        public final VideoOptions build() {
            return new VideoOptions(this, null);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzvb = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzva = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzuz = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzuz = builder.zzuz;
        this.zzva = builder.zzva;
        this.zzvb = builder.zzvb;
    }

    /* synthetic */ VideoOptions(Builder builder, zzc zzcVar) {
        this(builder);
    }

    public VideoOptions(zzmu zzmuVar) {
        this.zzuz = zzmuVar.zzato;
        this.zzva = zzmuVar.zzatp;
        this.zzvb = zzmuVar.zzatq;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzvb;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzva;
    }

    public final boolean getStartMuted() {
        return this.zzuz;
    }
}
