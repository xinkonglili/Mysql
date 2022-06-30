package com.jinli.lession2.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    //提升作用域
    private static String driver = null;
    private static String url = null;
    private static String name = null;
    private static String password = null;


    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //创建一个Properties对象，然后把流加载进来
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");

            //1、驱动只加载一次
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }

    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            rs = null;
        }

        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
