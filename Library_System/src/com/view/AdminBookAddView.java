package com.view;

import com.service.BookService;
import com.util.AbstractView;

import java.util.Scanner;

/**
 * @author aidenli
 */
public class AdminBookAddView extends AbstractView {
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("**Aiden's Library Management System***");
        System.out.println("**************************************");
        System.out.print("Enter book number: ");
        int bnum = input.nextInt();
        System.out.print("Enter book name: ");
        String bname = input.next();
        System.out.print("Enter book author: ");
        String bauthor = input.next();
        System.out.print("Enter book type: ");
        String btype = input.next();

        BookService bookService = BookService.getInstance();
        bookService.addBook(bnum, bname, bauthor, btype);

    }

    @Override
    public void setData(Object objects) {

    }
}
