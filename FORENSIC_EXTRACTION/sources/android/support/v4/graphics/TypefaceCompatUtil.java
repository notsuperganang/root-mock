package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        ByteBuffer byteBufferMmap = null;
        File tempFile = getTempFile(context);
        if (tempFile != null) {
            try {
                if (copyToFile(tempFile, resources, i)) {
                    byteBufferMmap = mmap(tempFile);
                }
            } finally {
                tempFile.delete();
            }
        }
        return byteBufferMmap;
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            return copyToFile(file, inputStreamOpenRawResource);
        } finally {
            closeQuietly(inputStreamOpenRawResource);
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) throws Throwable {
        IOException iOException;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        closeQuietly(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
            } catch (IOException e) {
                iOException = e;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e(TAG, "Error copying resource contents to temp file: " + iOException.getMessage());
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            iOException = e2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static File getTempFile(Context context) {
        String str = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return null;
            }
            File file = new File(context.getCacheDir(), str + i2);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i = i2 + 1;
            } catch (IOException e) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0048 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0053 A[Catch: Throwable -> 0x002f, all -> 0x003e, TRY_LEAVE, TryCatch #3 {Throwable -> 0x002f, blocks: (B:4:0x000b, B:7:0x0026, B:33:0x0053, B:32:0x004f, B:30:0x004d), top: B:45:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x005c A[Catch: IOException -> 0x003b, TRY_LEAVE, TryCatch #8 {IOException -> 0x003b, blocks: (B:3:0x0005, B:9:0x002b, B:17:0x0037, B:37:0x005c, B:36:0x0058, B:18:0x003a), top: B:50:0x0005, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @RequiresApi(19)
    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (parcelFileDescriptorOpenFileDescriptor == null) {
                            return map;
                        }
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return map;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            th = th5;
                            th3 = th4;
                            if (fileInputStream != null) {
                                if (th3 != null) {
                                    fileInputStream.close();
                                } else {
                                    fileInputStream.close();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th6;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            if (th2 != null) {
                                try {
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                } catch (Throwable th8) {
                                    th2.addSuppressed(th8);
                                }
                            } else {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                th2 = null;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    if (th2 != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } else {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0030 A[Catch: IOException -> 0x001c, TRY_LEAVE, TryCatch #4 {IOException -> 0x001c, blocks: (B:3:0x0001, B:6:0x0018, B:16:0x0027, B:20:0x0030, B:19:0x002c, B:17:0x002a), top: B:28:0x0001, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @RequiresApi(19)
    private static ByteBuffer mmap(File file) throws Throwable {
        Throwable th;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                if (fileInputStream == null) {
                    return map;
                }
                fileInputStream.close();
                return map;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    th = th3;
                    th = th2;
                    if (fileInputStream != null) {
                        if (th != null) {
                            fileInputStream.close();
                        } else {
                            fileInputStream.close();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e) {
            return null;
        }
    }
}
