package com.example.administrator.nuoctinhkhiet.Models;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 04/11/2017.
 */

public class A {
    public String  name;
    public Bitmap image;
    public Integer cost;
    public A(){

    }
    public A(String name, Bitmap image, Integer cost)
    {
        this.name=name;
        this.image=image;
        this.cost=cost;
    }
}
