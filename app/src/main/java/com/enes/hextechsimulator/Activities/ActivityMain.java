package com.enes.hextechsimulator.Activities;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.enes.hextechsimulator.Animations.AnimationProgressBar;
import com.enes.hextechsimulator.Database.Db;
import com.enes.hextechsimulator.Database.GrupTypes;
import com.enes.hextechsimulator.Database.DatabaseManager;
import com.enes.hextechsimulator.Managers.ManagerDialog;
import com.enes.hextechsimulator.Models.ModelDialog;
import com.enes.hextechsimulator.Models.ModelEnvanter;
import com.enes.hextechsimulator.R;
import com.enes.hextechsimulator.RootApp;

public class ActivityMain extends AppCompatActivity {
    private static final boolean DEBUG = true;
    private static final int UI_TEXT_CHANGE_TIME = 2750; /* UI sayı arttırma animasyon süresi */
    Activity activity;
    PopupWindow changeStatusPopUp;
    Db db;

    private TextView textBe;
    private TextView textOe;
    private TextView textGem;
    private TextView textKey;
    private TextView textChest;
    private TextView textLevel;
    private ProgressBar progressExp;
    private Button butonStore;
    private Button butonDebug;
    private Button butonAyarlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ActivityMain.this, ActivitySplash.class));
            }
        }).start();

        // TODO: Log sistemi.
        // TODO: Smooth envanter scroll.

        activity = this;
        db = Db.getDb();
        DatabaseManager.init();

        textBe = findViewById(R.id.text_mo);
        textOe = findViewById(R.id.text_to);
        textGem = findViewById(R.id.text_gem);
        textKey = findViewById(R.id.text_anahtar);
        textChest = findViewById(R.id.text_sandik);
        textLevel = findViewById(R.id.text_level);
        progressExp = findViewById(R.id.progress_exp);
        butonStore = findViewById(R.id.main_buton_store);
        butonDebug = findViewById(R.id.main_buton_debug_menu);
        butonAyarlar = findViewById(R.id.main_buton_settings);

        changeStatusPopUp = new PopupWindow(activity);

        butonAyarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityMain.this, ActivitySettings.class));
            }
        });
        butonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityMain.this, ActivityStore.class));
            }
        });
        butonDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setTitle("Debug Menu");
                String[] options = {"Sampiyon Ekle", "Kostum Ekle", "Mavi Oz Ekle", "Turuncu Oz Ekle", "Cevher Ekle", "Level Ekle", "Exp Ekle", "Sandik Ekle", "Anahtar Ekle"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                //
                            case 1:
                                //
                            case 2:
                                addBe(83);
                                break;
                            case 3:
                                addOe(39);
                                break;
                            case 4:
                                addGem(1);
                                break;
                            case 5:
                                addLevel();
                                break;
                            case 6:
                                addExp(132);
                                break;
                            case 7:
                                addChest(1);
                                break;
                            case 8:
                                addKey(1);
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //final RecyclerView recyclerView = findViewById(R.id.grid_envanter);
        //recyclerView.setHasFixedSize(true);

        //View header = LayoutInflater.from(this).inflate(R.layout.adapter_separator, recyclerView, false);
        /*final AdapterEnvanterOld adapter = new AdapterEnvanterOld(activity, databaseOld, new AdapterEnvanterOld.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, Item item, int position) {
                if (!changeStatusPopUp.isShowing()) {
                    if (DEBUG)
                        Log.e("İsim:", item.getIsim() + " ID:" + String.valueOf(item.getId()) + " itemTip:" + String.valueOf(item.getItemTip()));
                    int[] location = new int[2];
                    //int currentRowId = position;
                    //View currentRow = v;
                    v.getLocationOnScreen(location);

                    //Initialize the Point with x, and y positions
                    Point point = new Point();
                    point.x = location[0];
                    point.y = location[1];

                    // TODO: Materyal öğelerine tıklayınca da popup açılıyor
                    // TODO: Tıklanan itemin çerçevesini değiştir
                    if (item.getItemTip() == 1 || item.getItemTip() == 2) {
                        onShardClick(v, item, point);
                    }
                }
            }
        });
        final GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.isHeader(position)) {
                    return manager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setAdapter(adapter);

        final Runnable runnableGui = new Runnable() {
            @Override
            public void run() {
                adapter.envanterDuzenle();
                adapter.notifyDataSetChanged();
            }
        };

        Timer timerEnvanterUpdate = new Timer();
        TimerTask envanterTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (databaseOld.isEnvanterUpdated()) {
                            adapter.envanterDuzenle();
                            adapter.notifyDataSetChanged();
                            if (DEBUG) Log.e("envanterThread", "runned.");
                        }
                    }
                });
            }
        };
        timerEnvanterUpdate.scheduleAtFixedRate(envanterTask, 0, 1000);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    /*
    private void onShardClick(View view, Item item, Point p) {
        int itemId = item.getId();
        int itemTip = item.getItemTip();
        RelativeLayout viewGroup = activity.findViewById(R.id.popup_envanter_menu);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater != null) {
            View layoutEnvanterPopup = layoutInflater.inflate(R.layout.popup_envanter_item, viewGroup);

            changeStatusPopUp.setContentView(layoutEnvanterPopup);
            changeStatusPopUp.setFocusable(true);

            if (DEBUG) Log.e("X", String.valueOf(p.x) + " Y:" + String.valueOf(p.y));
            int OFFSET_X = view.getMeasuredWidth();
            int OFFSET_Y = -view.getMeasuredHeight();

            changeStatusPopUp.showAtLocation(layoutEnvanterPopup, Gravity.START, p.x + OFFSET_X, p.y + OFFSET_Y);
            //changeStatusPopUp.showAsDropDown(layout, p.x + OFFSET_X, p.y + OFFSET_Y, Gravity.CENTER);

            TextView textItemName = layoutEnvanterPopup.findViewById(R.id.popup_envanter_item_name);
            TextView textGenelName = layoutEnvanterPopup.findViewById(R.id.popup_envanter_item_genel_name);
            TextView textMevcutDurum = layoutEnvanterPopup.findViewById(R.id.popup_envanter_samp_mevcut_degil);
            if (itemTip == 1) {
                if (databaseOld.isSampMevcut(itemId)) {
                    textMevcutDurum.setText(getResources().getText(R.string.popup_mevcut));
                    textMevcutDurum.setBackground(getResources().getDrawable(R.drawable.popup_not_available));
                } else {
                    textMevcutDurum.setText(getResources().getText(R.string.popup_acilabilir));
                    textMevcutDurum.setBackground(getResources().getDrawable(R.drawable.popup_available));
                }
            } else if (itemTip == 2) {
                if (databaseOld.isKostumMevcut(item.getId())) {
                    textMevcutDurum.setText(getResources().getText(R.string.popup_mevcut));
                    textMevcutDurum.setBackground(getResources().getDrawable(R.drawable.popup_not_available));
                } else {
                    if (databaseOld.isSampMevcut(new ManagerKostum().getKostumById(itemId).getSampId())) {
                        textMevcutDurum.setText(getResources().getText(R.string.popup_acilabilir));
                        textMevcutDurum.setBackground(getResources().getDrawable(R.drawable.popup_available));
                    } else {
                        textMevcutDurum.setText(getResources().getText(R.string.popup_samp_mevcut_degil));
                        textMevcutDurum.setBackground(getResources().getDrawable(R.drawable.popup_not_available));
                    }
                }
            }

            TextView textAyristir = layoutEnvanterPopup.findViewById(R.id.popup_layer_ayristir_text);
            TextView textAyristirAciklama = layoutEnvanterPopup.findViewById(R.id.popup_layer_ayristir_aciklama);
            TextView textAyristirOz = layoutEnvanterPopup.findViewById(R.id.popup_envanter_ayristir_oz);

            TextView textGelistir = layoutEnvanterPopup.findViewById(R.id.popup_layer_gelistir_text);
            TextView textGelistirAciklama = layoutEnvanterPopup.findViewById(R.id.popup_layer_gelistir_aciklama);
            TextView textGelistirOz = layoutEnvanterPopup.findViewById(R.id.popup_envanter_gelistir_oz);

            RelativeLayout butonYenidenIsle = layoutEnvanterPopup.findViewById(R.id.popup_layer_yeniden_isle);
            RelativeLayout butonGelistir = layoutEnvanterPopup.findViewById(R.id.popup_layer_gelistir);
            RelativeLayout butonAyristir = layoutEnvanterPopup.findViewById(R.id.popup_layer_ayristir);

            ImageView imgAyristirIkon = layoutEnvanterPopup.findViewById(R.id.popup_envanter_ayristir_icon);
            ImageView imgGelistirIkon = layoutEnvanterPopup.findViewById(R.id.popup_envanter_gelistir_icon);

            textItemName.setText(item.getIsim());
            textGenelName.setText(item.getGenelIsim());
            if (itemTip == 1) {
                butonYenidenIsle.setVisibility(View.GONE);
                SampiyonKristali samp = databaseOld.getSampKristalById(item.getId());
                textAyristirOz.setText(String.valueOf(samp.getFiyatMo()));
                textGelistirOz.setText(String.valueOf(samp.getFiyatIp()));
                imgAyristirIkon.setImageResource(R.mipmap.icon_mo);
                imgGelistirIkon.setImageResource(R.mipmap.icon_mo);
            } else if (itemTip == 2) {
                KostumKristali kostum = databaseOld.getKostumKristalById(item.getId());
                textAyristirOz.setText(String.valueOf(kostum.getFiyatTo()));
                textGelistirOz.setText(String.valueOf(kostum.getFiyatRp()));
                imgAyristirIkon.setImageResource(R.mipmap.icon_to);
                imgGelistirIkon.setImageResource(R.mipmap.icon_to);
            }

            butonYenidenIsle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DEBUG) Log.e("Yeniden İşle", "basıldı.");
                    changeStatusPopUp.dismiss();
                }
            });

            butonAyristir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DEBUG) Log.e("Ayrıştır", "basıldı.");
                    changeStatusPopUp.dismiss();
                }
            });

            butonGelistir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DEBUG) Log.e("Geliştir", "basıldı.");
                    changeStatusPopUp.dismiss();
                }
            });

            changeStatusPopUp.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    // Dismiss listener
                }
            });
        }
    }*/

    private void updateTextBe() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textBe != null) {
                    changeValueWithAnimation(textBe, db.daoPlayer().getBe());
                }
            }
        });
    }

    public void addBe(final int be) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().setBe(db.daoPlayer().getBe() + be);
                updateTextBe();
            }
        }).start();
    }

    private void updateTextOe() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textOe != null) {
                    changeValueWithAnimation(textOe, db.daoPlayer().getOe());
                }
            }
        });
    }

    public void addOe(final int oe) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().setOe(db.daoPlayer().getOe() + oe);
                updateTextOe();
            }
        }).start();
    }

    private void updateTextGem() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textGem != null) {
                    changeValueWithAnimation(textGem, db.daoEnvanter().getEsyaSayisi(GrupTypes.GRUP_SPECIAL, GrupTypes.ITEM_CEVHER));
                }
            }
        });
    }

    public void addGem(final int gem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < gem; i++) {
                    db.daoEnvanter().addToEnvanter(new ModelEnvanter(GrupTypes.GRUP_SPECIAL, GrupTypes.ITEM_CEVHER));
                }
                updateTextGem();
            }
        }).start();
    }

    private void updateTextKey() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textKey != null) {
                    changeValueWithAnimation(textKey, db.daoPlayer().getKeyAmount());
                }
            }
        });
    }

    public void addKey(final int key) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().setKeyAmount(db.daoPlayer().getKeyAmount() + key);
                updateTextKey();
            }
        }).start();
    }

    private void updateTextChest() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textChest != null) {
                    changeValueWithAnimation(textChest, db.daoEnvanter().getGrupSayisi(GrupTypes.GRUP_SANDIK));
                }
            }
        });
    }

    public void addChest(final int sandikId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoEnvanter().addToEnvanter(new ModelEnvanter(GrupTypes.GRUP_SANDIK, sandikId));
                updateTextChest();
            }
        }).start();
    }

    private void updateProgressExp() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (DEBUG)
                    Log.e("Current Exp", db.daoPlayer().getPlayer().getExp() + " Next Exp: " +
                            db.daoPlayer().getNextExp());
                progressExp.setMax(db.daoPlayer().getNextExp());
                AnimationProgressBar anim = new AnimationProgressBar(progressExp, progressExp.getProgress(),
                        db.daoPlayer().getExp());
                anim.setDuration(900);
                progressExp.startAnimation(anim);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        checkLevelUp();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    private void checkLevelUp() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int curExp = db.daoPlayer().getExp();
                int nexExp = db.daoPlayer().getNextExp();
                if (curExp >= nexExp) {
                    addLevel();
                    progressExp.setProgress(0);
                    db.daoPlayer().setExp(curExp - nexExp);
                    db.daoPlayer().setNextExp(db.daoPlayer().getNextExp() + 200);
                    updateProgressExp();
                }
            }
        });
    }

    public void addExp(final int exp) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().addExp(exp);
                updateProgressExp();
            }
        }).start();
    }

    private void updateTextLevel() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (textLevel != null) {
                    final int curLevel = db.daoPlayer().getLevel();
                    int curLevelText = Integer.parseInt(textLevel.getText().toString());
                    if (curLevel != curLevelText) {
                        final AlphaAnimation animFadeIn = new AlphaAnimation(0.0f, 1.0f);
                        AlphaAnimation animFadeOut = new AlphaAnimation(1.0f, 0.0f);
                        animFadeIn.setDuration(50);
                        animFadeOut.setDuration(250);
                        textLevel.startAnimation(animFadeOut);
                        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                textLevel.setText(String.valueOf(curLevel));
                                textLevel.startAnimation(animFadeIn);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }
            }
        });
    }

    private void addLevel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().setLevel(db.daoPlayer().getLevel() + 1);
                updateTextLevel();
            }
        }).start();
    }

    private void addLevel(final int level) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.daoPlayer().setLevel(db.daoPlayer().getLevel() + level);
                updateTextLevel();
            }
        }).start();
    }

    public void updateUi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateTextBe();
                updateTextOe();
                updateTextGem();
                updateTextKey();
                updateTextChest();
                updateTextLevel();
                updateProgressExp();
            }
        }).start();
    }

    private void changeValueWithAnimation(final TextView text, final int value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int curVal = Integer.valueOf(text.getText().toString());
                final ValueAnimator anim = ValueAnimator.ofInt(curVal, value);
                if (Math.abs(curVal - value) > 1) {
                    anim.setDuration(UI_TEXT_CHANGE_TIME);
                } else anim.setDuration(20);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        text.setText(anim.getAnimatedValue().toString());
                    }
                });
                anim.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        /*final DialogManagerYesNo dialogAsk = new DialogManagerYesNo(activity, activity.getResources().getString(R.string.sys_exit_prompt));
        dialogAsk.show();
        Button pos = dialogAsk.findViewById(R.id.dialog_buton_yes);
        Button neg = dialogAsk.findViewById(R.id.dialog_buton_no);
        pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAsk.dismiss();
                ActivityMain.super.onBackPressed();
            }
        });
        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAsk.dismiss();
            }
        });*/

        final ManagerDialog dialog = new ManagerDialog(activity, new ModelDialog(activity.getResources().getString(R.string.sys_exit_prompt),
                activity.getResources().getString(R.string.sys_evet), activity.getResources().getString(R.string.sys_hayir)));
        dialog.show();
        Button pos = dialog.findViewById(R.id.dialog_buton_pos);
        Button neg = dialog.findViewById(R.id.dialog_buton_neg);
        pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                ActivityMain.super.onBackPressed();
            }
        });
        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (changeStatusPopUp.isShowing()) {
            changeStatusPopUp.dismiss();
            if (DEBUG) Log.e("onDestroy", "popup leak protected.");
        }
        db.close();
        super.onDestroy();
    }

    /*private void sandikAc(int sandikId) {
        Sandik sandik = cm.getSandikById(sandikId);
        try {
            JSONObject sandikIcerik = sandik.getIcerik();
            JSONArray sandikKristaller = sandikIcerik.getJSONArray("contents");
            JSONArray sandikExtra = sandikIcerik.getJSONArray("extras");
            if (DEBUG) Log.e("Sandık İçeriği", sandikIcerik.toString());
            for (int i=0; i < sandikKristaller.length(); i++) {
                if (sandikIcerik.getInt("contentType") == 1) {
                    Toast.makeText(this, "Şampiyon: "+sm.getSamp(sandikKristaller.getInt(i)).getIsim(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Kostüm: "+km.getKostum(sandikKristaller.getInt(i), sandik.isHatiraIcerikMevcut(),
                            sandik.isMevcutOlmayanIcerikMevcut()).getIsim(), Toast.LENGTH_SHORT).show();
                }
            }
            for (int j=0; j < sandikExtra.length(); j+=2) {
                int miktar = sandikExtra.getInt(j+1);
                String itemName = ItemTip.getIsim(sandikExtra.getInt(j));
                Toast.makeText(this, String.valueOf(miktar)+"x "+itemName, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/

}
