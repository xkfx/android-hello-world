package com.example.myfirstapp.ex4;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.myfirstapp.R;

public class PrefFragmentSample extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从xml文件加载选项
        addPreferencesFromResource(R.xml.preferences_ex4);
    }
}