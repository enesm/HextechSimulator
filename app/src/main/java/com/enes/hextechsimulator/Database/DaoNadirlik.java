package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.enes.hextechsimulator.Models.ModelNadirlik;

import java.util.List;

@Dao
public interface DaoNadirlik {

    @Query("SELECT * FROM Nadirlikler")
    List<ModelNadirlik> getNadirlik();

    @Query("SELECT * FROM Nadirlikler WHERE level = :level")
    ModelNadirlik getNadirlik(int level);

    @Insert
    void addNadirlik(ModelNadirlik nadirlik);

    @Query("DELETE FROM Nadirlikler")
    void clear();
}
