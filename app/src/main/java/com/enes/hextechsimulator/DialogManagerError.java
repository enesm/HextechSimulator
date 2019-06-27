package com.enes.hextechsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogManagerError extends Dialog implements android.view.View.OnClickListener {
    private String msg;
    private String errorCode;

    DialogManagerError(@NonNull Activity activity, String msg, String errorCode) {
        super(activity);
        this.msg = msg;
        this.errorCode = errorCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_error);
        TextView textMsg = findViewById(R.id.dialog_error_text_mesaj);
        TextView textErrorCode = findViewById(R.id.dialog_error_text_errorcode);
        textMsg.setText(msg);
        if (errorCode != null) {
            textErrorCode.setText(errorCode);
        } else {
            TextView textErrorTag = findViewById(R.id.dialog_error_tag_errorcode);
            textErrorCode.setVisibility(View.GONE);
            textErrorTag.setVisibility(View.GONE);
        }
        Button ok = findViewById(R.id.dialog_error_buton_ok);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
