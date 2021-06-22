package com.action;

import com.Action;
import com.Request;
import com.Response;

/**
 * 注册功能控制类
 * @author aidenli
 */
public class RegisterAction implements Action {
    @Override
    public void service(Request request, Response response) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String repass = request.getParameter("repass");

        if (!upass.equals(repass)) {
            // password conflict
            response.sendDir("view/registerError.view");
        }
    }
}
