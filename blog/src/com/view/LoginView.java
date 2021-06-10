package com.view;

import com.service.UserService;
import com.util.AbstractView;
import com.util.Input;

public class LoginView extends AbstractView {

    @Override
    public void show() {
        TitleInfo.showTitle();
        System.out.print("username: ");
        String uname = Input.next();
        System.out.print("password: ");
        String upass = Input.next();

        UserService.getInstance().checkLogin(uname, upass);
    }

    @Override
    public void setData(Object o) {

    }
}
