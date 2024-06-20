package com.jpfa;
import java.sql.*;

import java.sql.SQLException;

public class Main {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java_jdbc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price_per_unit");
                boolean active = resultSet.getBoolean("active_for_sell");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price per Unit: " + price);
                System.out.println("Active for Sell: " + active);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}