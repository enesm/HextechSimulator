package com.enes.hextechsimulator.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.enes.hextechsimulator.Database.GrupTypes;

@Entity(tableName = "Sandiklar")
public class ModelSandik {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "GrupID")
    private int grupID = GrupTypes.GRUP_SANDIK;

    @ColumnInfo(name = "sandikAdiRef")
    private int sandikAdiRef;

    @ColumnInfo(name = "sansN1")
    private double sansN1;

    @ColumnInfo(name = "sansN2")
    private double sansN2;

    @ColumnInfo(name = "sansN3")
    private double sansN3;

    @ColumnInfo(name = "sansN4")
    private double sansN4;

    @ColumnInfo(name = "sansN5")
    private double sansN5;

    @ColumnInfo(name = "sansN6")
    private double sansN6;

    @ColumnInfo(name = "sansN7")
    private double sansN7;

    @ColumnInfo(name = "sansGem")
    private double sansGem;

    @ColumnInfo(name = "sansExtra")
    private double sansExtra;

    @ColumnInfo(name = "sansSandikSet")
    private double sansSandikSet;

    @ColumnInfo(name = "sansOz")
    private double sansOz;

    @ColumnInfo(name = "isKeyReq")
    private boolean isKeyReq;

    @ColumnInfo(name = "odulSayisi")
    private int odulSayisi;

    @ColumnInfo(name = "isContainNa")
    private boolean isContainNa;

    @ColumnInfo(name = "isContainLegacy")
    private boolean isContainLegacy;

    @ColumnInfo(name = "be")
    private int be;

    @ColumnInfo(name = "oe")
    private int oe;
    // TODO: İleriye dönük special item güncellemeleri için esnek değil.
    public ModelSandik(int sandikAdiRef, double sansN1, double sansN2, double sansN3, double sansN4, double sansN5, double sansN6, double sansN7, double sansExtra,
                       double sansGem, double sansSandikSet, double sansOz, boolean isKeyReq, int odulSayisi, boolean isContainNa, boolean isContainLegacy,
                       int be, int oe) {
        this.sandikAdiRef = sandikAdiRef;
        this.sansN1 = sansN1;
        this.sansN2 = sansN2;
        this.sansN3 = sansN3;
        this.sansN4 = sansN4;
        this.sansN5 = sansN5;
        this.sansN6 = sansN6;
        this.sansN7 = sansN7;
        this.sansGem = sansGem;
        this.sansExtra = sansExtra;
        this.sansSandikSet = sansSandikSet;
        this.sansOz = sansOz;
        this.isKeyReq = isKeyReq;
        this.odulSayisi = odulSayisi;
        this.isContainNa = isContainNa;
        this.isContainLegacy = isContainLegacy;
        this.be = be;
        this.oe = oe;
    }

    public void open() {
        // TODO: Open.
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrupID() {
        return grupID;
    }

    public void setGrupID(int grupID) {
        this.grupID = grupID;
    }

    public int getSandikAdiRef() {
        return sandikAdiRef;
    }

    public void setSandikAdi(int sandikAdiRef) {
        this.sandikAdiRef = sandikAdiRef;
    }

    public double getSansN1() {
        return sansN1;
    }

    public void setSansN1(int sansN1) {
        this.sansN1 = sansN1;
    }

    public double getSansN2() {
        return sansN2;
    }

    public void setSansN2(int sansN2) {
        this.sansN2 = sansN2;
    }

    public double getSansN3() {
        return sansN3;
    }

    public void setSansN3(int sansN3) {
        this.sansN3 = sansN3;
    }

    public double getSansN4() {
        return sansN4;
    }

    public void setSansN4(int sansN4) {
        this.sansN4 = sansN4;
    }

    public double getSansN5() {
        return sansN5;
    }

    public void setSansN5(int sansN5) {
        this.sansN5 = sansN5;
    }

    public double getSansN6() {
        return sansN6;
    }

    public void setSansN6(int sansN6) {
        this.sansN6 = sansN6;
    }

    public double getSansN7() {
        return sansN7;
    }

    public void setSansN7(int sansN7) {
        this.sansN7 = sansN7;
    }

    public double getSansGem() {
        return sansGem;
    }

    public void setSansGem(int sansGem) {
        this.sansGem = sansGem;
    }

    public double getSansExtra() {
        return sansExtra;
    }

    public void setSansExtra(int sansExtra) {
        this.sansExtra = sansExtra;
    }

    public double getSansSandikSet() {
        return sansSandikSet;
    }

    public void setSansSandikSet(int sansSandikSet) {
        this.sansSandikSet = sansSandikSet;
    }

    public double getSansOz() {
        return sansOz;
    }

    public void setSansOz(int sansOz) {
        this.sansOz = sansOz;
    }

    public boolean isKeyReq() {
        return isKeyReq;
    }

    public void setKeyReq(boolean keyReq) {
        isKeyReq = keyReq;
    }

    public int getOdulSayisi() {
        return odulSayisi;
    }

    public void setOdulSayisi(int odulSayisi) {
        this.odulSayisi = odulSayisi;
    }

    public boolean isContainNa() {
        return isContainNa;
    }

    public void setContainNa(boolean containNa) {
        isContainNa = containNa;
    }

    public boolean isContainLegacy() {
        return isContainLegacy;
    }

    public void setContainLegacy(boolean containLegacy) {
        isContainLegacy = containLegacy;
    }

    public int getBe() {
        return be;
    }

    public void setBe(int be) {
        this.be = be;
    }

    public int getOe() {
        return oe;
    }

    public void setOe(int oe) {
        this.oe = oe;
    }
}
