package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0004zaa> zack;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.zaa$zaa, reason: collision with other inner class name */
    @VisibleForTesting(otherwise = 2)
    static class C0004zaa extends LifecycleCallback {
        private List<Runnable> zacl;

        private C0004zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.zacl = new ArrayList();
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0004zaa zaa(Activity activity) {
            C0004zaa c0004zaa;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                c0004zaa = (C0004zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0004zaa.class);
                if (c0004zaa == null) {
                    c0004zaa = new C0004zaa(fragment);
                }
            }
            return c0004zaa;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zaa(Runnable runnable) {
            synchronized (this) {
                this.zacl.add(runnable);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacl;
                this.zacl = new ArrayList();
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public zaa(Activity activity) {
        this(C0004zaa.zaa(activity));
    }

    @VisibleForTesting(otherwise = 2)
    private zaa(C0004zaa c0004zaa) {
        this.zack = new WeakReference<>(c0004zaa);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0004zaa c0004zaa = this.zack.get();
        if (c0004zaa == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c0004zaa.zaa(runnable);
        return this;
    }
}
