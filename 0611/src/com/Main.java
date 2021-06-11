package com;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Socket client = new Socket("127.0.0.1", 6666);
            OutputStream os = client.getOutputStream();
            os.write("吃吃吃吃吃".getBytes());
            os.flush();
            client.shutdownOutput();

            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);
            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                }
                System.out.print((char) c);
            }
            System.out.println();
            System.out.println("杀我的人是： "+ client.getInetAddress());
            System.out.println("他家在（端口）： "+ client.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
