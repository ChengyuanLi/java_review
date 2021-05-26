package com.view;

import com.util.AbstractView;
import com.util.Browser;
import com.util.View;

import java.util.Scanner;

public class SelectView extends AbstractView {
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("**Aiden's Library Management System***");
        System.out.println("**************************************");
        System.out.println("1. You are Users");
        System.out.println("2. You are Admins");
        System.out.print("Please choose your operation: ");
        int num = input.nextInt();
        switch (num) {
            case 1:

                ;break;
            case 2:
                Browser browser = Browser.getInstance();
                View view = new AdminMainView();
                browser.showView(view);
                ;break;
        }

    }

    @Override
    public void setData(Object o) {

    }

}
