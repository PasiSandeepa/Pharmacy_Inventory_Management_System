package repository;

import model.dto.Suppliers;

import java.util.List;

public interface SupplierRepository {
    boolean addSupplier(Suppliers suppliers);

    boolean updateSupplier(Suppliers suppliers);

    List<Suppliers> getAllSuppliers();

    Suppliers findByName(String name);

    boolean deleteSupplier(String id);
}
