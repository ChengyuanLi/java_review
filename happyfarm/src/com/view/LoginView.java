package com.view;
import java.util.*;

import com.service.UserService;
import com.util.View;

public class LoginView implements View {

    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("******Aiden HAPPYFARM 1.0*************");
        System.out.println("**************************************");
        System.out.print("USERNAME: ");
        String uname = input.next();
        System.out.print("PASSWORD: ");
        String upass = input.next();

        UserService userService = UserService.getInstance();
        userService.checkLogin(uname, upass);
    }

    @Override
    public void setData(Object[] object) {

    }
}
