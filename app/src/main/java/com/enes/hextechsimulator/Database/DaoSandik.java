package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.enes.hextechsimulator.Models.ModelSandik;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoSandik {

    @Query("SELECT * FROM Sandiklar")
    List<ModelSandik> getSandik();

    @Query("SELECT * FROM Sandiklar WHERE ID = :id")
    ModelSandik getSandik(int id);

    @Insert
    void addSandik(ModelSandik sandik);

    @Insert
    void addSandik(ArrayList<ModelSandik> sandikAll);

    @Query("DELETE FROM Sandiklar")
    void clear();
}
