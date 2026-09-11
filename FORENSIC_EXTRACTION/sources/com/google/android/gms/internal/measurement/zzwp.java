package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: loaded from: classes.dex */
final class zzwp<FieldDescriptorType> extends zzwo<FieldDescriptorType, Object> {
    zzwp(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzwo
    public final void zzsw() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzyc()) {
                    break;
                }
                Map.Entry<FieldDescriptorType, Object> entryZzbx = zzbx(i2);
                if (((zzuh) entryZzbx.getKey()).zzwb()) {
                    entryZzbx.setValue(Collections.unmodifiableList((List) entryZzbx.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzyd()) {
                if (((zzuh) entry.getKey()).zzwb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzsw();
    }
}
