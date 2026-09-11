package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SearchViewCompat {

    @Deprecated
    public interface OnCloseListener {
        boolean onClose();
    }

    @Deprecated
    public static abstract class OnCloseListenerCompat implements OnCloseListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnCloseListener
        public boolean onClose() {
            return false;
        }
    }

    @Deprecated
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    @Deprecated
    public static abstract class OnQueryTextListenerCompat implements OnQueryTextListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    private SearchViewCompat(Context context) {
    }

    private static void checkIfLegalArg(View view) {
        if (view == null) {
            throw new IllegalArgumentException("searchView must be non-null");
        }
        if (!(view instanceof SearchView)) {
            throw new IllegalArgumentException("searchView must be an instance of android.widget.SearchView");
        }
    }

    @Deprecated
    public static CharSequence getQuery(View view) {
        checkIfLegalArg(view);
        return ((SearchView) view).getQuery();
    }

    @Deprecated
    public static boolean isIconified(View view) {
        checkIfLegalArg(view);
        return ((SearchView) view).isIconified();
    }

    @Deprecated
    public static boolean isQueryRefinementEnabled(View view) {
        checkIfLegalArg(view);
        return ((SearchView) view).isQueryRefinementEnabled();
    }

    @Deprecated
    public static boolean isSubmitButtonEnabled(View view) {
        checkIfLegalArg(view);
        return ((SearchView) view).isSubmitButtonEnabled();
    }

    private static SearchView.OnCloseListener newOnCloseListener(OnCloseListener onCloseListener) {
        return new SearchView.OnCloseListener(onCloseListener) { // from class: android.support.v4.widget.SearchViewCompat.2
            final OnCloseListener val$listener;

            {
                this.val$listener = onCloseListener;
            }

            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                return this.val$listener.onClose();
            }
        };
    }

    private static SearchView.OnQueryTextListener newOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        return new SearchView.OnQueryTextListener(onQueryTextListener) { // from class: android.support.v4.widget.SearchViewCompat.1
            final OnQueryTextListener val$listener;

            {
                this.val$listener = onQueryTextListener;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                return this.val$listener.onQueryTextChange(str);
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return this.val$listener.onQueryTextSubmit(str);
            }
        };
    }

    @Deprecated
    public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    @Deprecated
    public static void setIconified(View view, boolean z) {
        checkIfLegalArg(view);
        ((SearchView) view).setIconified(z);
    }

    @Deprecated
    public static void setImeOptions(View view, int i) {
        checkIfLegalArg(view);
        ((SearchView) view).setImeOptions(i);
    }

    @Deprecated
    public static void setInputType(View view, int i) {
        checkIfLegalArg(view);
        ((SearchView) view).setInputType(i);
    }

    @Deprecated
    public static void setMaxWidth(View view, int i) {
        checkIfLegalArg(view);
        ((SearchView) view).setMaxWidth(i);
    }

    @Deprecated
    public static void setOnCloseListener(View view, OnCloseListener onCloseListener) {
        checkIfLegalArg(view);
        ((SearchView) view).setOnCloseListener(newOnCloseListener(onCloseListener));
    }

    @Deprecated
    public static void setOnQueryTextListener(View view, OnQueryTextListener onQueryTextListener) {
        checkIfLegalArg(view);
        ((SearchView) view).setOnQueryTextListener(newOnQueryTextListener(onQueryTextListener));
    }

    @Deprecated
    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        checkIfLegalArg(view);
        ((SearchView) view).setQuery(charSequence, z);
    }

    @Deprecated
    public static void setQueryHint(View view, CharSequence charSequence) {
        checkIfLegalArg(view);
        ((SearchView) view).setQueryHint(charSequence);
    }

    @Deprecated
    public static void setQueryRefinementEnabled(View view, boolean z) {
        checkIfLegalArg(view);
        ((SearchView) view).setQueryRefinementEnabled(z);
    }

    @Deprecated
    public static void setSearchableInfo(View view, ComponentName componentName) {
        checkIfLegalArg(view);
        ((SearchView) view).setSearchableInfo(((SearchManager) view.getContext().getSystemService(FirebaseAnalytics.Event.SEARCH)).getSearchableInfo(componentName));
    }

    @Deprecated
    public static void setSubmitButtonEnabled(View view, boolean z) {
        checkIfLegalArg(view);
        ((SearchView) view).setSubmitButtonEnabled(z);
    }
}
