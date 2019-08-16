package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.enes.hextechsimulator.Models.ModelSkin;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoSkin {

    @Query("SELECT * FROM Kostumler")
    List<ModelSkin> getSkin();

    @Query("SELECT * FROM Kostumler WHERE ID = :id")
    ModelSkin getSkin(int id);

    @Insert
    void addSkin(ModelSkin skin);

    @Insert
    void addSkin(ArrayList<ModelSkin> skinAll);

    @Query("DELETE FROM Kostumler")
    void clear();
}
