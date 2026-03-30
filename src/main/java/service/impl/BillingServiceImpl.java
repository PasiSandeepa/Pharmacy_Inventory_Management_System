package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Medicine;
import model.dto.Sales;
import repository.MedicineRepository;
import repository.impl.MedicineRepositoryImpl;
import service.BillingService;
import service.SaleService;
import service.SalesItemService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingServiceImpl implements BillingService {
    MedicineServiceImpl medicineService;
    MedicineRepository medicineRepository = new MedicineRepositoryImpl();
    SaleService saleService = new SalesServiceImpl();


    @Override
    public ObservableList<Medicine> searchByName(String name) {
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = medicineRepository.searchByName(name);
            if (resultSet.next()) {
                Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getString("batch_no"),
                        resultSet.getDate("expiry_date").toLocalDate(),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unit_price"),
                        resultSet.getInt("reorder_level"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );

                list.add(medicine);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void billing(Sales sales, ObservableList<CartItem> cartItems) {
        SaleService saleService1 = new SalesServiceImpl();


        int saleId = saleService1.addSales(sales);
        if (saleId <= 0) return;


        sales.setId(saleId);

        SalesItemService salesItemService = new SalesItemServiceImpl();
        salesItemService.addSaleItem(sales, cartItems);

        medicineService.updateMedicineQty(cartItems);
    }

}