package controller;

import model.Img;
import service.ImgService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {""})
public class ImgServlet extends HttpServlet {
    ImgService imgService = new ImgService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/createImg.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("idImg"));
                imgService.delete(id);
                response.sendRedirect("/");
                break;
            case "edit":
                int idImg = Integer.parseInt(request.getParameter("idImg"));
                try {
                    request.setAttribute("listImgEdit", imgService.getImgById(idImg));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                requestDispatcher = request.getRequestDispatcher("view/editImg.jsp");
                requestDispatcher.forward(request, response);
                break;
            default:
                imgService.show();
                request.setAttribute("listImg", imgService.list);
                requestDispatcher = request.getRequestDispatcher("indexImg.jsp");
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
                int idProduct = Integer.parseInt(request.getParameter("idProduct"));
                String img = request.getParameter("img");
                Img img1 = new Img(idProduct, img);
                imgService.save(img1);
                response.sendRedirect("/");
                break;
            case "edit":
                int idProductEdit = Integer.parseInt(request.getParameter("idProduct"));
                String imgEdit = request.getParameter("img");
                Img img2 = new Img(idProductEdit, imgEdit);
                int indexEdit = Integer.parseInt(request.getParameter("idImg"));
                imgService.edit(img2, indexEdit);
                response.sendRedirect("/");
                break;
        }
    }
}
