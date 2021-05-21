package com.util;

/**
 * @author aidenli
 */
public class Browser {
    //singleton
    private Browser() {}
    private static Browser b = new Browser();
    public static Browser getInstance() {
        return b;
    }
    //------------------------------------
    public void showView(View view) {
        view.show();
    }
}
