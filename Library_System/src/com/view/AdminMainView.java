package com.view;

import com.service.BookService;
import com.util.AbstractView;
import com.util.Browser;
import com.util.View;

import java.util.Scanner;

public class AdminMainView extends AbstractView {
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("**Aiden's Library Management System***");
        System.out.println("**************************************");
        System.out.println("1. Add a new book");
        System.out.println("2. Show book list");
        System.out.println("3. Edit a book");
        System.out.println("4. Remove a book");
        System.out.println("5. Drop a book");
        System.out.println("9. Exit");
        System.out.print("Please choose your operation: ");
        int num = input.nextInt();
        switch (num) {
            case 1:
                Browser.getInstance().showView(new AdminBookAddView());
                ;break;
            case 2:
                //Browser browser = Browser.getInstance();
                //browser.showView(view);
                BookService.getInstance().showBooks();
                ;break;
            case 3:;break;
            case 4:;break;
            case 5:;break;
            case 9:
                Browser.getInstance().showView(new SelectView());
                ;break;
        }
    }

    @Override
    public void setData(Object o) {

    }

}
