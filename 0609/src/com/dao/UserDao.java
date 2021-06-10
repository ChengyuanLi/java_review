package com.dao;

import com.domain.User;
import com.mysql.cj.protocol.Resultset;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author aidenli
 */
public class UserDao {
    /**
     * 根据用户名密码查询用户信息
     * @param uname
     * @param upass
     */

    private static HikariConfig config = new HikariConfig("/Users/aidenli/Desktop/java/0609/hikari.properties");
    private static HikariDataSource dataSource = new HikariDataSource(config);
    public User findUserByNameAndPass(String uname, String upass) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "SELECT * FROM T_USER WHERE UNAME = ? AND UPASS = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, uname);
            statement.setString(2, upass);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int uno = rs.getInt("uno");
                uname = rs.getString("uname");
                upass = rs.getString("upass");
                return new User(uno, uname, upass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
