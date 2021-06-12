package test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * 服务端读取线程
 * @author aidenli
 */
public class Handler extends Thread{

    private Socket client;

    public Handler(Socket client) {
        this.client = client;
    }

    public void handle() {
        try {
            InputStream is = client.getInputStream();
            Reader r = new InputStreamReader(is);

            StringBuilder sb = new StringBuilder();
            char[] cs = new char[010];
            while (true) {
                int length = r.read(cs);
                sb.append(cs, 0, length);
                System.out.println("received message from: " + client.getInetAddress() + " port: " + client.getPort() + " \"" + sb + "\".");
                if (sb.toString().endsWith("over")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.handle();
    }
}
