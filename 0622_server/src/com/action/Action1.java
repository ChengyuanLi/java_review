package com.action;

import com.Action;
import com.Request;
import com.Response;

public class Action1 extends Action {
    @Override
    public void service(Request request, Response response) {
        request.getSession().setAttribute("name", "lcy");
    }
}
