package com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            System.out.println("——————————钓鱼开始——————————");
            ServerSocket server = new ServerSocket(6666);
            Socket linkClient = server.accept();
            InputStream is = linkClient.getInputStream();
            Reader r = new InputStreamReader(is); //字符字节转换流 保证中文可以输入。
            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                }
                System.out.print((char) c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("——————————鱼上钩了——————————");
            System.out.println("鱼的ip：" + linkClient.getInetAddress());
            System.out.println("鱼的端口：" + linkClient.getPort());

            OutputStream os = linkClient.getOutputStream();
            os.write("你没了".getBytes(StandardCharsets.UTF_8));
            os.flush();
            linkClient.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
