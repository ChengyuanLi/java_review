package com.server;

import java.io.*;

/**
 * @author aidenli
 */
public class Response {
    // response content
    StringBuilder content = new StringBuilder();

    //load content dynamic
    public void append(String s) {
        this.content.append(s);
    }

    public void appendln(String s) {
        this.content.append(s).append("/n");
    }

    //send a view file path
    public void sendRedirect(String path) {
        try {
            Reader reader = new FileReader(path);
            while (true) {
                int c = reader.read();
                if (c == -1) {
                    break;
                }
                this.content.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
