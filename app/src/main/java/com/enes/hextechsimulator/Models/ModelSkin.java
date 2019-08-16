package com.enes.hextechsimulator.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.enes.hextechsimulator.Database.GrupTypes;

@Entity(tableName = "Kostumler")
public class ModelSkin {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "GrupID")
    private int grupID = GrupTypes.GRUP_SKIN_SHARD;

    @ColumnInfo(name = "skinID")
    private int skinId;

    @ColumnInfo(name = "sampId")
    private int sampId;

    @ColumnInfo(name = "kostumAdiRef")
    private int kostumAdiRef;

    @ColumnInfo(name = "nadirlik")
    private int nadirlik;

    @ColumnInfo(name = "hatira")
    private boolean hatira;

    @ColumnInfo(name = "na")
    private boolean na;

    public ModelSkin(int skinId, int sampId, int kostumAdiRef, int nadirlik, boolean hatira, boolean na) {
        this.skinId = skinId;
        this.sampId = sampId;
        this.kostumAdiRef = kostumAdiRef;
        this.nadirlik = nadirlik;
        this.hatira = hatira;
        this.na = na;
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

    public int getSkinId() {
        return skinId;
    }

    public void setSkinId(int skinId) {
        this.skinId = skinId;
    }

    public int getSampId() {
        return sampId;
    }

    public void setSampId(int sampId) {
        this.sampId = sampId;
    }

    public int getKostumAdiRef() {
        return kostumAdiRef;
    }

    public void setKostumAdiRef(int kostumAdiRef) {
        this.kostumAdiRef = kostumAdiRef;
    }

    public int getNadirlik() {
        return nadirlik;
    }

    public void setNadirlik(int nadirlik) {
        this.nadirlik = nadirlik;
    }

    public boolean isHatira() {
        return hatira;
    }

    public void setHatira(boolean hatira) {
        this.hatira = hatira;
    }

    public boolean isNa() {
        return na;
    }

    public void setNa(boolean na) {
        this.na = na;
    }
}
