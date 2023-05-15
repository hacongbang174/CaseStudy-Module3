package com.codegym.casestudymodule3.controller.Admin;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.DAO.ProductDAO;
import com.codegym.casestudymodule3.DAO.UserDAO;
import com.codegym.casestudymodule3.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderManagerServlet", urlPatterns = "/orderManager")
public class OrderManagerServlet extends HttpServlet {
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showDetail":
                showOrderDetail(request, response);
                break;
            default:
                showOrder(request, response);
        }
    }

    private void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bill_id = request.getParameter("bill_id");
        int id = Integer.parseInt(bill_id);
        List<BillDetail> detail = billDAO.getDetail(id);
        request.setAttribute("detail", detail);
        request.getRequestDispatcher("admin/orderDetail.jsp").forward(request, response);
    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getRole().equalsIgnoreCase("true")) {
                List<Bill> bill = billDAO.getBillInfo();
                request.setAttribute("bill", bill);
                request.getRequestDispatcher("admin/order.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?action=login");
            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
