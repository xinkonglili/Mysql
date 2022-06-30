package com.jinli.lession1;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String name = "root";
        String password = "jinli666";
        //3、获取数据库对象------> Connection 代表数据库
        Connection connection = DriverManager.getConnection(url, name, password);
        //4、用数据库对象去创建sql对象
        Statement statement = connection.createStatement();
        //5、用sql对象去执行sql，可能存在结果，查看返回结果
        String sql ="select * from user";
        ResultSet resultSet = statement.executeQuery(sql);  //返回的结果集

        while (resultSet.next()){
            System.out.println("id= "+resultSet.getObject("id"));
            System.out.println("name= "+resultSet.getObject("name"));
            System.out.println("password= "+resultSet.getObject("password"));
            System.out.println("email= "+resultSet.getObject("email"));
        }

        //6、释放连接---释放的顺序从下往上
        resultSet.close();
        statement.close();
        connection.close();




    }

}
