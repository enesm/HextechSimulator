package com.enes.hextechsimulator.Database;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.annotation.NonNull;

import com.enes.hextechsimulator.Models.ModelChamp;
import com.enes.hextechsimulator.Models.ModelEnvanter;
import com.enes.hextechsimulator.Models.ModelNadirlik;
import com.enes.hextechsimulator.Models.ModelPlayer;
import com.enes.hextechsimulator.Models.ModelSandik;
import com.enes.hextechsimulator.Models.ModelSkin;
import com.enes.hextechsimulator.Models.ModelSpec;
import com.enes.hextechsimulator.RootApp;

@Database(entities = {AktifYama.class, ModelSandik.class, ModelSkin.class, ModelChamp.class, ModelPlayer.class, ModelSpec.class,
        ModelEnvanter.class, ModelNadirlik.class}, version = GrupTypes.DATABASE_VERSION,
        exportSchema = false)
public abstract class Db extends RoomDatabase {

    private static final boolean DEBUG = true;
    private static Db INSTANCE;

    public abstract DaoPlayer daoPlayer();

    public abstract DaoChamp daoChamp();

    public abstract DaoSkin daoSkin();

    public abstract DaoSandik daoSandik();

    public abstract DaoSpec daoSpec();

    public abstract DaoEnvanter daoEnvanter();

    public abstract DaoYama daoYama();

    public abstract DaoNadirlik daoNadirlik();
    //public abstract DaoPlayer daoItem();

    private static final Migration MIGRATION_PLAYER = new Migration(2, 1) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //
        }
    };

    public static Db getDb() {
        if (INSTANCE == null) {
            synchronized (Db.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(RootApp.getContext().getApplicationContext(), Db.class, "Database")
                            .allowMainThreadQueries()
                            //.fallbackToDestructiveMigration() // Schema guncellemesinde tum veritabani drop
                            .addMigrations(MIGRATION_PLAYER)
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
