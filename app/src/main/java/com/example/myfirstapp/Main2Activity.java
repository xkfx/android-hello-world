package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapp.ex1.UnderstandTheActivityLifecycle;
import com.example.myfirstapp.ex2.ConstraintLayoutSample;
import com.example.myfirstapp.ex2.LinearLayoutSample;
import com.example.myfirstapp.ex2.TableLayoutSample;
import com.example.myfirstapp.ex3.AlertDialogSample;
import com.example.myfirstapp.ex3.ListViewSample;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex0_activity_main2);
    }

    public void ex1(View view) {
        Intent intent = new Intent(this, UnderstandTheActivityLifecycle.class);
        startActivity(intent);
    }

    public void ex2_1(View view) {
        Intent intent = new Intent(this, LinearLayoutSample.class);
        startActivity(intent);
    }

    public void ex2_2(View view) {
        Intent intent = new Intent(this, ConstraintLayoutSample.class);
        startActivity(intent);
    }

    public void ex2_3(View view) {
        Intent intent = new Intent(this, TableLayoutSample.class);
        startActivity(intent);
    }

    public void ex3_1(View view) {
        Intent intent = new Intent(this, ListViewSample.class);
        startActivity(intent);
    }

    public void ex3_2(View view) {
        Intent intent = new Intent(this, AlertDialogSample.class);
        startActivity(intent);
    }
}
