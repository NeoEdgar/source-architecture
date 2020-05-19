package com.edgar.neo;

import com.edgar.neo.pojo.Blog;

import java.sql.*;

public class NeoExecutor {

    public <T> T query(String sql, Object parameter) {

        Blog blog = new Blog();
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root123456");
            statement = connection.createStatement();
            // 执行查询
            ResultSet rs = statement.executeQuery(String.format(sql, parameter));
            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return (T) blog;
    }
}
