package com;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author aidenli
 */
public class RedPocket {
    private int count;
    private String money;

    public RedPocket(int count, String money) {
        this.count = count;
        this.money = money;
    }

    public synchronized String getPocket() {
        if (count == 1) {
            count--;
            return "\t" + money;
        }
        if (count == 0) {
            count--;
            return "\t" +"手慢了";
        }
        double m = Double.parseDouble(money);
        m = m * 100;
        double m1 = m - count; // 确保剩下的人至少每人一分，所以当前的人从其他的人的钱里抢
        Random r = new Random();
        int m2 = r.nextInt((int) m1) + 1; // 当前的人拿的钱

        m1 = m1 - m2 + count;
        DecimalFormat df = new DecimalFormat("#0.00");
        money = df.format(m1 / 100.0);
        count--;
        return "\t" + df.format(m2 / 100.0)+ "";
    }
}
