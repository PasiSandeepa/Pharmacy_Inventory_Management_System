package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Medicine;

import repository.MedicineRepository;
import repository.impl.MedicineRepositoryImpl;
import service.MedicineService;

import java.sql.SQLException;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository = new MedicineRepositoryImpl();

    @Override
    public boolean addMedicine(Medicine medicine) {
        return medicineRepository.addMedicine(medicine);
    }

    @Override
    public Medicine searchByName(String name) {
        return medicineRepository.searchByName(name);
    }


    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.getAllMedicines();
    }

    @Override
    public boolean Update(Medicine medicine) {
        return medicineRepository.updateMedicine(medicine);
    }

    @Override
    public boolean deleteMedicine(String name) throws SQLException {
      return  medicineRepository.deleteMedicine(name);
    }

    @Override
    public void updateMedicineQty(ObservableList<CartItem> cartItems) {
        for (CartItem cartItem : cartItems){
            try {
                medicineRepository.updateMedicineQty(cartItem.getMedicineId(),cartItem.getQuantity());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
