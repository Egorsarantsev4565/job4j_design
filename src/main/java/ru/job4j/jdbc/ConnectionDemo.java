package ru.job4j.jdbc;

import ru.job4j.service.Settings;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Settings settings = new Settings();
        settings.load();
        Class.forName(settings.getValue("driver"));
        String url = settings.getValue("url");
        String login = settings.getValue("login");
        String password = settings.getValue("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}