package com.codegym.casestudymodule3.controller.Admin;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.DAO.ProductDAO;
import com.codegym.casestudymodule3.model.Bill;
import com.codegym.casestudymodule3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashboardServlet", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {
    private ProductDAO productDAO;
    private BillDAO billDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        billDAO = new BillDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getRole().equalsIgnoreCase("true")) {
                int count = productDAO.CountProduct();
                int countuser = productDAO.CountUser();
                int countbill = productDAO.CountBill();
                int countproductlow = productDAO.CountProductLow();
                List<Bill> billbyday = billDAO.getBillByDay();
                request.setAttribute("product", count);
                request.setAttribute("user", countuser);
                request.setAttribute("bill", countbill);
                request.setAttribute("low", countproductlow);
                request.setAttribute("billbyday", billbyday);
                request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            } else {
                response.sendRedirect("login");
            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {

    }
}
