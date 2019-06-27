package com.enes.hextechsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogManagerInfo extends Dialog implements android.view.View.OnClickListener {
    private String msg;

    DialogManagerInfo(@NonNull Activity activity, String msg) {
        super(activity);
        this.msg = msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_ok);
        TextView textMsg = findViewById(R.id.dialog_ok_text_mesaj);
        textMsg.setText(msg);
        Button ok = findViewById(R.id.dialog_ok_buton_ok);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
