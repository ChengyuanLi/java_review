package com.store;

import com.domain.Book;
import com.util.ArrayBox;
import com.util.Box;

import javax.swing.*;

/**
 * @author aidenli
 */
public class BookStore {
    private BookStore(){};
    private static BookStore bookStore;
    public static BookStore getInstance() {
        if (bookStore == null) {
            bookStore = new BookStore();
        }
        return bookStore;
    }

    private Box books = new ArrayBox();
    {
        Book b1 = new Book(1001, "三国演义", "罗贯中", "历史");
        Book b2 = new Book(1002, "水浒传", "施耐庵", "历史");
        Book b3 = new Book(1003, "红楼梦", "曹雪芹", "言情");
        Book b4 = new Book(1004, "西游记", "吴承恩", "玄幻");
        Book b5 = new Book(1005, "封神榜", "司马光", "仙侠");
        Book b6 = new Book(1006, "三国演义", "罗贯中", "历史");
        Book b7 = new Book(1007, "三国演义", "罗贯中", "历史");

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
    }
    public void save(Book book) {
        books.add(book);
    }

    public Box findBooks() {
        return books;
    }
}
