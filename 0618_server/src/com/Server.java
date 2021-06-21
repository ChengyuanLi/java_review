package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
	// write your code here
        new Server().start();
    }

    private void start() {

        System.out.println("Server starting...");

        try {
            ServerSocket server = new ServerSocket(6666);
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
