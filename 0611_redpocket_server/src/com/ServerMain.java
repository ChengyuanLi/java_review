package com;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerMain {
    private static final int REDPOCKET_NUM = 50;

    public static void main(String[] args) throws IOException {
        System.out.println("==========启动服务器==========");
        ServerSocket server = new ServerSocket(6666);
        int count = 0;
        RedPocket redPocket = new RedPocket(3, "50");
        while (count ++ < REDPOCKET_NUM) {
                Socket linkedClient = server.accept();
                Handler handler = new Handler(linkedClient, redPocket);
                Thread t = new Thread(handler);
                t.start();
        }
    }
}
