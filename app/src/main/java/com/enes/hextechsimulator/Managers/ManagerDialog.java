package com.enes.hextechsimulator.Managers;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enes.hextechsimulator.Models.ModelDialog;
import com.enes.hextechsimulator.R;
import com.enes.hextechsimulator.RootApp;

public class ManagerDialog extends Dialog implements android.view.View.OnClickListener {

    private ModelDialog mDialog;

    public ManagerDialog(@NonNull Activity activity, ModelDialog mDialog) {
        super(activity);
        this.mDialog = mDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);
        TextView viewMesaj = findViewById(R.id.dialog_mesaj);
        LinearLayout viewMainframe = findViewById(R.id.dialog_mainframe);
        LinearLayout viewErrorFrame = findViewById(R.id.dialog_error_frame);
        ImageView viewLogo = findViewById(R.id.dialog_mainlogo);
        Button viewBtnPos = findViewById(R.id.dialog_buton_pos);
        Button viewBtnNeg = findViewById(R.id.dialog_buton_neg);
        TextView viewErrorCode = findViewById(R.id.dialog_errorcode);

        viewMesaj.setText(mDialog.getMesaj());

        if (mDialog.getTip() == 1) { // info
            viewBtnNeg.setVisibility(View.GONE);
            viewErrorFrame.setVisibility(View.GONE);
            viewBtnPos.setText(RootApp.getContext().getResources().getText(R.string.sys_ok));
            viewMainframe.setBackground(RootApp.getContext().getResources().getDrawable(R.drawable.dialog_background));
            viewLogo.setImageResource(R.mipmap.icon_info);
        } else if (mDialog.getTip() == 2) { // hata
            if(mDialog.getErrorCode().isEmpty()) {
                viewErrorFrame.setVisibility(View.GONE);
            } else {
                viewErrorFrame.setVisibility(View.VISIBLE);
                viewErrorCode.setText(mDialog.getErrorCode());
            }
            viewBtnNeg.setVisibility(View.GONE);
            viewBtnPos.setText(RootApp.getContext().getResources().getText(R.string.sys_ok));
            viewMainframe.setBackground(RootApp.getContext().getResources().getDrawable(R.drawable.dialog_background_error));
            viewLogo.setImageResource(R.mipmap.icon_error);
        } else { // 3 soru
            viewErrorFrame.setVisibility(View.GONE);
            viewBtnNeg.setVisibility(View.VISIBLE);
            viewBtnPos.setText(mDialog.getBtnPos());
            viewBtnNeg.setText(mDialog.getBtnNeg());
            viewMainframe.setBackground(RootApp.getContext().getResources().getDrawable(R.drawable.dialog_background));
            viewLogo.setImageResource(R.mipmap.icon_question);
        }
    }

    @Override
    public void onClick(View view) {
        if (mDialog.getTip() != 3) dismiss();
    }
}
