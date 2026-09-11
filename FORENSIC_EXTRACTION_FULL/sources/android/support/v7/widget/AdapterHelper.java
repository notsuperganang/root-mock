package android.support.v7.widget;

import android.support.v4.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    static class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.positionStart = i2;
            this.itemCount = i3;
            this.payload = obj;
        }

        String cmdToString() {
            switch (this.cmd) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    return "??";
                case 4:
                    return "up";
                case 8:
                    return "mv";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            if (this.cmd != updateOp.cmd) {
                return false;
            }
            if (this.cmd == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount == updateOp.itemCount && this.positionStart == updateOp.positionStart) {
                if (this.payload != null) {
                    return this.payload.equals(updateOp.payload);
                }
                return updateOp.payload == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z;
        this.mOpReorderer = new OpReorderer(this);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z;
        int i;
        int i2 = updateOp.positionStart;
        int i3 = updateOp.positionStart + updateOp.itemCount;
        byte b = -1;
        int i4 = updateOp.positionStart;
        int i5 = 0;
        while (i4 < i3) {
            if (this.mCallback.findViewHolder(i4) != null || canFindInPreLayout(i4)) {
                if (b == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i = 1;
            } else {
                i = i5 + 1;
            }
            i4++;
            i5 = i;
        }
        if (i5 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i2, i5, null);
        }
        if (b == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i = updateOp.positionStart;
        int i2 = updateOp.positionStart;
        int i3 = updateOp.itemCount;
        byte b = -1;
        int i4 = 0;
        for (int i5 = updateOp.positionStart; i5 < i2 + i3; i5++) {
            if (this.mCallback.findViewHolder(i5) != null || canFindInPreLayout(i5)) {
                if (b == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i, i4, updateOp.payload));
                    i4 = 0;
                    i = i5;
                }
                b = 1;
            } else {
                if (b == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i, i4, updateOp.payload));
                    i4 = 0;
                    i = i5;
                }
                b = 0;
            }
            i4++;
        }
        if (i4 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i, i4, obj);
        }
        if (b == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            if (updateOp.cmd == 8) {
                if (findPositionOffset(updateOp.itemCount, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.cmd == 1) {
                int i3 = updateOp.positionStart;
                int i4 = updateOp.itemCount;
                for (int i5 = updateOp.positionStart; i5 < i3 + i4; i5++) {
                    if (findPositionOffset(i5, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        boolean z;
        if (updateOp.cmd == 1 || updateOp.cmd == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iUpdatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, updateOp.cmd);
        int i2 = updateOp.positionStart;
        switch (updateOp.cmd) {
            case 2:
                i = 0;
                break;
            case 3:
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            case 4:
                i = 1;
                break;
        }
        int i3 = 1;
        for (int i4 = 1; i4 < updateOp.itemCount; i4++) {
            int iUpdatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i * i4), updateOp.cmd);
            switch (updateOp.cmd) {
                case 2:
                    z = iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed;
                    break;
                case 3:
                    z = false;
                    break;
                case 4:
                    z = iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed + 1;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                i3++;
            } else {
                UpdateOp updateOpObtainUpdateOp = obtainUpdateOp(updateOp.cmd, iUpdatePositionWithPostponed, i3, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(updateOpObtainUpdateOp, i2);
                recycleUpdateOp(updateOpObtainUpdateOp);
                if (updateOp.cmd == 4) {
                    i2 += i3;
                }
                i3 = 1;
                iUpdatePositionWithPostponed = iUpdatePositionWithPostponed2;
            }
        }
        Object obj = updateOp.payload;
        recycleUpdateOp(updateOp);
        if (i3 > 0) {
            UpdateOp updateOpObtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, iUpdatePositionWithPostponed, i3, obj);
            dispatchFirstPassAndUpdateViewHolders(updateOpObtainUpdateOp2, i2);
            recycleUpdateOp(updateOpObtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        switch (updateOp.cmd) {
            case 1:
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                return;
            case 2:
                this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
            case 4:
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                return;
            case 8:
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e6  */
    private int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = this.mPostponedList.size() - 1;
        int i6 = i;
        while (size >= 0) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            if (updateOp.cmd == 8) {
                if (updateOp.positionStart < updateOp.itemCount) {
                    i4 = updateOp.positionStart;
                    i5 = updateOp.itemCount;
                } else {
                    i4 = updateOp.itemCount;
                    i5 = updateOp.positionStart;
                }
                if (i6 < i4 || i6 > i5) {
                    if (i6 >= updateOp.positionStart) {
                        i3 = i6;
                    } else if (i2 == 1) {
                        updateOp.positionStart++;
                        updateOp.itemCount++;
                        i3 = i6;
                    } else if (i2 == 2) {
                        updateOp.positionStart--;
                        updateOp.itemCount--;
                        i3 = i6;
                    } else {
                        i3 = i6;
                    }
                } else if (i4 == updateOp.positionStart) {
                    if (i2 == 1) {
                        updateOp.itemCount++;
                    } else if (i2 == 2) {
                        updateOp.itemCount--;
                    }
                    i3 = i6 + 1;
                } else {
                    if (i2 == 1) {
                        updateOp.positionStart++;
                    } else if (i2 == 2) {
                        updateOp.positionStart--;
                    }
                    i3 = i6 - 1;
                }
            } else if (updateOp.positionStart <= i6) {
                if (updateOp.cmd == 1) {
                    i3 = i6 - updateOp.itemCount;
                } else if (updateOp.cmd == 2) {
                    i3 = updateOp.itemCount + i6;
                } else {
                    i3 = i6;
                }
            } else if (i2 == 1) {
                updateOp.positionStart++;
                i3 = i6;
            } else if (i2 == 2) {
                updateOp.positionStart--;
                i3 = i6;
            } else {
                i3 = i6;
            }
            size--;
            i6 = i3;
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                if (updateOp2.itemCount == updateOp2.positionStart || updateOp2.itemCount < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i6;
    }

    AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int i2;
        int size = this.mPendingUpdates.size();
        int i3 = 0;
        int i4 = i;
        while (i3 < size) {
            UpdateOp updateOp = this.mPendingUpdates.get(i3);
            switch (updateOp.cmd) {
                case 1:
                    if (updateOp.positionStart <= i4) {
                        i2 = updateOp.itemCount + i4;
                    } else {
                        i2 = i4;
                    }
                    i3++;
                    i4 = i2;
                    break;
                case 2:
                    if (updateOp.positionStart > i4) {
                        i2 = i4;
                    } else {
                        if (updateOp.positionStart + updateOp.itemCount > i4) {
                            return -1;
                        }
                        i2 = i4 - updateOp.itemCount;
                    }
                    i3++;
                    i4 = i2;
                    break;
                case 8:
                    if (updateOp.positionStart == i4) {
                        i2 = updateOp.itemCount;
                    } else {
                        if (updateOp.positionStart < i4) {
                            i4--;
                        }
                        if (updateOp.itemCount <= i4) {
                            i2 = i4 + 1;
                        } else {
                            i2 = i4;
                        }
                    }
                    i3++;
                    i4 = i2;
                    break;
                default:
                    i2 = i4;
                    i3++;
                    i4 = i2;
                    break;
            }
        }
        return i4;
    }

    void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = 0; i < size; i++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case 1:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                    break;
                case 2:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                    break;
                case 4:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    break;
                case 8:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                    break;
            }
            if (this.mOnItemProcessedCallback != null) {
                this.mOnItemProcessedCallback.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        this.mCallback.onDispatchFirstPass(updateOp);
        switch (updateOp.cmd) {
            case 2:
                this.mCallback.offsetPositionsForRemovingInvisible(i, updateOp.itemCount);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.mCallback.markViewHoldersUpdated(i, updateOp.itemCount, updateOp.payload);
                return;
        }
    }

    int findPositionOffset(int i) {
        return findPositionOffset(i, 0);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004e A[PHI: r1
      0x004e: PHI (r1v3 int) = (r1v1 int), (r1v1 int), (r1v5 int) binds: [B:17:0x0030, B:26:0x0048, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    int findPositionOffset(int i, int i2) {
        int i3;
        int size = this.mPostponedList.size();
        int i4 = i;
        while (i2 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            if (updateOp.cmd == 8) {
                if (updateOp.positionStart == i4) {
                    i3 = updateOp.itemCount;
                } else {
                    if (updateOp.positionStart < i4) {
                        i4--;
                    }
                    if (updateOp.itemCount <= i4) {
                        i3 = i4 + 1;
                    } else {
                        i3 = i4;
                    }
                }
            } else if (updateOp.positionStart > i4) {
                i3 = i4;
            } else if (updateOp.cmd == 2) {
                if (i4 < updateOp.positionStart + updateOp.itemCount) {
                    return -1;
                }
                i3 = i4 - updateOp.itemCount;
            } else if (updateOp.cmd == 1) {
                i3 = updateOp.itemCount + i4;
            } else {
                i3 = i4;
            }
            i2++;
            i4 = i3;
        }
        return i4;
    }

    boolean hasAnyUpdateTypes(int i) {
        return (this.mExistingUpdateTypes & i) != 0;
    }

    boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    boolean hasUpdates() {
        return (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true;
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp updateOpAcquire = this.mUpdateOpPool.acquire();
        if (updateOpAcquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        updateOpAcquire.cmd = i;
        updateOpAcquire.positionStart = i2;
        updateOpAcquire.itemCount = i3;
        updateOpAcquire.payload = obj;
        return updateOpAcquire;
    }

    boolean onItemRangeChanged(int i, int i2, Object obj) {
        if (i2 >= 1) {
            this.mPendingUpdates.add(obtainUpdateOp(4, i, i2, obj));
            this.mExistingUpdateTypes |= 4;
            if (this.mPendingUpdates.size() == 1) {
                return true;
            }
        }
        return false;
    }

    boolean onItemRangeInserted(int i, int i2) {
        if (i2 >= 1) {
            this.mPendingUpdates.add(obtainUpdateOp(1, i, i2, null));
            this.mExistingUpdateTypes |= 1;
            if (this.mPendingUpdates.size() == 1) {
                return true;
            }
        }
        return false;
    }

    boolean onItemRangeMoved(int i, int i2, int i3) {
        if (i != i2) {
            if (i3 != 1) {
                throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
            }
            this.mPendingUpdates.add(obtainUpdateOp(8, i, i2, null));
            this.mExistingUpdateTypes |= 8;
            if (this.mPendingUpdates.size() == 1) {
                return true;
            }
        }
        return false;
    }

    boolean onItemRangeRemoved(int i, int i2) {
        if (i2 >= 1) {
            this.mPendingUpdates.add(obtainUpdateOp(2, i, i2, null));
            this.mExistingUpdateTypes |= 2;
            if (this.mPendingUpdates.size() == 1) {
                return true;
            }
        }
        return false;
    }

    void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case 1:
                    applyAdd(updateOp);
                    break;
                case 2:
                    applyRemove(updateOp);
                    break;
                case 4:
                    applyUpdate(updateOp);
                    break;
                case 8:
                    applyMove(updateOp);
                    break;
            }
            if (this.mOnItemProcessedCallback != null) {
                this.mOnItemProcessedCallback.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.mDisableRecycler) {
            return;
        }
        updateOp.payload = null;
        this.mUpdateOpPool.release(updateOp);
    }

    void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }
}
