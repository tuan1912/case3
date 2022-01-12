package dao;

import model.Img;

import java.sql.*;
import java.util.ArrayList;

public class ImgDao {
    Connection connection = ConnectMySQL.getConnection();

    public ArrayList<Img> showImg() throws SQLException {
        String select = "select * from img";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Img> list = new ArrayList<>();
        while (resultSet.next()) {
            int idImg = resultSet.getInt("idImg");
            int idProduct = resultSet.getInt("idProduct");
            String img = resultSet.getString("img");
            list.add(new Img(idImg, idProduct, img));
        }
        return list;
    }

    public void addImg(Img img) throws SQLException {
        String insert = "INSERT INTO img (`idProduct`, `img`) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, img.getIdProduct());
        preparedStatement.setString(2, img.getImg());
        preparedStatement.execute();
    }

    public void editImg(int id, Img img) throws SQLException {
        String update = "UPDATE img SET `idProduct` = ?, `img` = ? WHERE (`idImg` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setInt(1, img.getIdProduct());
        preparedStatement.setString(2, img.getImg());
        preparedStatement.setInt(3, id);
        preparedStatement.execute();
    }

    public void deleteImg(int id) throws SQLException {
        String delete = "DELETE FROM img WHERE idImg=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
}
