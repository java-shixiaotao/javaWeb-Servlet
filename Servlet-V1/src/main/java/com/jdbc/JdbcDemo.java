package com.jdbc;


import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "shi6265408";

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建sql环境
        Statement statement = connection.createStatement();
        //写sql
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getInt("id"));
            System.out.println("name = " + resultSet.getString("name"));
            System.out.println("password = " + resultSet.getString("password"));
            System.out.println("email = " + resultSet.getString("email"));
            System.out.println("birthday = " + resultSet.getString("birthday"));
            System.out.println("--------------------------------------");
        }
        statement.close();
        connection.close();
    }

}
