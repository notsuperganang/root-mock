package com.google.android.gms.internal.places;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzkx {
    private static final int zzaaq = 11;
    private static final int zzaar = 12;
    private static final int zzaas = 16;
    private static final int zzaat = 26;
    public static final int[] zzaau = new int[0];
    private static final long[] zzaav = new long[0];
    private static final float[] zzaaw = new float[0];
    private static final double[] zzaax = new double[0];
    private static final boolean[] zzaay = new boolean[0];
    public static final String[] zzaaz = new String[0];
    public static final byte[][] zzaba = new byte[0][];
    public static final byte[] zzabb = new byte[0];

    public static final int zzc(zzkl zzklVar, int i) throws IOException {
        int i2 = 1;
        int position = zzklVar.getPosition();
        zzklVar.zzai(i);
        while (zzklVar.zzcj() == i) {
            zzklVar.zzai(i);
            i2++;
        }
        zzklVar.zzu(position, i);
        return i2;
    }
}
