package com.Controller;

import com.service.Request;
import com.service.UserService;

import java.util.Map;

public class Controller {
    public void control(Request request) {

        if (request.getContent().equals("login")) {
            String uname = request.getParameter("uname");
            String upass = request.getParameter("upass");
            UserService us = new UserService();
            us.checkLogin(uname, upass);
        }
    }
}
