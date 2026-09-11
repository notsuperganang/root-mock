package com.google.android.gms.internal.places;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: loaded from: classes.dex */
final class zzjc<FieldDescriptorType> extends zzjb<FieldDescriptorType, Object> {
    zzjc(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.places.zzjb
    public final void zzbb() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzgg()) {
                    break;
                }
                Map.Entry<FieldDescriptorType, Object> entryZzbn = zzbn(i2);
                if (((zzgs) entryZzbn.getKey()).zzdk()) {
                    entryZzbn.setValue(Collections.unmodifiableList((List) entryZzbn.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzgh()) {
                if (((zzgs) entry.getKey()).zzdk()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbb();
    }
}
