package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "AktifYama")
public class AktifYama {
    @PrimaryKey
    @ColumnInfo(name = "yama")
    @NonNull
    private String yama;

    void setYama(String yama) {
        this.yama = yama;
    }

    String getYama() {
        return yama;
    }
}
