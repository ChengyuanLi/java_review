package com.service;

import com.dao.UserDao;
import com.domain.User;
import com.util.Browser;
import com.view.LoginView;

/**
 * 单例模式提供账号服务
 * @author aidenli
 */
public class UserService {

    private UserService() {}
    private static UserService userService = new UserService();
    public static UserService getUserService() {
        return userService;
    }


    public void checkLogin(String uname, String upass) {
        UserDao udao= new UserDao();
        User user = udao.findUserByNameAndPass(uname, upass);
        if (user == null) {
            //fail
            Browser.getInstance().showView(new LoginView());
        } else {
            //succ
        }
    }
}
