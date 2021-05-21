package com.view;
import java.util.*;

import com.service.UserService;
import com.util.View;

/**
 * @author aidenli
 */
public class MainView implements View {

    @Override
    public void show() {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("!                 1. MY FARM**********");
        System.out.println("!                 2. MY PACK**********");
        System.out.println("!                 3. STORE************");
        System.out.println("**************************************");
        System.out.print("PLEASE OPERATE: ");
        int num = input.nextInt();
        switch (num){
            case 1:
                // show my farm
                UserService userService = UserService.getInstance();
                userService.getCurrentFarmToShow();
                ;break;
            case 2:
                // show my pack
                ;break;
            case 3:
                // show store
                ;break;
        }
    }

    @Override
    public void setData(Object[] object) {

    }
}
