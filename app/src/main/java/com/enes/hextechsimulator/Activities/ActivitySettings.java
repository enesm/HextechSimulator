package com.enes.hextechsimulator.Activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.enes.hextechsimulator.Models.ModelSetting;
import com.enes.hextechsimulator.R;
import com.enes.hextechsimulator.Adapters.SettingListViewAdapter;

import java.util.ArrayList;

public class ActivitySettings extends AppCompatActivity {

    private ArrayList<ModelSetting> settings;
    private ListView listSettings;
    private SettingListViewAdapter settingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
        populateList();
        listSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 4) {
                    startActivity(new Intent(ActivitySettings.this, ActivityAbout.class));
                }
            }
        });
    }

    private void init() {
        settings = new ArrayList<>();
        listSettings = findViewById(R.id.list_settings);
        settingsAdapter = new SettingListViewAdapter(ActivitySettings.this, settings);
        listSettings.setAdapter(settingsAdapter);

    }

    private void populateList() {
        //TODO: Metinleri resources dan cek.
        settings.add(new ModelSetting("Sesler", "Tüm ses efektlerini aç/kapa.", true, R.drawable.ic_settings));
        settings.add(new ModelSetting("Arkaplan Müziği", "Arkaplanda çalan müzikleri aç/kapa.", true, R.drawable.ic_settings, R.color.colorErrorLightRed));
        settings.add(new ModelSetting("Otomatik Dönüştürme", "Elde edilen her şeyi öze dönüştür.", true, R.drawable.ic_settings, R.color.colorGreyBronz));
        settings.add(new ModelSetting("Düşük Otomatik Dönüştürme", "Elde edilen değersiz her şeyi öze dönüştür.", true, R.drawable.ic_settings, R.color.colorFrameGoldEnd));
        settings.add(new ModelSetting("Hakkında", getString(R.string.app_name) + " hakkında.", false, R.drawable.ic_settings, R.color.colorGoldYellow));
    }
}
