package com.codegym.casestudymodule3.controller.Home;

import com.codegym.casestudymodule3.Context.Config;
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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "paymentServlet", urlPatterns = "/checkout")
public class PaymentServlet extends HttpServlet {
    private UserDAO userDAO;
    private BillDAO billDAO;
    private ProductDAO productDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        billDAO = new BillDAO();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        showCheckOut(request,response);
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
            if(payment_method == null) {
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
                    if (payment_method.equals("vnpay")) {
                        payment = "VNPAY";
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
                    if (payment_method.equals("vnpay")) {
                        Bill bill = billDAO.getBill();
                        String vnp_Version = "2.0.0";
                        String vnp_Command = "pay";
                        String vnp_OrderInfo = "Thanh toan don hang" + bill.getBill_id();
                        String orderType = "billpayment";
                        String vnp_TxnRef = bill.getBill_id() + "";
                        String vnp_IpAddr = Config.getIpAddress(request);
                        String vnp_TmnCode = Config.vnp_TmnCode;

                        int amount = (int) (Math.round(bill.getTotal()) * 100);
                        Map<String, String> vnp_Params = new HashMap<>();
                        vnp_Params.put("vnp_Version", vnp_Version);
                        vnp_Params.put("vnp_Command", vnp_Command);
                        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                        vnp_Params.put("vnp_Amount", String.valueOf(amount));
                        vnp_Params.put("vnp_CurrCode", "VND");
                        String bank_code = "";
                        if (bank_code != null && bank_code.isEmpty()) {
                            vnp_Params.put("vnp_BankCode", bank_code);
                        }
                        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
                        vnp_Params.put("vnp_OrderType", orderType);

                        String locate = "vi";
                        if (locate != null && !locate.isEmpty()) {
                            vnp_Params.put("vnp_Locale", locate);
                        } else {
                            vnp_Params.put("vnp_Locale", "vn");
                        }
                        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
                        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

                        Date dt = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                        String dateString = formatter.format(dt);
                        String vnp_CreateDate = dateString;
                        String vnp_TransDate = vnp_CreateDate;
                        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

                        //Build data to hash and querystring
                        List fieldNames = new ArrayList(vnp_Params.keySet());
                        Collections.sort(fieldNames);
                        StringBuilder hashData = new StringBuilder();
                        StringBuilder query = new StringBuilder();
                        Iterator itr = fieldNames.iterator();
                        while (itr.hasNext()) {
                            String fieldName = (String) itr.next();
                            String fieldValue = (String) vnp_Params.get(fieldName);
                            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                                //Build hash data
                                hashData.append(fieldName);
                                hashData.append('=');
                                hashData.append(fieldValue);
                                //Build query
                                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                                query.append('=');
                                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                                if (itr.hasNext()) {
                                    query.append('&');
                                    hashData.append('&');
                                }
                            }
                        }
                        String queryUrl = query.toString();
                        String vnp_SecureHash = Config.Sha256(Config.vnp_HashSecret + hashData.toString());
                        queryUrl += "&vnp_SecureHashType=SHA256&vnp_SecureHash=" + vnp_SecureHash;
                        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
                        request.setAttribute("code", "00");
                        request.setAttribute("message", "success");
                        request.setAttribute("data", paymentUrl);
                        response.sendRedirect(paymentUrl);
                        return;
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
