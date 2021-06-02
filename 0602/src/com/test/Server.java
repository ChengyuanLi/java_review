package com.test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author aidenli
 */

public enum Server {

    /**
     *
     */
    server;

    private Stack<Ticket> tickets = new Stack<Ticket>();

    {
        for (int i = 0; i < 100; i++) {
             tickets.push(new Ticket("Toronto", "Beijing", i*100));
        }
    }

    public Ticket getTicket() {
        try {
            return this.tickets.pop();
        } catch (EmptyStackException e) {
            return null;
        }

    }

}
