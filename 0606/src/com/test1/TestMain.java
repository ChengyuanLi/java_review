package com.test1;

import java.sql.*;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        // write your code here
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lcy",
                "root",
                ",,,,");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_user");
        while (rs.next()) {
            String name = rs.getString("uname");
            String password = rs.getString("upass");
            System.out.println(name + ", " + password);
        }
        statement.close();
        conn.close();
    }
}
