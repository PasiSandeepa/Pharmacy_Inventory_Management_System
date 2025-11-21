package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Medicine;
import model.dto.SaleItem;
import model.dto.Sales;
import service.BillingService;
import service.MedicineService;
import service.SaleService;
import service.SalesItemService;

public class BillingServiceImpl implements BillingService {
    MedicineService medicineService = new MedicineServiceImpl();
    SaleService saleService = new SalesServiceImpl();

    @Override
    public Medicine searchByName(String name) {
        return medicineService.searchByName(name);
    }

    @Override
    public void billing(Sales sales, ObservableList<CartItem> cartItems) {
        try {
            SaleService saleService1 = new SalesServiceImpl();
            saleService1.addSales(sales);


            for (CartItem item : cartItems) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}