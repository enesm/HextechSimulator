package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

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
