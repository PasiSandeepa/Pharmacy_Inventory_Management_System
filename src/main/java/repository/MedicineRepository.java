package repository;

import model.dto.Medicine;

import java.sql.SQLException;
import java.util.List;

public interface MedicineRepository {

    boolean addMedicine(Medicine medicine);

    Medicine searchByName(String name);

    List<Medicine> getAllMedicines();

    boolean updateMedicine(Medicine medicine);

    boolean deleteMedicine(String name);

    void updateMedicineQty(String medicineId, int quantity) throws SQLException;
}
