package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: loaded from: classes.dex */
final class zzbdq<FieldDescriptorType> extends zzbdp<FieldDescriptorType, Object> {
    zzbdq(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbdp
    public final void zzaaz() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzafs()) {
                    break;
                }
                Map.Entry<FieldDescriptorType, Object> entryZzcy = zzcy(i2);
                if (((zzbbi) entryZzcy.getKey()).zzada()) {
                    entryZzcy.setValue(Collections.unmodifiableList((List) entryZzcy.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzaft()) {
                if (((zzbbi) entry.getKey()).zzada()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzaaz();
    }
}
