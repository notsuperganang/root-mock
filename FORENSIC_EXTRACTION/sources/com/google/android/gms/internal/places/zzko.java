package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzko;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzko<M extends zzko<M>> extends zzku {
    protected zzkq zzaaf;

    @Override // com.google.android.gms.internal.places.zzku
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzko zzkoVar = (zzko) super.clone();
        zzks.zzb(this, zzkoVar);
        return zzkoVar;
    }

    @Override // com.google.android.gms.internal.places.zzku
    protected int zzal() {
        int iZzal = 0;
        if (this.zzaaf == null) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = iZzal;
            if (i >= this.zzaaf.size()) {
                return i2;
            }
            iZzal = this.zzaaf.zzbv(i).zzal() + i2;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzku
    public void zzb(zzkm zzkmVar) throws IOException {
        if (this.zzaaf == null) {
            return;
        }
        for (int i = 0; i < this.zzaaf.size(); i++) {
            this.zzaaf.zzbv(i).zzb(zzkmVar);
        }
    }

    protected final boolean zzb(zzkl zzklVar, int i) throws IOException {
        int position = zzklVar.getPosition();
        if (!zzklVar.zzai(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzkw zzkwVar = new zzkw(i, zzklVar.zzt(position, zzklVar.getPosition() - position));
        zzkr zzkrVarZzbu = null;
        if (this.zzaaf == null) {
            this.zzaaf = new zzkq();
        } else {
            zzkrVarZzbu = this.zzaaf.zzbu(i2);
        }
        if (zzkrVarZzbu == null) {
            zzkrVarZzbu = new zzkr();
            this.zzaaf.zzb(i2, zzkrVarZzbu);
        }
        zzkrVarZzbu.zzb(zzkwVar);
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzku
    /* JADX INFO: renamed from: zzhe */
    public final /* synthetic */ zzku clone() throws CloneNotSupportedException {
        return (zzko) clone();
    }
}
