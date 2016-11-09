package com.mybank.atm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DataBase jdbcExample = new DataBase();
        Properties properties = jdbcExample.loadProperties();
        return (Connection) DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("db.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

