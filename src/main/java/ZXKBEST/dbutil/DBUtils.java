package ZXKBEST.dbutil;

import ZXKBEST.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    Connection conn;
    //预处理
    PreparedStatement pstmt;
    //结果集
    ResultSet rs;

    public DBUtils() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int login(User user) {
        try {
            pstmt = conn.prepareStatement("select * from tb_user where uname=? and upwd=?");
            pstmt.setString(1, user.getUname());
            pstmt.setString(2, user.getUpwd());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return 1;
            } else
                return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    //查询tb_User表中信息
    public List<User> findAllUser() {
        try {
            String sql = "Select * from tb_user";
            //预处理
            pstmt = conn.prepareStatement(sql);
            //执行查询
            rs = pstmt.executeQuery();
            //实例化
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setLastLoginTime(rs.getString(4));
                user.setRole(rs.getString(5));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
