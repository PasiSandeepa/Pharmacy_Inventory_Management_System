package service.impl;

import model.dto.Suppliers;
import repository.SupplierRepository;
import service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
   private  final  SupplierRepository supplierRepository =  new SupplierRepository();

    @Override
    public boolean addSupplier(Suppliers suppliers) {
        return  supplierRepository.addSupplier(suppliers);
    }
}
