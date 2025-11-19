package repository;

import db.DBConnection;
import model.dto.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierRepository {
    public boolean addSupplier(Suppliers suppliers) {
        String SQL="Insert into suppliers(name,phone,email,address,created_at)Values(?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, suppliers.getName());
            preparedStatement.setString(2, suppliers.getPhone());
            preparedStatement.setString(3, suppliers.getEmail());
            preparedStatement.setString(4, suppliers.getAddress());
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(suppliers.getCreatedAt().atStartOfDay()));
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
