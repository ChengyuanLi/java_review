package test1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author aidenli
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
       while (true)  {
           Socket client = server.accept();
           Handler handler = new Handler(client);
           Thread t = new Thread(handler);
           t.start();
       }

    }
}
