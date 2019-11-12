package com.example.thanya;

import android.graphics.Bitmap;

import java.io.Serializable;

public class NewsItems implements Serializable {
    String title;
    String content;


    String imgurl;
    String url;
    String state;
    String date;


    public NewsItems(String title, String content, String imgurl,

                     String url , String state , String date) {
        this.title = title;

        this.content = content;

        this.imgurl = imgurl;
        this.url = url;
        this.state = state;
        this.date=date;
    }

}
