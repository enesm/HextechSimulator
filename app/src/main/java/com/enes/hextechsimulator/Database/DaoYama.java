package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface DaoYama {

    @Query("SELECT * FROM AktifYama")
    AktifYama getAktifYama();

    @Insert
    void setAktifYama(AktifYama newYama);

    @Query("DELETE FROM AktifYama")
    void clear();
}
