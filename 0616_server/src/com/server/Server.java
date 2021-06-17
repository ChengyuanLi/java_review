package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
	// write your code here
        new Server().open();
    }

    private void open() {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server starting...");
            while (true) {
                Socket client = server.accept();
                Handler h = new Handler(client);
                Thread t = new Thread(h);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
