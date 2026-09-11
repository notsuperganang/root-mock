package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    private final PrintHelperVersionImpl mImpl;

    @Retention(RetentionPolicy.SOURCE)
    private @interface ColorMode {
    }

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface Orientation {
    }

    @RequiresApi(19)
    private static class PrintHelperApi19 implements PrintHelperVersionImpl {
        private static final String LOG_TAG = "PrintHelperApi19";
        private static final int MAX_PRINT_SIZE = 3500;
        final Context mContext;
        int mOrientation;
        BitmapFactory.Options mDecodeOptions = null;
        private final Object mLock = new Object();
        int mScaleMode = 2;
        int mColorMode = 2;
        protected boolean mPrintActivityRespectsOrientation = true;
        protected boolean mIsMinMarginsHandlingCorrect = true;

        /* JADX INFO: renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3, reason: invalid class name */
        class AnonymousClass3 extends PrintDocumentAdapter {
            private PrintAttributes mAttributes;
            Bitmap mBitmap = null;
            AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
            final PrintHelperApi19 this$0;
            final OnPrintFinishCallback val$callback;
            final int val$fittingMode;
            final Uri val$imageFile;
            final String val$jobName;

            /* JADX INFO: renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3$1, reason: invalid class name */
            class AnonymousClass1 extends AsyncTask<Uri, Boolean, Bitmap> {
                final AnonymousClass3 this$1;
                final CancellationSignal val$cancellationSignal;
                final PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
                final PrintAttributes val$newPrintAttributes;
                final PrintAttributes val$oldPrintAttributes;

                AnonymousClass1(AnonymousClass3 anonymousClass3, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                    this.this$1 = anonymousClass3;
                    this.val$cancellationSignal = cancellationSignal;
                    this.val$newPrintAttributes = printAttributes;
                    this.val$oldPrintAttributes = printAttributes2;
                    this.val$layoutResultCallback = layoutResultCallback;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Bitmap doInBackground(Uri... uriArr) {
                    try {
                        return this.this$1.this$0.loadConstrainedBitmap(this.this$1.val$imageFile);
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onCancelled(Bitmap bitmap) {
                    this.val$layoutResultCallback.onLayoutCancelled();
                    this.this$1.mLoadBitmap = null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Bitmap bitmap) {
                    PrintAttributes.MediaSize mediaSize;
                    super.onPostExecute(bitmap);
                    if (bitmap != null && (!this.this$1.this$0.mPrintActivityRespectsOrientation || this.this$1.this$0.mOrientation == 0)) {
                        synchronized (this) {
                            mediaSize = this.this$1.mAttributes.getMediaSize();
                        }
                        if (mediaSize != null && mediaSize.isPortrait() != PrintHelperApi19.isPortrait(bitmap)) {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(90.0f);
                            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        }
                    }
                    this.this$1.mBitmap = bitmap;
                    if (bitmap != null) {
                        this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.this$1.val$jobName).setContentType(1).setPageCount(1).build(), this.val$newPrintAttributes.equals(this.val$oldPrintAttributes) ? false : true);
                    } else {
                        this.val$layoutResultCallback.onLayoutFailed(null);
                    }
                    this.this$1.mLoadBitmap = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    this.val$cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(this) { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1.1
                        final AnonymousClass1 this$2;

                        {
                            this.this$2 = this;
                        }

                        @Override // android.os.CancellationSignal.OnCancelListener
                        public void onCancel() {
                            this.this$2.this$1.cancelLoad();
                            this.this$2.cancel(false);
                        }
                    });
                }
            }

            AnonymousClass3(PrintHelperApi19 printHelperApi19, String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
                this.this$0 = printHelperApi19;
                this.val$jobName = str;
                this.val$imageFile = uri;
                this.val$callback = onPrintFinishCallback;
                this.val$fittingMode = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void cancelLoad() {
                synchronized (this.this$0.mLock) {
                    if (this.this$0.mDecodeOptions != null) {
                        this.this$0.mDecodeOptions.requestCancelDecode();
                        this.this$0.mDecodeOptions = null;
                    }
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onFinish() {
                super.onFinish();
                cancelLoad();
                if (this.mLoadBitmap != null) {
                    this.mLoadBitmap.cancel(true);
                }
                if (this.val$callback != null) {
                    this.val$callback.onFinish();
                }
                if (this.mBitmap != null) {
                    this.mBitmap.recycle();
                    this.mBitmap = null;
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                synchronized (this) {
                    this.mAttributes = printAttributes2;
                }
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.mBitmap != null) {
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ? false : true);
                } else {
                    this.mLoadBitmap = new AnonymousClass1(this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                this.this$0.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }
        }

        PrintHelperApi19(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
            if (i != 1) {
                return bitmap;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
            Matrix matrix = new Matrix();
            float fWidth = rectF.width() / i;
            float fMax = i3 == 2 ? Math.max(fWidth, rectF.height() / i2) : Math.min(fWidth, rectF.height() / i2);
            matrix.postScale(fMax, fMax);
            matrix.postTranslate((rectF.width() - (i * fMax)) / 2.0f, (rectF.height() - (fMax * i2)) / 2.0f);
            return matrix;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isPortrait(Bitmap bitmap) {
            return bitmap.getWidth() <= bitmap.getHeight();
        }

        private Bitmap loadBitmap(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
            InputStream inputStreamOpenInputStream = null;
            if (uri == null || this.mContext == null) {
                throw new IllegalArgumentException("bad argument to loadBitmap");
            }
            try {
                inputStreamOpenInputStream = this.mContext.getContentResolver().openInputStream(uri);
                return BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        Log.w(LOG_TAG, "close fail ", e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
            BitmapFactory.Options options;
            Bitmap bitmapLoadBitmap = null;
            int i = 1;
            if (uri == null || this.mContext == null) {
                throw new IllegalArgumentException("bad argument to getScaledBitmap");
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            loadBitmap(uri, options2);
            int i2 = options2.outWidth;
            int i3 = options2.outHeight;
            if (i2 > 0 && i3 > 0) {
                int iMax = Math.max(i2, i3);
                while (iMax > MAX_PRINT_SIZE) {
                    iMax >>>= 1;
                    i <<= 1;
                }
                if (i > 0 && Math.min(i2, i3) / i > 0) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = new BitmapFactory.Options();
                        this.mDecodeOptions.inMutable = true;
                        this.mDecodeOptions.inSampleSize = i;
                        options = this.mDecodeOptions;
                    }
                    try {
                        bitmapLoadBitmap = loadBitmap(uri, options);
                        synchronized (this.mLock) {
                            this.mDecodeOptions = null;
                        }
                    } catch (Throwable th) {
                        synchronized (this.mLock) {
                            this.mDecodeOptions = null;
                            throw th;
                        }
                    }
                }
            }
            return bitmapLoadBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.support.v4.print.PrintHelper$PrintHelperApi19$2] */
        public void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            new AsyncTask<Void, Void, Throwable>(this, cancellationSignal, this.mIsMinMarginsHandlingCorrect ? printAttributes : copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback) { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.2
                final PrintHelperApi19 this$0;
                final PrintAttributes val$attributes;
                final Bitmap val$bitmap;
                final CancellationSignal val$cancellationSignal;
                final ParcelFileDescriptor val$fileDescriptor;
                final int val$fittingMode;
                final PrintAttributes val$pdfAttributes;
                final PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

                {
                    this.this$0 = this;
                    this.val$cancellationSignal = cancellationSignal;
                    this.val$pdfAttributes = printAttributes;
                    this.val$bitmap = bitmap;
                    this.val$attributes = printAttributes;
                    this.val$fittingMode = i;
                    this.val$fileDescriptor = parcelFileDescriptor;
                    this.val$writeResultCallback = writeResultCallback;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Throwable doInBackground(Void... voidArr) {
                    RectF rectF;
                    try {
                        if (this.val$cancellationSignal.isCanceled()) {
                            return null;
                        }
                        PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.this$0.mContext, this.val$pdfAttributes);
                        Bitmap bitmapConvertBitmapForColorMode = this.this$0.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                        if (this.val$cancellationSignal.isCanceled()) {
                            return null;
                        }
                        try {
                            PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                            if (this.this$0.mIsMinMarginsHandlingCorrect) {
                                rectF = new RectF(pageStartPage.getInfo().getContentRect());
                            } else {
                                PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(this.this$0.mContext, this.val$attributes);
                                PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                                rectF = new RectF(pageStartPage2.getInfo().getContentRect());
                                printedPdfDocument2.finishPage(pageStartPage2);
                                printedPdfDocument2.close();
                            }
                            Matrix matrix = this.this$0.getMatrix(bitmapConvertBitmapForColorMode.getWidth(), bitmapConvertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                            if (!this.this$0.mIsMinMarginsHandlingCorrect) {
                                matrix.postTranslate(rectF.left, rectF.top);
                                pageStartPage.getCanvas().clipRect(rectF);
                            }
                            pageStartPage.getCanvas().drawBitmap(bitmapConvertBitmapForColorMode, matrix, null);
                            printedPdfDocument.finishPage(pageStartPage);
                            if (this.val$cancellationSignal.isCanceled()) {
                            }
                            printedPdfDocument.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                        } finally {
                            printedPdfDocument.close();
                            if (this.val$fileDescriptor != null) {
                                try {
                                    this.val$fileDescriptor.close();
                                } catch (IOException e) {
                                }
                            }
                            if (bitmapConvertBitmapForColorMode != this.val$bitmap) {
                                bitmapConvertBitmapForColorMode.recycle();
                            }
                        }
                    } catch (Throwable th) {
                        return th;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Throwable th) {
                    if (this.val$cancellationSignal.isCanceled()) {
                        this.val$writeResultCallback.onWriteCancelled();
                    } else if (th == null) {
                        this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } else {
                        Log.e(PrintHelperApi19.LOG_TAG, "Error writing printed content", th);
                        this.val$writeResultCallback.onWriteFailed(null);
                    }
                }
            }.execute(new Void[0]);
        }

        protected PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            return minMargins;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mColorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            if (this.mOrientation == 0) {
                return 1;
            }
            return this.mOrientation;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            if (bitmap == null) {
                return;
            }
            int i = this.mScaleMode;
            ((PrintManager) this.mContext.getSystemService("print")).print(str, new PrintDocumentAdapter(this, str, i, bitmap, onPrintFinishCallback) { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.1
                private PrintAttributes mAttributes;
                final PrintHelperApi19 this$0;
                final Bitmap val$bitmap;
                final OnPrintFinishCallback val$callback;
                final int val$fittingMode;
                final String val$jobName;

                {
                    this.this$0 = this;
                    this.val$jobName = str;
                    this.val$fittingMode = i;
                    this.val$bitmap = bitmap;
                    this.val$callback = onPrintFinishCallback;
                }

                @Override // android.print.PrintDocumentAdapter
                public void onFinish() {
                    if (this.val$callback != null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // android.print.PrintDocumentAdapter
                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    this.mAttributes = printAttributes2;
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ? false : true);
                }

                @Override // android.print.PrintDocumentAdapter
                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    this.this$0.writeBitmap(this.mAttributes, this.val$fittingMode, this.val$bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                }
            }, new PrintAttributes.Builder().setMediaSize(isPortrait(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.mColorMode).build());
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this, str, uri, onPrintFinishCallback, this.mScaleMode);
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setColorMode(this.mColorMode);
            if (this.mOrientation == 1 || this.mOrientation == 0) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
            } else if (this.mOrientation == 2) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
            printManager.print(str, anonymousClass3, builder.build());
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }
    }

    @RequiresApi(20)
    private static class PrintHelperApi20 extends PrintHelperApi19 {
        PrintHelperApi20(Context context) {
            super(context);
            this.mPrintActivityRespectsOrientation = false;
        }
    }

    @RequiresApi(23)
    private static class PrintHelperApi23 extends PrintHelperApi20 {
        PrintHelperApi23(Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = false;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperApi19
        protected PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
            PrintAttributes.Builder builderCopyAttributes = super.copyAttributes(printAttributes);
            if (printAttributes.getDuplexMode() != 0) {
                builderCopyAttributes.setDuplexMode(printAttributes.getDuplexMode());
            }
            return builderCopyAttributes;
        }
    }

    @RequiresApi(24)
    private static class PrintHelperApi24 extends PrintHelperApi23 {
        PrintHelperApi24(Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = true;
            this.mPrintActivityRespectsOrientation = true;
        }
    }

    private static final class PrintHelperStub implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStub() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mColorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            return this.mOrientation;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ScaleMode {
    }

    public PrintHelper(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mImpl = new PrintHelperApi24(context);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new PrintHelperApi23(context);
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.mImpl = new PrintHelperApi20(context);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.mImpl = new PrintHelperApi19(context);
        } else {
            this.mImpl = new PrintHelperStub();
        }
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, onPrintFinishCallback);
    }

    public void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }
}
