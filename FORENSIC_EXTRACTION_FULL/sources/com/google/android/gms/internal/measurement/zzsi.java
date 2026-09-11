package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzsi<T> {
    private final String name;
    private volatile T zzall;
    private final zzso zzbrq;
    private final T zzbrr;
    private volatile int zzbrt;
    private static final Object zzbro = new Object();

    @SuppressLint({"StaticFieldLeak"})
    private static Context zzri = null;
    private static boolean zzbrp = false;
    private static final AtomicInteger zzbrs = new AtomicInteger();

    private zzsi(zzso zzsoVar, String str, T t) {
        this.zzbrt = -1;
        if (zzsoVar.zzbrv == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzbrq = zzsoVar;
        this.name = str;
        this.zzbrr = t;
    }

    /* synthetic */ zzsi(zzso zzsoVar, String str, Object obj, zzsj zzsjVar) {
        this(zzsoVar, str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsi<Double> zza(zzso zzsoVar, String str, double d) {
        return new zzsm(zzsoVar, str, Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsi<Integer> zza(zzso zzsoVar, String str, int i) {
        return new zzsk(zzsoVar, str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsi<Long> zza(zzso zzsoVar, String str, long j) {
        return new zzsj(zzsoVar, str, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsi<String> zza(zzso zzsoVar, String str, String str2) {
        return new zzsn(zzsoVar, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsi<Boolean> zza(zzso zzsoVar, String str, boolean z) {
        return new zzsl(zzsoVar, str, Boolean.valueOf(z));
    }

    public static void zzae(Context context) {
        synchronized (zzbro) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzri != context) {
                synchronized (zzrx.class) {
                    try {
                        zzrx.zzbrd.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                synchronized (zzsp.class) {
                    try {
                        zzsp.zzbsb.clear();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                synchronized (zzse.class) {
                    try {
                        zzse.zzbrl = null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                zzbrs.incrementAndGet();
                zzri = context;
            }
        }
    }

    private final String zzfr(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.name);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    static void zztq() {
        zzbrs.incrementAndGet();
    }

    @Nullable
    private final T zzts() {
        zzsb zzsbVarZzi;
        Object objZzfn;
        zzso zzsoVar = this.zzbrq;
        String str = (String) zzse.zzad(zzri).zzfn("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (str != null && zzru.zzbqq.matcher(str).matches()) {
            String strValueOf = String.valueOf(zztr());
            Log.w("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else {
            if (this.zzbrq.zzbrv != null) {
                zzsbVarZzi = zzrx.zza(zzri.getContentResolver(), this.zzbrq.zzbrv);
            } else {
                Context context = zzri;
                zzso zzsoVar2 = this.zzbrq;
                zzsbVarZzi = zzsp.zzi(context, null);
            }
            if (zzsbVarZzi != null && (objZzfn = zzsbVarZzi.zzfn(zztr())) != null) {
                return zzs(objZzfn);
            }
        }
        return null;
    }

    @Nullable
    private final T zztt() {
        zzso zzsoVar = this.zzbrq;
        zzse zzseVarZzad = zzse.zzad(zzri);
        zzso zzsoVar2 = this.zzbrq;
        Object objZzfn = zzseVarZzad.zzfn(zzfr(this.zzbrq.zzbrw));
        if (objZzfn != null) {
            return zzs(objZzfn);
        }
        return null;
    }

    public final T get() {
        int i = zzbrs.get();
        if (this.zzbrt < i) {
            synchronized (this) {
                if (this.zzbrt < i) {
                    if (zzri == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    zzso zzsoVar = this.zzbrq;
                    T tZzts = zzts();
                    if (tZzts == null && (tZzts = zztt()) == null) {
                        tZzts = this.zzbrr;
                    }
                    this.zzall = tZzts;
                    this.zzbrt = i;
                }
            }
        }
        return this.zzall;
    }

    public final T getDefaultValue() {
        return this.zzbrr;
    }

    abstract T zzs(Object obj);

    public final String zztr() {
        return zzfr(this.zzbrq.zzbrx);
    }
}
