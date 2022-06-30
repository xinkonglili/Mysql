package com.jinli.lession2;

import com.jinli.lession2.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rt = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "UPDATE `user` SET `name` = 'oo' WHERE id = 3";
            String sql2 = "update `user` set `password` = '9999999' where id = 4";
            int n = st.executeUpdate(sql);
            if(n>0){
                System.out.println("更新成功");
            }
            int m = st.executeUpdate(sql2);
            if(n>0){
                System.out.println("更新成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rt);
        }

    }
}
