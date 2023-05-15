package com.codegym.casestudymodule3.controller.Home;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "paymentServlet", urlPatterns = "/checkout")
public class PaymentServlet extends HttpServlet {
    private BillDAO billDAO;

    @Override
    public void init() throws ServletException {
        billDAO = new BillDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        showCheckOut(request, response);
    }

    private void showCheckOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "payment":
                payment(request, response);
                break;
            default:
        }
    }

    private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            Cart cart = null;
            String payment = null;
            String payment_method = request.getParameter("payment_method");
            if (payment_method == null) {
                request.setAttribute("error", "Vui lòng chọn chức năng thanh toán!");
                request.getRequestDispatcher("/checkout.jsp").forward(request, response);
            }
            //check card
            Object o = session.getAttribute("cart");
            if (o != null) {
                cart = (Cart) o;
            } else {
                cart = new Cart();
            }
            User acc = null;
            Object u = session.getAttribute("user");
            if (o != null) {
                if (u != null) {
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    if (payment_method.equals("momo")) {
                        payment = "MOMO";
                    }
                    if (payment_method.equals("cod")) {
                        payment = "COD";
                    }
                    acc = (User) u;
                    billDAO.addOrder(acc, cart, payment, address, phone);
                    session.removeAttribute("cart");
                    session.setAttribute("size", 0);
                    if (payment_method.equals("cod")) {
                        request.setAttribute("message", "success");
                        request.getRequestDispatcher("checkout.jsp").forward(request, response);
                    }
                    if (payment_method.equals("momo")) {
                        Bill bill = billDAO.getBill();
                        int total = (int) Math.round(bill.getTotal());
                        request.setAttribute("total", total);
                        request.setAttribute("bill", bill);
                        request.getRequestDispatcher("qrcode.jsp").forward(request, response);
                    }
                } else {
                    response.sendRedirect("user?action=login");
                }
            } else {
                if (payment_method.equals("momo")) {
                    Bill bill = billDAO.getBill();
                    int total = (int) Math.round(bill.getTotal());
                    request.setAttribute("total", total);
                    request.setAttribute("bill", bill);
                    request.getRequestDispatcher("qrcode.jsp").forward(request, response);
                }
                if (payment_method.equals("cod")) {
                    request.setAttribute("message", "success");
                    request.getRequestDispatcher("checkout.jsp").forward(request, response);
                }
            }
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        } catch (IOException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        } catch (ServletException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        } catch (SQLException e) {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
