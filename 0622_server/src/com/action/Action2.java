package com.action;

import com.Action;
import com.Request;
import com.Response;

public class Action2 extends Action {
    @Override
    public void service(Request request, Response response) {
        String name = (String) request.getSession().getAttribute("name");
        System.out.println("======> " + name);
    }
}
