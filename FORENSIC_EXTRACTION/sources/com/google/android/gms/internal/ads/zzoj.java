package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class zzoj extends zzpt {
    private static final int zzbha = Color.rgb(12, 174, 206);
    private static final int zzbhb;
    private static final int zzbhc;
    private static final int zzbhd;
    private final int mTextColor;
    private final String zzbhe;
    private final List<zzon> zzbhf = new ArrayList();
    private final List<zzpw> zzbhg = new ArrayList();
    private final int zzbhh;
    private final int zzbhi;
    private final int zzbhj;
    private final int zzbhk;
    private final boolean zzbhl;

    static {
        int iRgb = Color.rgb(204, 204, 204);
        zzbhb = iRgb;
        zzbhc = iRgb;
        zzbhd = zzbha;
    }

    public zzoj(String str, List<zzon> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzbhe = str;
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                zzon zzonVar = list.get(i4);
                this.zzbhf.add(zzonVar);
                this.zzbhg.add(zzonVar);
                i3 = i4 + 1;
            }
        }
        this.zzbhh = num != null ? num.intValue() : zzbhc;
        this.mTextColor = num2 != null ? num2.intValue() : zzbhd;
        this.zzbhi = num3 != null ? num3.intValue() : 12;
        this.zzbhj = i;
        this.zzbhk = i2;
        this.zzbhl = z;
    }

    public final int getBackgroundColor() {
        return this.zzbhh;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final String getText() {
        return this.zzbhe;
    }

    public final int getTextColor() {
        return this.mTextColor;
    }

    public final int getTextSize() {
        return this.zzbhi;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final List<zzpw> zzjr() {
        return this.zzbhg;
    }

    public final List<zzon> zzjs() {
        return this.zzbhf;
    }

    public final int zzjt() {
        return this.zzbhj;
    }

    public final int zzju() {
        return this.zzbhk;
    }

    public final boolean zzjv() {
        return this.zzbhl;
    }
}
