package com.test;

/**
 * @author aidenli
 */
public class Window implements Runnable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sell() {
        while (true) {
            Ticket ticket = Server.server.getTicket();
            if (ticket == null) {
                break;
            }
            System.out.println(this.name + ": " + ticket);
        }
    }


    @Override
    public void run() {
        this.sell();
    }
}
