package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Response {

    private StringBuilder content = new StringBuilder();

    public void append(String str) {
        content.append(str);
    }

    public void sendDir(String path) {
        try {

            File file = new File(path);
            if (!file.exists()) {
                this.content.append(path + " -> File does not exit!");
                return;
            }

            FileReader r = new FileReader(path);
            while (true) {
                int c = r.read();
                if (c == -1) {
                    break;
                }
                this.content.append((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
