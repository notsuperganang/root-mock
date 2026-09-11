package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
final class zzy {
    zzy() {
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e1 A[Catch: Throwable -> 0x00e5, all -> 0x00ed, TRY_ENTER, TryCatch #7 {Throwable -> 0x00e5, all -> 0x00ed, blocks: (B:7:0x0045, B:17:0x0062, B:28:0x00aa, B:39:0x00e1, B:40:0x00e4), top: B:61:0x0045 }] */
    @Nullable
    private final zzz zza(Context context, String str, zzz zzzVar, boolean z) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("pub", zzzVar.zzv());
        properties.setProperty("pri", zzzVar.zzw());
        properties.setProperty("cre", String.valueOf(zzzVar.zzbw));
        File fileZzf = zzf(context, str);
        try {
            fileZzf.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileZzf, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.lock();
                    if (z && channel.size() > 0) {
                        try {
                            channel.position(0L);
                            zzz zzzVarZza = zza(channel);
                            if (channel != null) {
                                zza((Throwable) null, channel);
                            }
                            zza((Throwable) null, randomAccessFile);
                            return zzzVarZza;
                        } catch (zzaa | IOException e) {
                            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                                String strValueOf = String.valueOf(e);
                                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 64).append("Tried reading key pair before writing new one, but failed with: ").append(strValueOf).toString());
                            }
                        }
                    }
                    channel.position(0L);
                    properties.store(Channels.newOutputStream(channel), (String) null);
                    if (channel != null) {
                        zza((Throwable) null, channel);
                    }
                    zza((Throwable) null, randomAccessFile);
                    return zzzVar;
                } catch (Throwable th5) {
                    th3 = null;
                    th4 = th5;
                    if (channel != null) {
                        zza(th3, channel);
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                th = null;
                th2 = th6;
                zza(th, randomAccessFile);
                throw th2;
            }
        } catch (IOException e2) {
            String strValueOf2 = String.valueOf(e2);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf2).length() + 21).append("Failed to write key: ").append(strValueOf2).toString());
            return null;
        }
    }

    @Nullable
    private static zzz zza(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(zzaw.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzaw.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzz(zzc(string, string2), zzb(sharedPreferences, str));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0029 A[Catch: Throwable -> 0x002d, all -> 0x0038, TRY_ENTER, TryCatch #6 {Throwable -> 0x002d, all -> 0x0038, blocks: (B:3:0x0006, B:8:0x001c, B:16:0x0029, B:17:0x002c), top: B:31:0x0006 }] */
    private final zzz zza(File file) throws Throwable {
        Throwable th;
        Throwable th2 = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                channel.lock(0L, Long.MAX_VALUE, true);
                zzz zzzVarZza = zza(channel);
                if (channel != null) {
                    zza((Throwable) null, channel);
                }
                zza((Throwable) null, fileInputStream);
                return zzzVarZza;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    th = th4;
                    th = th3;
                    if (channel != null) {
                        zza(th, channel);
                    }
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            zza(th2, fileInputStream);
            throw th;
        }
    }

    private static zzz zza(FileChannel fileChannel) throws IOException, zzaa {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new zzaa("Invalid properties file");
        }
        try {
            return new zzz(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new zzaa(e);
        }
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final void zza(Context context, String str, zzz zzzVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzzVar.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(zzaw.zzd(str, "|P|"), zzzVar.zzv());
        editorEdit.putString(zzaw.zzd(str, "|K|"), zzzVar.zzw());
        editorEdit.putString(zzaw.zzd(str, "cre"), String.valueOf(zzzVar.zzbw));
        editorEdit.commit();
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) throws IOException {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzh.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) throws IOException {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzh.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzh.zza(th, th2);
        }
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzaw.zzd(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return 0L;
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static KeyPair zzc(String str, String str2) throws zzaa {
        try {
            byte[] bArrDecode = Base64.decode(str, 8);
            byte[] bArrDecode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String strValueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 19).append("Invalid key stored ").append(strValueOf).toString());
                throw new zzaa(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzaa(e2);
        }
    }

    @Nullable
    private final zzz zzd(Context context, String str) throws Throwable {
        zzaa zzaaVar;
        try {
            zzz zzzVarZze = zze(context, str);
            if (zzzVarZze != null) {
                zza(context, str, zzzVarZze);
                return zzzVarZze;
            }
            zzaaVar = null;
        } catch (zzaa e) {
            zzaaVar = e;
        }
        try {
            zzz zzzVarZza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (zzzVarZza != null) {
                zza(context, str, zzzVarZza, false);
                return zzzVarZza;
            }
            e = zzaaVar;
        } catch (zzaa e2) {
            e = e2;
        }
        if (e != null) {
            throw e;
        }
        return null;
    }

    @Nullable
    private final zzz zze(Context context, String str) throws zzaa {
        File fileZzf = zzf(context, str);
        if (!fileZzf.exists()) {
            return null;
        }
        try {
            return zza(fileZzf);
        } catch (zzaa | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 40).append("Failed to read key from file, retrying: ").append(strValueOf).toString());
            }
            try {
                return zza(fileZzf);
            } catch (IOException e2) {
                String strValueOf2 = String.valueOf(e2);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf2).length() + 45).append("IID file exists, but failed to read from it: ").append(strValueOf2).toString());
                throw new zzaa(e2);
            }
        }
    }

    private static File zzf(Context context, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = "com.google.InstanceId.properties";
        } else {
            try {
                String strEncodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                string = new StringBuilder(String.valueOf(strEncodeToString).length() + 33).append("com.google.InstanceId_").append(strEncodeToString).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), string);
    }

    @WorkerThread
    final zzz zzb(Context context, String str) throws Throwable {
        zzz zzzVarZzd = zzd(context, str);
        return zzzVarZzd != null ? zzzVarZzd : zzc(context, str);
    }

    @WorkerThread
    final zzz zzc(Context context, String str) throws Throwable {
        zzz zzzVar = new zzz(zza.zzc(), System.currentTimeMillis());
        zzz zzzVarZza = zza(context, str, zzzVar, true);
        if (zzzVarZza == null || zzzVarZza.equals(zzzVar)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            zza(context, str, zzzVar);
            return zzzVar;
        }
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return zzzVarZza;
        }
        Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        return zzzVarZza;
    }
}
