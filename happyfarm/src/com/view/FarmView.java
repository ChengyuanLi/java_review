package com.view;

import com.domain.Farm;
import com.domain.Seed;
import com.service.UserService;
import com.util.View;

import java.util.Scanner;

/**
 * @author aidenli
 */
public class FarmView implements View {

    private Farm farm;

    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        Seed[][] ss = this.farm.getFarm();
        for (int i = 0; i < ss.length; i++) {
            Seed[] seeds = ss[i];
            for (int j = 0; j < seeds.length; j++) {
                Seed seed = seeds[j];
                if (seed == null) {
                    System.out.print("\t******\t");
                } else if (seed.getFlag() == 0) {
                    System.out.print("\t||||||\t");
                } else if (seed.getFlag() == 1) {
                    System.out.print("\tYYYYYY\t");
                } else {
                    System.out.print("\tOOOOOO\t");
                }
            }
            System.out.println();
        }

        System.out.println("**************************************");
        System.out.println("!                 1. SEED*************");
        System.out.println("!                 2. WATER************");
        System.out.println("!                 3. COLLECT**********");
        System.out.println("**************************************");

        System.out.print("PLEASE OPERATE: ");
        int num = input.nextInt();
        switch (num) {
            case 1:
//                System.out.print("row: ");
//                int row = input.nextInt();
//                System.out.print("column: ");
//                int col = input.nextInt();
                ; break;
            case 2:
                System.out.print("row: ");
                int row = input.nextInt();
                System.out.print("column: ");
                int col = input.nextInt();
                UserService userService = UserService.getInstance();
                userService.water(row, col);
                ; break;
            case 3:

                ; break;
        }
    }

    @Override
    public void setData(Object[] object) {
        Farm farm = (Farm) object[0];
        this.farm = farm;
    }
}
