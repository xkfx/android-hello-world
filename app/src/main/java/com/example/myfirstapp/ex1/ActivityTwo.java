package com.example.myfirstapp.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myfirstapp.R;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("♥活动二", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    protected void onStart() {
        Log.d("♥活动二", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("♥活动二", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("♥活动二", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("♥活动二", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("♥活动二", "onDestroy");
        super.onDestroy();
    }
}
