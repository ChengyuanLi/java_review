package com.Controller;

import com.Service.UserService;

public class Controller {
    public void control(String content) {
        if (content.equals("login")) {
            UserService us = new UserService();
            us.checkLogin();
        }
    }
}
