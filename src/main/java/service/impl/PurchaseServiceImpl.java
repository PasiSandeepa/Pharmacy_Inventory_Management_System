package service.impl;

import model.dto.Purchases;
import repository.PurchaseRepository;
import repository.impl.PurchaseRepositoryImpl;
import service.PurchaseService;

import java.util.List;


public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository=new PurchaseRepositoryImpl();

    @Override
    public boolean addPurchase(Purchases purchases) {
        return  purchaseRepository.addPurchase(purchases);
    }

    @Override
    public boolean updatePurchase(Purchases purchases) {
        return purchaseRepository.updatePurchase(purchases);
    }

    @Override
    public List<Purchases> getAllPurchases() {
   return purchaseRepository.getAllPurchases();
    }

    @Override
    public Purchases findPurchaseById(int id) {
        return purchaseRepository.searchByInvoiceNo(String.valueOf(id));}

    @Override
    public Boolean deletePurchase(String invoiceno) {
   return purchaseRepository.deletePurchase(invoiceno);
    }

}






