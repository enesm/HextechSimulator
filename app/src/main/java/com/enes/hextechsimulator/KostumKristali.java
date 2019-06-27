package com.enes.hextechsimulator;

public class KostumKristali extends Item {
    private int fiyatRp;
    private int fiyatTo;
    private int sampId;
    private int skinId;
    private boolean hatiraIcerik;
    private boolean mevcutOlmayanIcerik;

    KostumKristali(int id, int skinId, int sampId, String isim, int nadirlikId, boolean hatiraIcerik, boolean mevcutOlmayanIcerik) {
        super(id, 2, isim, nadirlikId);
        this.fiyatRp = Nadirlik.getFiyatRp(this.nadirlikId);
        this.fiyatTo = Nadirlik.getFiyatTo(this.nadirlikId);
        this.sampId = sampId;
        this.skinId = skinId;
        this.hatiraIcerik = hatiraIcerik;
        this.mevcutOlmayanIcerik = mevcutOlmayanIcerik;
    }

    public int getFiyatRp() {
        return fiyatRp;
    }

    public int getFiyatTo() {
        return fiyatTo;
    }

    public int getSampId() {
        return sampId;
    }

    public int getSkinId() {
        return skinId;
    }

    boolean isHatiraIcerik() {
        return hatiraIcerik;
    }

    boolean isMevcutOlmayanIcerik() {
        return mevcutOlmayanIcerik;
    }
}
