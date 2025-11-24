package repository.impl;

import db.DBConnection;
import model.dto.Suppliers;
import repository.SupplierRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {
    public boolean addSupplier(Suppliers suppliers) {
        String SQL = "Insert into suppliers(name,phone,email,address,created_at)Values(?,?,?,?,?)";
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

    public boolean updateSupplier(Suppliers suppliers) {
        String SQL = "Update suppliers set name=?,phone=?,email=?,address=?,created_at=? where id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, suppliers.getName());
            preparedStatement.setString(2, suppliers.getPhone());
            preparedStatement.setString(3, suppliers.getEmail());
            preparedStatement.setString(4, suppliers.getAddress());
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(suppliers.getCreatedAt().atStartOfDay()));
            preparedStatement.setInt(6, Integer.parseInt(suppliers.getId()));
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Suppliers> getAllSuppliers() {
        List<Suppliers> supplierList = new ArrayList<>();

        String SQL = "SELECT * FROM suppliers";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Suppliers suppliers = new Suppliers();

                suppliers.setId(String.valueOf(resultSet.getInt("id")));
                suppliers.setName(resultSet.getString("name"));
                suppliers.setPhone(resultSet.getString("phone"));
                suppliers.setEmail(resultSet.getString("email"));
                suppliers.setAddress(resultSet.getString("address"));
                suppliers.setCreatedAt(resultSet.getDate("created_at").toLocalDate());

                supplierList.add(suppliers);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error loading suppliers", e);
        }

        return supplierList;
    }
    public Suppliers findByName(String name) {
        String SQL = "SELECT * FROM suppliers WHERE name = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Suppliers suppliers = new Suppliers();
                    suppliers.setId(String.valueOf(resultSet.getInt("id")));
                    suppliers.setName(resultSet.getString("name"));
                    suppliers.setPhone(resultSet.getString("phone"));
                    suppliers.setEmail(resultSet.getString("email"));
                    suppliers.setAddress(resultSet.getString("address"));
                    suppliers.setCreatedAt(resultSet.getDate("created_at").toLocalDate());
                    return suppliers;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding supplier by name", e);
        }
        return null;
    }
    public boolean deleteSupplier(String id) {
        String SQL = "DELETE FROM suppliers WHERE id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting supplier", e);
        }
        return false;
    }
}