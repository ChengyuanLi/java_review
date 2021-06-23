package com;

import com.util.Input;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 输入url
 * 解析url
 * 创建与服务器的连接
 * 发送请求
 * 等待并接受服务器的响应
 * 解析并显示视图内容
 * 发送下一次请求
 * @author aidenli
 */
public class Browser {

    private String ip;
    private int port;
    private String content;
    private Socket client;

    public static void main(String[] args) {
        new Browser().open();
    }

    private void open() {
        System.out.println("TEMPLATE: 127.0.0.1:6666/");
        System.out.print("PLEASE ENTER URL:");
        String url = Input.nextLine();

        if (!url.contains("/")) {
            url += "/";
        }

        this.parseUrl(url);
    }

    private void parseUrl(String url) {
        url = url.trim();

        int i1 = url.indexOf(":");
        ip = url.substring(0, i1);

        int i2 = url.indexOf("/");
        port = new Integer(url.substring(i1+1, i2));

        content = url.substring(i2);
        this.createConnection();
    }

    private void createConnection() {
        try {
            client = new Socket(ip, port);
            this.request2Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void request2Server() {
        try {
            OutputStream os = client.getOutputStream();
            os.write(content.getBytes(StandardCharsets.UTF_8));
            os.flush();
            client.shutdownOutput();

            this.w84Response();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void w84Response() {
        try {
            InputStream is = client.getInputStream();
            char[] cs = new char[is.available()];
            Reader r = new InputStreamReader(is);

            int length = r.read(cs);
            String content = new String(cs, 0, length);

            this.show(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void show(String content) {
        String requestContent = null;
        Map<String, String> params = new HashMap<>();
        while (true) {
            int i1 = content.indexOf("[");
            int i2 = content.indexOf("]", i1);

            if (i1 == -1 || i2 == -1) {
                System.out.println(content);
                break;
            }

            String before = content.substring(0, i1);
            System.out.print(before);
            String tag = content.substring(i1+1, i2);
            if ("input".equals(tag) || tag.startsWith("input ")) {
                String value = Input.nextLine();
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">", i3);
                if (i3 != -1 && i3 < i4) {
                    String key = tag.substring(i3+1, i4);
                    params.put(key, value);
                }
            }
            if ("form".equals(tag) || tag.startsWith("form ")) {
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">", i3);
                if (i3 != -1 && i3 < i4) {
                    requestContent = tag.substring(i3+1, i4);
                }
            }
            if ("menus".equals(tag) || tag.startsWith("menus ")) {
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">", i3);
                if (i3 != -1 && i3 < i4) {
                    String menuContent = tag.substring(i3+1, i4);
                    String[] menuArray = menuContent.split(",");
                    List<String> reqs = new ArrayList<String>(menuArray.length);
                    int index = 1;
                    for (String menu : menuArray) {
                        String[] textAndReq = menu.split(":");
                        System.out.println(index++ + "." + textAndReq[0]);
                        reqs.add(textAndReq[1]);
                    }
                    System.out.print("PLEASE ENTER YOUR CHOICE: ");
                    int no = Input.nextInt();
                    requestContent = reqs.get(no - 1);
                }
            }
            if (content.length()-1 == i2) {
                break;
            }
            content = content.substring(i2+1);
            continue;
        }
        if (requestContent == null || "".equals(requestContent)) {
            this.open();
            return;
        }
        StringBuilder url = new StringBuilder();
        url.append(ip);
        url.append(":");
        url.append(port);
        url.append("/");
        url.append(requestContent);
        if (params.size() > 0) {
            url.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                url.append(key + "=" + value);
                url.append("&");
            }
            url.delete(url.length() - 1, url.length());
        }
        this.parseUrl(url.toString());
    }
}
