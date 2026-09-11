package android.support.v4.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.provider.FontsContractCompat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x005f A[Catch: Throwable -> 0x003d, all -> 0x004b, TryCatch #3 {Throwable -> 0x003d, blocks: (B:7:0x0018, B:9:0x001e, B:40:0x0063, B:11:0x0024, B:14:0x0033, B:39:0x005f, B:38:0x005b, B:36:0x0059), top: B:55:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0073 A[Catch: IOException -> 0x0049, TRY_LEAVE, TryCatch #0 {IOException -> 0x0049, blocks: (B:6:0x000e, B:42:0x0069, B:16:0x0038, B:24:0x0045, B:46:0x0073, B:45:0x006f, B:25:0x0048), top: B:50:0x000e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(fontInfoArr, i).getUri(), "r", cancellationSignal);
            try {
                try {
                    File file = getFile(parcelFileDescriptorOpenFileDescriptor);
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceCreateFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        Typeface typefaceCreateFromInputStream = super.createFromInputStream(context, fileInputStream);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceCreateFromInputStream;
                    } catch (Throwable th4) {
                        th = th4;
                        th3 = null;
                        if (fileInputStream != null) {
                            if (th3 != null) {
                                fileInputStream.close();
                            } else {
                                fileInputStream.close();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        th2 = th6;
                        th = th5;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            if (th != null) {
                                try {
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                } catch (Throwable th7) {
                                    th.addSuppressed(th7);
                                }
                            } else {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th8) {
                th = null;
                th2 = th8;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    if (th != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } else {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                }
                throw th2;
            }
        } catch (IOException e) {
            return null;
        }
    }
}
