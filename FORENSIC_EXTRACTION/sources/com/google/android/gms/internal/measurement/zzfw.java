package com.google.android.gms.internal.measurement;

import com.tiket.git.R;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfw extends zzyc<zzfw> {
    private static volatile zzfw[] zzaxi;
    public Integer zzaxj = null;
    public zzft[] zzaxk = zzft.zzmz();
    public zzfz[] zzaxl = zzfz.zznd();
    public Long zzaxm = null;
    public Long zzaxn = null;
    public Long zzaxo = null;
    public Long zzaxp = null;
    public Long zzaxq = null;
    public String zzaxr = null;
    public String zzaxs = null;
    public String zzaxt = null;
    public String zzahr = null;
    public Integer zzaxu = null;
    public String zzafp = null;
    public String zztt = null;
    public String zzts = null;
    public Long zzaxv = null;
    public Long zzaxw = null;
    public String zzaxx = null;
    public Boolean zzaxy = null;
    public String zzafh = null;
    public Long zzaxz = null;
    public Integer zzaya = null;
    public String zzagm = null;
    public String zzafi = null;
    public Boolean zzayb = null;
    public zzfr[] zzayc = zzfr.zzmx();
    public String zzafk = null;
    public Integer zzayd = null;
    private Integer zzaye = null;
    private Integer zzayf = null;
    public String zzayg = null;
    public Long zzayh = null;
    public Long zzayi = null;
    public String zzayj = null;
    private String zzayk = null;
    public Integer zzayl = null;
    public String zzawr = null;
    public zzfe.zzb zzaym = null;
    public int[] zzayn = zzyl.zzcaq;
    private Long zzayo = null;

    public zzfw() {
        this.zzcev = null;
        this.zzcff = -1;
    }

    public static zzfw[] zznb() {
        if (zzaxi == null) {
            synchronized (zzyg.zzcfe) {
                if (zzaxi == null) {
                    zzaxi = new zzfw[0];
                }
            }
        }
        return zzaxi;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfwVar = (zzfw) obj;
        if (this.zzaxj == null) {
            if (zzfwVar.zzaxj != null) {
                return false;
            }
        } else if (!this.zzaxj.equals(zzfwVar.zzaxj)) {
            return false;
        }
        if (zzyg.equals(this.zzaxk, zzfwVar.zzaxk) && zzyg.equals(this.zzaxl, zzfwVar.zzaxl)) {
            if (this.zzaxm == null) {
                if (zzfwVar.zzaxm != null) {
                    return false;
                }
            } else if (!this.zzaxm.equals(zzfwVar.zzaxm)) {
                return false;
            }
            if (this.zzaxn == null) {
                if (zzfwVar.zzaxn != null) {
                    return false;
                }
            } else if (!this.zzaxn.equals(zzfwVar.zzaxn)) {
                return false;
            }
            if (this.zzaxo == null) {
                if (zzfwVar.zzaxo != null) {
                    return false;
                }
            } else if (!this.zzaxo.equals(zzfwVar.zzaxo)) {
                return false;
            }
            if (this.zzaxp == null) {
                if (zzfwVar.zzaxp != null) {
                    return false;
                }
            } else if (!this.zzaxp.equals(zzfwVar.zzaxp)) {
                return false;
            }
            if (this.zzaxq == null) {
                if (zzfwVar.zzaxq != null) {
                    return false;
                }
            } else if (!this.zzaxq.equals(zzfwVar.zzaxq)) {
                return false;
            }
            if (this.zzaxr == null) {
                if (zzfwVar.zzaxr != null) {
                    return false;
                }
            } else if (!this.zzaxr.equals(zzfwVar.zzaxr)) {
                return false;
            }
            if (this.zzaxs == null) {
                if (zzfwVar.zzaxs != null) {
                    return false;
                }
            } else if (!this.zzaxs.equals(zzfwVar.zzaxs)) {
                return false;
            }
            if (this.zzaxt == null) {
                if (zzfwVar.zzaxt != null) {
                    return false;
                }
            } else if (!this.zzaxt.equals(zzfwVar.zzaxt)) {
                return false;
            }
            if (this.zzahr == null) {
                if (zzfwVar.zzahr != null) {
                    return false;
                }
            } else if (!this.zzahr.equals(zzfwVar.zzahr)) {
                return false;
            }
            if (this.zzaxu == null) {
                if (zzfwVar.zzaxu != null) {
                    return false;
                }
            } else if (!this.zzaxu.equals(zzfwVar.zzaxu)) {
                return false;
            }
            if (this.zzafp == null) {
                if (zzfwVar.zzafp != null) {
                    return false;
                }
            } else if (!this.zzafp.equals(zzfwVar.zzafp)) {
                return false;
            }
            if (this.zztt == null) {
                if (zzfwVar.zztt != null) {
                    return false;
                }
            } else if (!this.zztt.equals(zzfwVar.zztt)) {
                return false;
            }
            if (this.zzts == null) {
                if (zzfwVar.zzts != null) {
                    return false;
                }
            } else if (!this.zzts.equals(zzfwVar.zzts)) {
                return false;
            }
            if (this.zzaxv == null) {
                if (zzfwVar.zzaxv != null) {
                    return false;
                }
            } else if (!this.zzaxv.equals(zzfwVar.zzaxv)) {
                return false;
            }
            if (this.zzaxw == null) {
                if (zzfwVar.zzaxw != null) {
                    return false;
                }
            } else if (!this.zzaxw.equals(zzfwVar.zzaxw)) {
                return false;
            }
            if (this.zzaxx == null) {
                if (zzfwVar.zzaxx != null) {
                    return false;
                }
            } else if (!this.zzaxx.equals(zzfwVar.zzaxx)) {
                return false;
            }
            if (this.zzaxy == null) {
                if (zzfwVar.zzaxy != null) {
                    return false;
                }
            } else if (!this.zzaxy.equals(zzfwVar.zzaxy)) {
                return false;
            }
            if (this.zzafh == null) {
                if (zzfwVar.zzafh != null) {
                    return false;
                }
            } else if (!this.zzafh.equals(zzfwVar.zzafh)) {
                return false;
            }
            if (this.zzaxz == null) {
                if (zzfwVar.zzaxz != null) {
                    return false;
                }
            } else if (!this.zzaxz.equals(zzfwVar.zzaxz)) {
                return false;
            }
            if (this.zzaya == null) {
                if (zzfwVar.zzaya != null) {
                    return false;
                }
            } else if (!this.zzaya.equals(zzfwVar.zzaya)) {
                return false;
            }
            if (this.zzagm == null) {
                if (zzfwVar.zzagm != null) {
                    return false;
                }
            } else if (!this.zzagm.equals(zzfwVar.zzagm)) {
                return false;
            }
            if (this.zzafi == null) {
                if (zzfwVar.zzafi != null) {
                    return false;
                }
            } else if (!this.zzafi.equals(zzfwVar.zzafi)) {
                return false;
            }
            if (this.zzayb == null) {
                if (zzfwVar.zzayb != null) {
                    return false;
                }
            } else if (!this.zzayb.equals(zzfwVar.zzayb)) {
                return false;
            }
            if (!zzyg.equals(this.zzayc, zzfwVar.zzayc)) {
                return false;
            }
            if (this.zzafk == null) {
                if (zzfwVar.zzafk != null) {
                    return false;
                }
            } else if (!this.zzafk.equals(zzfwVar.zzafk)) {
                return false;
            }
            if (this.zzayd == null) {
                if (zzfwVar.zzayd != null) {
                    return false;
                }
            } else if (!this.zzayd.equals(zzfwVar.zzayd)) {
                return false;
            }
            if (this.zzaye == null) {
                if (zzfwVar.zzaye != null) {
                    return false;
                }
            } else if (!this.zzaye.equals(zzfwVar.zzaye)) {
                return false;
            }
            if (this.zzayf == null) {
                if (zzfwVar.zzayf != null) {
                    return false;
                }
            } else if (!this.zzayf.equals(zzfwVar.zzayf)) {
                return false;
            }
            if (this.zzayg == null) {
                if (zzfwVar.zzayg != null) {
                    return false;
                }
            } else if (!this.zzayg.equals(zzfwVar.zzayg)) {
                return false;
            }
            if (this.zzayh == null) {
                if (zzfwVar.zzayh != null) {
                    return false;
                }
            } else if (!this.zzayh.equals(zzfwVar.zzayh)) {
                return false;
            }
            if (this.zzayi == null) {
                if (zzfwVar.zzayi != null) {
                    return false;
                }
            } else if (!this.zzayi.equals(zzfwVar.zzayi)) {
                return false;
            }
            if (this.zzayj == null) {
                if (zzfwVar.zzayj != null) {
                    return false;
                }
            } else if (!this.zzayj.equals(zzfwVar.zzayj)) {
                return false;
            }
            if (this.zzayk == null) {
                if (zzfwVar.zzayk != null) {
                    return false;
                }
            } else if (!this.zzayk.equals(zzfwVar.zzayk)) {
                return false;
            }
            if (this.zzayl == null) {
                if (zzfwVar.zzayl != null) {
                    return false;
                }
            } else if (!this.zzayl.equals(zzfwVar.zzayl)) {
                return false;
            }
            if (this.zzawr == null) {
                if (zzfwVar.zzawr != null) {
                    return false;
                }
            } else if (!this.zzawr.equals(zzfwVar.zzawr)) {
                return false;
            }
            if (this.zzaym == null) {
                if (zzfwVar.zzaym != null) {
                    return false;
                }
            } else if (!this.zzaym.equals(zzfwVar.zzaym)) {
                return false;
            }
            if (!zzyg.equals(this.zzayn, zzfwVar.zzayn)) {
                return false;
            }
            if (this.zzayo == null) {
                if (zzfwVar.zzayo != null) {
                    return false;
                }
            } else if (!this.zzayo.equals(zzfwVar.zzayo)) {
                return false;
            }
            if (this.zzcev == null || this.zzcev.isEmpty()) {
                return zzfwVar.zzcev == null || zzfwVar.zzcev.isEmpty();
            }
            return this.zzcev.equals(zzfwVar.zzcev);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode();
        int iHashCode3 = this.zzaxj == null ? 0 : this.zzaxj.hashCode();
        int iHashCode4 = zzyg.hashCode(this.zzaxk);
        int iHashCode5 = zzyg.hashCode(this.zzaxl);
        int iHashCode6 = this.zzaxm == null ? 0 : this.zzaxm.hashCode();
        int iHashCode7 = this.zzaxn == null ? 0 : this.zzaxn.hashCode();
        int iHashCode8 = this.zzaxo == null ? 0 : this.zzaxo.hashCode();
        int iHashCode9 = this.zzaxp == null ? 0 : this.zzaxp.hashCode();
        int iHashCode10 = this.zzaxq == null ? 0 : this.zzaxq.hashCode();
        int iHashCode11 = this.zzaxr == null ? 0 : this.zzaxr.hashCode();
        int iHashCode12 = this.zzaxs == null ? 0 : this.zzaxs.hashCode();
        int iHashCode13 = this.zzaxt == null ? 0 : this.zzaxt.hashCode();
        int iHashCode14 = this.zzahr == null ? 0 : this.zzahr.hashCode();
        int iHashCode15 = this.zzaxu == null ? 0 : this.zzaxu.hashCode();
        int iHashCode16 = this.zzafp == null ? 0 : this.zzafp.hashCode();
        int iHashCode17 = this.zztt == null ? 0 : this.zztt.hashCode();
        int iHashCode18 = this.zzts == null ? 0 : this.zzts.hashCode();
        int iHashCode19 = this.zzaxv == null ? 0 : this.zzaxv.hashCode();
        int iHashCode20 = this.zzaxw == null ? 0 : this.zzaxw.hashCode();
        int iHashCode21 = this.zzaxx == null ? 0 : this.zzaxx.hashCode();
        int iHashCode22 = this.zzaxy == null ? 0 : this.zzaxy.hashCode();
        int iHashCode23 = this.zzafh == null ? 0 : this.zzafh.hashCode();
        int iHashCode24 = this.zzaxz == null ? 0 : this.zzaxz.hashCode();
        int iHashCode25 = this.zzaya == null ? 0 : this.zzaya.hashCode();
        int iHashCode26 = this.zzagm == null ? 0 : this.zzagm.hashCode();
        int iHashCode27 = this.zzafi == null ? 0 : this.zzafi.hashCode();
        int iHashCode28 = this.zzayb == null ? 0 : this.zzayb.hashCode();
        int iHashCode29 = zzyg.hashCode(this.zzayc);
        int iHashCode30 = this.zzafk == null ? 0 : this.zzafk.hashCode();
        int iHashCode31 = this.zzayd == null ? 0 : this.zzayd.hashCode();
        int iHashCode32 = this.zzaye == null ? 0 : this.zzaye.hashCode();
        int iHashCode33 = this.zzayf == null ? 0 : this.zzayf.hashCode();
        int iHashCode34 = this.zzayg == null ? 0 : this.zzayg.hashCode();
        int iHashCode35 = this.zzayh == null ? 0 : this.zzayh.hashCode();
        int iHashCode36 = this.zzayi == null ? 0 : this.zzayi.hashCode();
        int iHashCode37 = this.zzayj == null ? 0 : this.zzayj.hashCode();
        int iHashCode38 = this.zzayk == null ? 0 : this.zzayk.hashCode();
        int iHashCode39 = this.zzayl == null ? 0 : this.zzayl.hashCode();
        int iHashCode40 = this.zzawr == null ? 0 : this.zzawr.hashCode();
        zzfe.zzb zzbVar = this.zzaym;
        int iHashCode41 = zzbVar == null ? 0 : zzbVar.hashCode();
        int iHashCode42 = zzyg.hashCode(this.zzayn);
        int iHashCode43 = this.zzayo == null ? 0 : this.zzayo.hashCode();
        if (this.zzcev != null && !this.zzcev.isEmpty()) {
            iHashCode = this.zzcev.hashCode();
        }
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((iHashCode3 + ((iHashCode2 + 527) * 31)) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + iHashCode16) * 31) + iHashCode17) * 31) + iHashCode18) * 31) + iHashCode19) * 31) + iHashCode20) * 31) + iHashCode21) * 31) + iHashCode22) * 31) + iHashCode23) * 31) + iHashCode24) * 31) + iHashCode25) * 31) + iHashCode26) * 31) + iHashCode27) * 31) + iHashCode28) * 31) + iHashCode29) * 31) + iHashCode30) * 31) + iHashCode31) * 31) + iHashCode32) * 31) + iHashCode33) * 31) + iHashCode34) * 31) + iHashCode35) * 31) + iHashCode36) * 31) + iHashCode37) * 31) + iHashCode38) * 31) + iHashCode39) * 31) + iHashCode40) * 31) + iHashCode41) * 31) + iHashCode42) * 31) + iHashCode43) * 31) + iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int iZzuj = zzxzVar.zzuj();
            switch (iZzuj) {
                case 0:
                    break;
                case 8:
                    this.zzaxj = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 18:
                    int iZzb = zzyl.zzb(zzxzVar, 18);
                    int length = this.zzaxk == null ? 0 : this.zzaxk.length;
                    zzft[] zzftVarArr = new zzft[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzaxk, 0, zzftVarArr, 0, length);
                    }
                    while (length < zzftVarArr.length - 1) {
                        zzftVarArr[length] = new zzft();
                        zzxzVar.zza(zzftVarArr[length]);
                        zzxzVar.zzuj();
                        length++;
                    }
                    zzftVarArr[length] = new zzft();
                    zzxzVar.zza(zzftVarArr[length]);
                    this.zzaxk = zzftVarArr;
                    break;
                case 26:
                    int iZzb2 = zzyl.zzb(zzxzVar, 26);
                    int length2 = this.zzaxl == null ? 0 : this.zzaxl.length;
                    zzfz[] zzfzVarArr = new zzfz[iZzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaxl, 0, zzfzVarArr, 0, length2);
                    }
                    while (length2 < zzfzVarArr.length - 1) {
                        zzfzVarArr[length2] = new zzfz();
                        zzxzVar.zza(zzfzVarArr[length2]);
                        zzxzVar.zzuj();
                        length2++;
                    }
                    zzfzVarArr[length2] = new zzfz();
                    zzxzVar.zza(zzfzVarArr[length2]);
                    this.zzaxl = zzfzVarArr;
                    break;
                case 32:
                    this.zzaxm = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 40:
                    this.zzaxn = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 48:
                    this.zzaxo = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 56:
                    this.zzaxq = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 66:
                    this.zzaxr = zzxzVar.readString();
                    break;
                case 74:
                    this.zzaxs = zzxzVar.readString();
                    break;
                case 82:
                    this.zzaxt = zzxzVar.readString();
                    break;
                case 90:
                    this.zzahr = zzxzVar.readString();
                    break;
                case 96:
                    this.zzaxu = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case R.styleable.AppCompatTheme_checkedTextViewStyle /* 106 */:
                    this.zzafp = zzxzVar.readString();
                    break;
                case R.styleable.AppCompatTheme_switchStyle /* 114 */:
                    this.zztt = zzxzVar.readString();
                    break;
                case 130:
                    this.zzts = zzxzVar.readString();
                    break;
                case 136:
                    this.zzaxv = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 144:
                    this.zzaxw = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 154:
                    this.zzaxx = zzxzVar.readString();
                    break;
                case 160:
                    this.zzaxy = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 170:
                    this.zzafh = zzxzVar.readString();
                    break;
                case 176:
                    this.zzaxz = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 184:
                    this.zzaya = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 194:
                    this.zzagm = zzxzVar.readString();
                    break;
                case 202:
                    this.zzafi = zzxzVar.readString();
                    break;
                case 208:
                    this.zzaxp = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 224:
                    this.zzayb = Boolean.valueOf(zzxzVar.zzup());
                    break;
                case 234:
                    int iZzb3 = zzyl.zzb(zzxzVar, 234);
                    int length3 = this.zzayc == null ? 0 : this.zzayc.length;
                    zzfr[] zzfrVarArr = new zzfr[iZzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzayc, 0, zzfrVarArr, 0, length3);
                    }
                    while (length3 < zzfrVarArr.length - 1) {
                        zzfrVarArr[length3] = new zzfr();
                        zzxzVar.zza(zzfrVarArr[length3]);
                        zzxzVar.zzuj();
                        length3++;
                    }
                    zzfrVarArr[length3] = new zzfr();
                    zzxzVar.zza(zzfrVarArr[length3]);
                    this.zzayc = zzfrVarArr;
                    break;
                case 242:
                    this.zzafk = zzxzVar.readString();
                    break;
                case 248:
                    this.zzayd = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 256:
                    this.zzaye = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 264:
                    this.zzayf = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 274:
                    this.zzayg = zzxzVar.readString();
                    break;
                case 280:
                    this.zzayh = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 288:
                    this.zzayi = Long.valueOf(zzxzVar.zzvc());
                    break;
                case 298:
                    this.zzayj = zzxzVar.readString();
                    break;
                case 306:
                    this.zzayk = zzxzVar.readString();
                    break;
                case 312:
                    this.zzayl = Integer.valueOf(zzxzVar.zzvb());
                    break;
                case 330:
                    this.zzawr = zzxzVar.readString();
                    break;
                case 354:
                    zzfe.zzb zzbVar = (zzfe.zzb) zzxzVar.zza(zzfe.zzb.zza());
                    if (this.zzaym != null) {
                        zzbVar = (zzfe.zzb) ((zzuo) this.zzaym.zzwf().zza(zzbVar).zzwo());
                    }
                    this.zzaym = zzbVar;
                    break;
                case 360:
                    int iZzb4 = zzyl.zzb(zzxzVar, 360);
                    int length4 = this.zzayn == null ? 0 : this.zzayn.length;
                    int[] iArr = new int[iZzb4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzayn, 0, iArr, 0, length4);
                    }
                    while (length4 < iArr.length - 1) {
                        iArr[length4] = zzxzVar.zzvb();
                        zzxzVar.zzuj();
                        length4++;
                    }
                    iArr[length4] = zzxzVar.zzvb();
                    this.zzayn = iArr;
                    break;
                case 362:
                    int iZzas = zzxzVar.zzas(zzxzVar.zzvb());
                    int position = zzxzVar.getPosition();
                    int i = 0;
                    while (zzxzVar.zzyy() > 0) {
                        zzxzVar.zzvb();
                        i++;
                    }
                    zzxzVar.zzcb(position);
                    int length5 = this.zzayn == null ? 0 : this.zzayn.length;
                    int[] iArr2 = new int[i + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.zzayn, 0, iArr2, 0, length5);
                    }
                    while (length5 < iArr2.length) {
                        iArr2[length5] = zzxzVar.zzvb();
                        length5++;
                    }
                    this.zzayn = iArr2;
                    zzxzVar.zzat(iZzas);
                    break;
                case 368:
                    this.zzayo = Long.valueOf(zzxzVar.zzvc());
                    break;
                default:
                    if (!super.zza(zzxzVar, iZzuj)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        if (this.zzaxj != null) {
            zzyaVar.zzd(1, this.zzaxj.intValue());
        }
        if (this.zzaxk != null && this.zzaxk.length > 0) {
            for (int i = 0; i < this.zzaxk.length; i++) {
                zzft zzftVar = this.zzaxk[i];
                if (zzftVar != null) {
                    zzyaVar.zza(2, zzftVar);
                }
            }
        }
        if (this.zzaxl != null && this.zzaxl.length > 0) {
            for (int i2 = 0; i2 < this.zzaxl.length; i2++) {
                zzfz zzfzVar = this.zzaxl[i2];
                if (zzfzVar != null) {
                    zzyaVar.zza(3, zzfzVar);
                }
            }
        }
        if (this.zzaxm != null) {
            zzyaVar.zzi(4, this.zzaxm.longValue());
        }
        if (this.zzaxn != null) {
            zzyaVar.zzi(5, this.zzaxn.longValue());
        }
        if (this.zzaxo != null) {
            zzyaVar.zzi(6, this.zzaxo.longValue());
        }
        if (this.zzaxq != null) {
            zzyaVar.zzi(7, this.zzaxq.longValue());
        }
        if (this.zzaxr != null) {
            zzyaVar.zzb(8, this.zzaxr);
        }
        if (this.zzaxs != null) {
            zzyaVar.zzb(9, this.zzaxs);
        }
        if (this.zzaxt != null) {
            zzyaVar.zzb(10, this.zzaxt);
        }
        if (this.zzahr != null) {
            zzyaVar.zzb(11, this.zzahr);
        }
        if (this.zzaxu != null) {
            zzyaVar.zzd(12, this.zzaxu.intValue());
        }
        if (this.zzafp != null) {
            zzyaVar.zzb(13, this.zzafp);
        }
        if (this.zztt != null) {
            zzyaVar.zzb(14, this.zztt);
        }
        if (this.zzts != null) {
            zzyaVar.zzb(16, this.zzts);
        }
        if (this.zzaxv != null) {
            zzyaVar.zzi(17, this.zzaxv.longValue());
        }
        if (this.zzaxw != null) {
            zzyaVar.zzi(18, this.zzaxw.longValue());
        }
        if (this.zzaxx != null) {
            zzyaVar.zzb(19, this.zzaxx);
        }
        if (this.zzaxy != null) {
            zzyaVar.zzb(20, this.zzaxy.booleanValue());
        }
        if (this.zzafh != null) {
            zzyaVar.zzb(21, this.zzafh);
        }
        if (this.zzaxz != null) {
            zzyaVar.zzi(22, this.zzaxz.longValue());
        }
        if (this.zzaya != null) {
            zzyaVar.zzd(23, this.zzaya.intValue());
        }
        if (this.zzagm != null) {
            zzyaVar.zzb(24, this.zzagm);
        }
        if (this.zzafi != null) {
            zzyaVar.zzb(25, this.zzafi);
        }
        if (this.zzaxp != null) {
            zzyaVar.zzi(26, this.zzaxp.longValue());
        }
        if (this.zzayb != null) {
            zzyaVar.zzb(28, this.zzayb.booleanValue());
        }
        if (this.zzayc != null && this.zzayc.length > 0) {
            for (int i3 = 0; i3 < this.zzayc.length; i3++) {
                zzfr zzfrVar = this.zzayc[i3];
                if (zzfrVar != null) {
                    zzyaVar.zza(29, zzfrVar);
                }
            }
        }
        if (this.zzafk != null) {
            zzyaVar.zzb(30, this.zzafk);
        }
        if (this.zzayd != null) {
            zzyaVar.zzd(31, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            zzyaVar.zzd(32, this.zzaye.intValue());
        }
        if (this.zzayf != null) {
            zzyaVar.zzd(33, this.zzayf.intValue());
        }
        if (this.zzayg != null) {
            zzyaVar.zzb(34, this.zzayg);
        }
        if (this.zzayh != null) {
            zzyaVar.zzi(35, this.zzayh.longValue());
        }
        if (this.zzayi != null) {
            zzyaVar.zzi(36, this.zzayi.longValue());
        }
        if (this.zzayj != null) {
            zzyaVar.zzb(37, this.zzayj);
        }
        if (this.zzayk != null) {
            zzyaVar.zzb(38, this.zzayk);
        }
        if (this.zzayl != null) {
            zzyaVar.zzd(39, this.zzayl.intValue());
        }
        if (this.zzawr != null) {
            zzyaVar.zzb(41, this.zzawr);
        }
        if (this.zzaym != null) {
            zzyaVar.zze(44, this.zzaym);
        }
        if (this.zzayn != null && this.zzayn.length > 0) {
            for (int i4 = 0; i4 < this.zzayn.length; i4++) {
                int i5 = this.zzayn[i4];
                zzyaVar.zzc(45, 0);
                zzyaVar.zzcd(i5);
            }
        }
        if (this.zzayo != null) {
            zzyaVar.zzi(46, this.zzayo.longValue());
        }
        super.zza(zzyaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    protected final int zzf() {
        int iZzf = super.zzf();
        if (this.zzaxj != null) {
            iZzf += zzya.zzh(1, this.zzaxj.intValue());
        }
        if (this.zzaxk != null && this.zzaxk.length > 0) {
            int iZzb = iZzf;
            for (int i = 0; i < this.zzaxk.length; i++) {
                zzft zzftVar = this.zzaxk[i];
                if (zzftVar != null) {
                    iZzb += zzya.zzb(2, zzftVar);
                }
            }
            iZzf = iZzb;
        }
        if (this.zzaxl != null && this.zzaxl.length > 0) {
            int iZzb2 = iZzf;
            for (int i2 = 0; i2 < this.zzaxl.length; i2++) {
                zzfz zzfzVar = this.zzaxl[i2];
                if (zzfzVar != null) {
                    iZzb2 += zzya.zzb(3, zzfzVar);
                }
            }
            iZzf = iZzb2;
        }
        if (this.zzaxm != null) {
            iZzf += zzya.zzd(4, this.zzaxm.longValue());
        }
        if (this.zzaxn != null) {
            iZzf += zzya.zzd(5, this.zzaxn.longValue());
        }
        if (this.zzaxo != null) {
            iZzf += zzya.zzd(6, this.zzaxo.longValue());
        }
        if (this.zzaxq != null) {
            iZzf += zzya.zzd(7, this.zzaxq.longValue());
        }
        if (this.zzaxr != null) {
            iZzf += zzya.zzc(8, this.zzaxr);
        }
        if (this.zzaxs != null) {
            iZzf += zzya.zzc(9, this.zzaxs);
        }
        if (this.zzaxt != null) {
            iZzf += zzya.zzc(10, this.zzaxt);
        }
        if (this.zzahr != null) {
            iZzf += zzya.zzc(11, this.zzahr);
        }
        if (this.zzaxu != null) {
            iZzf += zzya.zzh(12, this.zzaxu.intValue());
        }
        if (this.zzafp != null) {
            iZzf += zzya.zzc(13, this.zzafp);
        }
        if (this.zztt != null) {
            iZzf += zzya.zzc(14, this.zztt);
        }
        if (this.zzts != null) {
            iZzf += zzya.zzc(16, this.zzts);
        }
        if (this.zzaxv != null) {
            iZzf += zzya.zzd(17, this.zzaxv.longValue());
        }
        if (this.zzaxw != null) {
            iZzf += zzya.zzd(18, this.zzaxw.longValue());
        }
        if (this.zzaxx != null) {
            iZzf += zzya.zzc(19, this.zzaxx);
        }
        if (this.zzaxy != null) {
            this.zzaxy.booleanValue();
            iZzf += zzya.zzbd(20) + 1;
        }
        if (this.zzafh != null) {
            iZzf += zzya.zzc(21, this.zzafh);
        }
        if (this.zzaxz != null) {
            iZzf += zzya.zzd(22, this.zzaxz.longValue());
        }
        if (this.zzaya != null) {
            iZzf += zzya.zzh(23, this.zzaya.intValue());
        }
        if (this.zzagm != null) {
            iZzf += zzya.zzc(24, this.zzagm);
        }
        if (this.zzafi != null) {
            iZzf += zzya.zzc(25, this.zzafi);
        }
        if (this.zzaxp != null) {
            iZzf += zzya.zzd(26, this.zzaxp.longValue());
        }
        if (this.zzayb != null) {
            this.zzayb.booleanValue();
            iZzf += zzya.zzbd(28) + 1;
        }
        if (this.zzayc != null && this.zzayc.length > 0) {
            int iZzb3 = iZzf;
            for (int i3 = 0; i3 < this.zzayc.length; i3++) {
                zzfr zzfrVar = this.zzayc[i3];
                if (zzfrVar != null) {
                    iZzb3 += zzya.zzb(29, zzfrVar);
                }
            }
            iZzf = iZzb3;
        }
        if (this.zzafk != null) {
            iZzf += zzya.zzc(30, this.zzafk);
        }
        if (this.zzayd != null) {
            iZzf += zzya.zzh(31, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            iZzf += zzya.zzh(32, this.zzaye.intValue());
        }
        if (this.zzayf != null) {
            iZzf += zzya.zzh(33, this.zzayf.intValue());
        }
        if (this.zzayg != null) {
            iZzf += zzya.zzc(34, this.zzayg);
        }
        if (this.zzayh != null) {
            iZzf += zzya.zzd(35, this.zzayh.longValue());
        }
        if (this.zzayi != null) {
            iZzf += zzya.zzd(36, this.zzayi.longValue());
        }
        if (this.zzayj != null) {
            iZzf += zzya.zzc(37, this.zzayj);
        }
        if (this.zzayk != null) {
            iZzf += zzya.zzc(38, this.zzayk);
        }
        if (this.zzayl != null) {
            iZzf += zzya.zzh(39, this.zzayl.intValue());
        }
        if (this.zzawr != null) {
            iZzf += zzya.zzc(41, this.zzawr);
        }
        if (this.zzaym != null) {
            iZzf += zztv.zzc(44, this.zzaym);
        }
        if (this.zzayn != null && this.zzayn.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (i5 < this.zzayn.length) {
                int iZzbl = zzya.zzbl(this.zzayn[i5]) + i4;
                i5++;
                i4 = iZzbl;
            }
            iZzf = iZzf + i4 + (this.zzayn.length * 2);
        }
        return this.zzayo != null ? iZzf + zzya.zzd(46, this.zzayo.longValue()) : iZzf;
    }
}
