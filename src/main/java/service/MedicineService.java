package service;

import model.dto.Medicine;

import java.util.List;

public interface MedicineService {

    boolean addMedicine(Medicine medicine);
    Medicine searchByName(String name);
    List<Medicine> getAllMedicines();
    boolean Update(Medicine medicine);
    boolean deleteMedicine(String name);


}
