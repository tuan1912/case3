package dao;

import model.Supplier;

import java.sql.*;
import java.util.ArrayList;

public class SupplierDao {
    Connection connection = ConnectMySQL.getConnection();

    public ArrayList<Supplier> showSupplier() throws SQLException {
        String select = "select * from supplier";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Supplier> list = new ArrayList<>();
        while (resultSet.next()) {
            int idSupplier = resultSet.getInt("idSupplier");
            String nameSupplier = resultSet.getString("nameSupplier");
            String descriptionSupplier = resultSet.getString("descriptionSupplier");
            list.add(new Supplier(idSupplier, nameSupplier, descriptionSupplier));
        }
        return list;
    }

    public void addSupplier(Supplier supplier) throws SQLException {
        String insert = "INSERT INTO supplier (`nameSupplier`, `descriptionSupplier`) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, supplier.getNameSupplier());
        preparedStatement.setString(2, supplier.getDescriptionSupplier());
        preparedStatement.execute();
    }

    public void editSupplier(int id, Supplier supplier) throws SQLException {
        String update = "UPDATE supplier SET `nameSupplier` = ?, `descriptionSupplier` = ? WHERE (`idSupplier` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, supplier.getNameSupplier());
        preparedStatement.setString(2, supplier.getDescriptionSupplier());
        preparedStatement.setInt(3, id);
        preparedStatement.execute();
    }

    public void deleteSupplier(int id) throws SQLException {
        String delete = "DELETE FROM supplier WHERE idSupplier=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
}
