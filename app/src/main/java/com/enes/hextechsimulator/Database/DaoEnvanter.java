package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.enes.hextechsimulator.Models.ModelEnvanter;

import java.util.List;

@Dao
public interface DaoEnvanter {

    @Query("SELECT * FROM Envanter")
    List<ModelEnvanter> getEnvanter();

    @Insert
    void addToEnvanter(ModelEnvanter env);

    @Query("DELETE FROM Envanter WHERE grupID = :grupID AND esyaID = :esyaID")
    void removeFromEnvanter(int grupID, int esyaID);

    @Query("SELECT COUNT(*) FROM Envanter WHERE grupID = :grupID")
    int getGrupSayisi(int grupID);

    @Query("SELECT COUNT(*) FROM Envanter WHERE grupID = :grupID AND esyaID = :esyaID")
    int getEsyaSayisi(int grupID, int esyaID);

}
