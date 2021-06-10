package com.view;

import com.util.AbstractView;
import com.util.Browser;
import com.util.Input;

/**
 * @author aidenli
 */
public class SelectView extends AbstractView {
    @Override
    public void setData(Object o) {
    }

    @Override
    public void show() {
        System.out.println("*************************************");
        System.out.println("***************WEIBO*****************");
        System.out.println("*************************************");
        System.out.println("1.LOGIN");
        System.out.println("2.SIGNIN");
        System.out.print("SELECT OPERATION:");
        int no = Input.nextRightInt(new int[]{1, 2});

        switch (no) {
            case 1:
                Browser.getInstance().showView(new LoginView());
                ; break;
            case 2:; break;
        }
    }

}
