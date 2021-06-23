package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("--------Server started--------");
            while (true) {
                Socket client = ss.accept();
                Handler h = new Handler(client);
                Thread t = new Thread(h);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
