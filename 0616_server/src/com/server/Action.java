package com.server;

/**
 * 控制器的统一规范
 */
public interface Action {
    public void control(Request request, Response response) ;
}
