package com.cb.testing.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelper {

    public static Connection getConnection(String connectionUrl) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return DriverManager.getConnection(connectionUrl, "","");
    }

    public static String getTalentNetworkDbConnectionUrl(){
        return "jdbc:sqlserver://192.168.105.90:4730;"
                + "database=TalentNetworkNew;"
                + "user=talentuser;"
                + "password=123456;";
    }

    public  static String getTalentNetworkMsqlConnectionUrl(){
        return "jdbc:mysql://192.168.105.90:4730/TalentNetworkNew?" +
                "user=talentuser&password=123456";
    }
}
