package com.test;

import com.sql.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionPool cp = new ConnectionPool();
            for (int i = 33; i < 100; i++) {
                Connection conn = cp.getConnection();
                //String sql = "INSERT INTO T_CAR VALUES(?, ?)";
                // statement.setInt(1, i);
                //statement.setString(2, "BMW" + i);
                String sql = "SELECT * FROM t_car LIMIT 0,1";
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                System.out.println(resultSet.getString("cno")+ ", "+ resultSet.getString("cname"));
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
