package com.test;

import com.dbcp.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionPool cp = new ConnectionPool();


            for (int i = 1; i < 50; i++) {
                Connection connection = cp.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM T_CAR LIMIT 0, 1");
                ResultSet rs = statement.executeQuery();
                rs.next();
                System.out.println(i + ", " + rs.getString("cno")+ ", " + rs.getString("cname"));
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
