package controller;

import model.Category;
import service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {""})
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/createCategory.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("idCategory"));
                categoryService.delete(id);
                response.sendRedirect("/");
                break;
            case "edit":
                int idCategory = Integer.parseInt(request.getParameter("idCategory"));
                try {
                    request.setAttribute("listCategoryEdit", categoryService.getCategoryById(idCategory));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                requestDispatcher = request.getRequestDispatcher("view/editCategory.jsp");
                requestDispatcher.forward(request, response);
                break;
            default:
                categoryService.show();
                request.setAttribute("listCategory", categoryService.list);
                requestDispatcher = request.getRequestDispatcher("indexCategory.jsp");
                requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String nameCategory = request.getParameter("nameCategory");
                String codeCategory = request.getParameter("codeCategory");
                String descriptionCategory = request.getParameter("descriptionCategory");
                Category category = new Category(nameCategory, codeCategory, descriptionCategory);
                categoryService.save(category);
                response.sendRedirect("/");
                break;
            case "edit":
                String nameCategoryEdit = request.getParameter("nameCategory");
                String codeCategoryEdit = request.getParameter("codeCategory");
                String descriptionCategoryEdit = request.getParameter("descriptionCategory");
                Category categoryEdit = new Category(nameCategoryEdit, codeCategoryEdit, descriptionCategoryEdit);
                int indexEdit = Integer.parseInt(request.getParameter("idCategory"));
                categoryService.edit(categoryEdit, indexEdit);
                response.sendRedirect("/");
                break;
        }
    }
}
