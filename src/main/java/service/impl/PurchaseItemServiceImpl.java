package service.impl;

import model.dto.Purchase_items;
import repository.PurchaseItemRepository;
import service.PurchaseItemService;

import java.util.List;

public class PurchaseItemServiceImpl implements PurchaseItemService {

    private final PurchaseItemRepository purchaseItemRepository= new PurchaseItemRepository();

    @Override
    public boolean addPurchaseItem(Purchase_items purchaseItems) {
        return purchaseItemRepository.addPurchaseItem(purchaseItems);
    }

    @Override
    public boolean updatePurchaseItem(Purchase_items purchaseItems) {
        return  purchaseItemRepository.updatePurchaseItems(purchaseItems);
    }

    @Override
    public Purchase_items findPurchaseItemByNo(String batchNo) {
     return  purchaseItemRepository.findBybatchNo(batchNo);
    }

    @Override
    public List<Purchase_items> getAllPurchaseItems() {
       return  purchaseItemRepository.getAllPurchaseItems();
    }

    @Override
    public boolean deletePurchaseItems(String batchNo) {
        return  purchaseItemRepository.deletePurchaseItems(batchNo);
    }

}
