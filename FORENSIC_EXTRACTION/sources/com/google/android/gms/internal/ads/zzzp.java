package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzzp extends zzzk {
    private final zzatg zzbvi;

    public zzzp(zzatg zzatgVar) {
        this.zzbvi = zzatgVar;
    }

    private static Bundle zzbt(String str) throws RemoteException {
        String strValueOf = String.valueOf(str);
        zzane.zzdk(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzane.zzb("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final zzlo getVideoController() {
        if (!(this.zzbvi instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.zzbvi).getVideoController();
        } catch (Throwable th) {
            zzane.zzb("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void showInterstitial() throws RemoteException {
        try {
            throw new NullPointerException();
        } catch (Throwable th) {
            zzane.zzb("", th);
            throw new RemoteException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzatj, com.google.android.gms.internal.ads.zzzs] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, zzzm zzzmVar) throws RemoteException {
        int i;
        try {
            ?? zzzsVar = new zzzs(this, zzzmVar);
            zzatg zzatgVar = this.zzbvi;
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            switch (str) {
                case "banner":
                    i = zzath.zzdgn;
                    break;
                case "interstitial":
                    i = zzath.zzdgo;
                    break;
                case "rewarded":
                    i = zzath.zzdgp;
                    break;
                case "native":
                    i = zzath.zzdgq;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            zzatgVar.zza(new zzati(context, i, bundle), zzzsVar);
        } catch (Throwable th) {
            zzane.zzb("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzf zzzfVar, zzxt zzxtVar, zzjn zzjnVar) throws RemoteException {
        try {
            zzzq zzzqVar = new zzzq(this, zzzfVar, zzxtVar);
            zzatg zzatgVar = this.zzbvi;
            new zzatf((Context) ObjectWrapper.unwrap(iObjectWrapper), bArr, zzbt(str), bundle);
            zzb.zza(zzjnVar.width, zzjnVar.height, zzjnVar.zzarb);
            zzzqVar.zzau(String.valueOf(zzatgVar.getClass().getSimpleName()).concat(" does not support banner."));
        } catch (Throwable th) {
            zzane.zzb("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzh zzzhVar, zzxt zzxtVar) throws RemoteException {
        try {
            zzzr zzzrVar = new zzzr(this, zzzhVar, zzxtVar);
            zzatg zzatgVar = this.zzbvi;
            new zzatf((Context) ObjectWrapper.unwrap(iObjectWrapper), bArr, zzbt(str), bundle);
            zzzrVar.zzau(String.valueOf(zzatgVar.getClass().getSimpleName()).concat(" does not support interstitial."));
        } catch (Throwable th) {
            zzane.zzb("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final zzzt zznc() throws RemoteException {
        return zzzt.zza(this.zzbvi.zzwa());
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final zzzt zznd() throws RemoteException {
        return zzzt.zza(this.zzbvi.zzvz());
    }
}
