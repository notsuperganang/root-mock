package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: android.support.v7.util.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i = snake.x - snake2.x;
            return i == 0 ? snake.y - snake2.y : i;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.x == 0 && snake.y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.x = 0;
            snake2.y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.mNewItemStatuses[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.onInserted(i, 1);
                        Iterator<PostponedUpdate> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().currentPos++;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.mNewItemStatuses[i3 + i4] >> 5;
                        listUpdateCallback.onMoved(removePostponedUpdate(list, i6, true).currentPos, i);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(i, 1, this.mCallback.getChangePayload(i6, i3 + i4));
                        }
                        break;
                    case 16:
                        list.add(new PostponedUpdate(i3 + i4, i, false));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.mOldItemStatuses[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.onRemoved(i + i4, 1);
                        Iterator<PostponedUpdate> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().currentPos--;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.mOldItemStatuses[i3 + i4] >> 5;
                        PostponedUpdate postponedUpdateRemovePostponedUpdate = removePostponedUpdate(list, i6, false);
                        listUpdateCallback.onMoved(i + i4, postponedUpdateRemovePostponedUpdate.currentPos - 1);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(postponedUpdateRemovePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i3 + i4, i6));
                        }
                        break;
                    case 16:
                        list.add(new PostponedUpdate(i3 + i4, i + i4, true));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }

        private void findAddition(int i, int i2, int i3) {
            if (this.mOldItemStatuses[i - 1] != 0) {
                return;
            }
            findMatchingItem(i, i2, i3, false);
        }

        private boolean findMatchingItem(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i5 = i;
                i4 = i2 - 1;
                i2--;
            } else {
                i4 = i - 1;
                i5 = i - 1;
            }
            while (i3 >= 0) {
                Snake snake = this.mSnakes.get(i3);
                int i6 = snake.x;
                int i7 = snake.size;
                int i8 = snake.y;
                int i9 = snake.size;
                if (z) {
                    while (true) {
                        i5--;
                        if (i5 < i6 + i7) {
                            break;
                        }
                        if (this.mCallback.areItemsTheSame(i5, i4)) {
                            int i10 = this.mCallback.areContentsTheSame(i5, i4) ? 8 : 4;
                            this.mNewItemStatuses[i4] = (i5 << 5) | 16;
                            this.mOldItemStatuses[i5] = i10 | (i4 << 5);
                            return true;
                        }
                    }
                } else {
                    for (int i11 = i2 - 1; i11 >= i8 + i9; i11--) {
                        if (this.mCallback.areItemsTheSame(i4, i11)) {
                            int i12 = this.mCallback.areContentsTheSame(i4, i11) ? 8 : 4;
                            this.mOldItemStatuses[i - 1] = (i11 << 5) | 16;
                            this.mNewItemStatuses[i11] = i12 | ((i - 1) << 5);
                            return true;
                        }
                    }
                }
                i5 = snake.x;
                i2 = snake.y;
                i3--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.x;
                int i4 = snake.size;
                int i5 = snake.y;
                int i6 = snake.size;
                if (this.mDetectMoves) {
                    while (i > i3 + i4) {
                        findAddition(i, i2, size);
                        i--;
                    }
                    while (i2 > i5 + i6) {
                        findRemoval(i, i2, size);
                        i2--;
                    }
                }
                for (int i7 = 0; i7 < snake.size; i7++) {
                    int i8 = snake.x + i7;
                    int i9 = snake.y + i7;
                    int i10 = this.mCallback.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.mOldItemStatuses[i8] = (i9 << 5) | i10;
                    this.mNewItemStatuses[i9] = i10 | (i8 << 5);
                }
                i = snake.x;
                i2 = snake.y;
            }
        }

        private void findRemoval(int i, int i2, int i3) {
            if (this.mNewItemStatuses[i2 - 1] != 0) {
                return;
            }
            findMatchingItem(i, i2, i3, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return postponedUpdate;
                        }
                        PostponedUpdate postponedUpdate2 = list.get(i2);
                        postponedUpdate2.currentPos = (z ? 1 : -1) + postponedUpdate2.currentPos;
                        size = i2 + 1;
                    }
                } else {
                    size--;
                }
            }
            return null;
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            List<PostponedUpdate> arrayList = new ArrayList<>();
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            int size = this.mSnakes.size() - 1;
            int i3 = i2;
            while (size >= 0) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.size;
                int i5 = snake.x + i4;
                int i6 = snake.y + i4;
                if (i5 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i5, i - i5, i5);
                }
                if (i6 < i3) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    if ((this.mOldItemStatuses[snake.x + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(snake.x + i7, 1, this.mCallback.getChangePayload(snake.x + i7, snake.y + i7));
                    }
                }
                i = snake.x;
                size--;
                i3 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new ListUpdateCallback(this, adapter) { // from class: android.support.v7.util.DiffUtil.DiffResult.1
                final DiffResult this$0;
                final RecyclerView.Adapter val$adapter;

                {
                    this.this$0 = this;
                    this.val$adapter = adapter;
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onChanged(int i, int i2, Object obj) {
                    this.val$adapter.notifyItemRangeChanged(i, i2, obj);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onInserted(int i, int i2) {
                    this.val$adapter.notifyItemRangeInserted(i, i2);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onMoved(int i, int i2) {
                    this.val$adapter.notifyItemMoved(i, i2);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onRemoved(int i, int i2) {
                    this.val$adapter.notifyItemRangeRemoved(i, i2);
                }
            });
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int iAbs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int[] iArr = new int[iAbs * 2];
        int[] iArr2 = new int[iAbs * 2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeDiffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, iAbs);
            if (snakeDiffPartial != null) {
                if (snakeDiffPartial.size > 0) {
                    arrayList.add(snakeDiffPartial);
                }
                snakeDiffPartial.x += range.oldListStart;
                snakeDiffPartial.y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (snakeDiffPartial.reverse) {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y;
                } else if (snakeDiffPartial.removal) {
                    range2.oldListEnd = snakeDiffPartial.x - 1;
                    range2.newListEnd = snakeDiffPartial.y;
                } else {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y - 1;
                }
                arrayList2.add(range2);
                if (!snakeDiffPartial.reverse) {
                    range.oldListStart = snakeDiffPartial.x + snakeDiffPartial.size;
                    range.newListStart = snakeDiffPartial.y + snakeDiffPartial.size;
                } else if (snakeDiffPartial.removal) {
                    range.oldListStart = snakeDiffPartial.x + snakeDiffPartial.size + 1;
                    range.newListStart = snakeDiffPartial.y + snakeDiffPartial.size;
                } else {
                    range.oldListStart = snakeDiffPartial.x + snakeDiffPartial.size;
                    range.newListStart = snakeDiffPartial.y + snakeDiffPartial.size + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    private static Snake diffPartial(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6;
        boolean z;
        int i7;
        boolean z2;
        int i8 = i2 - i;
        int i9 = i4 - i3;
        if (i2 - i < 1 || i4 - i3 < 1) {
            return null;
        }
        int i10 = i8 - i9;
        int i11 = ((i8 + i9) + 1) / 2;
        Arrays.fill(iArr, (i5 - i11) - 1, i5 + i11 + 1, 0);
        Arrays.fill(iArr2, ((i5 - i11) - 1) + i10, i5 + i11 + 1 + i10, i8);
        boolean z3 = i10 % 2 != 0;
        for (int i12 = 0; i12 <= i11; i12++) {
            for (int i13 = -i12; i13 <= i12; i13 += 2) {
                if (i13 == (-i12) || (i13 != i12 && iArr[(i5 + i13) - 1] < iArr[i5 + i13 + 1])) {
                    i7 = iArr[i5 + i13 + 1];
                    z2 = false;
                } else {
                    i7 = iArr[(i5 + i13) - 1] + 1;
                    z2 = true;
                }
                for (int i14 = i7 - i13; i7 < i8 && i14 < i9 && callback.areItemsTheSame(i + i7, i3 + i14); i14++) {
                    i7++;
                }
                iArr[i5 + i13] = i7;
                if (z3 && i13 >= (i10 - i12) + 1 && i13 <= (i10 + i12) - 1 && iArr[i5 + i13] >= iArr2[i5 + i13]) {
                    Snake snake = new Snake();
                    snake.x = iArr2[i5 + i13];
                    snake.y = snake.x - i13;
                    snake.size = iArr[i5 + i13] - iArr2[i5 + i13];
                    snake.removal = z2;
                    snake.reverse = false;
                    return snake;
                }
            }
            for (int i15 = -i12; i15 <= i12; i15 += 2) {
                int i16 = i15 + i10;
                if (i16 == i12 + i10 || (i16 != (-i12) + i10 && iArr2[(i5 + i16) - 1] < iArr2[i5 + i16 + 1])) {
                    i6 = iArr2[(i5 + i16) - 1];
                    z = false;
                } else {
                    i6 = iArr2[(i5 + i16) + 1] - 1;
                    z = true;
                }
                int i17 = i6;
                for (int i18 = i6 - i16; i17 > 0 && i18 > 0 && callback.areItemsTheSame((i + i17) - 1, (i3 + i18) - 1); i18--) {
                    i17--;
                }
                iArr2[i5 + i16] = i17;
                if (!z3 && i15 + i10 >= (-i12) && i15 + i10 <= i12 && iArr[i5 + i16] >= iArr2[i5 + i16]) {
                    Snake snake2 = new Snake();
                    snake2.x = iArr2[i5 + i16];
                    snake2.y = snake2.x - i16;
                    snake2.size = iArr[i5 + i16] - iArr2[i5 + i16];
                    snake2.removal = z;
                    snake2.reverse = true;
                    return snake2;
                }
            }
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
