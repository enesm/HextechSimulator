package com.enes.hextechsimulator.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Envanter")
public class ModelEnvanter {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "grupID")
    private int grupID;

    @ColumnInfo(name = "esyaID")
    private int esyaID;

    public ModelEnvanter(int grupID, int esyaID) {
        this.grupID = grupID;
        this.esyaID = esyaID;
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

    public int getEsyaID() {
        return esyaID;
    }

    public void setEsyaID(int esyaID) {
        this.esyaID = esyaID;
    }
}
