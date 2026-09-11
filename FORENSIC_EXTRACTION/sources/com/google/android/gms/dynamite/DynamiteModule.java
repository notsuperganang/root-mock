package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class DynamiteModule {

    @GuardedBy("DynamiteModule.class")
    private static Boolean zzid;

    @GuardedBy("DynamiteModule.class")
    private static zzi zzie;

    @GuardedBy("DynamiteModule.class")
    private static zzk zzif;

    @GuardedBy("DynamiteModule.class")
    private static String zzig;
    private final Context zzim;

    @GuardedBy("DynamiteModule.class")
    private static int zzih = -1;
    private static final ThreadLocal<zza> zzii = new ThreadLocal<>();
    private static final VersionPolicy.zza zzij = new com.google.android.gms.dynamite.zza();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new com.google.android.gms.dynamite.zzb();
    private static final VersionPolicy zzik = new zzc();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    private static final VersionPolicy zzil = new zzg();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.zza zzaVar) {
            this(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.zza zzaVar) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface zza {
            int getLocalVersion(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        public static final class zzb {
            public int zziq = 0;
            public int zzir = 0;
            public int zzis = 0;
        }

        zzb zza(Context context, String str, zza zzaVar) throws LoadingException;
    }

    private static final class zza {
        public Cursor zzin;

        private zza() {
        }

        /* synthetic */ zza(com.google.android.gms.dynamite.zza zzaVar) {
            this();
        }
    }

    private static final class zzb implements VersionPolicy.zza {
        private final int zzio;
        private final int zzip = 0;

        public zzb(int i, int i2) {
            this.zzio = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int getLocalVersion(Context context, String str) {
            return this.zzio;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.zzim = (Context) Preconditions.checkNotNull(context);
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        int i = 0;
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf(str).length() + 61).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".ModuleDescriptor").toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                i = declaredField2.getInt(null);
            } else {
                String strValueOf = String.valueOf(declaredField.get(null));
                Log.e("DynamiteModule", new StringBuilder(String.valueOf(strValueOf).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(strValueOf).append("' didn't match expected id '").append(str).append("'").toString());
            }
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
        }
        return i;
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        zza zzaVar = zzii.get();
        zza zzaVar2 = new zza(null);
        zzii.set(zzaVar2);
        try {
            VersionPolicy.zzb zzbVarZza = versionPolicy.zza(context, str, zzij);
            Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zzbVarZza.zziq).append(" and remote module ").append(str).append(":").append(zzbVarZza.zzir).toString());
            if (zzbVarZza.zzis == 0 || ((zzbVarZza.zzis == -1 && zzbVarZza.zziq == 0) || (zzbVarZza.zzis == 1 && zzbVarZza.zzir == 0))) {
                throw new LoadingException(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zzbVarZza.zziq).append(" and remote version is ").append(zzbVarZza.zzir).append(".").toString(), (com.google.android.gms.dynamite.zza) null);
            }
            if (zzbVarZza.zzis == -1) {
                DynamiteModule dynamiteModuleZze = zze(context, str);
                if (zzaVar2.zzin != null) {
                    zzaVar2.zzin.close();
                }
                zzii.set(zzaVar);
                return dynamiteModuleZze;
            }
            if (zzbVarZza.zzis != 1) {
                throw new LoadingException(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zzbVarZza.zzis).toString(), (com.google.android.gms.dynamite.zza) null);
            }
            try {
                DynamiteModule dynamiteModuleZza = zza(context, str, zzbVarZza.zzir);
                if (zzaVar2.zzin != null) {
                    zzaVar2.zzin.close();
                }
                zzii.set(zzaVar);
                return dynamiteModuleZza;
            } catch (LoadingException e) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                if (zzbVarZza.zziq == 0 || versionPolicy.zza(context, str, new zzb(zzbVarZza.zziq, 0)).zzis != -1) {
                    throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                }
                DynamiteModule dynamiteModuleZze2 = zze(context, str);
                if (zzaVar2.zzin != null) {
                    zzaVar2.zzin.close();
                }
                zzii.set(zzaVar);
                return dynamiteModuleZze2;
            }
        } catch (Throwable th) {
            if (zzaVar2.zzin != null) {
                zzaVar2.zzin.close();
            }
            zzii.set(zzaVar);
            throw th;
        }
    }

    public static int zza(Context context, String str, boolean z) {
        try {
            synchronized (DynamiteModule.class) {
                try {
                    Boolean bool = zzid;
                    if (bool == null) {
                        try {
                            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                            Field declaredField = clsLoadClass.getDeclaredField("sClassLoader");
                            synchronized (clsLoadClass) {
                                try {
                                    ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                    if (classLoader != null) {
                                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                zza(classLoader);
                                            } catch (LoadingException e) {
                                            }
                                            bool = Boolean.TRUE;
                                        }
                                    } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iZzc = zzc(context, str, z);
                                            if (zzig == null || zzig.isEmpty()) {
                                                return iZzc;
                                            }
                                            zzh zzhVar = new zzh(zzig, ClassLoader.getSystemClassLoader());
                                            zza(zzhVar);
                                            declaredField.set(null, zzhVar);
                                            zzid = Boolean.TRUE;
                                            return iZzc;
                                        } catch (LoadingException e2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                    zzid = bool;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                            String strValueOf = String.valueOf(e3);
                            Log.w("DynamiteModule", new StringBuilder(String.valueOf(strValueOf).length() + 30).append("Failed to load module via V2: ").append(strValueOf).toString());
                            bool = Boolean.FALSE;
                        }
                    }
                    if (!bool.booleanValue()) {
                        return zzb(context, str, z);
                    }
                    try {
                        return zzc(context, str, z);
                    } catch (LoadingException e4) {
                        String strValueOf2 = String.valueOf(e4.getMessage());
                        Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            CrashUtils.addDynamiteErrorToDropBox(context, th3);
            throw th3;
        }
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzk zzkVar) {
        IObjectWrapper iObjectWrapperZza;
        try {
            ObjectWrapper.wrap(null);
            if (zzai().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                iObjectWrapperZza = zzkVar.zzb(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapperZza = zzkVar.zza(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(cursor));
            }
            return (Context) ObjectWrapper.unwrap(iObjectWrapperZza);
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(strValueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                try {
                    bool = zzid;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zza) null);
            }
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        } catch (Throwable th2) {
            CrashUtils.addDynamiteErrorToDropBox(context, th2);
            throw th2;
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzk zzlVar;
        com.google.android.gms.dynamite.zza zzaVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzlVar = iInterfaceQueryLocalInterface instanceof zzk ? (zzk) iInterfaceQueryLocalInterface : new zzl(iBinder);
            }
            zzif = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzaVar);
        }
    }

    private static Boolean zzai() {
        boolean z;
        synchronized (DynamiteModule.class) {
            try {
                z = zzih >= 2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return Boolean.valueOf(z);
    }

    private static int zzb(Context context, String str, boolean z) {
        int iZza;
        zzi zziVarZzj = zzj(context);
        if (zziVarZzj == null) {
            return 0;
        }
        try {
            if (zziVarZzj.zzaj() >= 2) {
                iZza = zziVarZzj.zzb(ObjectWrapper.wrap(context), str, z);
            } else {
                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                iZza = zziVarZzj.zza(ObjectWrapper.wrap(context), str, z);
            }
            return iZza;
        } catch (RemoteException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException {
        IObjectWrapper iObjectWrapperZza;
        com.google.android.gms.dynamite.zza zzaVar = null;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzi zziVarZzj = zzj(context);
        if (zziVarZzj == null) {
            throw new LoadingException("Failed to create IDynamiteLoader.", zzaVar);
        }
        try {
            if (zziVarZzj.zzaj() >= 2) {
                iObjectWrapperZza = zziVarZzj.zzb(ObjectWrapper.wrap(context), str, i);
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                iObjectWrapperZza = zziVarZzj.zza(ObjectWrapper.wrap(context), str, i);
            }
            if (ObjectWrapper.unwrap(iObjectWrapperZza) == null) {
                throw new LoadingException("Failed to load remote module.", zzaVar);
            }
            return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapperZza));
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, zzaVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0066  */
    private static int zzc(Context context, String str, boolean z) throws Throwable {
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                String str2 = z ? "api_force_staging" : "api";
                Cursor cursorQuery = contentResolver.query(Uri.parse(new StringBuilder(String.valueOf(str2).length() + 42 + String.valueOf(str).length()).append("content://com.google.android.gms.chimera/").append(str2).append("/").append(str).toString()), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        zzig = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            zzih = cursorQuery.getInt(columnIndex);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                zza zzaVar = zzii.get();
                                if (zzaVar != null && zzaVar.zzin == null) {
                                    zzaVar.zzin = cursorQuery;
                                    cursorQuery = null;
                                }
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e) {
                        e = e;
                        if (e instanceof LoadingException) {
                            throw e;
                        }
                        throw new LoadingException("V2 version check failed", e, null);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", (com.google.android.gms.dynamite.zza) null);
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws LoadingException {
        zzk zzkVar;
        com.google.android.gms.dynamite.zza zzaVar = null;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            try {
                zzkVar = zzif;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzkVar == null) {
            throw new LoadingException("DynamiteLoaderV2 was not cached.", zzaVar);
        }
        zza zzaVar2 = zzii.get();
        if (zzaVar2 == null || zzaVar2.zzin == null) {
            throw new LoadingException("No result cursor", zzaVar);
        }
        Context contextZza = zza(context.getApplicationContext(), str, i, zzaVar2.zzin, zzkVar);
        if (contextZza == null) {
            throw new LoadingException("Failed to get module context", zzaVar);
        }
        return new DynamiteModule(contextZza);
    }

    private static DynamiteModule zze(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static zzi zzj(Context context) {
        zzi zzjVar;
        synchronized (DynamiteModule.class) {
            try {
                if (zzie != null) {
                    return zzie;
                }
                if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                    return null;
                }
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzjVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzjVar = iInterfaceQueryLocalInterface instanceof zzi ? (zzi) iInterfaceQueryLocalInterface : new zzj(iBinder);
                    }
                    if (zzjVar != null) {
                        zzie = zzjVar;
                        return zzjVar;
                    }
                } catch (Exception e) {
                    String strValueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.zzim;
    }

    @KeepForSdk
    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzim.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String strValueOf = String.valueOf(str);
            throw new LoadingException(strValueOf.length() != 0 ? "Failed to instantiate module class: ".concat(strValueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
