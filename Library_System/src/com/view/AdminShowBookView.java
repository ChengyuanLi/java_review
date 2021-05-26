package com.view;

import com.domain.Book;
import com.util.AbstractView;
import com.util.Box;
import com.util.Browser;

import java.util.Scanner;

public class AdminShowBookView extends AbstractView {
    private Box books;
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("**Aiden's Library Management System***");
        System.out.println("**************************************");
        if (books.size() == 0) {
            System.out.println("No books available");
        } else {
            for (int i = 0; i < books.size(); i++) {
                Book book = (Book) books.get(i);
                System.out.println(book.toString());
            }
        }
        System.out.println("Press any key to return: ");
        input.next();
        Browser.getInstance().showView(new AdminMainView());
    }

    @Override
    public void setData(Object objects) {
        this.books = (Box) objects;
    }
}
