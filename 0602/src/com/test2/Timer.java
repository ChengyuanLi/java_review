package com.test2;

import com.test3.Reader;

import java.util.List;

public class Timer {
    private long start;
    private long end;
    private List<Reader> rs;

    public List<Reader> getRs() {
        return rs;

    }

    public void setRs(List<Reader> rs) {
        this.rs = rs;
    }

    public Timer() {
        this.s();
    }

    public void s() {
        this.start = System.currentTimeMillis();
    }

    public void e() {
        this.end = System.currentTimeMillis();
    }

    public void scan() {
        a: while (true) {
            for (int i = 0; i < rs.size(); i++) {
                if (!rs.get(i).isFlag()) {
                    continue a;
                }
                break ;
            }
            this.e();
            System.out.println(end - start);
        }
    }

}
