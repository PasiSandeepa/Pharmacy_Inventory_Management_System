package service.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.SaleItem;
import model.dto.Sales;
import repository.impl.SalesItemRepositoryImpl;
import service.SaleService;
import service.SalesItemService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SalesItemServiceImpl implements SalesItemService {
    private final SalesItemRepositoryImpl salesItemRepository = new SalesItemRepositoryImpl();

    @Override
    public List<SaleItem> getAllSaleItems() {
        return salesItemRepository.getAllSaleItems();
    }
    @Override
    public void addSaleItem(Sales newSaleItem, ObservableList<CartItem> cartItems) {
        try {
            SaleService saleService = new SalesServiceImpl();


            int saleId = saleService.addSales(newSaleItem);
            if (saleId <= 0) return;


            for (CartItem cartItem : cartItems) {
                salesItemRepository.addSaleItem(
                        new SaleItem(
                                0,
                                saleId,
                                cartItem.getMedicineId(),
                                cartItem.getQuantity(),
                                cartItem.getUnitPrice(),
                                newSaleItem.getCreated_at()
                        )
                );
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    public String generateInvoiceNo() {

        String SQL = "SELECT invoice_no FROM sales ORDER BY id DESC LIMIT 1";
        String lastInvoice = null;

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lastInvoice = resultSet.getString("invoice_no");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lastInvoice == null) {
            return "INV0001";
        }

        int number = Integer.parseInt(lastInvoice.replace("INV", "")) + 1;

        return String.format("INV%04d", number);
    }
}

