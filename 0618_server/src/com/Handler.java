package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * @author aidenli
 */
public class Handler implements Runnable{
    private Socket client;

    public Handler(Socket client) {
        this.client = client;
    }

    //输入
    private void w8AndReadFromBrowser() {
        try {
            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);
            StringBuilder content = new StringBuilder();

            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                }

                content.append((char) c);
            }

            this.executeRequest(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeRequest(String content) {
        System.out.println("received raw content: " + content);
    }


    @Override
    public void run() {
        this.w8AndReadFromBrowser();
    }
}
