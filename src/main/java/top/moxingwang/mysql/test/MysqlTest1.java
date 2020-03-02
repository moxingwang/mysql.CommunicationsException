package top.moxingwang.mysql.test;


import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlTest1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://db201.dev.rs.com:3306/tx_order?characterEncoding=utf8");
        dataSource.setUsername("zyp");
        dataSource.setPassword("zyp_user");
        dataSource.setQueryTimeout(5);
        dataSource.setLogAbandoned(true);

        int ct = 0;

        try {
            conn = dataSource.getConnection();

            conn.setAutoCommit(false);

            String sql = "select sleep(10) ,id from tx_order where id =74";
            pstmt = conn.prepareStatement(sql);


            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        System.out.println(1);
    }
}
