package com.service;

import com.Controller.Controller;
import com.service.Request;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

        Controller c = new Controller();
        c.control(request);
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
