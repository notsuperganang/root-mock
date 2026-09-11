package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    private static final float EPSILON = 1.0E-5f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_MEDIA_ITEM = "media_item";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    ConnectionRecord mCurConnection;
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;
    static final String TAG = "MBServiceCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    final ServiceHandler mHandler = new ServiceHandler(this);

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    private static class ConnectionRecord {
        ServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();

        ConnectionRecord() {
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    @RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;
        final MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi21(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (this.this$0.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            }
            if (this.this$0.mCurConnection.rootHints != null) {
                return new Bundle(this.this$0.mCurConnection.rootHints);
            }
            return null;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            if (this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                this.this$0.mHandler.post(new Runnable(this, str, bundle) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                    final MediaBrowserServiceImplApi21 this$1;
                    final Bundle val$options;
                    final String val$parentId;

                    {
                        this.this$1 = this;
                        this.val$parentId = str;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator<IBinder> it = this.this$1.this$0.mConnections.keySet().iterator();
                        while (it.hasNext()) {
                            ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(it.next());
                            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(this.val$parentId);
                            if (list != null) {
                                for (Pair<IBinder, Bundle> pair : list) {
                                    if (MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, pair.second)) {
                                        this.this$1.this$0.performLoadChildren(this.val$parentId, connectionRecord, pair.second);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            Bundle extras;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                extras = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new Messenger(this.this$0.mHandler);
                Bundle bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                if (this.this$0.mSession != null) {
                    IMediaSession extraBinder = this.this$0.mSession.getExtraBinder();
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                    extras = bundle2;
                } else {
                    this.mRootExtrasList.add(bundle2);
                    extras = bundle2;
                }
            }
            BrowserRoot browserRootOnGetRoot = this.this$0.onGetRoot(str, i, bundle);
            if (browserRootOnGetRoot == null) {
                return null;
            }
            if (extras == null) {
                extras = browserRootOnGetRoot.getExtras();
            } else if (browserRootOnGetRoot.getExtras() != null) {
                extras.putAll(browserRootOnGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(browserRootOnGetRoot.getRootId(), extras);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            this.this$0.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultWrapper) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3
                final MediaBrowserServiceImplApi21 this$1;
                final MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

                {
                    this.this$1 = this;
                    this.val$resultWrapper = resultWrapper;
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList = null;
                    if (list != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel parcelObtain = Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList2.add(parcelObtain);
                        }
                        arrayList = arrayList2;
                    }
                    this.val$resultWrapper.sendResult(arrayList);
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            this.this$0.mHandler.postOrRun(new Runnable(this, token) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                final MediaBrowserServiceImplApi21 this$1;
                final MediaSessionCompat.Token val$token;

                {
                    this.this$1 = this;
                    this.val$token = token;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!this.this$1.mRootExtrasList.isEmpty()) {
                        IMediaSession extraBinder = this.val$token.getExtraBinder();
                        if (extraBinder != null) {
                            Iterator<Bundle> it = this.this$1.mRootExtrasList.iterator();
                            while (it.hasNext()) {
                                BundleCompat.putBinder(it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        this.this$1.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(this.this$1.mServiceObj, this.val$token.getToken());
                }
            });
        }
    }

    @RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        final MediaBrowserServiceCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super(mediaBrowserServiceCompat);
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            this.this$0.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(this, str, resultWrapper) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                final MediaBrowserServiceImplApi23 this$1;
                final MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

                {
                    this.this$1 = this;
                    this.val$resultWrapper = resultWrapper;
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        this.val$resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    this.val$resultWrapper.sendResult(parcelObtain);
                }
            });
        }
    }

    @RequiresApi(26)
    class MediaBrowserServiceImplApi24 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi24.ServiceCompatProxy {
        final MediaBrowserServiceCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        MediaBrowserServiceImplApi24(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super(mediaBrowserServiceCompat);
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.this$0.mCurConnection == null) {
                return MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
            }
            if (this.this$0.mCurConnection.rootHints == null) {
                return null;
            }
            return new Bundle(this.this$0.mCurConnection.rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            if (bundle == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, str, bundle);
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi24.createService(this.this$0, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi24.ResultWrapper resultWrapper, Bundle bundle) {
            this.this$0.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultWrapper) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi24.1
                final MediaBrowserServiceImplApi24 this$1;
                final MediaBrowserServiceCompatApi24.ResultWrapper val$resultWrapper;

                {
                    this.this$1 = this;
                    this.val$resultWrapper = resultWrapper;
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    this.val$resultWrapper.detach();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList = null;
                    if (list != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel parcelObtain = Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList2.add(parcelObtain);
                        }
                        arrayList = arrayList2;
                    }
                    this.val$resultWrapper.sendResult(arrayList, getFlags());
                }
            }, bundle);
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;
        final MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.this$0.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            }
            if (this.this$0.mCurConnection.rootHints == null) {
                return null;
            }
            return new Bundle(this.this$0.mCurConnection.rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull String str, Bundle bundle) {
            this.this$0.mHandler.post(new Runnable(this, str, bundle) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2
                final MediaBrowserServiceImplBase this$1;
                final Bundle val$options;
                final String val$parentId;

                {
                    this.this$1 = this;
                    this.val$parentId = str;
                    this.val$options = bundle;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<IBinder> it = this.this$1.this$0.mConnections.keySet().iterator();
                    while (it.hasNext()) {
                        ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(it.next());
                        List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(this.val$parentId);
                        if (list != null) {
                            for (Pair<IBinder, Bundle> pair : list) {
                                if (MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, pair.second)) {
                                    this.this$1.this$0.performLoadChildren(this.val$parentId, connectionRecord, pair.second);
                                }
                            }
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(this.this$0.mHandler);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            this.this$0.mHandler.post(new Runnable(this, token) { // from class: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1
                final MediaBrowserServiceImplBase this$1;
                final MediaSessionCompat.Token val$token;

                {
                    this.this$1 = this;
                    this.val$token = token;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<ConnectionRecord> it = this.this$1.this$0.mConnections.values().iterator();
                    while (it.hasNext()) {
                        ConnectionRecord next = it.next();
                        try {
                            next.callbacks.onConnect(next.root.getRootId(), this.val$token, next.root.getExtras());
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + next.pkg + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            if (this.mSendErrorCalled) {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
            this.mDetachCalled = true;
        }

        int getFlags() {
            return this.mFlags;
        }

        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        void onErrorSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        void onProgressUpdateSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onResultSent(T t) {
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            onErrorSent(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendResult(T t) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(t);
        }

        void setFlags(int i) {
            this.mFlags = i;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private @interface ResultFlags {
    }

    private class ServiceBinderImpl {
        final MediaBrowserServiceCompat this$0;

        ServiceBinderImpl(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.this$0 = mediaBrowserServiceCompat;
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, iBinder, bundle) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final String val$id;
                final Bundle val$options;
                final IBinder val$token;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$id = str;
                    this.val$token = iBinder;
                    this.val$options = bundle;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + this.val$id);
                    } else {
                        this.this$1.this$0.addSubscription(this.val$id, connectionRecord, this.val$token, this.val$options);
                    }
                }
            });
        }

        public void connect(String str, int i, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (!this.this$0.isValidPackage(str, i)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, bundle, i) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final String val$pkg;
                final Bundle val$rootHints;
                final int val$uid;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$pkg = str;
                    this.val$rootHints = bundle;
                    this.val$uid = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderAsBinder = this.val$callbacks.asBinder();
                    this.this$1.this$0.mConnections.remove(iBinderAsBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord();
                    connectionRecord.pkg = this.val$pkg;
                    connectionRecord.rootHints = this.val$rootHints;
                    connectionRecord.callbacks = this.val$callbacks;
                    connectionRecord.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                    if (connectionRecord.root == null) {
                        Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + this.val$pkg + " from service " + getClass().getName());
                        try {
                            this.val$callbacks.onConnectFailed();
                            return;
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
                            return;
                        }
                    }
                    try {
                        this.this$1.this$0.mConnections.put(iBinderAsBinder, connectionRecord);
                        if (this.this$1.this$0.mSession != null) {
                            this.val$callbacks.onConnect(connectionRecord.root.getRootId(), this.this$1.this$0.mSession, connectionRecord.root.getExtras());
                        }
                    } catch (RemoteException e2) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
                        this.this$1.this$0.mConnections.remove(iBinderAsBinder);
                    }
                }
            });
        }

        public void disconnect(ServiceCallbacks serviceCallbacks) {
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder()) != null) {
                    }
                }
            });
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final String val$mediaId;
                final ResultReceiver val$receiver;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$mediaId = str;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
                    } else {
                        this.this$1.this$0.performLoadItem(this.val$mediaId, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, Bundle bundle) {
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, bundle) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final Bundle val$rootHints;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$rootHints = bundle;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderAsBinder = this.val$callbacks.asBinder();
                    this.this$1.this$0.mConnections.remove(iBinderAsBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord();
                    connectionRecord.callbacks = this.val$callbacks;
                    connectionRecord.rootHints = this.val$rootHints;
                    this.this$1.this$0.mConnections.put(iBinderAsBinder, connectionRecord);
                }
            });
        }

        public void removeSubscription(String str, IBinder iBinder, ServiceCallbacks serviceCallbacks) {
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, iBinder) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final String val$id;
                final IBinder val$token;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$id = str;
                    this.val$token = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + this.val$id);
                    } else {
                        if (this.this$1.this$0.removeSubscription(this.val$id, connectionRecord, this.val$token)) {
                            return;
                        }
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + this.val$id + " which is not subscribed");
                    }
                }
            });
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, bundle, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;
                final Bundle val$extras;
                final String val$query;
                final ResultReceiver val$receiver;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$query = str;
                    this.val$extras = bundle;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "search for callback that isn't registered query=" + this.val$query);
                    } else {
                        this.this$1.this$0.performSearch(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, bundle, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                final ServiceBinderImpl this$1;
                final String val$action;
                final ServiceCallbacks val$callbacks;
                final Bundle val$extras;
                final ResultReceiver val$receiver;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$action = str;
                    this.val$extras = bundle;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "sendCustomAction for callback that isn't registered action=" + this.val$action + ", extras=" + this.val$extras);
                    } else {
                        this.this$1.this$0.performCustomAction(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void unregisterCallbacks(ServiceCallbacks serviceCallbacks) {
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks) { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                final ServiceBinderImpl this$1;
                final ServiceCallbacks val$callbacks;

                {
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
                }
            });
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException;
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        private void sendRequest(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            this.mCallbacks.send(messageObtain);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            if (list != null) {
                bundle2.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            sendRequest(3, bundle2);
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;
        final MediaBrowserServiceCompat this$0;

        ServiceHandler(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.this$0 = mediaBrowserServiceCompat;
            this.mServiceBinderImpl = new ServiceBinderImpl(this.this$0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                    break;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: 1\n  Client version: " + message.arg1);
                    break;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
        List<Pair<IBinder, Bundle>> arrayList = list == null ? new ArrayList() : list;
        for (Pair<IBinder, Bundle> pair : arrayList) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        arrayList.add(new Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, arrayList);
        performLoadChildren(str, connectionRecord, bundle);
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int size = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i3, size);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, bundle);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi24(this);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23(this);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21(this);
        } else {
            this.mImpl = new MediaBrowserServiceImplBase(this);
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Result<Bundle> result = new Result<Bundle>(this, str, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.4
            final MediaBrowserServiceCompat this$0;
            final ResultReceiver val$receiver;

            {
                this.this$0 = this;
                this.val$receiver = resultReceiver;
            }

            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            void onErrorSent(Bundle bundle2) {
                this.val$receiver.send(-1, bundle2);
            }

            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            void onProgressUpdateSent(Bundle bundle2) {
                this.val$receiver.send(1, bundle2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(Bundle bundle2) {
                this.val$receiver.send(0, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, str, connectionRecord, str, bundle) { // from class: android.support.v4.media.MediaBrowserServiceCompat.1
            final MediaBrowserServiceCompat this$0;
            final ConnectionRecord val$connection;
            final Bundle val$options;
            final String val$parentId;

            {
                this.this$0 = this;
                this.val$connection = connectionRecord;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                if (this.this$0.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
                    if (MediaBrowserServiceCompat.DEBUG) {
                        Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
                    }
                } else {
                    if ((getFlags() & 1) != 0) {
                        list = this.this$0.applyOptions(list, this.val$options);
                    }
                    try {
                        this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$options);
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
                    }
                }
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, result);
        } else {
            onLoadChildren(str, result, bundle);
        }
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    void performLoadItem(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(this, str, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.2
            final MediaBrowserServiceCompat this$0;
            final ResultReceiver val$receiver;

            {
                this.this$0 = this;
                this.val$receiver = resultReceiver;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                if ((getFlags() & 2) != 0) {
                    this.val$receiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                this.val$receiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultReceiver) { // from class: android.support.v4.media.MediaBrowserServiceCompat.3
            final MediaBrowserServiceCompat this$0;
            final ResultReceiver val$receiver;

            {
                this.this$0 = this;
                this.val$receiver = resultReceiver;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                if ((getFlags() & 4) != 0 || list == null) {
                    this.val$receiver.send(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                this.val$receiver.send(0, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        if (iBinder == null) {
            return connectionRecord.subscriptions.remove(str) != null;
        }
        List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            return false;
        }
        Iterator<Pair<IBinder, Bundle>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (iBinder == it.next().first) {
                it.remove();
                z = true;
            }
        }
        if (list.size() != 0) {
            return z;
        }
        connectionRecord.subscriptions.remove(str);
        return z;
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }
}
