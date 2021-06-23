package com;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Response {
    StringBuilder content = new StringBuilder();

    public void print(String s) {
        this.content.append(s);
    }

    public void println(String s) {
        this.print(s);
        this.print("\r");
    }

    public void sendDir(String path) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(path);

            Reader r = new InputStreamReader(is);

            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                }

                content.append((char) c);
            }

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            this.content.append("404 - [" + path + "] not found!" );
        }

    }
}
