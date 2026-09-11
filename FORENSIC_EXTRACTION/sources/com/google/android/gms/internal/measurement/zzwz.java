package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzwz {
    static String zzd(zzte zzteVar) {
        zzxa zzxaVar = new zzxa(zzteVar);
        StringBuilder sb = new StringBuilder(zzxaVar.size());
        for (int i = 0; i < zzxaVar.size(); i++) {
            byte bZzam = zzxaVar.zzam(i);
            switch (bZzam) {
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
                    if (bZzam < 32 || bZzam > 126) {
                        sb.append('\\');
                        sb.append((char) (((bZzam >>> 6) & 3) + 48));
                        sb.append((char) (((bZzam >>> 3) & 7) + 48));
                        sb.append((char) ((bZzam & 7) + 48));
                    } else {
                        sb.append((char) bZzam);
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
