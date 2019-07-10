package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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
