package com.action;

import com.server.Action;
import com.server.Request;
import com.server.Response;

public class LoginAction implements Action {
    @Override
    public void control (Request request, Response response) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        System.out.println("LoginAction" + uname + upass);

        if ("lcy".equals(uname) && "123".equals(upass)) {
            response.append("Login success!");

        } else {
            response.sendRedirect("view/login.view");
        }




        /*UserService userService = new UserService();
        userService.checkLogin(uname, upass);*/
    }
}
