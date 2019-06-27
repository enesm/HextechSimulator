package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "AktifYama")
public class AktifYama {
    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "yama")
    private String yama;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setYama(String yama) {
        this.yama = yama;
    }

    public String getYama() {
        return yama;
    }
}
