package com;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Handler implements Runnable{

    @Override
    public void run() {
        this.w8AndReqdFromBrowser();
    }

    private Socket client;
    public Handler(Socket client) {
        super();
        this.client = client;
    }

    private void w8AndReqdFromBrowser() {
        try {
            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);

            char[] cs = new char[010];
            StringBuilder content = new StringBuilder();

            while (true) {
                int length = r.read(cs);
                if (length == -1) {
                    break;
                }
                content.append(cs, 0, length);
            }

            this.parseRequest(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRequest(String content) {
        if (content.equals("/")) {
            content += "default";
        }

        content = content.substring(1);

        String requestContent = null;
        Map<String, String> params = new HashMap<>();

        int i1;
        if ((i1=content.indexOf("?")) != -1) {
            requestContent = content.substring(0, i1);
            String paramStr = content.substring(i1+1);
            String[] paramStrs = paramStr.split("&");
            for (String str : paramStrs) {
                String[] keyAndValue = str.split("=");
                params.put(keyAndValue[0], keyAndValue[1]);
            }
        }else{
            requestContent = content;
        }

        Request request = new Request(requestContent, params, client.getInetAddress());
        Response response = new Response();

        Controller.mapping(request, response);
        this.response2Browser(response.content.toString());
    }

    private void response2Browser(String content) {
        try {
            OutputStream os = client.getOutputStream();
            os.write(content.getBytes(StandardCharsets.UTF_8));
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
