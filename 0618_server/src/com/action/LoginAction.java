package com.action;

import com.Action;
import com.Request;
import com.Response;

public class LoginAction implements Action {
    @Override
    public void service(Request request, Response response) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        if (uname.equals("lcy") && upass.equals("123")) {
            response.sendDir("view/main.view");
        } else {
            response.sendDir("view/login.view");
        }

    }
}
