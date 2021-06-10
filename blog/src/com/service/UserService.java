package com.service;

import com.dao.UserDao;
import com.domain.Blog;
import com.domain.User;
import com.test.Main;
import com.util.Browser;
import com.view.LoginView;
import com.view.MainView;

import java.util.List;

public class UserService {

    private UserService() {}
    private static UserService us = new UserService();
    public static UserService getInstance() {
        return us;
    }


    public void checkLogin(String uname, String upass) {
        UserDao dao = new UserDao();
        User user = dao.findUserByNameAndPass(uname, upass);
        if (user == null) {
            // fail
            Browser.getInstance().showView(new LoginView());
        } else {
            // login succ, find recent tranding blogs
            List<Blog> bs = dao.findHotBlogs();
            MainView view = new MainView();
            view.setData(bs);
            Browser.getInstance().showView(view);
        }
    }
}
