package com.test;

import com.util.Browser;
import com.view.SelectView;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Browser.getInstance().showView(new SelectView());
    }
}
