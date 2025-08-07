package com.algonquin.www.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Singleton class responsible for creating and managing a single database connection.
 * <p>
 * This class reads database connection properties from a {@code database.properties} file
 * located in the classpath and establishes a connection to the MySQL database using JDBC.
 * It ensures only one connection instance is created and reused throughout the application.
 * </p>
 * 
 * <p><strong>Usage example:</strong></p>
 * <pre>
 * Connection conn = DataSource.createConnection();
 * </pre>
 * 
 * <p><strong>Note:</strong> This implementation is basic and not thread-safe.
 * Consider enhancements for production use, such as connection pooling and thread safety.</p>
 * 
 * @author YourName
 */

public class DataSource {
    
     /** Singleton database connection instance */

    private static Connection connection = null;
    
    /**
     * Private constructor to prevent instantiation.
     */

    private DataSource() {
    }
    /**
     * Creates and returns a singleton database connection.
     * <p>
     * If a connection has already been established, the existing connection is returned.
     * Otherwise, it reads the connection properties from {@code database.properties}
     * and attempts to create a new connection.
     * </p>
     * 
     * @return a singleton {@link Connection} instance to the database
     */

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
