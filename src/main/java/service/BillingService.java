package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Medicine;
import model.dto.Sales;

public interface BillingService {
    Medicine searchByName(String name);
    void billing(Sales sales, ObservableList<CartItem>cartItems);


}
