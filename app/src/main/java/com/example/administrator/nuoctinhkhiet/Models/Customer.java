package com.example.administrator.nuoctinhkhiet.Models;

/**
 * Created by Administrator on 07/11/2017.
 */

public class Customer {
    String id,name,address, phoneNumber, picture;
    Boolean male;
    Integer age;
    public Customer(){

    }
    public Customer(String id, String name, Integer age, Boolean male, String address, String phoneNumber,String picture)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.male=male;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.picture=picture;
    }
}
