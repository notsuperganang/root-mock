package com.google.android.gms.internal.places;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgf extends zzfq {
    private static final Logger logger = Logger.getLogger(zzgf.class.getName());
    private static final boolean zzoo = zzjw.zzgs();
    zzgh zzop;

    static class zzb extends zzgf {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
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

        @Override // com.google.android.gms.internal.places.zzgf
        public void flush() {
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzao(int i) throws IOException {
            if (i >= 0) {
                zzap(i);
            } else {
                zze(i);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzap(int i) throws IOException {
            if (zzgf.zzoo && zzcs() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzjw.zzb(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzjw.zzb(bArr2, i3, (byte) i);
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
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzar(int i) throws IOException {
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
                bArr4[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, long j) throws IOException {
            zzd(i, 0);
            zze(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzfr zzfrVar) throws IOException {
            zzd(i, 2);
            zzb(zzfrVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzih zzihVar) throws IOException {
            zzd(i, 2);
            zzc(zzihVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(int i, zzih zzihVar, zziy zziyVar) throws IOException {
            zzd(i, 2);
            zzfh zzfhVar = (zzfh) zzihVar;
            int iZzay = zzfhVar.zzay();
            if (iZzay == -1) {
                iZzay = zziyVar.zzn(zzfhVar);
                zzfhVar.zzv(iZzay);
            }
            zzap(iZzay);
            zziyVar.zzb(zzihVar, this.zzop);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, String str) throws IOException {
            zzd(i, 2);
            zzk(str);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(zzfr zzfrVar) throws IOException {
            zzap(zzfrVar.size());
            zzfrVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(zzih zzihVar, zziy zziyVar) throws IOException {
            zzfh zzfhVar = (zzfh) zzihVar;
            int iZzay = zzfhVar.zzay();
            if (iZzay == -1) {
                iZzay = zziyVar.zzn(zzfhVar);
                zzfhVar.zzv(iZzay);
            }
            zzap(iZzay);
            zziyVar.zzb(zzihVar, this.zzop);
        }

        @Override // com.google.android.gms.internal.places.zzfq
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzfr zzfrVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzfrVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzih zzihVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzihVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzb((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(zzih zzihVar) throws IOException {
            zzap(zzihVar.zzdg());
            zzihVar.zzc(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final int zzcs() {
            return this.limit - this.position;
        }

        public final int zzcu() {
            return this.position - this.offset;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, int i2) throws IOException {
            zzap((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, long j) throws IOException {
            zzd(i, 1);
            zzg(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzao(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(long j) throws IOException {
            if (zzgf.zzoo && zzcs() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzjw.zzb(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzjw.zzb(bArr2, i2, (byte) j);
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
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzap(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(long j) throws IOException {
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
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(byte[] bArr, int i, int i2) throws IOException {
            zzap(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzar(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzk(String str) throws IOException {
            int i = this.position;
            try {
                int iZzau = zzau(str.length() * 3);
                int iZzau2 = zzau(str.length());
                if (iZzau2 == iZzau) {
                    this.position = i + iZzau2;
                    int iZzb = zzjy.zzb(str, this.buffer, this.position, zzcs());
                    this.position = i;
                    zzap((iZzb - i) - iZzau2);
                    this.position = iZzb;
                } else {
                    zzap(zzjy.zzb(str));
                    this.position = zzjy.zzb(str, this.buffer, this.position, zzcs());
                }
            } catch (zzkb e) {
                this.position = i;
                zzb(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }
    }

    static final class zzc extends zzb {
        private final ByteBuffer zzoq;
        private int zzor;

        zzc(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzoq = byteBuffer;
            this.zzor = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.places.zzgf.zzb, com.google.android.gms.internal.places.zzgf
        public final void flush() {
            this.zzoq.position(this.zzor + zzcu());
        }
    }

    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzd(String str) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzd(String str, Throwable th) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), th);
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class zze extends zzgf {
        private final int zzor;
        private final ByteBuffer zzos;
        private final ByteBuffer zzot;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzos = byteBuffer;
            this.zzot = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzor = byteBuffer.position();
        }

        private final void zzm(String str) throws IOException {
            try {
                zzjy.zzb(str, this.zzot);
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void flush() {
            this.zzos.position(this.zzot.position());
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzot.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(e);
            } catch (BufferOverflowException e2) {
                throw new zzd(e2);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzao(int i) throws IOException {
            if (i >= 0) {
                zzap(i);
            } else {
                zze(i);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzap(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.zzot.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzd(e);
                }
            }
            this.zzot.put((byte) i);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzar(int i) throws IOException {
            try {
                this.zzot.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzd(e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(byte b) throws IOException {
            try {
                this.zzot.put(b);
            } catch (BufferOverflowException e) {
                throw new zzd(e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, long j) throws IOException {
            zzd(i, 0);
            zze(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzfr zzfrVar) throws IOException {
            zzd(i, 2);
            zzb(zzfrVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzih zzihVar) throws IOException {
            zzd(i, 2);
            zzc(zzihVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(int i, zzih zzihVar, zziy zziyVar) throws IOException {
            zzd(i, 2);
            zzb(zzihVar, zziyVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, String str) throws IOException {
            zzd(i, 2);
            zzk(str);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(zzfr zzfrVar) throws IOException {
            zzap(zzfrVar.size());
            zzfrVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(zzih zzihVar, zziy zziyVar) throws IOException {
            zzfh zzfhVar = (zzfh) zzihVar;
            int iZzay = zzfhVar.zzay();
            if (iZzay == -1) {
                iZzay = zziyVar.zzn(zzfhVar);
                zzfhVar.zzv(iZzay);
            }
            zzap(iZzay);
            zziyVar.zzb(zzihVar, this.zzop);
        }

        @Override // com.google.android.gms.internal.places.zzfq
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzfr zzfrVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzfrVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzih zzihVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzihVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzb((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(zzih zzihVar) throws IOException {
            zzap(zzihVar.zzdg());
            zzihVar.zzc(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final int zzcs() {
            return this.zzot.remaining();
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, int i2) throws IOException {
            zzap((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, long j) throws IOException {
            zzd(i, 1);
            zzg(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzao(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.zzot.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzd(e);
                }
            }
            this.zzot.put((byte) j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzap(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(long j) throws IOException {
            try {
                this.zzot.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzd(e);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(byte[] bArr, int i, int i2) throws IOException {
            zzap(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzar(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzk(String str) throws IOException {
            int iPosition = this.zzot.position();
            try {
                int iZzau = zzau(str.length() * 3);
                int iZzau2 = zzau(str.length());
                if (iZzau2 == iZzau) {
                    int iPosition2 = this.zzot.position() + iZzau2;
                    this.zzot.position(iPosition2);
                    zzm(str);
                    int iPosition3 = this.zzot.position();
                    this.zzot.position(iPosition);
                    zzap(iPosition3 - iPosition2);
                    this.zzot.position(iPosition3);
                } else {
                    zzap(zzjy.zzb(str));
                    zzm(str);
                }
            } catch (zzkb e) {
                this.zzot.position(iPosition);
                zzb(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzd(e2);
            }
        }
    }

    static final class zzf extends zzgf {
        private final ByteBuffer zzos;
        private final ByteBuffer zzot;
        private final long zzou;
        private final long zzov;
        private final long zzow;
        private final long zzox;
        private long zzoy;

        zzf(ByteBuffer byteBuffer) {
            super();
            this.zzos = byteBuffer;
            this.zzot = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzou = zzjw.zzc(byteBuffer);
            this.zzov = this.zzou + ((long) byteBuffer.position());
            this.zzow = this.zzou + ((long) byteBuffer.limit());
            this.zzox = this.zzow - 10;
            this.zzoy = this.zzov;
        }

        private final void zzn(long j) {
            this.zzot.position((int) (j - this.zzou));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void flush() {
            this.zzos.position((int) (this.zzoy - this.zzou));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr == null || i < 0 || i2 < 0 || bArr.length - i2 < i || this.zzow - ((long) i2) < this.zzoy) {
                if (bArr != null) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzoy), Long.valueOf(this.zzow), Integer.valueOf(i2)));
                }
                throw new NullPointerException(FirebaseAnalytics.Param.VALUE);
            }
            zzjw.zzb(bArr, i, this.zzoy, i2);
            this.zzoy += (long) i2;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzao(int i) throws IOException {
            if (i >= 0) {
                zzap(i);
            } else {
                zze(i);
            }
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzap(int i) throws IOException {
            if (this.zzoy <= this.zzox) {
                while ((i & (-128)) != 0) {
                    long j = this.zzoy;
                    this.zzoy = j + 1;
                    zzjw.zzb(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzoy;
                this.zzoy = j2 + 1;
                zzjw.zzb(j2, (byte) i);
                return;
            }
            while (this.zzoy < this.zzow) {
                if ((i & (-128)) == 0) {
                    long j3 = this.zzoy;
                    this.zzoy = j3 + 1;
                    zzjw.zzb(j3, (byte) i);
                    return;
                } else {
                    long j4 = this.zzoy;
                    this.zzoy = j4 + 1;
                    zzjw.zzb(j4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzoy), Long.valueOf(this.zzow), 1));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzar(int i) throws IOException {
            this.zzot.putInt((int) (this.zzoy - this.zzou), i);
            this.zzoy += 4;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(byte b) throws IOException {
            if (this.zzoy >= this.zzow) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzoy), Long.valueOf(this.zzow), 1));
            }
            long j = this.zzoy;
            this.zzoy = 1 + j;
            zzjw.zzb(j, b);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, long j) throws IOException {
            zzd(i, 0);
            zze(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzfr zzfrVar) throws IOException {
            zzd(i, 2);
            zzb(zzfrVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, zzih zzihVar) throws IOException {
            zzd(i, 2);
            zzc(zzihVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(int i, zzih zzihVar, zziy zziyVar) throws IOException {
            zzd(i, 2);
            zzb(zzihVar, zziyVar);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(int i, String str) throws IOException {
            zzd(i, 2);
            zzk(str);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzb(zzfr zzfrVar) throws IOException {
            zzap(zzfrVar.size());
            zzfrVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        final void zzb(zzih zzihVar, zziy zziyVar) throws IOException {
            zzfh zzfhVar = (zzfh) zzihVar;
            int iZzay = zzfhVar.zzay();
            if (iZzay == -1) {
                iZzay = zziyVar.zzn(zzfhVar);
                zzfhVar.zzv(iZzay);
            }
            zzap(iZzay);
            zziyVar.zzb(zzihVar, this.zzop);
        }

        @Override // com.google.android.gms.internal.places.zzfq
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzfr zzfrVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzfrVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, zzih zzihVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zzb(3, zzihVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzb((byte) (z ? 1 : 0));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzc(zzih zzihVar) throws IOException {
            zzap(zzihVar.zzdg());
            zzihVar.zzc(this);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final int zzcs() {
            return (int) (this.zzow - this.zzoy);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, int i2) throws IOException {
            zzap((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzd(int i, long j) throws IOException {
            zzd(i, 1);
            zzg(j);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzao(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zze(long j) throws IOException {
            if (this.zzoy <= this.zzox) {
                while ((j & (-128)) != 0) {
                    long j2 = this.zzoy;
                    this.zzoy = j2 + 1;
                    zzjw.zzb(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzoy;
                this.zzoy = j3 + 1;
                zzjw.zzb(j3, (byte) j);
                return;
            }
            while (this.zzoy < this.zzow) {
                if ((j & (-128)) == 0) {
                    long j4 = this.zzoy;
                    this.zzoy = j4 + 1;
                    zzjw.zzb(j4, (byte) j);
                    return;
                } else {
                    long j5 = this.zzoy;
                    this.zzoy = j5 + 1;
                    zzjw.zzb(j5, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
            throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzoy), Long.valueOf(this.zzow), 1));
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzap(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(long j) throws IOException {
            this.zzot.putLong((int) (this.zzoy - this.zzou), j);
            this.zzoy += 8;
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzg(byte[] bArr, int i, int i2) throws IOException {
            zzap(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzar(i2);
        }

        @Override // com.google.android.gms.internal.places.zzgf
        public final void zzk(String str) throws IOException {
            long j = this.zzoy;
            try {
                int iZzau = zzau(str.length() * 3);
                int iZzau2 = zzau(str.length());
                if (iZzau2 == iZzau) {
                    int i = ((int) (this.zzoy - this.zzou)) + iZzau2;
                    this.zzot.position(i);
                    zzjy.zzb(str, this.zzot);
                    int iPosition = this.zzot.position() - i;
                    zzap(iPosition);
                    this.zzoy = ((long) iPosition) + this.zzoy;
                } else {
                    int iZzb = zzjy.zzb(str);
                    zzap(iZzb);
                    zzn(this.zzoy);
                    zzjy.zzb(str, this.zzot);
                    this.zzoy = ((long) iZzb) + this.zzoy;
                }
            } catch (zzkb e) {
                this.zzoy = j;
                zzn(this.zzoy);
                zzb(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzd(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzd(e3);
            }
        }
    }

    private zzgf() {
    }

    public static int zzas(int i) {
        return zzau(i << 3);
    }

    public static int zzat(int i) {
        if (i >= 0) {
            return zzau(i);
        }
        return 10;
    }

    public static int zzau(int i) {
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

    public static int zzav(int i) {
        return zzau(zzaz(i));
    }

    public static int zzaw(int i) {
        return 4;
    }

    public static int zzax(int i) {
        return 4;
    }

    public static int zzay(int i) {
        return zzat(i);
    }

    private static int zzaz(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzb(int i, zzho zzhoVar) {
        int iZzas = zzas(i);
        int iZzdg = zzhoVar.zzdg();
        return iZzas + iZzdg + zzau(iZzdg);
    }

    public static int zzb(zzho zzhoVar) {
        int iZzdg = zzhoVar.zzdg();
        return iZzdg + zzau(iZzdg);
    }

    public static zzgf zzb(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzc(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return zzjw.zzgt() ? new zzf(byteBuffer) : new zze(byteBuffer);
    }

    @Deprecated
    public static int zzba(int i) {
        return zzau(i);
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(int i, double d) {
        return zzas(i) + 8;
    }

    public static int zzc(int i, zzho zzhoVar) {
        return (zzas(1) << 1) + zzj(2, i) + zzb(3, zzhoVar);
    }

    static int zzc(int i, zzih zzihVar, zziy zziyVar) {
        return zzas(i) + zzc(zzihVar, zziyVar);
    }

    public static int zzc(int i, String str) {
        return zzas(i) + zzl(str);
    }

    public static int zzc(zzfr zzfrVar) {
        int size = zzfrVar.size();
        return size + zzau(size);
    }

    static int zzc(zzih zzihVar, zziy zziyVar) {
        zzfh zzfhVar = (zzfh) zzihVar;
        int iZzay = zzfhVar.zzay();
        if (iZzay == -1) {
            iZzay = zziyVar.zzn(zzfhVar);
            zzfhVar.zzv(iZzay);
        }
        return iZzay + zzau(iZzay);
    }

    public static int zzd(int i, float f) {
        return zzas(i) + 4;
    }

    public static int zzd(int i, zzfr zzfrVar) {
        int iZzas = zzas(i);
        int size = zzfrVar.size();
        return iZzas + size + zzau(size);
    }

    public static int zzd(int i, zzih zzihVar) {
        return zzas(i) + zzd(zzihVar);
    }

    @Deprecated
    static int zzd(int i, zzih zzihVar, zziy zziyVar) {
        int iZzas = zzas(i) << 1;
        zzfh zzfhVar = (zzfh) zzihVar;
        int iZzay = zzfhVar.zzay();
        if (iZzay == -1) {
            iZzay = zziyVar.zzn(zzfhVar);
            zzfhVar.zzv(iZzay);
        }
        return iZzay + iZzas;
    }

    public static int zzd(int i, boolean z) {
        return zzas(i) + 1;
    }

    public static int zzd(zzih zzihVar) {
        int iZzdg = zzihVar.zzdg();
        return iZzdg + zzau(iZzdg);
    }

    public static zzgf zzd(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zze(float f) {
        return 4;
    }

    public static int zze(int i, long j) {
        return zzas(i) + zzi(j);
    }

    public static int zze(int i, zzfr zzfrVar) {
        return (zzas(1) << 1) + zzj(2, i) + zzd(3, zzfrVar);
    }

    public static int zze(int i, zzih zzihVar) {
        return (zzas(1) << 1) + zzj(2, i) + zzd(3, zzihVar);
    }

    @Deprecated
    public static int zze(zzih zzihVar) {
        return zzihVar.zzdg();
    }

    public static int zze(boolean z) {
        return 1;
    }

    public static int zze(byte[] bArr) {
        int length = bArr.length;
        return length + zzau(length);
    }

    public static int zzf(int i, long j) {
        return zzas(i) + zzi(j);
    }

    public static int zzg(int i, long j) {
        return zzas(i) + zzi(zzm(j));
    }

    public static int zzh(int i, long j) {
        return zzas(i) + 8;
    }

    public static int zzh(long j) {
        return zzi(j);
    }

    public static int zzi(int i, int i2) {
        return zzas(i) + zzat(i2);
    }

    public static int zzi(int i, long j) {
        return zzas(i) + 8;
    }

    public static int zzi(long j) {
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

    public static int zzj(int i, int i2) {
        return zzas(i) + zzau(i2);
    }

    public static int zzj(long j) {
        return zzi(zzm(j));
    }

    public static int zzk(int i, int i2) {
        return zzas(i) + zzau(zzaz(i2));
    }

    public static int zzk(long j) {
        return 8;
    }

    public static int zzl(int i, int i2) {
        return zzas(i) + 4;
    }

    public static int zzl(long j) {
        return 8;
    }

    public static int zzl(String str) {
        int length;
        try {
            length = zzjy.zzb(str);
        } catch (zzkb e) {
            length = str.getBytes(zzhb.UTF_8).length;
        }
        return length + zzau(length);
    }

    public static int zzm(int i, int i2) {
        return zzas(i) + 4;
    }

    private static long zzm(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzn(int i, int i2) {
        return zzas(i) + zzat(i2);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzao(int i) throws IOException;

    public abstract void zzap(int i) throws IOException;

    public final void zzaq(int i) throws IOException {
        zzap(zzaz(i));
    }

    public abstract void zzar(int i) throws IOException;

    public abstract void zzb(byte b) throws IOException;

    public final void zzb(double d) throws IOException {
        zzg(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, double d) throws IOException {
        zzd(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzb(int i, zzfr zzfrVar) throws IOException;

    public abstract void zzb(int i, zzih zzihVar) throws IOException;

    abstract void zzb(int i, zzih zzihVar, zziy zziyVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(zzfr zzfrVar) throws IOException;

    abstract void zzb(zzih zzihVar, zziy zziyVar) throws IOException;

    final void zzb(String str, zzkb zzkbVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzkbVar);
        byte[] bytes = str.getBytes(zzhb.UTF_8);
        try {
            zzap(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (zzd e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzd(e2);
        }
    }

    public final void zzc(int i, float f) throws IOException {
        zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzc(int i, long j) throws IOException {
        zzb(i, zzm(j));
    }

    public abstract void zzc(int i, zzfr zzfrVar) throws IOException;

    public abstract void zzc(int i, zzih zzihVar) throws IOException;

    public abstract void zzc(int i, boolean z) throws IOException;

    public abstract void zzc(zzih zzihVar) throws IOException;

    public abstract int zzcs();

    public final void zzd(float f) throws IOException {
        zzar(Float.floatToRawIntBits(f));
    }

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzd(int i, long j) throws IOException;

    public final void zzd(boolean z) throws IOException {
        zzb((byte) (z ? 1 : 0));
    }

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zze(long j) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public final void zzf(long j) throws IOException {
        zze(zzm(j));
    }

    public final void zzg(int i, int i2) throws IOException {
        zzf(i, zzaz(i2));
    }

    public abstract void zzg(long j) throws IOException;

    abstract void zzg(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzk(String str) throws IOException;
}
