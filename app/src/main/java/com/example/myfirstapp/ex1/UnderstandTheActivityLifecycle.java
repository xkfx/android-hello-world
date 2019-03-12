package com.example.myfirstapp.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myfirstapp.R;

/**
 * 参考文档：
 * https://developer.android.com/guide/components/activities/activity-lifecycle
 * 试验了文档所述的Activity的
 * 6个主要生命周期：onCreate、onStart、onResume、
 * onPause、onStop、onDestroy
 */
public class UnderstandTheActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("😀活动一", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understand_the_lifecycle);
    }

    @Override
    protected void onStart() {
        Log.d("😀😀😀活动一", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("😀😀😀活动一", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("😀😀😀活动一", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("😀😀😀活动一", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("😀😀😀活动一", "onDestroy");
        super.onDestroy();
    }

    public void goToActivity2(View view) {
        Log.d("😀😀😀活动一", "goToActivity2");
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }
}
