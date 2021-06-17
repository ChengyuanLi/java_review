package com;

import com.util.Input;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author aidenli
 */
public class Broswer {

    public static void main(String[] args) {
	// write your code here
        new Broswer().open();
    }

    private void open() {
        System.out.print("URL: ");
        String url = Input.nextLine();
        /**
         * ip:port/content
         */
        if (!url.contains("/")) {
            url += "/";
        }

        this.parseURL(url);

    }

    private void parseURL(String url) {
        url = url.trim();
        int i1 = url.indexOf(":");
        String ipStr = url.substring(0, i1);

        int i2 = url.indexOf("/");
        String portStr = url.substring(i1 + 1, i2);
        int port = Integer.parseInt(portStr);

        String content = url.substring(i2); // with "/"

        this.createConnection2Server(ipStr, port, content);
    }

    private void createConnection2Server(String ip, int port, String content) {
        try {
            Socket client = new Socket(ip, port);
            this.send2Server(client, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send2Server(Socket client, String content) {
        OutputStream os = null;
        try {
            os = client.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);
            bufferedOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();
            client.shutdownOutput();
            this.w8AndReadResponse(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void w8AndReadResponse(Socket client) {
        try {
            InputStream inputStream = client.getInputStream();
            Reader r = new InputStreamReader(inputStream);
            StringBuilder content = new StringBuilder();
            char[] cs = new char[010];
            while (true) {
                int length = r.read(cs);
                content.append(cs, 0, length);
                if (content.toString().endsWith("over")) {
                    break;
                }
            }

            content.delete(content.length() - 4, content.length());
            this.showContent(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContent(String content) {
        System.out.println(content);
    }


}
