package com.example.administrator.nuoctinhkhiet.Models;

/**
 * Created by Administrator on 07/11/2017.
 */

public class Account {
    public String phoneNumber, password,status,activationDate;
    public Integer rightId;
    public Account()
    {

    }
    public Account(String phoneNumber,String password,Integer rightId, String status,String activationDate)
    {
        this.phoneNumber=phoneNumber;
        this.password=password;
        this.rightId=rightId;
        this.status=status;
        this.activationDate=activationDate;
    }

}
