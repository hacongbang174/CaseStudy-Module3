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
    private ProductDAO productDAO;
    private BillDAO billDAO;
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        billDAO = new BillDAO();
        userDAO = new UserDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String action = request.getParameter("action");
            BillDAO dao = new BillDAO();

            if (user.getRole().equalsIgnoreCase("true")) {
                if (action == null) {
                    List<Bill> bill = dao.getBillInfo();
                    request.setAttribute("bill", bill);
                    request.getRequestDispatcher("admin/order.jsp").forward(request, response);
                }
                if(action.equals("showDetail")){
                   String bill_id = request.getParameter("bill_id");
                   int id = Integer.parseInt(bill_id);
                   List<BillDetail> detail = dao.getDetail(id);
                   request.setAttribute("detail", detail);
                   request.getRequestDispatcher("admin/orderetail.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("user?action=login");
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
