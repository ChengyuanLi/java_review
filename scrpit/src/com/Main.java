package com;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String path = "/Users/aidenli/Downloads/PsyMood.html";
        StringBuilder input = new StringBuilder();
        InputStream is = null;
        List<String> personCards = new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<String> location = new ArrayList<String>();
        List<String> pictures = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        try {
            is = new FileInputStream(path);
            Reader r = new InputStreamReader(is);
            StringBuilder content = new StringBuilder();
            char[] cs = new char[0x10];
            while (true) {
                int length = r.read(cs);
                if (length == -1) {
                    break;
                }
                input.append(cs, 0, length);
            }

            personCards = divPerson(input.toString());

            for (String s : personCards) {
                name.add(divName(s));
            }

            for (String s : personCards) {
                location.add(divLocation(s));
            }

            for (String s : personCards) {
                pictures.add(divPicture(s));
            }

            /*System.out.println(personCards);*/
            System.out.println(name.size() +" "+ location.size() +" "+ pictures.size());
/*            System.out.println(name);
            System.out.println(location);
            System.out.println(pictures);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 128; i++) {
            result.add("index=" + i + "&name=" + name.get(i) + "&location=" + location.get(i)+ "&picture=" + pictures.get(i));
        }

        String tPath = "/Users/aidenli/psymood.txt";
        File f = new File(tPath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            OutputStreamWriter dos = new OutputStreamWriter(fos);
            for (int i = 0; i < 128; i++) {
                dos.write(result.get(i) + "\r");
            }
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(result);
        for (int i = 0; i < 128; i++) {
            System.out.println(pictures.get(i) + "\r");
        }

        for (int i = 0; i < 128; i++) {
            try {
                download(pictures.get(i), name.get(i) + ".jpg", location.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> divPerson(String s) {
        List<String> personCards = new ArrayList<String>();
       String person = "";
       String personStart = "<app-specialist-card";
       String personEnd = "</app-specialist-card>";
       String cardEnd = "<!----></section>";
        for (int i = 0; i <128; i++) {
            int i1 = s.indexOf(cardEnd);
            int i2 = cardEnd.length();
            person = s.substring(s.indexOf(personStart), s.indexOf(cardEnd));
            personCards.add(person + "/n");
            s = s.substring(i1 + i2);

        }
       return personCards;
    }

    public static String divName(String s) {
        String name = "";
        String nameStart = "<h3 _ngcontent-pqw-c63=\"\">";
        String nameEnd = "</h3><h4 _ngcontent-pqw-c63=\"\">";

        int nameS = s.indexOf(nameStart);
        int nameE = s.indexOf(nameEnd);

        name = s.substring(nameS, nameE);
        name = name.replace(nameStart, "");

        return name;
    }

    public static String divLocation(String s) {
        String location = "";
        String locationStart = "</mat-icon>";
        String locationEnd = "</div><h3";

        int locS = s.indexOf(locationStart);
        int locE = s.indexOf(locationEnd);

        location = s.substring(locS, locE);
        location = location.replace(locationStart, "");

        return location;
    }

    public static String divPicture(String s) {
        String pic = "";
        String picStart = "(&quot;";
        String picEnd = "&quot;)";

        int picS = s.indexOf(picStart);
        int picE = s.indexOf(picEnd);

        pic = s.substring(picS, picE);
        pic = pic.replace(picStart, "");

        return pic;
    }

    /**
     *
     * @param urlString
     * @param filename 文件名
     * @param savePath 保存路径
     * @return
     * @throws Exception
     */
    public static void download(String urlString, String filename,String savePath) throws Exception {
        // 构造URL
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "192.168.2.138");
        System.setProperty("http.proxyPort", "1081");
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求的路径
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"/"+filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();

        is.close();
    }

}