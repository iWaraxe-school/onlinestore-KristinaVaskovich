package db;

import store.Store;

import java.sql.*;

public class DBConnector {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?autoReconnect=false&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "password";
    private Store store = Store.getStore();

    public void createAndFillDB() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            String createDatabaseCommand = "CREATE DATABASE store";
            statement.executeUpdate(createDatabaseCommand);

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/store?autoReconnect=false&useSSL=false", USER, PASS);
            statement = connection.createStatement();
            String createCategoriesTableCommand = "CREATE TABLE categories(CategoryName VARCHAR(20))";
            statement.executeUpdate(createCategoriesTableCommand);

            for (int i = 0; i < store.getCategoryList().size(); i++) {
                String insertIntoCategoriesCommand = "INSERT INTO categories(CategoryName) VALUES('" + store.getCategoryList().get(i).getName() + "')";
                statement.executeUpdate(insertIntoCategoriesCommand);
            }

            for (int i = 0; i < store.getCategoryList().size(); i++) {
                String sqlCreateCategoryTableCommand = "CREATE TABLE " + store.getCategoryList().get(i).getName() + "(ProductName VARCHAR(20), Price INT, Rate INT)";
                statement.executeUpdate(sqlCreateCategoryTableCommand);
                for (int j = 0; j < store.getCategoryList().get(i).getProducts().size(); j++) {
                    String insertIntoCategoryTableCommand = "INSERT INTO " + store.getCategoryList().get(i).getName() + "(ProductName, Price, Rate) VALUES('" + store.getCategoryList().get(i).getProducts().get(j).getName() + "'," +
                            store.getCategoryList().get(i).getProducts().get(j).getPrice() + "," + store.getCategoryList().get(i).getProducts().get(j).getRate() + ")";
                    statement.executeUpdate(insertIntoCategoryTableCommand);
                }
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
