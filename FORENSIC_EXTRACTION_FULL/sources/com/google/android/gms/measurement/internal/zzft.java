package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzya;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzft extends zzfm {
    zzft(zzfn zzfnVar) {
        super(zzfnVar);
    }

    static com.google.android.gms.internal.measurement.zzfu zza(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzftVar.zzaxc) {
            if (zzfuVar.name.equals(str)) {
                return zzfuVar;
            }
        }
        return null;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfk zzfkVar) {
        if (zzfkVar == null) {
            return;
        }
        zza(sb, i);
        sb.append("filter {\n");
        zza(sb, i, "complement", zzfkVar.zzavu);
        zza(sb, i, "param_name", zzgq().zzbu(zzfkVar.zzavv));
        int i2 = i + 1;
        com.google.android.gms.internal.measurement.zzfn zzfnVar = zzfkVar.zzavs;
        if (zzfnVar != null) {
            zza(sb, i2);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzfnVar.zzawe != null) {
                String str = "UNKNOWN_MATCH_TYPE";
                switch (zzfnVar.zzawe.intValue()) {
                    case 1:
                        str = "REGEXP";
                        break;
                    case 2:
                        str = "BEGINS_WITH";
                        break;
                    case 3:
                        str = "ENDS_WITH";
                        break;
                    case 4:
                        str = "PARTIAL";
                        break;
                    case 5:
                        str = "EXACT";
                        break;
                    case 6:
                        str = "IN_LIST";
                        break;
                }
                zza(sb, i2, "match_type", str);
            }
            zza(sb, i2, "expression", zzfnVar.zzawf);
            zza(sb, i2, "case_sensitive", zzfnVar.zzawg);
            if (zzfnVar.zzawh.length > 0) {
                zza(sb, i2 + 1);
                sb.append("expression_list {\n");
                for (String str2 : zzfnVar.zzawh) {
                    zza(sb, i2 + 2);
                    sb.append(str2);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, i2);
            sb.append("}\n");
        }
        zza(sb, i + 1, "number_filter", zzfkVar.zzavt);
        zza(sb, i);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        zza(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zzavw != null) {
            String str2 = "UNKNOWN_COMPARISON_TYPE";
            switch (zzflVar.zzavw.intValue()) {
                case 1:
                    str2 = "LESS_THAN";
                    break;
                case 2:
                    str2 = "GREATER_THAN";
                    break;
                case 3:
                    str2 = "EQUAL";
                    break;
                case 4:
                    str2 = "BETWEEN";
                    break;
            }
            zza(sb, i, "comparison_type", str2);
        }
        zza(sb, i, "match_as_float", zzflVar.zzavx);
        zza(sb, i, "comparison_value", zzflVar.zzavy);
        zza(sb, i, "min_comparison_value", zzflVar.zzavz);
        zza(sb, i, "max_comparison_value", zzflVar.zzawa);
        zza(sb, i);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfx zzfxVar, String str2) {
        if (zzfxVar == null) {
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzfxVar.zzayq != null) {
            zza(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            long[] jArr = zzfxVar.zzayq;
            int length = jArr.length;
            int i3 = 0;
            while (i3 < length) {
                long j = jArr[i3];
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(Long.valueOf(j));
                i3++;
                i2++;
            }
            sb.append('\n');
        }
        if (zzfxVar.zzayp != null) {
            zza(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            long[] jArr2 = zzfxVar.zzayp;
            int length2 = jArr2.length;
            int i5 = 0;
            while (i5 < length2) {
                long j2 = jArr2[i5];
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(Long.valueOf(j2));
                i5++;
                i4++;
            }
            sb.append('\n');
        }
        if (zzgv().zzbb(str2)) {
            if (zzfxVar.zzayr != null) {
                zza(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                com.google.android.gms.internal.measurement.zzfs[] zzfsVarArr = zzfxVar.zzayr;
                int length3 = zzfsVarArr.length;
                int i7 = 0;
                while (i7 < length3) {
                    com.google.android.gms.internal.measurement.zzfs zzfsVar = zzfsVarArr[i7];
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzfsVar.zzawz).append(":").append(zzfsVar.zzaxa);
                    i7++;
                    i6++;
                }
                sb.append("}\n");
            }
            if (zzfxVar.zzays != null) {
                zza(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                com.google.android.gms.internal.measurement.zzfy[] zzfyVarArr = zzfxVar.zzays;
                int length4 = zzfyVarArr.length;
                int i9 = 0;
                while (i9 < length4) {
                    com.google.android.gms.internal.measurement.zzfy zzfyVar = zzfyVarArr[i9];
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzfyVar.zzawz).append(": [");
                    int i10 = 0;
                    long[] jArr3 = zzfyVar.zzayu;
                    int length5 = jArr3.length;
                    int i11 = 0;
                    while (i11 < length5) {
                        long j3 = jArr3[i11];
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(j3);
                        i11++;
                        i10++;
                    }
                    sb.append("]");
                    i9++;
                    i8++;
                }
                sb.append("}\n");
            }
        }
        zza(sb, 3);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64 && (i << 6) + i2 < bitSet.length(); i2++) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    static com.google.android.gms.internal.measurement.zzfu[] zza(com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, String str, Object obj) {
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
            if (str.equals(zzfuVar.name)) {
                zzfuVar.zzaxg = null;
                zzfuVar.zzamn = null;
                zzfuVar.zzaup = null;
                if (obj instanceof Long) {
                    zzfuVar.zzaxg = (Long) obj;
                    return zzfuVarArr;
                }
                if (obj instanceof String) {
                    zzfuVar.zzamn = (String) obj;
                    return zzfuVarArr;
                }
                if (!(obj instanceof Double)) {
                    return zzfuVarArr;
                }
                zzfuVar.zzaup = (Double) obj;
                return zzfuVarArr;
            }
        }
        com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr2 = new com.google.android.gms.internal.measurement.zzfu[zzfuVarArr.length + 1];
        System.arraycopy(zzfuVarArr, 0, zzfuVarArr2, 0, zzfuVarArr.length);
        com.google.android.gms.internal.measurement.zzfu zzfuVar2 = new com.google.android.gms.internal.measurement.zzfu();
        zzfuVar2.name = str;
        if (obj instanceof Long) {
            zzfuVar2.zzaxg = (Long) obj;
        } else if (obj instanceof String) {
            zzfuVar2.zzamn = (String) obj;
        } else if (obj instanceof Double) {
            zzfuVar2.zzaup = (Double) obj;
        }
        zzfuVarArr2[zzfuVarArr.length] = zzfuVar2;
        return zzfuVarArr2;
    }

    static Object zzb(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        com.google.android.gms.internal.measurement.zzfu zzfuVarZza = zza(zzftVar, str);
        if (zzfuVarZza != null) {
            if (zzfuVarZza.zzamn != null) {
                return zzfuVarZza.zzamn;
            }
            if (zzfuVarZza.zzaxg != null) {
                return zzfuVarZza.zzaxg;
            }
            if (zzfuVarZza.zzaup != null) {
                return zzfuVarZza.zzaup;
            }
        }
        return null;
    }

    static boolean zzcs(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException e) {
            zzgt().zzjg().zzby("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    final String zza(com.google.android.gms.internal.measurement.zzfj zzfjVar) {
        if (zzfjVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", zzfjVar.zzavm);
        zza(sb, 0, "event_name", zzgq().zzbt(zzfjVar.zzavn));
        zza(sb, 1, "event_count_filter", zzfjVar.zzavq);
        sb.append("  filters {\n");
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfjVar.zzavo) {
            zza(sb, 2, zzfkVar);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    final String zza(com.google.android.gms.internal.measurement.zzfm zzfmVar) {
        if (zzfmVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", zzfmVar.zzavm);
        zza(sb, 0, "property_name", zzgq().zzbv(zzfmVar.zzawc));
        zza(sb, 1, zzfmVar.zzawd);
        sb.append("}\n");
        return sb.toString();
    }

    final void zza(com.google.android.gms.internal.measurement.zzfu zzfuVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfuVar.zzamn = null;
        zzfuVar.zzaxg = null;
        zzfuVar.zzaup = null;
        if (obj instanceof String) {
            zzfuVar.zzamn = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzfuVar.zzaxg = (Long) obj;
        } else if (obj instanceof Double) {
            zzfuVar.zzaup = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    final void zza(com.google.android.gms.internal.measurement.zzfz zzfzVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfzVar.zzamn = null;
        zzfzVar.zzaxg = null;
        zzfzVar.zzaup = null;
        if (obj instanceof String) {
            zzfzVar.zzamn = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzfzVar.zzaxg = (Long) obj;
        } else if (obj instanceof Double) {
            zzfzVar.zzaup = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final byte[] zza(com.google.android.gms.internal.measurement.zzfv zzfvVar) {
        try {
            byte[] bArr = new byte[zzfvVar.zzvx()];
            zzya zzyaVarZzk = zzya.zzk(bArr, 0, bArr.length);
            zzfvVar.zza(zzyaVarZzk);
            zzyaVarZzk.zzza();
            return bArr;
        } catch (IOException e) {
            zzgt().zzjg().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    final byte[] zza(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    final String zzb(com.google.android.gms.internal.measurement.zzfv zzfvVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzfvVar.zzaxh != null) {
            for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzfvVar.zzaxh) {
                if (zzfwVar != null && zzfwVar != null) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", zzfwVar.zzaxj);
                    zza(sb, 1, "platform", zzfwVar.zzaxr);
                    zza(sb, 1, "gmp_version", zzfwVar.zzaxv);
                    zza(sb, 1, "uploading_gmp_version", zzfwVar.zzaxw);
                    zza(sb, 1, "config_version", zzfwVar.zzayh);
                    zza(sb, 1, "gmp_app_id", zzfwVar.zzafi);
                    zza(sb, 1, "admob_app_id", zzfwVar.zzawr);
                    zza(sb, 1, "app_id", zzfwVar.zztt);
                    zza(sb, 1, "app_version", zzfwVar.zzts);
                    zza(sb, 1, "app_version_major", zzfwVar.zzayd);
                    zza(sb, 1, "firebase_instance_id", zzfwVar.zzafk);
                    zza(sb, 1, "dev_cert_hash", zzfwVar.zzaxz);
                    zza(sb, 1, "app_store", zzfwVar.zzafp);
                    zza(sb, 1, "upload_timestamp_millis", zzfwVar.zzaxm);
                    zza(sb, 1, "start_timestamp_millis", zzfwVar.zzaxn);
                    zza(sb, 1, "end_timestamp_millis", zzfwVar.zzaxo);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", zzfwVar.zzaxp);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", zzfwVar.zzaxq);
                    zza(sb, 1, "app_instance_id", zzfwVar.zzafh);
                    zza(sb, 1, "resettable_device_id", zzfwVar.zzaxx);
                    zza(sb, 1, "device_id", zzfwVar.zzayg);
                    zza(sb, 1, "ds_id", zzfwVar.zzayj);
                    zza(sb, 1, "limited_ad_tracking", zzfwVar.zzaxy);
                    zza(sb, 1, "os_version", zzfwVar.zzaxs);
                    zza(sb, 1, "device_model", zzfwVar.zzaxt);
                    zza(sb, 1, "user_default_language", zzfwVar.zzahr);
                    zza(sb, 1, "time_zone_offset_minutes", zzfwVar.zzaxu);
                    zza(sb, 1, "bundle_sequential_index", zzfwVar.zzaya);
                    zza(sb, 1, "service_upload", zzfwVar.zzayb);
                    zza(sb, 1, "health_monitor", zzfwVar.zzagm);
                    if (zzfwVar.zzayi != null && zzfwVar.zzayi.longValue() != 0) {
                        zza(sb, 1, "android_id", zzfwVar.zzayi);
                    }
                    if (zzfwVar.zzayl != null) {
                        zza(sb, 1, "retry_counter", zzfwVar.zzayl);
                    }
                    com.google.android.gms.internal.measurement.zzfz[] zzfzVarArr = zzfwVar.zzaxl;
                    if (zzfzVarArr != null) {
                        for (com.google.android.gms.internal.measurement.zzfz zzfzVar : zzfzVarArr) {
                            if (zzfzVar != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zza(sb, 2, "set_timestamp_millis", zzfzVar.zzayw);
                                zza(sb, 2, "name", zzgq().zzbv(zzfzVar.name));
                                zza(sb, 2, "string_value", zzfzVar.zzamn);
                                zza(sb, 2, "int_value", zzfzVar.zzaxg);
                                zza(sb, 2, "double_value", zzfzVar.zzaup);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.zzfr[] zzfrVarArr = zzfwVar.zzayc;
                    String str = zzfwVar.zztt;
                    if (zzfrVarArr != null) {
                        for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzfrVarArr) {
                            if (zzfrVar != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", zzfrVar.zzavg);
                                zza(sb, 2, "new_audience", zzfrVar.zzawx);
                                zza(sb, 2, "current_data", zzfrVar.zzawv, str);
                                zza(sb, 2, "previous_data", zzfrVar.zzaww, str);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.zzft[] zzftVarArr = zzfwVar.zzaxk;
                    if (zzftVarArr != null) {
                        for (com.google.android.gms.internal.measurement.zzft zzftVar : zzftVarArr) {
                            if (zzftVar != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, "name", zzgq().zzbt(zzftVar.name));
                                zza(sb, 2, "timestamp_millis", zzftVar.zzaxd);
                                zza(sb, 2, "previous_timestamp_millis", zzftVar.zzaxe);
                                zza(sb, 2, "count", zzftVar.count);
                                com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr = zzftVar.zzaxc;
                                if (zzfuVarArr != null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
                                        if (zzfuVar != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zza(sb, 3, "name", zzgq().zzbu(zzfuVar.name));
                                            zza(sb, 3, "string_value", zzfuVar.zzamn);
                                            zza(sb, 3, "int_value", zzfuVar.zzaxg);
                                            zza(sb, 3, "double_value", zzfuVar.zzaup);
                                            zza(sb, 3);
                                            sb.append("}\n");
                                        }
                                    }
                                }
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    final boolean zzb(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzbx().currentTimeMillis() - j) > j2;
    }

    final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @WorkerThread
    final boolean zze(zzag zzagVar, zzk zzkVar) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotNull(zzkVar);
        if (!TextUtils.isEmpty(zzkVar.zzafi) || !TextUtils.isEmpty(zzkVar.zzafv)) {
            return true;
        }
        zzgw();
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfx zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    protected final boolean zzgy() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzft zzjr() {
        return super.zzjr();
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    @Override // com.google.android.gms.measurement.internal.zzfl
    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    @Nullable
    final int[] zzmi() {
        Map<String, String> mapZzm = zzai.zzm(this.zzamx.getContext());
        if (mapZzm == null || mapZzm.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = zzai.zzakg.get().intValue();
        for (Map.Entry<String, String> entry : mapZzm.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i = Integer.parseInt(entry.getValue());
                    if (i != 0) {
                        arrayList.add(Integer.valueOf(i));
                        if (arrayList.size() >= iIntValue) {
                            zzgt().zzjj().zzg("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzgt().zzjj().zzg("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            iArr[i3] = ((Integer) obj).intValue();
            i3++;
        }
        return iArr;
    }
}
