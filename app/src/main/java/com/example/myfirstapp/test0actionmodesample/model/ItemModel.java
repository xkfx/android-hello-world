package com.example.myfirstapp.test0actionmodesample.model;
import java.io.Serializable;

public class ItemModel implements Serializable {

    /*  Model class for List and Recycler Items  */
    private String title, subTitle;

    public ItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}