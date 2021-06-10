package com.view;

import com.service.UserService;
import com.util.AbstractView;
import com.util.Input;

import javax.xml.ws.Service;

public class LoginView extends AbstractView {
    @Override
    public void setData(Object o) {

    }

    @Override
    public void show() {
        System.out.println("*************************************");
        System.out.println("***************WEIBO*****************");
        System.out.println("*************************************");
        System.out.print("username: ");
        String uname = Input.next();
        System.out.print("password: ");
        String upass = Input.next();

        UserService.getUserService().checkLogin(uname, upass);
    }
}
