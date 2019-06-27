package com.enes.hextechsimulator.Database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.enes.hextechsimulator.RootApp;

public class SequenceHelper extends SQLiteOpenHelper {

    SequenceHelper() {
        super(RootApp.getContext(), "Database", null, GrupTypes.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getDb() {
        return getWritableDatabase();
    }

}
