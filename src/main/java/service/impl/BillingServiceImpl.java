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
        SaleService saleService1 = new SalesServiceImpl();


        int saleId = saleService1.addSales(sales);
        if (saleId <= 0) return;


        sales.setId(saleId);

        SalesItemService salesItemService = new SalesItemServiceImpl();
        salesItemService.addSaleItem(sales, cartItems);

        medicineService.updateMedicineQty(cartItems);
    }

}