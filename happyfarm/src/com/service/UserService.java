package com.service;

import com.domain.Farm;
import com.domain.Seed;
import com.domain.User;
import com.store.UserStore;
import com.util.Browser;
import com.util.View;
import com.view.FarmView;
import com.view.LoginView;
import com.view.MainView;

/**
 * @author aidenli
 */
public class UserService {
    private UserService(){}
    private static UserService userService = new UserService();
    public static UserService getInstance() {
        return userService;
    }

    private User loginUser;
    // current user info
    public void checkLogin(String uname, String upass){
        UserStore userStore = UserStore.getInstance();
        User user = userStore.findUserByName(uname);
        if (user != null && user.getUpass().equals(upass)) {
            //success
            this.loginUser = user;
            View view = new MainView();
            Browser browser = Browser.getInstance();
            browser.showView(view);
            return;
        }
        // fail
        View view = new LoginView();
        Browser browser = Browser.getInstance();
        browser.showView(view);
    }

    public void getCurrentFarmToShow() {
        Farm farm = this.loginUser.getFarm();
        View view = new FarmView();
        view.setData(new Object[]{farm});
        Browser browser = Browser.getInstance();
        browser.showView(view);
    }

    public void water(int row, int col){
        Seed seed = this.loginUser.getFarm().getFarm()[row - 1][col - 1];
        if (seed == null || seed.getFlag() == 2) {
            // cant water view
            return;
        }
        seed.setFlag(seed.getFlag() + 1);
        // water success
        this.getCurrentFarmToShow();
    }
}
