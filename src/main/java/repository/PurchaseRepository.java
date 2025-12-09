package repository;

import model.dto.Purchases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PurchaseRepository {
    boolean addPurchase(Purchases purchases);

    boolean updatePurchase(Purchases purchases);

   ResultSet getAllPurchases() throws SQLException;

    Purchases searchByInvoiceNo(String s);

    Boolean deletePurchase(String invoiceno);
}
