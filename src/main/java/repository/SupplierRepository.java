package repository;

import model.dto.Suppliers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SupplierRepository {
    boolean addSupplier(Suppliers suppliers);

    boolean updateSupplier(Suppliers suppliers);

    ResultSet getAllSuppliers() throws SQLException;

    Suppliers findByName(String name);

    boolean deleteSupplier(String id);
}
