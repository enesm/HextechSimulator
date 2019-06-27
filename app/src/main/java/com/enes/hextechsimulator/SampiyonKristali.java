package com.enes.hextechsimulator;

public class SampiyonKristali extends Item {
    private int fiyatIp;
    private int fiyatMo;

    SampiyonKristali(int id, String isim, int nadirlikId) {
        super(id, 1, isim, nadirlikId);
        this.fiyatIp = Nadirlik.getFiyatIp(this.nadirlikId);
        this.fiyatMo = Nadirlik.getFiyatMo(this.nadirlikId);
    }

    public int getFiyatIp() {
        return fiyatIp;
    }

    public int getFiyatMo() {
        return fiyatMo;
    }
}
