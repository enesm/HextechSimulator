package com.enes.hextechsimulator.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.enes.hextechsimulator.Models.ModelChamp;
import com.enes.hextechsimulator.Models.ModelEnvanter;
import com.enes.hextechsimulator.Models.ModelPlayer;
import com.enes.hextechsimulator.Models.ModelSandik;
import com.enes.hextechsimulator.Models.ModelSkin;
import com.enes.hextechsimulator.Models.ModelSpec;
import com.enes.hextechsimulator.RootApp;

@Database(entities = {AktifYama.class, ModelSandik.class, ModelSkin.class, ModelChamp.class, ModelPlayer.class, ModelSpec.class,
        ModelEnvanter.class}, version = GrupTypes.DATABASE_VERSION,
        exportSchema = false)
public abstract class Db extends RoomDatabase {

    private static final boolean DEBUG = true;
    private static Db INSTANCE;
    // TODO: Player tablosu bazı durumlarda siliniyor.
    public abstract DaoPlayer daoPlayer();
    public abstract DaoChamp daoChamp();
    public abstract DaoSkin daoSkin();
    public abstract DaoSandik daoSandik();
    public abstract DaoSpec daoSpec();
    public abstract DaoEnvanter daoEnvanter();
    public abstract DaoYama daoYama();
    //public abstract DaoPlayer daoItem();

    public static Db getDb() {
        if (INSTANCE == null) {
            synchronized (Db.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(RootApp.getContext().getApplicationContext(), Db.class, "Database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
