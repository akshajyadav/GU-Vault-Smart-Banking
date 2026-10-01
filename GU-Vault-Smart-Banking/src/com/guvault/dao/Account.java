package com.guvault.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {
    
    public void insertTransaction(int accountId, double amount, String type) {
        String query = "INSERT INTO transactions (account_id, amount, type) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gu_vault", "root", "password");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, accountId);
            stmt.setDouble(2, amount);
            stmt.setString(3, type);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
