package com.algonquin.www.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {

    private static Connection connection = null;

    private DataSource() {
    }

    public static Connection createConnection() {
        String[] connectionInfo = openPropsFile();

        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    private static String[] openPropsFile() {
        Properties props = new Properties();

        try {
            props.load(DataSource.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String connectionString = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }
}
