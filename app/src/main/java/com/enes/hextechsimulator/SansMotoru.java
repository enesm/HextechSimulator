package com.enes.hextechsimulator;

import android.util.Log;

import java.util.Random;

class SansMotoru {
    private static final boolean DEBUG = false;

    static boolean getSans(double sans) {
        double sayi = Math.random();
        if (DEBUG && sayi != 0)
            Log.e("SansMotoru", "sayi:" + " " + String.valueOf(sayi) + " sans: " + sans / 100.0);
        if (sans != 0 && sayi < sans / 100.0) {
            if (DEBUG) Log.e("SansMotoru", String.valueOf(true));
            return true;
        } else {
            if (DEBUG) Log.e("SansMotoru", String.valueOf(false));
            return false;
        }
    }

    static int getInt(int max) {
        Random r = new Random();
        int miktar = 1;
        for (int i = 1; i <= max; i++) {
            int sans = r.nextInt(max * 3);
            if (i < sans) {
                miktar = i;
                break;
            }
        }
        if (DEBUG) Log.e("SansMotoru", String.valueOf(miktar));
        return miktar;
    }

    static int getNadirlik(double n2, double n3, double n4, double n5, double n6, double n7) {
        double nadirlik6 = n7 + n6;
        double nadirlik5 = nadirlik6 + n5;
        double nadirlik4 = nadirlik5 + n4;
        double nadirlik3 = nadirlik4 + n3;
        double nadirlik2 = nadirlik3 + n2;
        double sayi = Math.random() * 100;
        if (DEBUG) Log.e("SansMotoru nadirlik", String.valueOf(sayi));
        if (sayi <= n7) return 7;
        else if (sayi <= nadirlik6) return 6;
        else if (sayi <= nadirlik5) return 5;
        else if (sayi <= nadirlik4) return 4;
        else if (sayi <= nadirlik3) return 3;
        else if (sayi <= nadirlik2) return 2;
        else return 1;
    }
}
