package com.enes.hextechsimulator.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "AktifYama")
public class AktifYama {
    @PrimaryKey
    @ColumnInfo(name = "yama")
    @NonNull
    private String yama;

    void setYama(String yama) {
        this.yama = yama;
    }

    public String getYama() {
        return yama;
    }
}
