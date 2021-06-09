package com.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("please enter user name: ");
        String uname = input.nextLine();
        System.out.print("please enter user password: ");
        String upass = input.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lcy",
                    "root",
                    ",,,,"
            );
            String sql = "SELECT * FROM T_USER WHERE UNAME = ? AND UPASS = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, uname);
            statement.setString(2, upass);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

            statement.close();
            connection.close();

        } catch (Exception e) {

        }
    }
}
