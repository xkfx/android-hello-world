package com.example.myfirstapp.ex3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapp.R;

public class AlertDialogSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_2_alert_dialog_sample);
    }

    public void showAlertDialog01(View view) {
        new AlertDialog.Builder(this)
                .setView(R.layout.ex3_2_custom_dialog)
                .show();
    }
}
