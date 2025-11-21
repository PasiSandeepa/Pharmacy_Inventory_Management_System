package service.impl;

import model.dto.Sales;
import repository.SalesRepository;
import service.SaleService;

import java.util.List;

public class SalesServiceImpl implements SaleService {

    private final SalesRepository salesRepositorya=new SalesRepository();

    @Override
    public List<Sales> getAllSales() {
        return salesRepositorya.getAllSales();
    }
}

