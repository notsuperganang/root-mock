package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.tiket.git.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaqf = {'u', 'l', 'l'};
    private static final char[] zaqg = {'r', 'u', 'e'};
    private static final char[] zaqh = {'r', 'u', 'e', '\"'};
    private static final char[] zaqi = {'a', 'l', 's', 'e'};
    private static final char[] zaqj = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaqk = {'\n'};
    private static final zaa<Integer> zaqm = new com.google.android.gms.common.server.response.zaa();
    private static final zaa<Long> zaqn = new zab();
    private static final zaa<Float> zaqo = new zac();
    private static final zaa<Double> zaqp = new zad();
    private static final zaa<Boolean> zaqq = new zae();
    private static final zaa<String> zaqr = new zaf();
    private static final zaa<BigInteger> zaqs = new zag();
    private static final zaa<BigDecimal> zaqt = new zah();
    private final char[] zaqa = new char[1];
    private final char[] zaqb = new char[32];
    private final char[] zaqc = new char[1024];
    private final StringBuilder zaqd = new StringBuilder(32);
    private final StringBuilder zaqe = new StringBuilder(1024);
    private final Stack<Integer> zaql = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface zaa<O> {
        O zah(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    private final int zaa(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char cZaj = zaj(bufferedReader);
        if (cZaj == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (cZaj == ',') {
            throw new ParseException("Missing value");
        }
        if (cZaj == 'n') {
            zab(bufferedReader, zaqf);
            return 0;
        }
        bufferedReader.mark(1024);
        if (cZaj == '\"') {
            boolean z = false;
            i = 0;
            while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                char c = cArr[i];
                if (Character.isISOControl(c)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c == '\"' && !z) {
                    bufferedReader.reset();
                    bufferedReader.skip(i + 1);
                    return i;
                }
                if (c == '\\') {
                    z = !z;
                } else {
                    z = false;
                }
                i++;
            }
        } else {
            cArr[0] = cZaj;
            i = 1;
            while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i - 1);
                    cArr[i] = (char) 0;
                    return i;
                }
                i++;
            }
        }
        if (i == cArr.length) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final String zaa(BufferedReader bufferedReader) throws ParseException, IOException {
        String strZab = null;
        this.zaql.push(2);
        char cZaj = zaj(bufferedReader);
        switch (cZaj) {
            case '\"':
                this.zaql.push(3);
                strZab = zab(bufferedReader, this.zaqb, this.zaqd, null);
                zak(3);
                if (zaj(bufferedReader) != ':') {
                    throw new ParseException("Expected key/value separator");
                }
                return strZab;
            case ']':
                zak(2);
                zak(1);
                zak(5);
                return strZab;
            case '}':
                zak(2);
                return strZab;
            default:
                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(cZaj).toString());
        }
    }

    private final String zaa(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        switch (zaj(bufferedReader)) {
            case '\"':
                return zab(bufferedReader, cArr, sb, cArr2);
            case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 110 */:
                zab(bufferedReader, zaqf);
                return null;
            default:
                throw new ParseException("Expected string");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Switch 'out' block B:29:0x0036 for B:13:0x0047 already processed. Defaulting to fallback option. */
    private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char cZaj = zaj(bufferedReader);
        switch (cZaj) {
            case ']':
                zak(5);
                return arrayList;
            case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 110 */:
                zab(bufferedReader, zaqf);
                zak(5);
                return null;
            case '{':
                this.zaql.push(1);
                while (true) {
                    try {
                        FastJsonResponse fastJsonResponseZacp = field.zacp();
                        if (!zaa(bufferedReader, fastJsonResponseZacp)) {
                            return arrayList;
                        }
                        arrayList.add(fastJsonResponseZacp);
                        char cZaj2 = zaj(bufferedReader);
                        switch (cZaj2) {
                            case ',':
                                if (zaj(bufferedReader) != '{') {
                                    throw new ParseException("Expected start of next object in array");
                                }
                                this.zaql.push(1);
                                break;
                            case ']':
                                zak(5);
                                return arrayList;
                            default:
                                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(cZaj2).toString());
                        }
                    } catch (IllegalAccessException e) {
                        throw new ParseException("Error instantiating inner object", e);
                    } catch (InstantiationException e2) {
                        throw new ParseException("Error instantiating inner object", e2);
                    }
                }
                break;
            default:
                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(cZaj).toString());
        }
    }

    private final <O> ArrayList<O> zaa(BufferedReader bufferedReader, zaa<O> zaaVar) throws ParseException, IOException {
        char cZaj = zaj(bufferedReader);
        if (cZaj != 'n') {
            if (cZaj == '[') {
                this.zaql.push(5);
                ArrayList<O> arrayList = new ArrayList<>();
                while (true) {
                    bufferedReader.mark(1024);
                    switch (zaj(bufferedReader)) {
                        case 0:
                            throw new ParseException("Unexpected EOF");
                        case ',':
                            break;
                        case ']':
                            zak(5);
                            return arrayList;
                        default:
                            bufferedReader.reset();
                            arrayList.add(zaaVar.zah(this, bufferedReader));
                            break;
                    }
                }
            } else {
                throw new ParseException("Expected start of array");
            }
        } else {
            zab(bufferedReader, zaqf);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zaa(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap map;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String strZaa = zaa(bufferedReader);
        if (strZaa == null) {
            zak(1);
            return false;
        }
        while (strZaa != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(strZaa);
            if (field == null) {
                strZaa = zab(bufferedReader);
            } else {
                this.zaql.push(4);
                switch (field.zapq) {
                    case 0:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zad(bufferedReader));
                        } else {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, (ArrayList<Integer>) zaa(bufferedReader, zaqm));
                        }
                        break;
                    case 1:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zaf(bufferedReader));
                        } else {
                            fastJsonResponse.zab((FastJsonResponse.Field) field, (ArrayList<BigInteger>) zaa(bufferedReader, zaqs));
                        }
                        break;
                    case 2:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zae(bufferedReader));
                        } else {
                            fastJsonResponse.zac(field, zaa(bufferedReader, zaqn));
                        }
                        break;
                    case 3:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zag(bufferedReader));
                        } else {
                            fastJsonResponse.zad(field, zaa(bufferedReader, zaqo));
                        }
                        break;
                    case 4:
                        if (!field.zapr) {
                            fastJsonResponse.zaa(field, zah(bufferedReader));
                        } else {
                            fastJsonResponse.zae(field, zaa(bufferedReader, zaqp));
                        }
                        break;
                    case 5:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zai(bufferedReader));
                        } else {
                            fastJsonResponse.zaf(field, zaa(bufferedReader, zaqt));
                        }
                        break;
                    case 6:
                        if (!field.zapr) {
                            fastJsonResponse.zaa(field, zaa(bufferedReader, false));
                        } else {
                            fastJsonResponse.zag(field, zaa(bufferedReader, zaqq));
                        }
                        break;
                    case 7:
                        if (!field.zapr) {
                            fastJsonResponse.zaa((FastJsonResponse.Field) field, zac(bufferedReader));
                        } else {
                            fastJsonResponse.zah(field, zaa(bufferedReader, zaqr));
                        }
                        break;
                    case 8:
                        fastJsonResponse.zaa((FastJsonResponse.Field) field, Base64Utils.decode(zaa(bufferedReader, this.zaqc, this.zaqe, zaqk)));
                        break;
                    case 9:
                        fastJsonResponse.zaa((FastJsonResponse.Field) field, Base64Utils.decodeUrlSafe(zaa(bufferedReader, this.zaqc, this.zaqe, zaqk)));
                        break;
                    case 10:
                        char cZaj = zaj(bufferedReader);
                        if (cZaj == 'n') {
                            zab(bufferedReader, zaqf);
                            map = null;
                        } else {
                            if (cZaj != '{') {
                                throw new ParseException("Expected start of a map object");
                            }
                            this.zaql.push(1);
                            map = new HashMap();
                            while (true) {
                                switch (zaj(bufferedReader)) {
                                    case 0:
                                        throw new ParseException("Unexpected EOF");
                                    case '\"':
                                        String strZab = zab(bufferedReader, this.zaqb, this.zaqd, null);
                                        if (zaj(bufferedReader) != ':') {
                                            String strValueOf = String.valueOf(strZab);
                                            throw new ParseException(strValueOf.length() != 0 ? "No map value found for key ".concat(strValueOf) : new String("No map value found for key "));
                                        }
                                        if (zaj(bufferedReader) != '\"') {
                                            String strValueOf2 = String.valueOf(strZab);
                                            throw new ParseException(strValueOf2.length() != 0 ? "Expected String value for key ".concat(strValueOf2) : new String("Expected String value for key "));
                                        }
                                        map.put(strZab, zab(bufferedReader, this.zaqb, this.zaqd, null));
                                        char cZaj2 = zaj(bufferedReader);
                                        if (cZaj2 != ',') {
                                            if (cZaj2 != '}') {
                                                throw new ParseException(new StringBuilder(48).append("Unexpected character while parsing string map: ").append(cZaj2).toString());
                                            }
                                            zak(1);
                                        }
                                        break;
                                    case '}':
                                        zak(1);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        fastJsonResponse.zaa((FastJsonResponse.Field) field, (Map<String, String>) map);
                        break;
                    case 11:
                        if (field.zapr) {
                            char cZaj3 = zaj(bufferedReader);
                            if (cZaj3 != 'n') {
                                this.zaql.push(5);
                                if (cZaj3 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zapu, zaa(bufferedReader, field));
                            } else {
                                zab(bufferedReader, zaqf);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zapu, null);
                            }
                        } else {
                            char cZaj4 = zaj(bufferedReader);
                            if (cZaj4 == 'n') {
                                zab(bufferedReader, zaqf);
                                fastJsonResponse.addConcreteTypeInternal(field, field.zapu, null);
                            } else {
                                this.zaql.push(1);
                                if (cZaj4 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse fastJsonResponseZacp = field.zacp();
                                    zaa(bufferedReader, fastJsonResponseZacp);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zapu, fastJsonResponseZacp);
                                } catch (IllegalAccessException e) {
                                    throw new ParseException("Error instantiating inner object", e);
                                } catch (InstantiationException e2) {
                                    throw new ParseException("Error instantiating inner object", e2);
                                }
                            }
                        }
                        break;
                    default:
                        throw new ParseException(new StringBuilder(30).append("Invalid field type ").append(field.zapq).toString());
                }
                zak(4);
                zak(2);
                char cZaj5 = zaj(bufferedReader);
                switch (cZaj5) {
                    case ',':
                        strZaa = zaa(bufferedReader);
                        break;
                    case '}':
                        strZaa = null;
                        break;
                    default:
                        throw new ParseException(new StringBuilder(55).append("Expected end of object or field separator, but found: ").append(cZaj5).toString());
                }
            }
        }
        zak(1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Switch 'out' block B:3:0x0002 for B:4:0x0006 already processed. Defaulting to fallback option. */
    public final boolean zaa(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char cZaj = zaj(bufferedReader);
            switch (cZaj) {
                case '\"':
                    if (z) {
                        throw new ParseException("No boolean value found in string");
                    }
                    z = true;
                    break;
                case 'f':
                    zab(bufferedReader, z ? zaqj : zaqi);
                    return false;
                case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 110 */:
                    zab(bufferedReader, zaqf);
                    return false;
                case R.styleable.AppCompatTheme_tooltipFrameBackground /* 116 */:
                    zab(bufferedReader, z ? zaqh : zaqg);
                    return true;
                default:
                    throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(cZaj).toString());
            }
        }
    }

    private final String zab(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        switch (zaj(bufferedReader)) {
            case '\"':
                if (bufferedReader.read(this.zaqa) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                char c = this.zaqa[0];
                boolean z = false;
                while (true) {
                    if (c != '\"' || z) {
                        z = c == '\\' && !z;
                        if (bufferedReader.read(this.zaqa) == -1) {
                            throw new ParseException("Unexpected EOF while parsing string");
                        }
                        c = this.zaqa[0];
                        if (Character.isISOControl(c)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                }
                break;
            case ',':
                throw new ParseException("Missing value");
            case '[':
                this.zaql.push(5);
                bufferedReader.mark(32);
                if (zaj(bufferedReader) != ']') {
                    bufferedReader.reset();
                    boolean z2 = false;
                    boolean z3 = false;
                    int i = 1;
                    while (i > 0) {
                        char cZaj = zaj(bufferedReader);
                        if (cZaj == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(cZaj)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (cZaj == '\"' && !z3) {
                            z2 = !z2;
                        }
                        int i2 = (cZaj != '[' || z2) ? i : i + 1;
                        i = (cZaj != ']' || z2) ? i2 : i2 - 1;
                        z3 = (cZaj == '\\' && z2) ? !z3 : false;
                    }
                    zak(5);
                } else {
                    zak(5);
                }
                break;
            case '{':
                this.zaql.push(1);
                bufferedReader.mark(32);
                char cZaj2 = zaj(bufferedReader);
                if (cZaj2 == '}') {
                    zak(1);
                } else {
                    if (cZaj2 != '\"') {
                        throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(cZaj2).toString());
                    }
                    bufferedReader.reset();
                    zaa(bufferedReader);
                    while (zab(bufferedReader) != null) {
                    }
                    zak(1);
                }
                break;
            default:
                bufferedReader.reset();
                zaa(bufferedReader, this.zaqc);
                break;
        }
        char cZaj3 = zaj(bufferedReader);
        switch (cZaj3) {
            case ',':
                zak(2);
                return zaa(bufferedReader);
            case '}':
                zak(2);
                return null;
            default:
                throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(cZaj3).toString());
        }
    }

    private static String zab(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        boolean z;
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            for (int i2 = 0; i2 < i; i2++) {
                char c = cArr[i2];
                if (Character.isISOControl(c)) {
                    if (cArr2 == null) {
                        z = false;
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= cArr2.length) {
                            z = false;
                            break;
                        }
                        if (cArr2[i3] == c) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z) {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
                if (c == '\"' && !z2) {
                    sb.append(cArr, 0, i2);
                    bufferedReader.reset();
                    bufferedReader.skip(i2 + 1);
                    return z3 ? JsonUtils.unescapeString(sb.toString()) : sb.toString();
                }
                if (c == '\\') {
                    z2 = !z2;
                    z3 = true;
                } else {
                    z2 = false;
                }
            }
            sb.append(cArr, 0, i);
            bufferedReader.mark(cArr.length);
        }
    }

    private final void zab(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int i2 = bufferedReader.read(this.zaqb, 0, cArr.length - i);
            if (i2 == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (cArr[i3 + i] != this.zaqb[i3]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zac(BufferedReader bufferedReader) throws ParseException, IOException {
        return zaa(bufferedReader, this.zaqb, this.zaqd, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zad(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return 0;
        }
        char[] cArr = this.zaqc;
        if (iZaa <= 0) {
            throw new ParseException("No number to parse");
        }
        if (cArr[0] == '-') {
            z = true;
            i = Integer.MIN_VALUE;
            i2 = 1;
        } else {
            z = false;
            i = -2147483647;
            i2 = 0;
        }
        if (i2 < iZaa) {
            i3 = i2 + 1;
            int iDigit = Character.digit(cArr[i2], 10);
            if (iDigit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i4 = -iDigit;
        } else {
            i3 = i2;
        }
        while (i3 < iZaa) {
            int iDigit2 = Character.digit(cArr[i3], 10);
            if (iDigit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i4 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i5 = i4 * 10;
            if (i5 < i + iDigit2) {
                throw new ParseException("Number too large");
            }
            i4 = i5 - iDigit2;
            i3++;
        }
        if (!z) {
            return -i4;
        }
        if (i3 <= 1) {
            throw new ParseException("No digits to parse");
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zae(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        boolean z;
        int i;
        int i2;
        long j2 = 0;
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return 0L;
        }
        char[] cArr = this.zaqc;
        if (iZaa <= 0) {
            throw new ParseException("No number to parse");
        }
        if (cArr[0] == '-') {
            j = Long.MIN_VALUE;
            z = true;
            i = 1;
        } else {
            j = -9223372036854775807L;
            z = false;
            i = 0;
        }
        if (i < iZaa) {
            i2 = i + 1;
            int iDigit = Character.digit(cArr[i], 10);
            if (iDigit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j2 = -iDigit;
        } else {
            i2 = i;
        }
        while (i2 < iZaa) {
            int iDigit2 = Character.digit(cArr[i2], 10);
            if (iDigit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j2 < -922337203685477580L) {
                throw new ParseException("Number too large");
            }
            long j3 = j2 * 10;
            if (j3 < ((long) iDigit2) + j) {
                throw new ParseException("Number too large");
            }
            j2 = j3 - ((long) iDigit2);
            i2++;
        }
        if (!z) {
            return -j2;
        }
        if (i2 <= 1) {
            throw new ParseException("No digits to parse");
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zaf(BufferedReader bufferedReader) throws ParseException, IOException {
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaqc, 0, iZaa));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zag(BufferedReader bufferedReader) throws ParseException, IOException {
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaqc, 0, iZaa));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zah(BufferedReader bufferedReader) throws ParseException, IOException {
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaqc, 0, iZaa));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zai(BufferedReader bufferedReader) throws ParseException, IOException {
        int iZaa = zaa(bufferedReader, this.zaqc);
        if (iZaa == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaqc, 0, iZaa));
    }

    private final char zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zaqa) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.zaqa[0])) {
            if (bufferedReader.read(this.zaqa) == -1) {
                return (char) 0;
            }
        }
        return this.zaqa[0];
    }

    private final void zak(int i) throws ParseException {
        if (this.zaql.isEmpty()) {
            throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had empty stack").toString());
        }
        int iIntValue = this.zaql.pop().intValue();
        if (iIntValue != i) {
            throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had ").append(iIntValue).toString());
        }
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zaql.push(0);
                char cZaj = zaj(bufferedReader);
                switch (cZaj) {
                    case 0:
                        throw new ParseException("No data to parse");
                    case '[':
                        this.zaql.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                        if (fieldMappings.size() != 1) {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                        FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(value, value.zapu, zaa(bufferedReader, value));
                        break;
                    case '{':
                        this.zaql.push(1);
                        zaa(bufferedReader, t);
                        break;
                    default:
                        throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(cZaj).toString());
                }
                zak(0);
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e2) {
                throw new ParseException(e2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
