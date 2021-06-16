package com.service;

public class UserService {
    public void checkLogin(String uname, String upass){
        System.out.println("Checking Login");
        System.out.println(uname + ", " + upass);
        if (uname.equals("lcy") && upass.equals("123")) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }

    }
}
