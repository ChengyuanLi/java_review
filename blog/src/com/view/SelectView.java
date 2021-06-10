package com.view;

import com.util.AbstractView;
import com.util.Browser;
import com.util.Input;

/**
 * 主视图
 * @author aidenli
 */
public class SelectView extends AbstractView {

    @Override
    public void show() {
        TitleInfo.showTitle();
        System.out.println("1, login");
        System.out.println("2, sign in");
        System.out.print("select your operation: ");
        int num = Input.nextRightInt(new int[]{1, 2});
        switch (num) {
            case 1:
                Browser.getInstance().showView(new LoginView());
                ; break;
            case 2:

                ; break;
        }
    }

    @Override
    public void setData(Object o) {

    }
}
