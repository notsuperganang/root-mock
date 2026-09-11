package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_messaging.zzac;
import com.google.android.gms.internal.firebase_messaging.zzq;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzc();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle zzdw;
    private Map<String, String> zzdx;
    private Notification zzdy;

    public static class Builder {
        private final Bundle zzdw = new Bundle();
        private final Map<String, String> zzdx = new ArrayMap();

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                String strValueOf = String.valueOf(str);
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Invalid to: ".concat(strValueOf) : new String("Invalid to: "));
            }
            this.zzdw.putString("google.to", str);
        }

        public Builder addData(String str, String str2) {
            this.zzdx.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : this.zzdx.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putAll(this.zzdw);
            this.zzdw.remove("from");
            return new RemoteMessage(bundle);
        }

        public Builder clearData() {
            this.zzdx.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.zzdw.putString("collapse_key", str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.zzdx.clear();
            this.zzdx.putAll(map);
            return this;
        }

        public Builder setMessageId(String str) {
            this.zzdw.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.zzdw.putString("message_type", str);
            return this;
        }

        public Builder setTtl(@IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 86400) int i) {
            this.zzdw.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {
        private final String tag;
        private final String zzdz;
        private final String zzea;
        private final String[] zzeb;
        private final String zzec;
        private final String zzed;
        private final String[] zzee;
        private final String zzef;
        private final String zzeg;
        private final String zzeh;
        private final String zzei;
        private final String zzej;
        private final Uri zzek;

        private Notification(zzq zzqVar) {
            this.zzdz = zzqVar.getString("gcm.n.title");
            this.zzea = zzqVar.zzp("gcm.n.title");
            this.zzeb = zzqVar.zzn("gcm.n.title");
            this.zzec = zzqVar.getString("gcm.n.body");
            this.zzed = zzqVar.zzp("gcm.n.body");
            this.zzee = zzqVar.zzn("gcm.n.body");
            this.zzef = zzqVar.getString("gcm.n.icon");
            this.zzeg = zzqVar.zzav();
            this.tag = zzqVar.getString("gcm.n.tag");
            this.zzeh = zzqVar.getString("gcm.n.color");
            this.zzei = zzqVar.getString("gcm.n.click_action");
            this.zzej = zzqVar.getString("gcm.n.android_channel_id");
            this.zzek = zzqVar.zzaw();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static Notification zzf(Bundle bundle) {
            if (zzac.zzj(bundle)) {
                return new Notification(new zzq("FirebaseMessaging", bundle));
            }
            return null;
        }

        @Nullable
        public String getBody() {
            return this.zzec;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.zzee;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.zzed;
        }

        @Nullable
        public String getChannelId() {
            return this.zzej;
        }

        @Nullable
        public String getClickAction() {
            return this.zzei;
        }

        @Nullable
        public String getColor() {
            return this.zzeh;
        }

        @Nullable
        public String getIcon() {
            return this.zzef;
        }

        @Nullable
        public Uri getLink() {
            return this.zzek;
        }

        @Nullable
        public String getSound() {
            return this.zzeg;
        }

        @Nullable
        public String getTag() {
            return this.tag;
        }

        @Nullable
        public String getTitle() {
            return this.zzdz;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.zzeb;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.zzea;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzdw = bundle;
    }

    private static int zzm(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.zzdw.getString("collapse_key");
    }

    public final Map<String, String> getData() {
        if (this.zzdx == null) {
            Bundle bundle = this.zzdw;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.zzdx = arrayMap;
        }
        return this.zzdx;
    }

    @Nullable
    public final String getFrom() {
        return this.zzdw.getString("from");
    }

    @Nullable
    public final String getMessageId() {
        String string = this.zzdw.getString("google.message_id");
        return string == null ? this.zzdw.getString("message_id") : string;
    }

    @Nullable
    public final String getMessageType() {
        return this.zzdw.getString("message_type");
    }

    @Nullable
    public final Notification getNotification() {
        if (this.zzdy == null) {
            this.zzdy = Notification.zzf(this.zzdw);
        }
        return this.zzdy;
    }

    public final int getOriginalPriority() {
        String string = this.zzdw.getString("google.original_priority");
        if (string == null) {
            string = this.zzdw.getString("google.priority");
        }
        return zzm(string);
    }

    public final int getPriority() {
        String string = this.zzdw.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zzdw.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zzdw.getString("google.priority");
        }
        return zzm(string);
    }

    public final long getSentTime() {
        Object obj = this.zzdw.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                String strValueOf = String.valueOf(obj);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strValueOf).length() + 19).append("Invalid sent time: ").append(strValueOf).toString());
            }
        }
        return 0L;
    }

    @Nullable
    public final String getTo() {
        return this.zzdw.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zzdw.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                String strValueOf = String.valueOf(obj);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strValueOf).length() + 13).append("Invalid TTL: ").append(strValueOf).toString());
            }
        }
        return 0;
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zzdw);
        return intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdw, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
