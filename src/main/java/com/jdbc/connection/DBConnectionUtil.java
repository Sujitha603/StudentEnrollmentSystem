package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/student_enrollment_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sujitha@123";

    private DBConnectionUtil() {

    }

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
