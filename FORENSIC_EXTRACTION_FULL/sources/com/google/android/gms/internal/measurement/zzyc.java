package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzyc<M extends zzyc<M>> extends zzyi {
    protected zzye zzcev;

    @Override // com.google.android.gms.internal.measurement.zzyi
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzyc zzycVar = (zzyc) super.clone();
        zzyg.zza(this, zzycVar);
        return zzycVar;
    }

    public final <T> T zza(zzyd<M, T> zzydVar) {
        zzyf zzyfVarZzce;
        if (this.zzcev == null || (zzyfVarZzce = this.zzcev.zzce(zzydVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzyfVarZzce.zzb(zzydVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public void zza(zzya zzyaVar) throws IOException {
        if (this.zzcev == null) {
            return;
        }
        for (int i = 0; i < this.zzcev.size(); i++) {
            this.zzcev.zzcf(i).zza(zzyaVar);
        }
    }

    protected final boolean zza(zzxz zzxzVar, int i) throws IOException {
        int position = zzxzVar.getPosition();
        if (!zzxzVar.zzaq(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzyk zzykVar = new zzyk(i, zzxzVar.zzs(position, zzxzVar.getPosition() - position));
        zzyf zzyfVarZzce = null;
        if (this.zzcev == null) {
            this.zzcev = new zzye();
        } else {
            zzyfVarZzce = this.zzcev.zzce(i2);
        }
        if (zzyfVarZzce == null) {
            zzyfVarZzce = new zzyf();
            this.zzcev.zza(i2, zzyfVarZzce);
        }
        zzyfVarZzce.zza(zzykVar);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    protected int zzf() {
        int i = 0;
        if (this.zzcev == null) {
            return 0;
        }
        int iZzf = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzcev.size()) {
                return iZzf;
            }
            i = i2 + 1;
            iZzf += this.zzcev.zzcf(i2).zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    /* JADX INFO: renamed from: zzzb */
    public final /* synthetic */ zzyi clone() throws CloneNotSupportedException {
        return (zzyc) clone();
    }
}
