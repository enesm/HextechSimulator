package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.enes.hextechsimulator.Models.ModelPlayer;

@Dao
public interface DaoPlayer {

    @Query("UPDATE Player SET blueEssence = :be")
    void setBe(int be);

    @Query("UPDATE Player SET orangeEssence = :oe")
    void setOe(int oe);

    @Query("UPDATE Player SET exp = exp + :exp")
    void addExp(int exp);

    @Query("UPDATE Player SET exp = :exp")
    void setExp(int exp);

    @Query("UPDATE Player SET nextExp = :nextExp")
    void setNextExp(int nextExp);

    @Query("UPDATE Player SET level = :level")
    void setLevel(int level);

    @Insert
    void addPlayer(ModelPlayer player);

    @Update
    void updatePlayer(ModelPlayer player);

    @Query("SELECT * FROM Player")
    ModelPlayer getPlayer();

    @Query("SELECT name FROM Player")
    String getName();

    @Query("SELECT blueEssence FROM Player")
    int getBe();

    @Query("SELECT orangeEssence FROM Player")
    int getOe();

    @Query("SELECT exp FROM Player")
    int getExp();

    @Query("SELECT nextExp FROM Player")
    int getNextExp();

    @Query("SELECT level FROM Player")
    int getLevel();

    @Query("SELECT keyAmount FROM Player")
    int getKeyAmount();

    @Query("UPDATE Player SET keyAmount = :keyAmount")
    void setKeyAmount(int keyAmount);

    @Query("DELETE FROM Player")
    void clear();
}
