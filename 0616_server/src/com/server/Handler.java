package com.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Handler implements Runnable{

    private Socket client;

    public Handler(Socket client){
        this.client = client;
    }

    public void handle() {
        this.w8AndReadRequest();
    }

    private void w8AndReadRequest() {
        try {
            InputStream inputStream = client.getInputStream();
            Reader r = new InputStreamReader(inputStream);
            StringBuilder content = new StringBuilder();
            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                } else {
                    content.append((char) c);
                }
            }
            parseRequest(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseRequest(String content) {
        System.out.println(content);
        content = content.trim();
        if (content.equals("/")) {
            content += "default";
        }
        content = content.substring(1); // remove "/"
        int i1 = content.indexOf("?");
        Map<String, String> params = new HashMap<String, String>();
        if (i1 != -1) {
            //varibale
            String requestContent = content.substring(0, i1);
            String parameterContent = content.substring(i1 + 1);
            //[uname=lcy, upass=123]
            String[] parameters = parameterContent.split("&");
            for (String parameter : parameters) {
                String[] keyAndValue = parameter.split("=");
                String key = keyAndValue[0];
                String value = keyAndValue[1];
                params.put(key, value);
            }
            content = requestContent;
        }

        System.out.println(content);
        System.out.println(params);
        String ip = null;
        ip = client.getInetAddress().toString();

        Request request = new Request();
        request.setContent(content);
        request.setIp(ip);
        request.setParams(params);

        Response response = new Response();

        Controller c = new Controller();
        c.mapping(request, response);
        this.response2browser(response.content.toString());
    }

    private void response2browser(String content) {
        try {
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            outputStream.write("over".getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        this.handle();
    }
}
