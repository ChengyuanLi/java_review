package com.util;

import java.util.Scanner;

public class Input {
    private Input(){}
    public static String next() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public static String nextLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int nextInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static int nextRightInt() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                String s = input.next();
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Input integer format incorrect, please try again!");
                continue;
            }
        }
    }

    public static int nextRightInt(int[] area) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                String s = input.next();
                int num = Integer.parseInt(s);
                for (int i = 0; i < area.length; i++) {
                    if (num == area[i]) {
                        return num;
                    }
                }
                System.out.println("Please enter the number in correct range.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Input integer format incorrect, please try again!");
                continue;
            }
        }
    }

    public static int nextRightInt(int[] area, String msg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                String s = input.next();
                int num = Integer.parseInt(s);
                for (int i = 0; i < area.length; i++) {
                    if (num == area[i]) {
                        return num;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println(msg);
                continue;
            }
        }
    }

/*    public static int nextRightInt(int start, int end) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                String s = input.next();
                int num = Integer.parseInt(s);
                if (num >= start && num <= end) {

                }
            } catch () {

            }
        }
    }*/
}
