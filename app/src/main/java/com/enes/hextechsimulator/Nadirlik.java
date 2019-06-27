package com.enes.hextechsimulator;

import android.content.res.Resources;

public class Nadirlik {

    public static String getIsim(int nadirlikId) {
        Resources resources = RootApp.getContext().getResources();
        String isim = resources.getString(R.string.sys_hatali_veri);
        switch (nadirlikId) {
            case 1:
                isim = resources.getString(R.string.nadirlik_1);
                break;

            case 2:
                isim = resources.getString(R.string.nadirlik_2);
                break;

            case 3:
                isim = resources.getString(R.string.nadirlik_3);
                break;

            case 4:
                isim = resources.getString(R.string.nadirlik_4);
                break;

            case 5:
                isim = resources.getString(R.string.nadirlik_5);
                break;

            case 6:
                isim = resources.getString(R.string.nadirlik_6);
                break;

            case 7:
                isim = resources.getString(R.string.nadirlik_7 );
                break;
        }
        return isim;
    }

    static int getFiyatRp(int nadirlikId) {
        int fiyat = 0;
        switch (nadirlikId) {
            case 1:
                fiyat = 750;
                break;

            case 2:
                fiyat = 975;
                break;

            case 3:
                fiyat = 1350;
                break;

            case 4:
                fiyat = 1820;
                break;

            case 5:
                fiyat = 2775;
                break;

            case 6:
                fiyat = 3250;
                break;

            case 7:
                fiyat = 4500;
        }
        return fiyat;
    }

    static int getFiyatIp(int nadirlikId) {
        int fiyat = 0;
        switch (nadirlikId) {
            case 1:
                fiyat = 450;
                break;

            case 2:
                fiyat = 1350;
                break;

            case 3:
                fiyat = 3150;
                break;

            case 4:
                fiyat = 4800;
                break;

            case 5:
                fiyat = 6300;
                break;

            case 6:
                fiyat = 7800;
                break;

            case 7:
                fiyat = 8500;
                break;
        }
        return fiyat;
    }

    static int getFiyatMo(int nadirlikId) {
        int fiyat = 0;
        switch (nadirlikId) {
            case 1:
                fiyat = 90;
                break;

            case 2:
                fiyat = 270;
                break;

            case 3:
                fiyat = 630;
                break;

            case 4:
                fiyat = 960;
                break;

            case 5:
                fiyat = 1260;
                break;

            case 6:
                fiyat = 1560;
                break;

            case 7:
                fiyat = 1700;
                break;
        }
        return fiyat;
    }

    static int getFiyatTo(int nadirlikId) {
        int fiyat = 0;
        switch (nadirlikId) {
            case 1:
                fiyat = 150;
                break;

            case 2:
                fiyat = 195;
                break;

            case 3:
                fiyat = 270;
                break;

            case 4:
                fiyat = 364;
                break;

            case 5:
                fiyat = 555;
                break;

            case 6:
                fiyat = 650;
                break;

            case 7:
                fiyat = 900;
                break;
        }
        return fiyat;
    }
}
