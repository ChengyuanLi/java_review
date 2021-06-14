package com;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Handler implements Runnable{

    private Socket client;

    public Handler(){}

    public Handler(Socket client) {
        this.client = client;
    }

    public void handle() {
        this.w8AndAnswer();
    }

    private void w8AndAnswer() {
        try {
            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);
            StringBuilder content = new StringBuilder();
            char[] cs = new char[0x10];
            while (true) {
                int length = r.read(cs);
                if (length == -1) {
                    break;
                }
                content.append(cs, 0, length);
            }
            this.parseAndExcute(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseAndExcute(String content) {
        System.out.println(content);
        content = content.trim();
        if (content.equals("/")) {
            content += "default";
        }
        this.response2Browser();
    }

    private void response2Browser() {
        try {
            OutputStream os = client.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            bos.write("OK".getBytes(StandardCharsets.UTF_8));
            bos.flush();
            client.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.handle();
    }
}
