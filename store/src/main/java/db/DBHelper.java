package db;

import lombok.SneakyThrows;
import products.Product;
import store.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/store?autoReconnect=false&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "password";
    private Store store = Store.getStore();
    private Connection connection;
    private Statement statement;

    @SneakyThrows
    private void createConnection() {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }

    @SneakyThrows
    public void fillDB() {
        createConnection();
        String createCategoriesTableCommand = "CREATE TABLE categories(CategoryName VARCHAR(255) NOT NULL PRIMARY KEY)";
        statement.executeUpdate(createCategoriesTableCommand);

        for (int i = 0; i < store.getCategoryList().size(); i++) {
            String insertIntoCategoriesCommand = "INSERT INTO categories(CategoryName) VALUES(?)";
            PreparedStatement pstmt = connection.prepareStatement(insertIntoCategoriesCommand);
            pstmt.setString(1, store.getCategoryList().get(i).getName().toString());
            pstmt.execute();
        }

        for (int i = 0; i < store.getCategoryList().size(); i++) {
            String sqlCreateCategoryTableCommand = "CREATE TABLE " + store.getCategoryList().get(i).getName() + "(ProductName VARCHAR(255) NOT NULL, Price INT, Rate INT)";
            statement.executeUpdate(sqlCreateCategoryTableCommand);
            for (int j = 0; j < store.getCategoryList().get(i).getProducts().size(); j++) {
                String insertIntoCategoryTableCommand = "INSERT INTO " + store.getCategoryList().get(i).getName() + " (ProductName, Price, Rate) VALUES(?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(insertIntoCategoryTableCommand);
                pstmt.setString(1, store.getCategoryList().get(i).getProducts().get(j).getName());
                pstmt.setInt(2, store.getCategoryList().get(i).getProducts().get(j).getPrice());
                pstmt.setInt(3, store.getCategoryList().get(i).getProducts().get(j).getRate());
                pstmt.execute();
            }
        }

        String sqlCreateAllProductsTableCommand = "CREATE TABLE products (ProductName VARCHAR(255) NOT NULL, Price INT, Rate INT, CategoryName VARCHAR(255), FOREIGN KEY (CategoryName)  REFERENCES categories(CategoryName))";
        statement.executeUpdate(sqlCreateAllProductsTableCommand);
        for (int i = 0; i < store.getCategoryList().size(); i++) {
            for (int j = 0; j < store.getCategoryList().get(i).getProducts().size(); j++) {
                String insertIntoProductsTableCommand  = "INSERT INTO products (ProductName, Price, Rate, CategoryName) VALUES(?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(insertIntoProductsTableCommand);
                pstmt.setString(1, store.getCategoryList().get(i).getProducts().get(j).getName());
                pstmt.setInt(2, store.getCategoryList().get(i).getProducts().get(j).getPrice());
                pstmt.setInt(3, store.getCategoryList().get(i).getProducts().get(j).getRate());
                pstmt.setString(4, store.getCategoryList().get(i).getName().toString());
                pstmt.execute();
            }
        }
        closeConnection();
    }

    @SneakyThrows
    public List<Product> getAllProductsFromDB() {
        createConnection();
        List<Product> products = new ArrayList<>();
        String sqlGetAllProducts = "Select * From store.products";
        ResultSet resultSet = statement.executeQuery(sqlGetAllProducts);
        while (resultSet.next()) {
            Product product = new Product();
            product.setName(resultSet.getString("ProductName"));
            product.setPrice(resultSet.getInt("Price"));
            product.setRate(resultSet.getInt("Rate"));
            products.add(product);
        }
        closeConnection();
        return products;
    }

    @SneakyThrows
    private void closeConnection() {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
