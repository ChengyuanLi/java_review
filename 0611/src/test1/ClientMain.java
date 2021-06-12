package test1;

import com.util.Input;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端发送
 * @author aidenli
 */
public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 6666);
        while (true) {
            String content = Input.nextLine();
            OutputStream os = client.getOutputStream();
            os.write(content.getBytes(StandardCharsets.UTF_8));
            os.flush();
            if (content.equals("over")) {
                break;
            }
        }
    }
}
