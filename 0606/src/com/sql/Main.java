package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author aidenli
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lcy", "root", ",,,,");
        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate("insert into t_user values (1004, 'lcy4', '123', '2021-01-01', 21 )");
        statement.close();
        connection.close();
    }
}
