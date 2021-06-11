package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) throws IOException {
	// write your code here

        Socket client = new Socket("127.0.0.1", 6666);
        InputStream is = client.getInputStream();
        Reader r = new InputStreamReader(is);

        StringBuilder content = new StringBuilder();
        while (true) {
            int c = r.read();
            content.append((char) c);
            if (content.toString().endsWith("over")) {
                break;
            }
        }



        System.out.println(content.delete(content.length() - 4, content.length()));

        client.shutdownInput();

    }
}
