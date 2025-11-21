package service.impl;

import model.dto.Suppliers;
import repository.SupplierRepository;
import service.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
   private  final  SupplierRepository supplierRepository =  new SupplierRepository();

    @Override
    public boolean addSupplier(Suppliers suppliers) {
        return  supplierRepository.addSupplier(suppliers);
    }

    @Override
    public boolean updateSupplier(Suppliers suppliers) {
        return supplierRepository.updateSupplier(suppliers);
    }

    @Override
    public List<Suppliers> getAllSuppliers() {
        return supplierRepository.getAllSuppliers();
    }

    @Override
    public Suppliers findByName(String name) {
        return supplierRepository.findByName(name);
    }

    @Override
    public boolean deleteSupplier(String id) {
        return supplierRepository.deleteSupplier(id);
    }

}
