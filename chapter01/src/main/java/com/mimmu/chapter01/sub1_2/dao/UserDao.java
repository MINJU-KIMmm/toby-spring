package com.mimmu.chapter01.sub1_2.dao;

import com.mimmu.chapter01.sub1_1.domain.User;

import java.sql.*;

public abstract class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public class NUserDao extends UserDao {
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            //N사 DB connection 생성 코드
        }
    }

    public class DUserDao extends UserDao {
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            //D사 DB connection 생성 코드
        }
    }
}
