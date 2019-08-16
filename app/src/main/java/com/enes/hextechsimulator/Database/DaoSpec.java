package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.enes.hextechsimulator.Models.ModelSpec;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoSpec {

    @Query("SELECT * FROM Specials")
    List<ModelSpec> getSpecial();

    @Query("SELECT * FROM Specials WHERE ID = :id")
    ModelSpec getSpecial(int id);

    @Insert
    void addSpecial(ModelSpec special);

    @Insert
    void addSpecial(ArrayList<ModelSpec> specialAll);

    @Query("DELETE FROM Specials")
    void clear();

}
