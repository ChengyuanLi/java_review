package com.dao;

import com.dbcp.ConnectionPool;
import com.domain.Blog;
import com.domain.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDao {
    Connection connection = null;
    PreparedStatement statement = null;
    FileInputStream fis;
    String driver = null;
    String url  = null;
    String username = null;
    String password = null;

    {
        try {
            fis = new FileInputStream("database.properties");
            Properties p = new Properties();
            p.load(fis);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public User findUserByNameAndPass(String uname, String upass) {
        String sql = "SELECT * FROM T_USER WHERE UNAME = ? AND UPASS = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, uname);
            statement.setObject(2, upass);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int uno = rs.getInt("uno");
                uname = rs.getString("uname");
                upass = rs.getString("upass");
                return new User(uno, uname, upass);
            }
        } catch (Exception e) {
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

    /**
     * find recent trading blogs
     */
    public List<Blog> findHotBlogs() {
        String sql = "SELECT * FROM T_BLOGS B INNER JOIN T_USER U ON B.UNO = U.UNO WHERE BNO IN((SELECT BNO FROM T_REPLY GROUP BY BNO ORDER BY COUNT(*) DESC LIMIT 0,5))";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Blog> bs = new ArrayList<Blog>();
            while (rs.next()) {
                int bno = rs.getInt("bno");
                String content = rs.getString("content");
                Date createDate = rs.getDate("createdate");
                int uno = rs.getInt("uno");
                String uname = rs.getString("uname");
                Blog b = new Blog(bno, content, uno, createDate);
                b.setUname(uname);
                bs.add(b);
            }
        } catch (Exception e) {
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
