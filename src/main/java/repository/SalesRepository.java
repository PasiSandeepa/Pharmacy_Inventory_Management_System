package repository;

import db.DBConnection;
import model.dto.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository {

    public List<Sales> getAllSales() {
        Sales sales = null;
        ArrayList<Sales> sales1 = new ArrayList<>();
        String SQL = "SELECT * FROM sales";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sales = new Sales(
                        resultSet.getInt("id"),
                        resultSet.getString("invoice_no"),
                        resultSet.getDate("sale_date").toLocalDate().atStartOfDay(),
                        resultSet.getString("cashier"),
                        resultSet.getDouble("total_amount"),
                        resultSet.getDate("created_at").toLocalDate().atStartOfDay()
                );
                sales1.add(sales);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return sales1;
    }
}