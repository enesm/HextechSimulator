package com.enes.hextechsimulator;

import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;

class ManagerSandik {
    private static final boolean DEBUG = false;
    private ArrayList<Sandik> sandiklarHepsi = new ArrayList<Sandik>();
    private Resources resources;

    ManagerSandik() {
        this.resources = RootApp.getContext().getResources();
        sandiklarHepsi.add(new Sandik(0, resources.getString(R.string.sandik_1), true, 1, 75.0, 30,
                30, 25, 14, 0.45, 0.45, 0.10, 0, 1, 30,
                70, 3, 1, true, true));

        sandiklarHepsi.add(new Sandik(1, resources.getString(R.string.sandik_2), true, 3, 100, 10,
                10, 20, 30, 10, 10, 10, 100, 100, 25,
                250, 5, 1, true, false));
    }

    Sandik getSandikById(int id) {
        if (DEBUG) Log.e("Sandıklar", sandiklarHepsi.toString());
        return sandiklarHepsi.get(id);
    }

    ArrayList<Sandik> getSandiklarHepsi() {
        return sandiklarHepsi;
    }
}
