package com.enes.hextechsimulator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Sandik extends Item {
    private int garantiIcerikSayisi;        // Sandıktan çıkacak minimum içerik
    private double sansKostum;              // Kostüm çıkma ihtimali
    private double sansN1;                  // 750 çıkma şansı
    private double sansN2;                  // 975 çıkma şansı
    private double sansN3;                  // 1350 çıkma şansı
    private double sansN4;                  // 1820 çıkma şansı
    private double sansN5;                  // 2775 çıkma şansı
    private double sansN6;                  // 3250 çıkma şansı
    private double sansN7;                  // Cevher kostümü çıkma şansı
    private double sansEkstraIcerik;        // Ekstra bir içerik çıkma şansı
    private double sansCevher;              // Cevher çıkma şansı
    private double sansSandikSeti;          // Sandık seti çıkma şansı
    private int miktarPara;                 // Turuncu öz veya mavi öz çıkma miktarı
    private int miktarMaxCevher;            // Çıkabilecek maksimum cevher sayısı
    private int miktarMaxSandikSeti;        // Çıkabilecek maksimum set sayısı
    private boolean hatiraIcerik;           // Hatıra içerik çıkması açık/kapalı.
    private boolean mevcutOlmayanIcerik;    // Hiç bir şekilde erişilemeyen köstümlerin çıkması açık/kapalı.
    private boolean keyReq;                 // Açmak için anahtar gerekli mi

    Sandik(int id, String isim, boolean keyReq, int garantiIcerikSayisi, double sansKostum, double sansN1, double sansN2, double sansN3,
           double sansN4, double sansN5, double sansN6, double sansN7, double sansEkstraIcerik, double sansCevher, double sansSandikSeti,
           int miktarPara, int maxCevher, int maxSandikSeti, boolean hatiraIcerik, boolean mevcutOlmayanIcerik) {
        super(id, 6, isim, 1);
        this.garantiIcerikSayisi = garantiIcerikSayisi;
        this.sansKostum = sansKostum;
        this.sansN1 = sansN1;
        this.sansN2 = sansN2;
        this.sansN3 = sansN3;
        this.sansN4 = sansN4;
        this.sansN5 = sansN5;
        this.sansN6 = sansN6;
        this.sansN7 = sansN7;
        this.sansEkstraIcerik = sansEkstraIcerik;
        this.sansCevher = sansCevher;
        this.sansSandikSeti = sansSandikSeti;
        this.miktarPara = miktarPara;
        this.miktarMaxCevher = maxCevher;
        this.miktarMaxSandikSeti = maxSandikSeti;
        this.hatiraIcerik = hatiraIcerik;
        this.mevcutOlmayanIcerik = mevcutOlmayanIcerik;
        this.keyReq = keyReq;
    }

    JSONObject getIcerik() throws JSONException {
        JSONObject rewards = new JSONObject();
        JSONArray contents = new JSONArray();
        JSONArray extras = new JSONArray();
        int paraBirim = 8; // Mavi öz
        if (SansMotoru.getSans(sansKostum)) {
            rewards.put("contentType", 2);
            paraBirim = 9;
        } else {
            rewards.put("contentType", 1);
        }
        for (int i = 0; i < garantiIcerikSayisi; i++) {
            /*if (SansMotoru.getSans(sansN7)) contents.put(i, 7);
            else if (SansMotoru.getSans(sansN6)) contents.put(i, 6);
            else if (SansMotoru.getSans(sansN5)) contents.put(i, 5);
            else if (SansMotoru.getSans(sansN4)) contents.put(i, 4);
            else if (SansMotoru.getSans(sansN3)) contents.put(i, 3);
            else if (SansMotoru.getSans(sansN2)) contents.put(i, 2);
            else if (SansMotoru.getSans(sansN1)) contents.put(i, 1);
            else contents.put(i, 2);*/
            contents.put(i, SansMotoru.getNadirlik(sansN2, sansN3, sansN4, sansN5, sansN6, sansN7));
        }
        if (SansMotoru.getSans(sansEkstraIcerik)) {
            if (SansMotoru.getSans(sansSandikSeti)) {
                extras.put(0, 7); // Sandık seti
                extras.put(1, SansMotoru.getInt(miktarMaxSandikSeti)); // miktar
            } else if (SansMotoru.getSans(sansCevher)) {
                extras.put(0, 3); // cevher
                extras.put(1, SansMotoru.getInt(miktarMaxCevher)); // miktar
            } else {
                extras.put(0, paraBirim); // Öz
                extras.put(1, miktarPara);// miktar
            }
        }
        rewards.put("contents", contents);
        rewards.put("extras", extras);
        return rewards;
    }

    boolean isHatiraIcerikMevcut() {
        return hatiraIcerik;
    }

    boolean isMevcutOlmayanIcerikMevcut() {
        return mevcutOlmayanIcerik;
    }

    boolean isKeyReq() {
        return keyReq;
    }
}
