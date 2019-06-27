package com.enes.hextechsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.TextView;

public class DialogManagerYesNo extends Dialog {
    private String mesaj;

    DialogManagerYesNo(@NonNull Activity activity, String mesaj) {
        super(activity);
        this.mesaj = mesaj;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_yesno);
        TextView msg = findViewById(R.id.dialog_yesno_text_mesaj);
        msg.setText(mesaj);
    }
}
