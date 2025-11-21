package service;

import model.dto.Medicine;

import java.sql.SQLException;
import java.util.List;

public interface MedicineService {

    boolean addMedicine(Medicine medicine);
    Medicine searchByName(String name);
    List<Medicine> getAllMedicines();
    boolean Update(Medicine medicine);
    boolean deleteMedicine(String name) throws SQLException;


}
