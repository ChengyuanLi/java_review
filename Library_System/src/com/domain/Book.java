package com.domain;

import java.util.Date;

/**
 * @author aidenli
 */



public class Book {

    private int bNum;
    private String name;
    private String author;
    private String type;
    /**
     * @flag:
     *   true: 被借出
     *   flase: 空闲
     */
    private boolean flag;
    private Date outDate;

    /**
     * 预留属性
     */
    private String space1;
    private String space2;
    private String space3;

    public Book(){}

    public Book(int bNum, String name, String author, String type) {
        this.bNum = bNum;
        this.name = name;
        this.author = author;
        this.type = type;

    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getSpace1() {
        return space1;
    }

    public void setSpace1(String space1) {
        this.space1 = space1;
    }

    public String getSpace2() {
        return space2;
    }

    public void setSpace2(String space2) {
        this.space2 = space2;
    }

    public String getSpace3() {
        return space3;
    }

    public void setSpace3(String space3) {
        this.space3 = space3;
    }

    @Override
    public String toString() {
        String flag = this.flag ? "借出": "空闲";
        return "「图书编号」："+ bNum +"\t「图书名称」："+ name +"\t「图书作者」："+ author +"\t「图书类别」："+ type +"\t「图书状态」：" + flag ;
    }



}
