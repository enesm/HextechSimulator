package com.enes.hextechsimulator.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Player")
public class ModelPlayer {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int Id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "blueEssence")
    private int be;

    @ColumnInfo(name = "orangeEssence")
    private int oe;

    @ColumnInfo(name = "exp")
    private int exp;

    @ColumnInfo(name = "nextExp")
    private int nextExp;

    @ColumnInfo(name = "level")
    private int level;

    @ColumnInfo(name = "keyAmount")
    private int key;

    public ModelPlayer(String name, int be, int oe, int exp, int nextExp, int level, int key) {
        this.name = name;
        this.be = be;
        this.oe = oe;
        this.exp = exp;
        this.nextExp = nextExp;
        this.level = level;
        this.key = key;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
