package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.GuardedBy;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzaw {
    private final Context zzac;
    private final SharedPreferences zzdh;
    private final zzy zzdi;

    @GuardedBy("this")
    private final Map<String, zzz> zzdj;

    public zzaw(Context context) {
        this(context, new zzy());
    }

    private zzaw(Context context, zzy zzyVar) {
        this.zzdj = new ArrayMap();
        this.zzac = context;
        this.zzdh = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzdi = zzyVar;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzac), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            zzal();
            FirebaseInstanceId.getInstance().zzn();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    private final boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this) {
            zIsEmpty = this.zzdh.getAll().isEmpty();
        }
        return zIsEmpty;
    }

    private static String zza(String str, String str2, String str3) {
        return new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    static String zzd(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
    }

    public final void zza(String str, String str2, String str3, String str4, String str5) {
        synchronized (this) {
            String strZza = zzax.zza(str4, str5, System.currentTimeMillis());
            if (strZza != null) {
                SharedPreferences.Editor editorEdit = this.zzdh.edit();
                editorEdit.putString(zza(str, str2, str3), strZza);
                editorEdit.commit();
            }
        }
    }

    public final String zzak() {
        String string;
        synchronized (this) {
            string = this.zzdh.getString("topic_operaion_queue", "");
        }
        return string;
    }

    public final void zzal() {
        synchronized (this) {
            this.zzdj.clear();
            zzy.zza(this.zzac);
            this.zzdh.edit().clear().commit();
        }
    }

    public final zzax zzb(String str, String str2, String str3) {
        zzax zzaxVarZzi;
        synchronized (this) {
            zzaxVarZzi = zzax.zzi(this.zzdh.getString(zza(str, str2, str3), null));
        }
        return zzaxVarZzi;
    }

    public final void zzc(String str, String str2, String str3) {
        synchronized (this) {
            String strZza = zza(str, str2, str3);
            SharedPreferences.Editor editorEdit = this.zzdh.edit();
            editorEdit.remove(strZza);
            editorEdit.commit();
        }
    }

    public final void zzf(String str) {
        synchronized (this) {
            this.zzdh.edit().putString("topic_operaion_queue", str).apply();
        }
    }

    public final zzz zzg(String str) {
        zzz zzzVarZzc;
        synchronized (this) {
            zzzVarZzc = this.zzdj.get(str);
            if (zzzVarZzc == null) {
                try {
                    zzzVarZzc = this.zzdi.zzb(this.zzac, str);
                } catch (zzaa e) {
                    Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
                    FirebaseInstanceId.getInstance().zzn();
                    zzzVarZzc = this.zzdi.zzc(this.zzac, str);
                }
                this.zzdj.put(str, zzzVarZzc);
            }
        }
        return zzzVarZzc;
    }

    public final void zzh(String str) {
        synchronized (this) {
            String strConcat = String.valueOf(str).concat("|T|");
            SharedPreferences.Editor editorEdit = this.zzdh.edit();
            for (String str2 : this.zzdh.getAll().keySet()) {
                if (str2.startsWith(strConcat)) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
        }
    }
}
