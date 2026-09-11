package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.android.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private final List<byte[]> mBuffersByLastUse = new LinkedList();
    private final List<byte[]> mBuffersBySize = new ArrayList(64);
    private int mCurrentSize = 0;
    private final int mSizeLimit;

    public ByteArrayPool(int i) {
        this.mSizeLimit = i;
    }

    public byte[] getBuf(int i) {
        byte[] bArr;
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mBuffersBySize.size()) {
                    bArr = this.mBuffersBySize.get(i3);
                    if (bArr.length < i) {
                        i2 = i3 + 1;
                    } else {
                        this.mCurrentSize -= bArr.length;
                        this.mBuffersBySize.remove(i3);
                        this.mBuffersByLastUse.remove(bArr);
                        break;
                    }
                } else {
                    bArr = new byte[i];
                    break;
                }
            }
        }
        return bArr;
    }

    public void returnBuf(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.mSizeLimit) {
                    this.mBuffersByLastUse.add(bArr);
                    int iBinarySearch = Collections.binarySearch(this.mBuffersBySize, bArr, BUF_COMPARATOR);
                    if (iBinarySearch < 0) {
                        iBinarySearch = (-iBinarySearch) - 1;
                    }
                    this.mBuffersBySize.add(iBinarySearch, bArr);
                    this.mCurrentSize += bArr.length;
                    trim();
                }
            }
        }
    }

    private void trim() {
        synchronized (this) {
            while (this.mCurrentSize > this.mSizeLimit) {
                byte[] bArrRemove = this.mBuffersByLastUse.remove(0);
                this.mBuffersBySize.remove(bArrRemove);
                this.mCurrentSize -= bArrRemove.length;
            }
        }
    }
}
