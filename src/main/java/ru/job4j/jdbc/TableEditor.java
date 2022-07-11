package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws Exception {
        Properties properties = new Properties();
            Class.forName(properties.getProperty("driver"));
            return DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        }

    private void execute(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
            String sql = String.format(
                    "create table if not exists %s();", tableName);
            execute(sql);
    }

    public void dropTable(String tableName) {
            String sql = String.format(
                    "drop table if exists %s();", tableName);
            execute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
            String sql = String.format(
                    "alter table %s add %s %s;", tableName, columnName, type);
            execute(sql);
    }

    public void dropColumn(String tableName, String columnName) {
            String sql = String.format(
                    "alter table %s drop %s;", tableName, columnName);
            execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
            String sql = String.format(
                    "alter table %s rename %s to %s;", tableName, columnName, newColumnName);
            execute(sql);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            config.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(config)) {
            tableEditor.createTable("tab");
            System.out.println(TableEditor.getTableScheme(getConnection(), "tab"));
            tableEditor.addColumn("tab", "name",  "varchar(255)");
            System.out.println(TableEditor.getTableScheme(getConnection(), "tab"));
            tableEditor.renameColumn("tab", "name", "Surname");
            System.out.println(TableEditor.getTableScheme(getConnection(), "tab"));
            tableEditor.dropColumn("tab", "Surname");
            System.out.println(TableEditor.getTableScheme(getConnection(), "tab"));
            tableEditor.dropTable("tab");
            System.out.println(TableEditor.getTableScheme(getConnection(), "tab"));

        }
    }
    }