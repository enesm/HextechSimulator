package com.enes.hextechsimulator.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.enes.hextechsimulator.Database.GrupTypes;

@Entity(tableName = "Specials")
public class ModelSpec {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "GrupID")
    private int grupID = GrupTypes.GRUP_SPECIAL;

    @ColumnInfo(name = "specAdiRef")
    private int specAdiRef;

    public ModelSpec(int specAdiRef) {
        this.specAdiRef = specAdiRef;
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

    public int getSpecAdiRef() {
        return specAdiRef;
    }

    public void setSpecAdiRef(int specAdiRef) {
        this.specAdiRef = specAdiRef;
    }
}
