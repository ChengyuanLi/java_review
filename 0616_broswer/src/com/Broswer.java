package com;

import com.util.Input;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author aidenli
 */
public class Broswer {

    public static void main(String[] args) {
	// write your code here
        new Broswer().open();
    }

    private String ip;
    private int port;

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
        this.ip = ipStr;
        int i2 = url.indexOf("/");
        String portStr = url.substring(i1 + 1, i2);
        this.port = Integer.parseInt(portStr);

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
        Map<String, String> params = new HashMap<>();
        //from tag content
        String requestContent = null;
        int i = 0;
        while (true) {
            //start of block
            int i1 = content.indexOf("[");
            //end of block
            int i2 = content.indexOf("]", i1);

            if (i1 == -1 || i2 == -1) {
                System.out.println(content);
                break;
            }

            String before = content.substring(0, i1);
            System.out.println(before);

            String tag = content.substring(i1+1, i2);
            if ("input".equals(tag) || tag.startsWith("input ")) {
                String value = Input.next();
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">", i3);
                if (i3 != -1 && i3 < i4) {
                    String key = tag.substring(i3+1, i4);
                    params.put(key, value);
                }
            }

            if ("from".equals(tag) || tag.startsWith("from ")) {
                //from标记
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">", i3);
                if (i3 != -1 && i3 < i4) {
                    requestContent = tag.substring(i3+1, i4);
                }
            }

            //判断[]后是否有内容
            if (content.length()-1 == i2) {
                break;
            }

            content = content.substring(i2 + 1);
            continue;

        }
        if (requestContent == null || "".equals(requestContent)) {
            this.open();
            return;
        }
        String url = ip + ":" + port + "/" + requestContent;
        if (params.size() > 0) {
            url += "?";
            Set<String>keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                url += key + "=" + value + "&";
            }
            //remove last "&"
            url = url.substring(0, url.length()-1);
        }
        System.out.println(url);
        this.parseURL(url);
    }


}
