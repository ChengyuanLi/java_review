package com.domain;

import com.util.ArrayBox;
import com.util.Box;

public class User {
    private String uname;
    private String upass;
    //当前借阅书籍
    private Box books = new ArrayBox();
    public User(){}

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Box getBooks() {
        return books;
    }

    public void setBooks(Box books) {
        this.books = books;
    }

    //增加一本借阅的图书
    public void addBook(Book book){
        this.books.add(book);
    }

    public void returnBook(Book book) {

    }

}
