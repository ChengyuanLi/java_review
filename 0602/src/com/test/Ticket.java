package com.test;

import java.io.Serializable;

/**
 * @author aidenli
 */
public class Ticket implements Serializable {
    private String start;
    private String end;
    private int price;

    public Ticket() {
    }

    public Ticket(String start, String end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return start + " - " + end + ": " + price;
    }
}
