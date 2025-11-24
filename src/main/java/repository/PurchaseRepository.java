package repository;

import model.dto.Purchases;

import java.util.List;

public interface PurchaseRepository {
    boolean addPurchase(Purchases purchases);

    boolean updatePurchase(Purchases purchases);

    List<Purchases> getAllPurchases();

    Purchases searchByInvoiceNo(String s);

    Boolean deletePurchase(String invoiceno);
}
