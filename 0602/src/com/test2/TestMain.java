package com.test2;

import com.test3.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 大文件读取
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        File file = new File("/Volumes/warehouse/Video Editing/bt5/C0081.MP4");

        int length = (int) file.length();

        byte[] bs = new byte[(int) file.length()];

        Reader r1 = new Reader(new File("/Volumes/warehouse/Video Editing/bt5/C0081.MP4"), bs, 0, length / 4);
        Reader r2 = new Reader(new File("/Volumes/warehouse/Video Editing/bt5/C0081.MP4"), bs, length / 4, length / 4);
        Reader r3 = new Reader(new File("/Volumes/warehouse/Video Editing/bt5/C0081.MP4"), bs, length / 2, length / 4);
        Reader r4 = new Reader(new File("/Volumes/warehouse/Video Editing/bt5/C0081.MP4"), bs, length * 3 / 4, length / 4);

        Timer t = new Timer();
        t.setRs(Arrays.asList(r1, r2, r3, r4));

        r1.start();
        r2.start();
        r3.start();
        r4.start();

        t.scan();


    }
}
