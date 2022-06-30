package com.jinli.lession2;

import com.jinli.lession2.utils.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
         Connection  conn = null;
         Statement st = null;
         ResultSet rs = null; //如果不写的话，传个null

        try {

            //1、先获取数据库对象，用数据库对象去获取sql对象，用sql对象去执行sql
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into user(`id`,`name`,`password`,`email`) values(4,'pp','8537290','27573205830')";

            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
