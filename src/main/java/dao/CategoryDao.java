package dao;

import model.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDao {
    Connection connection = ConnectMySQL.getConnection();

    public ArrayList<Category> showCategory() throws SQLException {
        String select = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Category> list = new ArrayList<>();
        while (resultSet.next()) {
            int idCategory = resultSet.getInt("idCategory");
            String nameCategory = resultSet.getString("nameCategory");
            String codeCategory = resultSet.getString("codeCategory");
            String descriptionCategory = resultSet.getString("descriptionCategory");
            list.add(new Category(idCategory, nameCategory, codeCategory, descriptionCategory));
        }
        return list;
    }

    public void addCategory(Category category) throws SQLException {
        String insert = "INSERT INTO category (`nameCategory`, `codeCategory`, `descriptionCategory`) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, category.getNameCategory());
        preparedStatement.setString(2, category.getCodeCategory());
        preparedStatement.setString(3, category.getDescriptionCategory());
        preparedStatement.execute();
    }

    public void editCategory(int id, Category category) throws SQLException {
        String update = "UPDATE category SET `nameCategory` = ?, `codeCategory` = ?, `descriptionCategory` = ? WHERE (`idCategory` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, category.getNameCategory());
        preparedStatement.setString(2, category.getCodeCategory());
        preparedStatement.setString(3, category.getDescriptionCategory());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();
    }

    public void deleteCategory(int id) throws SQLException {
        String delete = "DELETE FROM category WHERE idCategory=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
}
