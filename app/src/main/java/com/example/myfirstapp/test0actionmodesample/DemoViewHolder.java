package com.example.myfirstapp.test0actionmodesample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class DemoViewHolder extends RecyclerView.ViewHolder {

    public TextView title, sub_title;

    public DemoViewHolder(View view) {
        super(view);
        this.title = view.findViewById(R.id.title);
        this.sub_title = view.findViewById(R.id.sub_title);
    }
}