package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
interface zzix {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zzb(zziy<T> zziyVar, zzgl zzglVar) throws IOException;

    <T> T zzb(Class<T> cls, zzgl zzglVar) throws IOException;

    <T> void zzb(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException;

    <K, V> void zzb(Map<K, V> map, zzia<K, V> zziaVar, zzgl zzglVar) throws IOException;

    int zzbg() throws IOException;

    boolean zzbh() throws IOException;

    long zzbi() throws IOException;

    long zzbj() throws IOException;

    int zzbk() throws IOException;

    long zzbl() throws IOException;

    int zzbm() throws IOException;

    boolean zzbn() throws IOException;

    String zzbo() throws IOException;

    zzfr zzbp() throws IOException;

    int zzbq() throws IOException;

    int zzbr() throws IOException;

    int zzbs() throws IOException;

    long zzbt() throws IOException;

    int zzbu() throws IOException;

    long zzbv() throws IOException;

    @Deprecated
    <T> T zzc(Class<T> cls, zzgl zzglVar) throws IOException;

    @Deprecated
    <T> void zzc(List<T> list, zziy<T> zziyVar, zzgl zzglVar) throws IOException;

    @Deprecated
    <T> T zzd(zziy<T> zziyVar, zzgl zzglVar) throws IOException;

    void zze(List<Double> list) throws IOException;

    void zzf(List<Float> list) throws IOException;

    void zzg(List<Long> list) throws IOException;

    void zzh(List<Long> list) throws IOException;

    void zzi(List<Integer> list) throws IOException;

    void zzj(List<Long> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Boolean> list) throws IOException;

    void zzm(List<String> list) throws IOException;

    void zzn(List<zzfr> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Integer> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Long> list) throws IOException;

    void zzs(List<Integer> list) throws IOException;

    void zzt(List<Long> list) throws IOException;
}
