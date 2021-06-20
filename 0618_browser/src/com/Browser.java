package com;

import com.util.Input;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Browser {

    public static void main(String[] args) {
	// write your code here
        new Browser().open();
    }

    /**
     * show default.view
     */
    private String ip;
    private int port;
    private String content;
    private Socket client;

    private void open() {
        System.out.println("Template: 127.0.0.1:6666/login");
        System.out.print("URL:");
        String url = Input.nextLine();
        if (!url.contains("/")) {
            url += "/";
        }

        this.parseUrl(url);
    }

    /**
     * divide url = ip + port + content
     * @param url
     */
    private void parseUrl(String url) {
        url = url.trim();

        int i1 = url.indexOf(":");
        String ip = url.substring(0, i1);

        int i2 = url.indexOf("/");
        int port = Integer.parseInt(url.substring(i1+1, i2));

        String content = url.substring(i2);

        this.ip = ip;
        this.port = port;
        this.content = content;

        this.createConnection2Server();
    }

    private void createConnection2Server() {
        try {
            this.client = new Socket(ip, port);
            this.request2Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void request2Server() {
        try {
            OutputStream outputStream = client.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            bufferedOutputStream.write(this.content.getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();

            //发送-1
            client.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
