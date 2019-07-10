package com.enes.hextechsimulator.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Nadirlikler")
public class ModelNadirlik {

    @ColumnInfo(name = "level")
    @PrimaryKey
    private int level;

    @ColumnInfo(name = "nameRef")
    private int nameRef;

    @ColumnInfo(name = "moDegeri")
    private int moDegeri;

    @ColumnInfo(name = "toDegeri")
    private int toDegeri;

    public ModelNadirlik(int level, int nameRef, int moDegeri, int toDegeri) {
        this.level = level;
        this.nameRef = nameRef;
        this.moDegeri = moDegeri;
        this.toDegeri = toDegeri;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNameRef() {
        return nameRef;
    }

    public void setNameRef(int nameRef) {
        this.nameRef = nameRef;
    }

    public int getMoDegeri() {
        return moDegeri;
    }

    public void setMoDegeri(int moDegeri) {
        this.moDegeri = moDegeri;
    }

    public int getToDegeri() {
        return toDegeri;
    }

    public void setToDegeri(int toDegeri) {
        this.toDegeri = toDegeri;
    }
}
