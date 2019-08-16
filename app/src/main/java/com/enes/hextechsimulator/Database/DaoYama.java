package com.enes.hextechsimulator.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DaoYama {

    @Query("SELECT * FROM AktifYama")
    AktifYama getAktifYama();

    @Insert
    void setAktifYama(AktifYama newYama);

    @Query("DELETE FROM AktifYama")
    void clear();
}
