package com.enes.hextechsimulator;

import android.content.res.Resources;

class ItemTip {
    static String getIsim(int tipId) {
        Resources resources = RootApp.getContext().getResources();
        String isim = resources.getString(R.string.sys_hatali_veri);
        switch (tipId) {
            case 1:
                isim = resources.getString(R.string.item_samp);
                break;

            case 2:
                isim = resources.getString(R.string.item_kostum);
                break;

            case 3:
                isim = resources.getString(R.string.item_cevher);
                break;

            case 4:
                isim = resources.getString(R.string.item_cevher_kostumu);
                break;

            case 5:
                isim = resources.getString(R.string.item_ekstra);
                break;

            case 6:
                isim = resources.getString(R.string.item_sandik);
                break;

            case 7:
                isim = resources.getString(R.string.item_sandik_seti);
                break;

            case 8:
                isim = resources.getString(R.string.item_mo);
                break;

            case 9:
                isim = resources.getString(R.string.item_to);
                break;

            case 10:
                isim = resources.getString(R.string.item_anahtar);

            case 11:
                isim = resources.getString(R.string.separator);
        }
        return isim;
    }
}
