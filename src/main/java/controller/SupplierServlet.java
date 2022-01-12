package controller;

import model.Supplier;
import service.SupplierService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {""})
public class SupplierServlet extends HttpServlet {
    SupplierService supplierService = new SupplierService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/createSupplier.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("idSupplier"));
                supplierService.delete(id);
                response.sendRedirect("/");
                break;
            case "edit":
                int idSupplier = Integer.parseInt(request.getParameter("idSupplier"));
                try {
                    request.setAttribute("listSupplierEdit", supplierService.getSupplierById(idSupplier));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                requestDispatcher = request.getRequestDispatcher("view/editSupplier.jsp");
                requestDispatcher.forward(request, response);
                break;
            default:
                supplierService.show();
                request.setAttribute("listSupplier", supplierService.list);
                requestDispatcher = request.getRequestDispatcher("indexSupplier.jsp");
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
                String nameSupplier = request.getParameter("nameSupplier");
                String descriptionSupplier = request.getParameter("descriptionSupplier");
                Supplier supplier = new Supplier(nameSupplier, descriptionSupplier);
                supplierService.save(supplier);
                response.sendRedirect("/");
                break;
            case "edit":
                String nameSupplierEdit = request.getParameter("nameSupplier");
                String descriptionSupplierEdit = request.getParameter("descriptionSupplier");
                Supplier supplier1 = new Supplier(nameSupplierEdit, descriptionSupplierEdit);
                int indexEdit = Integer.parseInt(request.getParameter("idSupplier"));
                supplierService.edit(supplier1, indexEdit);
                response.sendRedirect("/");
                break;
        }
    }
}
