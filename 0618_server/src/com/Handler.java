package com;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

        content = content.trim();

        if (content.equals("/")) {
            content += "default";
        }
        content = content.substring(1);

        String requestContnet = null;
        Map<String, String> params = new HashMap<>();

        int i1 = content.indexOf("?");
        if (i1 != -1) {
            requestContnet = content.substring(0, i1);
            String requestParams = content.substring(i1+1);
            String[] parameters = requestParams.split("&");
            for (String parameter : parameters) {
                String[] kAndV = parameter.split("=");
                String key = kAndV[0];
                String value = kAndV[1];
                params.put(key, value);
            }
        } else {
            requestContnet = content;
        }

        Request request = new Request(requestContnet, params, client.getInetAddress());
        Response response = new Response();
        Controller.mapping(request, response);

    }

    private void response2B(String content) {
        try {
            OutputStream outputStream = client.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            bos.write(content.getBytes(StandardCharsets.UTF_8));
            bos.write("[over]".getBytes(StandardCharsets.UTF_8));
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        this.w8AndReadFromBrowser();
    }
}
