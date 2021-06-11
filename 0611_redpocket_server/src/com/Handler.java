package com;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 处理一次连接
 * @author aidenli
 */
public class Handler extends Thread{
    private Socket client;
    private RedPocket rp;
    public Handler(Socket client, RedPocket redPocket) {
        this.client = client;
        this.rp = redPocket;
    }

    public void handle() throws Exception {
        System.out.println("来自主机：" + client.getInetAddress() + " 端口：" + client.getPort() + "的连接");
        OutputStream os = client.getOutputStream();
        os.write("欢迎访问lcy尊贵的iMac Pro".getBytes(StandardCharsets.UTF_8));
        String money = rp.getPocket();
        os.write(money.getBytes());
        os.write("over".getBytes());
        os.flush();
        Thread.sleep(5000);
        client.shutdownOutput();
    }

    @Override
    public void run() {
        try {
            this.handle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
