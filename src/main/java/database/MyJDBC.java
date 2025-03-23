package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://srv-tourism.mysql.database.azure.com/tourismdb", "tourism", "TouristGuide123");


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIES");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CityName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}