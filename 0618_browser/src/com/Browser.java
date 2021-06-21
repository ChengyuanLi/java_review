package com;

import com.util.Input;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class  Browser {

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
            this.w8Response();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void w8Response() {
        try {
            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);

            StringBuilder content = new StringBuilder();
            char[] cs = new char[010];
            while (true) {
                int length = r.read(cs);
                content.append(cs, 0, length);
                if (content.toString().endsWith("[over]")) {
                    break;
                }
            }

            content.delete(content.length()-6, content.length());
            this.show(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void show(String content) {
        String requestContent = null;
        Map<String, String> params = new HashMap<>();

        while (true) {

            int i1 = content.indexOf("[");
            int i2 = content.indexOf("]");

            if (i1 == -1 || i2 == -1) {
                System.out.println(content);
                break;
            }

            String head = content.substring(0, i1);
            System.out.println(head);

            String tag = content.substring(i1+1, i2);
            if("input".equals(tag) || tag.startsWith("input ")) {
                String value = Input.nextLine();
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">");
                if (i3 != -1 && i4 != -1) {
                    String key = tag.substring(i3+1, i4);
                    params.put(key, value);
                }
            }

            if("from".equals(tag) || tag.startsWith("from ")) {
                String value = Input.nextLine();
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">");
                if (i3 != -1 && i4 != -1) {
                    requestContent = tag.substring(i3+1, i4);
                }
            }

            if("menus".equals(tag) || tag.startsWith("menus ")) {
                String value = Input.nextLine();
                int i3 = tag.indexOf("<");
                int i4 = tag.indexOf(">");
                if (i3 != -1 && i4 != -1) {
                    String menuContent = tag.substring(i3+1, i4);
                    String[] menuStr = menuContent.split(",");

                    List<String> reqs = new ArrayList<>();
                    for (String s : menuStr) {
                        String[] textAndReq = s.split(":");
                        System.out.println(textAndReq[0]);
                        reqs.add(textAndReq[1]);
                    }
                    System.out.print("please select input: ");
                    int num = Input.nextRightInt();
                    requestContent = reqs.get(num - 1);
                }
            }

            if (content.length() -1 == i2) {
                break;
            }

            content = content.substring(i2+1);
            continue;
        }

        if (requestContent == null || requestContent.equals("")) {
            this.open();
            return;
        }

        String url = ip + ":" + port + "/" + requestContent;
        if (params.size() > 0) {
            url += "?";

            Set<Map.Entry<String, String>> es = params.entrySet();
            for (Map.Entry<String, String> e : es) {
                String key = e.getKey();
                String value = e.getValue();
                url += key + "=" + value + "&";
            }
            url = url.substring(0, url.length() - 1);
        }

        this.parseUrl(url);
    }

}
