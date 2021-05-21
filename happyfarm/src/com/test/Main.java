package com.test;

import com.util.Browser;
import com.util.View;
import com.view.LoginView;

public class Main {

    public static void main(String[] args) {
	// write your code here
        View view = new LoginView();
        Browser browser = Browser.getInstance();
        browser.showView(view);
    }
}
