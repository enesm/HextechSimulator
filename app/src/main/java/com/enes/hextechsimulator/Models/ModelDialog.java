package com.enes.hextechsimulator.Models;

public class ModelDialog {
    private int tip;
    private String mesaj;
    private String errorCode;
    private String btnPos;
    private String btnNeg;

    public ModelDialog(String mesaj) {
        this.mesaj = mesaj;
        this.tip = 1; // info
    }

    public ModelDialog(String mesaj, String errorCode) {
        this.mesaj = mesaj;
        this.errorCode = errorCode;
        this.tip = 2; // hata mesaji
    }

    public ModelDialog(String mesaj, String btnPos, String btnNeg) {
        this.mesaj = mesaj;
        this.btnPos = btnPos;
        this.btnNeg = btnNeg;
        this.tip = 3; // soru
    }

    public int getTip() {
        return tip;
    }

    public String getMesaj() {
        return mesaj;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getBtnPos() {
        return btnPos;
    }

    public String getBtnNeg() {
        return btnNeg;
    }
}
