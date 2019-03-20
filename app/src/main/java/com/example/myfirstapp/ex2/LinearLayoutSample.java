package com.example.myfirstapp.ex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myfirstapp.R;

/**
 * 解决用layout_weight调节横向布局占比时出现奇怪现象：
 * https://blog.csdn.net/yanzi1225627/article/details/24667299
 * 一句话：
 * Google官方推荐，当使用weight属性时，将width设为0dip即可，
 * 效果跟设成wrap_content是一样的。这样weight就可以理解为占比了！
 */
public class LinearLayoutSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex2_1_activity_linear_layout_test);
    }
}
