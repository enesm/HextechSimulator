package com.enes.hextechsimulator.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.enes.hextechsimulator.Adapters.SettingListViewAdapter;
import com.enes.hextechsimulator.BuildConfig;
import com.enes.hextechsimulator.Database.Db;
import com.enes.hextechsimulator.Models.ModelSetting;
import com.enes.hextechsimulator.R;
import com.enes.hextechsimulator.RootApp;

import java.util.ArrayList;

public class ActivityAbout extends AppCompatActivity {

    private ArrayList<ModelSetting> listItems;
    private ListView list;
    private SettingListViewAdapter adapter;
    private Db db;
    private int debugCounter = 7;
    private Toast tost;
    private Activity activity;
    private AlertDialog.Builder builder;
    private boolean isBuilderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        db = Db.getDb();
        activity = this;
        init();
        populate();
        isBuilderShow = false;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    if (debugCounter == 1) {
                        if (!isBuilderShow) enabler();
                    } else {
                        debugCounter--;
                        if (debugCounter < 4) {
                            if (tost != null) tost.cancel();
                            tost = Toast.makeText(RootApp.getContext(), "Debug Menu: " + debugCounter, Toast.LENGTH_SHORT);
                            tost.show();
                        }
                    }
                }
            }
        });
    }

    private void init() {
        listItems = new ArrayList<>();
        list = findViewById(R.id.list_about);
        adapter = new SettingListViewAdapter(ActivityAbout.this, listItems);
        list.setAdapter(adapter);
    }

    private void populate() {
        // TODO: resources dan cek dil icin
        listItems.add(new ModelSetting(getString(R.string.app_name), "", false, R.mipmap.icon_info));
        listItems.add(new ModelSetting("Aktif Yama Versiyonu", db.daoYama().getAktifYama().getYama(), false, R.mipmap.icon_info));
        listItems.add(new ModelSetting("Versiyon", BuildConfig.VERSION_NAME, false, R.mipmap.icon_info));
        listItems.add(new ModelSetting("Versiyon Kodu", String.valueOf(BuildConfig.VERSION_CODE), false, R.mipmap.icon_info));
    }

    private void enabler() {
        builder = new AlertDialog.Builder(activity);
        builder.setTitle("DEBUG");
        final EditText input = new EditText(activity);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String pass = input.getText().toString();
                // TODO: Anasayfa debug menu aktiflestir.
                isBuilderShow = pass.equals("cimbom123");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                isBuilderShow = false;
            }
        });

        builder.show();
        isBuilderShow = true;
    }
}
