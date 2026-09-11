package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbea {
    static String zzaq(zzbah zzbahVar) {
        zzbeb zzbebVar = new zzbeb(zzbahVar);
        StringBuilder sb = new StringBuilder(zzbebVar.size());
        for (int i = 0; i < zzbebVar.size(); i++) {
            byte bZzbn = zzbebVar.zzbn(i);
            switch (bZzbn) {
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
                    if (bZzbn < 32 || bZzbn > 126) {
                        sb.append('\\');
                        sb.append((char) (((bZzbn >>> 6) & 3) + 48));
                        sb.append((char) (((bZzbn >>> 3) & 7) + 48));
                        sb.append((char) ((bZzbn & 7) + 48));
                    } else {
                        sb.append((char) bZzbn);
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
