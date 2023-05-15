package com.codegym.casestudymodule3.controller.Admin;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.model.Bill;
import com.codegym.casestudymodule3.model.User;
import com.codegym.casestudymodule3.utils.CurrencyFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "revenueServlet", urlPatterns = "/revenueManager")
public class RevenueServlet extends HttpServlet {
    private BillDAO billDAO;
    @Override
    public void init() throws ServletException {
        billDAO = new BillDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getRole().equalsIgnoreCase("true")) {
                request.setAttribute("total", billDAO.revenue());
                request.setAttribute("bill1", billDAO.revenueByMonth(1));
                request.setAttribute("bill2", billDAO.revenueByMonth(2));
                request.setAttribute("bill3", billDAO.revenueByMonth(3));
                request.setAttribute("bill4", billDAO.revenueByMonth(4));
                request.setAttribute("bill5", billDAO.revenueByMonth(5));
                request.setAttribute("bill6", billDAO.revenueByMonth(6));
                request.setAttribute("bill7", billDAO.revenueByMonth(7));
                request.setAttribute("bill8", billDAO.revenueByMonth(8));
                request.setAttribute("bill9", billDAO.revenueByMonth(9));
                request.setAttribute("bill10", billDAO.revenueByMonth(10));
                request.setAttribute("bill11", billDAO.revenueByMonth(11));
                request.setAttribute("bill12", billDAO.revenueByMonth(12));
                request.getRequestDispatcher("admin/revenue.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?action=login");
            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
