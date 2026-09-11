package android.support.design.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TouchDelegateGroup extends TouchDelegate {
    private static final Rect USELESS_HACKY_RECT = new Rect();
    private TouchDelegate mCurrentTouchDelegate;
    private boolean mEnabled;
    private final ArrayList<TouchDelegate> mTouchDelegates;

    public TouchDelegateGroup(View view) {
        super(USELESS_HACKY_RECT, view);
        this.mTouchDelegates = new ArrayList<>();
    }

    public void addTouchDelegate(@NonNull TouchDelegate touchDelegate) {
        this.mTouchDelegates.add(touchDelegate);
    }

    public void removeTouchDelegate(TouchDelegate touchDelegate) {
        this.mTouchDelegates.remove(touchDelegate);
        if (this.mCurrentTouchDelegate == touchDelegate) {
            this.mCurrentTouchDelegate = null;
        }
    }

    public void clearTouchDelegates() {
        this.mTouchDelegates.clear();
        this.mCurrentTouchDelegate = null;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        TouchDelegate touchDelegate;
        if (!this.mEnabled) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                for (int i = 0; i < this.mTouchDelegates.size(); i++) {
                    TouchDelegate touchDelegate2 = this.mTouchDelegates.get(i);
                    if (touchDelegate2.onTouchEvent(motionEvent)) {
                        this.mCurrentTouchDelegate = touchDelegate2;
                        return true;
                    }
                }
                touchDelegate = null;
                break;
            case 1:
            case 3:
                touchDelegate = this.mCurrentTouchDelegate;
                this.mCurrentTouchDelegate = null;
                break;
            case 2:
                touchDelegate = this.mCurrentTouchDelegate;
                break;
            default:
                touchDelegate = null;
                break;
        }
        return touchDelegate != null && touchDelegate.onTouchEvent(motionEvent);
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }
}
