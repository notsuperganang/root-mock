package com.google.android.gms.internal.places;

/* JADX INFO: loaded from: classes.dex */
final class zzjm {
    static String zze(zzfr zzfrVar) {
        zzjn zzjnVar = new zzjn(zzfrVar);
        StringBuilder sb = new StringBuilder(zzjnVar.size());
        for (int i = 0; i < zzjnVar.size(); i++) {
            byte bZzaf = zzjnVar.zzaf(i);
            switch (bZzaf) {
                case 7:
                    sb.append("\\a");
                    break;
                case 8:
                    sb.append("\\b");
                    break;
                case 9:
                    sb.append("\\t");
                    break;
                case 10:
                    sb.append("\\n");
                    break;
                case 11:
                    sb.append("\\v");
                    break;
                case 12:
                    sb.append("\\f");
                    break;
                case 13:
                    sb.append("\\r");
                    break;
                case 34:
                    sb.append("\\\"");
                    break;
                case 39:
                    sb.append("\\'");
                    break;
                case 92:
                    sb.append("\\\\");
                    break;
                default:
                    if (bZzaf < 32 || bZzaf > 126) {
                        sb.append('\\');
                        sb.append((char) (((bZzaf >>> 6) & 3) + 48));
                        sb.append((char) (((bZzaf >>> 3) & 7) + 48));
                        sb.append((char) ((bZzaf & 7) + 48));
                    } else {
                        sb.append((char) bZzaf);
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
