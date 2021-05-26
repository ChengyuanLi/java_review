package com.test;

import com.util.Browser;
import com.util.View;
import com.view.SelectView;

/**
 * @author aidenli
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        //显示前后台选择界面
        Browser browser = Browser.getInstance();
        View view = new SelectView();
        browser.showView(view);
    }
}
