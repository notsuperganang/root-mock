package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zztv extends zztd {
    private static final Logger logger = Logger.getLogger(zztv.class.getName());
    private static final boolean zzbuo = zzxj.zzyo();
    zztx zzbup;

    static class zza extends zztv {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i | i2 | (bArr.length - (i + i2))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i + i2;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public void flush() {
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(int i, zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzc(i, 2);
            zzsx zzsxVar = (zzsx) zzvvVar;
            int iZztx = zzsxVar.zztx();
            if (iZztx == -1) {
                iZztx = zzwlVar.zzai(zzsxVar);
                zzsxVar.zzai(iZztx);
            }
            zzba(iZztx);
            zzwlVar.zza(zzvvVar, this.zzbup);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int iZztx = zzsxVar.zztx();
            if (iZztx == -1) {
                iZztx = zzwlVar.zzai(zzsxVar);
                zzsxVar.zzai(iZztx);
            }
            zzba(iZztx);
            zzwlVar.zza(zzvvVar, this.zzbup);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            if (zztv.zzbuo && zzvj() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzxj.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzxj.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            if (zztv.zzbuo && zzvj() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzxj.zza(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzxj.zza(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            int i = this.position;
            try {
                int iZzbf = zzbf(str.length() * 3);
                int iZzbf2 = zzbf(str.length());
                if (iZzbf2 == iZzbf) {
                    this.position = i + iZzbf2;
                    int iZza = zzxl.zza(str, this.buffer, this.position, zzvj());
                    this.position = i;
                    zzba((iZza - i) - iZzbf2);
                    this.position = iZza;
                } else {
                    zzba(zzxl.zza(str));
                    this.position = zzxl.zza(str, this.buffer, this.position, zzvj());
                }
            } catch (zzxp e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return this.limit - this.position;
        }

        public final int zzvl() {
            return this.position - this.offset;
        }
    }

    static final class zzb extends zza {
        private final ByteBuffer zzbuq;
        private int zzbur;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzbuq = byteBuffer;
            this.zzbur = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.measurement.zztv.zza, com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.zzbuq.position(this.zzbur + zzvl());
        }
    }

    public static final class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str, Throwable th) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), th);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class zzd extends zztv {
        private final int zzbur;
        private final ByteBuffer zzbus;
        private final ByteBuffer zzbut;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzbus = byteBuffer;
            this.zzbut = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbur = byteBuffer.position();
        }

        private final void zzgd(String str) throws IOException {
            try {
                zzxl.zza(str, this.zzbut);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.zzbus.position(this.zzbut.position());
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzbut.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(int i, zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzc(i, 2);
            zza(zzvvVar, zzwlVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int iZztx = zzsxVar.zztx();
            if (iZztx == -1) {
                iZztx = zzwlVar.zzai(zzsxVar);
                zzsxVar.zzai(iZztx);
            }
            zzba(iZztx);
            zzwlVar.zza(zzvvVar, this.zzbup);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.zzbut.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.zzbut.put((byte) j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            try {
                this.zzbut.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.zzbut.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.zzbut.put((byte) i);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            try {
                this.zzbut.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b) throws IOException {
            try {
                this.zzbut.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            int iPosition = this.zzbut.position();
            try {
                int iZzbf = zzbf(str.length() * 3);
                int iZzbf2 = zzbf(str.length());
                if (iZzbf2 == iZzbf) {
                    int iPosition2 = this.zzbut.position() + iZzbf2;
                    this.zzbut.position(iPosition2);
                    zzgd(str);
                    int iPosition3 = this.zzbut.position();
                    this.zzbut.position(iPosition);
                    zzba(iPosition3 - iPosition2);
                    this.zzbut.position(iPosition3);
                } else {
                    zzba(zzxl.zza(str));
                    zzgd(str);
                }
            } catch (zzxp e) {
                this.zzbut.position(iPosition);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return this.zzbut.remaining();
        }
    }

    static final class zze extends zztv {
        private final ByteBuffer zzbus;
        private final ByteBuffer zzbut;
        private final long zzbuu;
        private final long zzbuv;
        private final long zzbuw;
        private final long zzbux;
        private long zzbuy;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzbus = byteBuffer;
            this.zzbut = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbuu = zzxj.zzb(byteBuffer);
            this.zzbuv = this.zzbuu + ((long) byteBuffer.position());
            this.zzbuw = this.zzbuu + ((long) byteBuffer.limit());
            this.zzbux = this.zzbuw - 10;
            this.zzbuy = this.zzbuv;
        }

        private final void zzbc(long j) {
            this.zzbut.position((int) (j - this.zzbuu));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.zzbus.position((int) (this.zzbuy - this.zzbuu));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr == null || i < 0 || i2 < 0 || bArr.length - i2 < i || this.zzbuw - ((long) i2) < this.zzbuy) {
                if (bArr != null) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzbuy), Long.valueOf(this.zzbuw), Integer.valueOf(i2)));
                }
                throw new NullPointerException(FirebaseAnalytics.Param.VALUE);
            }
            zzxj.zza(bArr, i, this.zzbuy, i2);
            this.zzbuy += (long) i2;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(int i, zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzc(i, 2);
            zza(zzvvVar, zzwlVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, zzwl zzwlVar) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int iZztx = zzsxVar.zztx();
            if (iZztx == -1) {
                iZztx = zzwlVar.zzai(zzsxVar);
                zzsxVar.zzai(iZztx);
            }
            zzba(iZztx);
            zzwlVar.zza(zzvvVar, this.zzbup);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            if (this.zzbuy <= this.zzbux) {
                while ((j & (-128)) != 0) {
                    long j2 = this.zzbuy;
                    this.zzbuy = j2 + 1;
                    zzxj.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzbuy;
                this.zzbuy = j3 + 1;
                zzxj.zza(j3, (byte) j);
                return;
            }
            while (this.zzbuy < this.zzbuw) {
                if ((j & (-128)) == 0) {
                    long j4 = this.zzbuy;
                    this.zzbuy = j4 + 1;
                    zzxj.zza(j4, (byte) j);
                    return;
                } else {
                    long j5 = this.zzbuy;
                    this.zzbuy = j5 + 1;
                    zzxj.zza(j5, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzbuy), Long.valueOf(this.zzbuw), 1));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            this.zzbut.putLong((int) (this.zzbuy - this.zzbuu), j);
            this.zzbuy += 8;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            if (this.zzbuy <= this.zzbux) {
                while ((i & (-128)) != 0) {
                    long j = this.zzbuy;
                    this.zzbuy = j + 1;
                    zzxj.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzbuy;
                this.zzbuy = j2 + 1;
                zzxj.zza(j2, (byte) i);
                return;
            }
            while (this.zzbuy < this.zzbuw) {
                if ((i & (-128)) == 0) {
                    long j3 = this.zzbuy;
                    this.zzbuy = j3 + 1;
                    zzxj.zza(j3, (byte) i);
                    return;
                } else {
                    long j4 = this.zzbuy;
                    this.zzbuy = j4 + 1;
                    zzxj.zza(j4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzbuy), Long.valueOf(this.zzbuw), 1));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            this.zzbut.putInt((int) (this.zzbuy - this.zzbuu), i);
            this.zzbuy += 4;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b) throws IOException {
            if (this.zzbuy >= this.zzbuw) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzbuy), Long.valueOf(this.zzbuw), 1));
            }
            long j = this.zzbuy;
            this.zzbuy = 1 + j;
            zzxj.zza(j, b);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            long j = this.zzbuy;
            try {
                int iZzbf = zzbf(str.length() * 3);
                int iZzbf2 = zzbf(str.length());
                if (iZzbf2 == iZzbf) {
                    int i = ((int) (this.zzbuy - this.zzbuu)) + iZzbf2;
                    this.zzbut.position(i);
                    zzxl.zza(str, this.zzbut);
                    int iPosition = this.zzbut.position() - i;
                    zzba(iPosition);
                    this.zzbuy = ((long) iPosition) + this.zzbuy;
                } else {
                    int iZza = zzxl.zza(str);
                    zzba(iZza);
                    zzbc(this.zzbuy);
                    zzxl.zza(str, this.zzbut);
                    this.zzbuy = ((long) iZza) + this.zzbuy;
                }
            } catch (zzxp e) {
                this.zzbuy = j;
                zzbc(this.zzbuy);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return (int) (this.zzbuw - this.zzbuy);
        }
    }

    private zztv() {
    }

    public static int zza(int i, zzvc zzvcVar) {
        int iZzbd = zzbd(i);
        int iZzvx = zzvcVar.zzvx();
        return iZzbd + iZzvx + zzbf(iZzvx);
    }

    public static int zza(zzvc zzvcVar) {
        int iZzvx = zzvcVar.zzvx();
        return iZzvx + zzbf(iZzvx);
    }

    public static zztv zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return zzxj.zzyp() ? new zze(byteBuffer) : new zzd(byteBuffer);
    }

    public static int zzaw(long j) {
        return zzax(j);
    }

    public static int zzax(long j) {
        long j2;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i = 2;
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j2 = j >>> 28;
        } else {
            j2 = j;
        }
        if (((-2097152) & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzay(long j) {
        return zzax(zzbb(j));
    }

    public static int zzaz(long j) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(int i, double d) {
        return zzbd(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbd(i) + 4;
    }

    public static int zzb(int i, zzvc zzvcVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zza(3, zzvcVar);
    }

    static int zzb(int i, zzvv zzvvVar, zzwl zzwlVar) {
        return zzbd(i) + zzb(zzvvVar, zzwlVar);
    }

    public static int zzb(zzte zzteVar) {
        int size = zzteVar.size();
        return size + zzbf(size);
    }

    static int zzb(zzvv zzvvVar, zzwl zzwlVar) {
        zzsx zzsxVar = (zzsx) zzvvVar;
        int iZztx = zzsxVar.zztx();
        if (iZztx == -1) {
            iZztx = zzwlVar.zzai(zzsxVar);
            zzsxVar.zzai(iZztx);
        }
        return iZztx + zzbf(iZztx);
    }

    public static int zzba(long j) {
        return 8;
    }

    private static long zzbb(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzbd(int i) {
        return zzbf(i << 3);
    }

    public static int zzbe(int i) {
        if (i >= 0) {
            return zzbf(i);
        }
        return 10;
    }

    public static int zzbf(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public static int zzbg(int i) {
        return zzbf(zzbk(i));
    }

    public static int zzbh(int i) {
        return 4;
    }

    public static int zzbi(int i) {
        return 4;
    }

    public static int zzbj(int i) {
        return zzbe(i);
    }

    private static int zzbk(int i) {
        return (i << 1) ^ (i >> 31);
    }

    @Deprecated
    public static int zzbl(int i) {
        return zzbf(i);
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(int i, zzte zzteVar) {
        int iZzbd = zzbd(i);
        int size = zzteVar.size();
        return iZzbd + size + zzbf(size);
    }

    public static int zzc(int i, zzvv zzvvVar) {
        return zzbd(i) + zzc(zzvvVar);
    }

    @Deprecated
    static int zzc(int i, zzvv zzvvVar, zzwl zzwlVar) {
        int iZzbd = zzbd(i);
        zzsx zzsxVar = (zzsx) zzvvVar;
        int iZztx = zzsxVar.zztx();
        if (iZztx == -1) {
            iZztx = zzwlVar.zzai(zzsxVar);
            zzsxVar.zzai(iZztx);
        }
        return iZztx + (iZzbd << 1);
    }

    public static int zzc(int i, String str) {
        return zzbd(i) + zzgc(str);
    }

    public static int zzc(int i, boolean z) {
        return zzbd(i) + 1;
    }

    public static int zzc(zzvv zzvvVar) {
        int iZzvx = zzvvVar.zzvx();
        return iZzvx + zzbf(iZzvx);
    }

    public static int zzd(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zzd(int i, zzte zzteVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zzc(3, zzteVar);
    }

    public static int zzd(int i, zzvv zzvvVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zzc(3, zzvvVar);
    }

    @Deprecated
    public static int zzd(zzvv zzvvVar) {
        return zzvvVar.zzvx();
    }

    public static int zze(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zzf(int i, long j) {
        return zzbd(i) + zzax(zzbb(j));
    }

    public static int zzg(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzgc(String str) {
        int length;
        try {
            length = zzxl.zza(str);
        } catch (zzxp e) {
            length = str.getBytes(zzuq.UTF_8).length;
        }
        return length + zzbf(length);
    }

    public static int zzh(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzh(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzi(int i, int i2) {
        return zzbd(i) + zzbf(i2);
    }

    public static int zzj(int i, int i2) {
        return zzbd(i) + zzbf(zzbk(i2));
    }

    public static zztv zzj(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzk(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzk(byte[] bArr) {
        int length = bArr.length;
        return length + zzbf(length);
    }

    public static int zzl(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public final void zza(float f) throws IOException {
        zzbc(Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzte zzteVar) throws IOException;

    public abstract void zza(int i, zzvv zzvvVar) throws IOException;

    abstract void zza(int i, zzvv zzvvVar, zzwl zzwlVar) throws IOException;

    public abstract void zza(zzte zzteVar) throws IOException;

    abstract void zza(zzvv zzvvVar, zzwl zzwlVar) throws IOException;

    final void zza(String str, zzxp zzxpVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzxpVar);
        byte[] bytes = str.getBytes(zzuq.UTF_8);
        try {
            zzba(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    public abstract void zzat(long j) throws IOException;

    public final void zzau(long j) throws IOException {
        zzat(zzbb(j));
    }

    public abstract void zzav(long j) throws IOException;

    public abstract void zzaz(int i) throws IOException;

    public final void zzb(double d) throws IOException {
        zzav(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzbb(j));
    }

    public abstract void zzb(int i, zzte zzteVar) throws IOException;

    public abstract void zzb(int i, zzvv zzvvVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzvv zzvvVar) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public final void zzbb(int i) throws IOException {
        zzba(zzbk(i));
    }

    public abstract void zzbc(int i) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public final void zzf(int i, int i2) throws IOException {
        zze(i, zzbk(i2));
    }

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzgb(String str) throws IOException;

    public final void zzs(boolean z) throws IOException {
        zzc((byte) (z ? 1 : 0));
    }

    public abstract int zzvj();
}
