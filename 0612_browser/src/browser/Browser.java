package browser;

import com.util.Input;

public class Browser {
    public static void main(String[] args) {
        //new Browser().open;
    }

    private void open() {
        System.out.print("URL:");
        /**
         * 格式ip:port/content
         * http://127.0.0.1:6666/hello, world!
         * ip:port -> ip:port/
         */
        String url = Input.nextLine();

        //判断格式
        if (url.indexOf("/") == -1) {
            url += "/";
        }
    }

    private void parseUrl(String url) {
        url = url.trim();
        int ip = url.indexOf(":");
        String ipStr = url.substring(0, ip);

        int pt = url.indexOf("/");
        int port = Integer.parseInt(url.substring(ip + 1, pt));

        String content = url.substring(pt);
    }

}
