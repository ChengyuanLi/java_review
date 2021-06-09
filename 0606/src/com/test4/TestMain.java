package com.test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("dept number: ");
        int deptno = input.nextInt();
        System.out.println("dept name: ");
        String dname = input.next();
        System.out.println("dept location: ");
        String loc = input.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lcy",
                    "root",
                    ",,,,"
            );
            String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, deptno);
            statement.setString(2, dname);
            statement.setString(3, loc);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
