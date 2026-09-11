package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public static CharSequence zzb(String str, List<zzc> list, @Nullable CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (zzc zzcVar : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), zzcVar.offset, zzcVar.length + zzcVar.offset, 0);
        }
        return spannableString;
    }

    @Nullable
    public static String zzg(@Nullable Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return TextUtils.join(", ", collection);
    }
}
