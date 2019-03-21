package com.example.myfirstapp.ex3;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class AlertDialogSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_2_alert_dialog_sample);
    }

    public void showAlertDialog(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(R.layout.ex3_2_custom_dialog)
                .show();
        Button cancel = dialog.findViewById(R.id.ex3_2_cancel);
        Button signIn = dialog.findViewById(R.id.ex3_2_sign_in);
        if (cancel != null) {
            cancel.setOnClickListener((v) -> {
                dialog.dismiss();
            });
        }
        if (signIn != null) {
            signIn.setOnClickListener((v) -> {
                EditText editText = dialog.findViewById(R.id.ex3_2_editText_username);
                if (editText != null) {
                    Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
