package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzane;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzmt;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@zzadh
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    @Nullable
    private zzlo zzux;

    @GuardedBy("mLock")
    @Nullable
    private VideoLifecycleCallbacks zzuy;

    public static class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final float getAspectRatio() {
        float aspectRatio = 0.0f;
        synchronized (this.mLock) {
            if (this.zzux != null) {
                try {
                    aspectRatio = this.zzux.getAspectRatio();
                } catch (RemoteException e) {
                    zzane.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return aspectRatio;
    }

    @KeepForSdk
    public final int getPlaybackState() {
        int playbackState = 0;
        synchronized (this.mLock) {
            if (this.zzux != null) {
                try {
                    playbackState = this.zzux.getPlaybackState();
                } catch (RemoteException e) {
                    zzane.zzb("Unable to call getPlaybackState on video controller.", e);
                }
            }
        }
        return playbackState;
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.mLock) {
            videoLifecycleCallbacks = this.zzuy;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzux != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        boolean zIsClickToExpandEnabled = false;
        synchronized (this.mLock) {
            if (this.zzux != null) {
                try {
                    zIsClickToExpandEnabled = this.zzux.isClickToExpandEnabled();
                } catch (RemoteException e) {
                    zzane.zzb("Unable to call isClickToExpandEnabled.", e);
                }
            }
        }
        return zIsClickToExpandEnabled;
    }

    public final boolean isCustomControlsEnabled() {
        boolean zIsCustomControlsEnabled = false;
        synchronized (this.mLock) {
            if (this.zzux != null) {
                try {
                    zIsCustomControlsEnabled = this.zzux.isCustomControlsEnabled();
                } catch (RemoteException e) {
                    zzane.zzb("Unable to call isUsingCustomPlayerControls.", e);
                }
            }
        }
        return zIsCustomControlsEnabled;
    }

    public final boolean isMuted() {
        boolean zIsMuted = true;
        synchronized (this.mLock) {
            if (this.zzux != null) {
                try {
                    zIsMuted = this.zzux.isMuted();
                } catch (RemoteException e) {
                    zzane.zzb("Unable to call isMuted on video controller.", e);
                }
            }
        }
        return zIsMuted;
    }

    public final void mute(boolean z) {
        synchronized (this.mLock) {
            if (this.zzux == null) {
                return;
            }
            try {
                this.zzux.mute(z);
            } catch (RemoteException e) {
                zzane.zzb("Unable to call mute on video controller.", e);
            }
        }
    }

    public final void pause() {
        synchronized (this.mLock) {
            if (this.zzux == null) {
                return;
            }
            try {
                this.zzux.pause();
            } catch (RemoteException e) {
                zzane.zzb("Unable to call pause on video controller.", e);
            }
        }
    }

    public final void play() {
        synchronized (this.mLock) {
            if (this.zzux == null) {
                return;
            }
            try {
                this.zzux.play();
            } catch (RemoteException e) {
                zzane.zzb("Unable to call play on video controller.", e);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.mLock) {
            this.zzuy = videoLifecycleCallbacks;
            if (this.zzux == null) {
                return;
            }
            try {
                this.zzux.zza(new zzmt(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzane.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final void zza(zzlo zzloVar) {
        synchronized (this.mLock) {
            this.zzux = zzloVar;
            if (this.zzuy != null) {
                setVideoLifecycleCallbacks(this.zzuy);
            }
        }
    }

    public final zzlo zzbc() {
        zzlo zzloVar;
        synchronized (this.mLock) {
            zzloVar = this.zzux;
        }
        return zzloVar;
    }
}
