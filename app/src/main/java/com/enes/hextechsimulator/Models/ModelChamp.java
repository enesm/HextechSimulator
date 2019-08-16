package com.enes.hextechsimulator.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.enes.hextechsimulator.Database.GrupTypes;

@Entity(tableName = "Sampiyonlar")
public class ModelChamp {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "GrupId")
    private int grupId = GrupTypes.GRUP_SAMP_SHARD;

    @ColumnInfo(name = "sampName")
    private String sampName;

    @ColumnInfo(name = "nadirlik")
    private int nadirlik;

    public ModelChamp(String sampName, int nadirlik) {
        this.sampName = sampName;
        this.nadirlik = nadirlik;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrupId() {
        return grupId;
    }

    public void setGrupId(int grupId) {
        this.grupId = grupId;
    }

    public String getSampName() {
        return sampName;
    }

    public void setSampName(String sampName) {
        this.sampName = sampName;
    }

    public int getNadirlik() {
        return nadirlik;
    }

    public void setNadirlik(int nadirlik) {
        this.nadirlik = nadirlik;
    }
}
