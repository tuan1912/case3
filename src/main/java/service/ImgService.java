package service;

import dao.ImgDao;
import model.Img;

import java.sql.SQLException;
import java.util.ArrayList;

public class ImgService {
    ImgDao imgDao = new ImgDao();
    public ArrayList<Img> list = new ArrayList<>();

    public void show() {
        try {
            list = imgDao.showImg();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Img img) {
        try {
            imgDao.addImg(img);
            list = imgDao.showImg();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Img img, int index) {
        try {
            imgDao.editImg(index, img);
            list = imgDao.showImg();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            imgDao.deleteImg(id);
            list = imgDao.showImg();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Img getImgById(int id) throws SQLException {
        for (int i = 0; i < imgDao.showImg().size(); i++) {
            if (id == imgDao.showImg().get(i).getIdImg()) {
                return imgDao.showImg().get(i);
            }
        }
        return null;
    }
}
