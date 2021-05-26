package com.service;

import com.domain.Book;
import com.store.BookStore;
import com.util.Box;
import com.util.Browser;
import com.util.View;
import com.view.AdminMainView;
import com.view.AdminShowBookView;

public class BookService {
    private BookService(){}
    private static BookService bookService = new BookService();
    public static BookService getInstance() {
        return bookService;
    }
    public void addBook(int bNum, String name, String author, String type) {
        Book book = new Book(bNum, name, author, type);
        BookStore bookStore = BookStore.getInstance();
        bookStore.save(book);
        Browser.getInstance().showView(new AdminMainView());
    }

    public void showBooks() {
        BookStore bookStore = BookStore.getInstance();
        Box books = bookStore.findBooks();
        View view = new AdminShowBookView();
        view.setData(books);
    }
}
