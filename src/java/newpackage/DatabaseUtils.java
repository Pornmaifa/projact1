/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.TeaOrder;

public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/tea_shop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "UBU_12345678";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void saveOrder(TeaOrder order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orders (customer_name, tea_name, topping, sweetness, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getTeaName());
            stmt.setString(3, order.getTopping());
            stmt.setString(4, order.getSweetness());
            stmt.setDouble(5, order.getPrice());
            stmt.executeUpdate();
        }
    }
}