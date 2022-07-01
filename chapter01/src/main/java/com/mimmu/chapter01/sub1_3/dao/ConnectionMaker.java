package com.mimmu.chapter01.sub1_3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
