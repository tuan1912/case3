package service;

import dao.SupplierDao;
import model.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierService {
    SupplierDao supplierDao = new SupplierDao();
    public ArrayList<Supplier> list = new ArrayList<>();

    public void show() {
        try {
            list = supplierDao.showSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Supplier supplier) {
        try {
            supplierDao.addSupplier(supplier);
            list = supplierDao.showSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Supplier supplier, int index) {
        try {
            supplierDao.editSupplier(index, supplier);
            list = supplierDao.showSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            supplierDao.deleteSupplier(id);
            list = supplierDao.showSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Supplier getSupplierById(int id) throws SQLException {
        for (int i = 0; i < supplierDao.showSupplier().size(); i++) {
            if (id == supplierDao.showSupplier().get(i).getIdSupplier()) {
                return supplierDao.showSupplier().get(i);
            }
        }
        return null;
    }
}
