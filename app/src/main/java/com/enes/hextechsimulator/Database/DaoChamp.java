package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.enes.hextechsimulator.Models.ModelChamp;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoChamp {

    @Query("SELECT * FROM Sampiyonlar")
    List<ModelChamp> getChamp();

    @Query("SELECT * FROM Sampiyonlar WHERE ID = :id")
    ModelChamp getChamp(int id);

    @Insert
    void addChamp(ModelChamp samp);

    @Insert
    void addChamp(ArrayList<ModelChamp> sampAll);

    @Query("DELETE FROM Sampiyonlar")
    void clear();
}
