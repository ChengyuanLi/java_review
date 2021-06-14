package browser;

import com.util.Input;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Browser {
    public static void main(String[] args) {
        new Browser().open();
    }

    private void open() {
        System.out.print("URL:");
        String url = Input.nextLine();

        //判断格式
        if (url.indexOf("/") == -1) {
            url += "/";
        }
        this.parseUrl(url);
    }

    private void parseUrl(String url) {
        url = url.trim();
        int ip = url.indexOf(":");
        String ipStr = url.substring(0, ip);

        int pt = url.indexOf("/");
        int port = Integer.parseInt(url.substring(ip + 1, pt));

        String content = url.substring(pt);

        this.createConnection(ipStr, port, content);
    }

    private void createConnection(String ip, int port, String content) {
        try {
            Socket client = new Socket(ip, port);
            this.request2Server(client, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void request2Server(Socket client, String content) {
        try {
            OutputStream os = client.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            bos.write(content.getBytes(StandardCharsets.UTF_8));
            bos.flush();
            client.shutdownOutput();
            this.waitResponseFromServer(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitResponseFromServer(Socket client) {
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
            this.show(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void show(String content) {
        System.out.println(content);
    }

}
