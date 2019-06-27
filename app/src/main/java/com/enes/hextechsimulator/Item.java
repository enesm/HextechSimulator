package com.enes.hextechsimulator;

class Item {
    private int id;
    private String isim;
    private String genelIsim;
    private int itemTip;
    int nadirlikId;
    private int miktar;

    Item(int id, int itemTip, String isim, int nadirlikId) {
        this.id = id;
        this.isim = isim;
        this.itemTip = itemTip;
        this.genelIsim = ItemTip.getIsim(itemTip);
        this.nadirlikId = nadirlikId;
        this.miktar = 1;
    }

    int getId() {
        return id;
    }

    String getIsim() {
        return isim;
    }

    String getGenelIsim() {
        return genelIsim;
    }

    int getItemTip() {
        return itemTip;
    }

    int getNadirlikId() {
        return nadirlikId;
    }

    int getMiktar() {
        return miktar;
    }

    void incMiktar() {
        miktar += 1;
    }

    void decMiktar() {
        miktar -= 1;
    }

    void setMiktar(int newMiktar) {
        miktar = newMiktar;
    }
}
