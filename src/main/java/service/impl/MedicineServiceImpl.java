package service.impl;

import model.dto.Medicine;

import repository.MedicineRepository;
import service.MedicineService;

import java.sql.SQLException;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository = new MedicineRepository();

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
        try {
            return medicineRepository.updateMedicine(medicine);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteMedicine(String name) throws SQLException {
      return  medicineRepository.deleteMedicine(name);
    }



}
