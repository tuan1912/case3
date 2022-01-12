package service;

import dao.CategoryDao;
import model.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public ArrayList<Category> list = new ArrayList<>();

    public void show() {
        try {
            list = categoryDao.showCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Category category) {
        try {
            categoryDao.addCategory(category);
            list = categoryDao.showCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Category category, int index) {
        try {
            categoryDao.editCategory(index, category);
            list = categoryDao.showCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            categoryDao.deleteCategory(id);
            list = categoryDao.showCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Category getCategoryById(int id) throws SQLException {
        for (int i = 0; i < categoryDao.showCategory().size(); i++) {
            if(id==categoryDao.showCategory().get(i).getIdCategory()){
                return categoryDao.showCategory().get(i);
            }
        }
        return null;
    }
}
