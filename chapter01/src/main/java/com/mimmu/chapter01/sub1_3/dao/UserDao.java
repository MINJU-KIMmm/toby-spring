package com.mimmu.chapter01.sub1_3.dao;

import com.mimmu.chapter01.sub1_1.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker; //인터페이스를 통해 오브젝트에 접근. 구체적인 클래스 정보 알필요 X

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection(); // 인터페이스에 정의된 메소드 사용. 클래스가 바뀐다 해도 메소드 이름 변경 X
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
    }
}
