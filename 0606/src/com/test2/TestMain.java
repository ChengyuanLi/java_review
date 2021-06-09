package com.test2;

import java.sql.*;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("username: ");
        String uname = input.next();
        System.out.print("password: ");
        String upass = input.next();



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lcy",
                    "root",
                    ",,,,");

            Statement statement = connection.createStatement();

            String sqlLogin = "SELECT * FROM T_USER WHERE UNAME = ? AND UPASS = ?";
            System.out.println(sqlLogin);

            PreparedStatement statement1 = connection.prepareStatement(sqlLogin);
            statement1.setString(1, uname);
            statement1.setString(2, upass);

            ResultSet rs = statement.executeQuery(sqlLogin);

            if (rs.next()) {
                System.out.println("login success");
            }
            System.out.println("login failed");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
