package com.codegym.casestudymodule3.controller.Home;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.DAO.UserDAO;
import com.codegym.casestudymodule3.model.Bill;
import com.codegym.casestudymodule3.model.BillDetail;
import com.codegym.casestudymodule3.model.User;
import com.codegym.casestudymodule3.utils.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    private BillDAO billDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
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
            case "login":
                showLogin(request, response);
                break;
            case "signup":
                showSignup(request, response);
                break;
            case "logout":
                showLogout(request, response);
                break;
            case "myAccount":
                showMyAccount(request, response);
                break;
            case "showDetail":
                showBillDetail(request, response);
                break;
            default:
        }
    }

    private void showBillDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bill_id = request.getParameter("bill_id");
        int id = Integer.parseInt(bill_id);
        List<BillDetail> detail = billDAO.getDetail(id);
        request.setAttribute("detail", detail);
        request.getRequestDispatcher("/billdetail.jsp").forward(request, response);
    }

    private void showMyAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                int user_id = user.getUser_id();
                List<Bill> bill = billDAO.getBillByID(user_id);
                request.setAttribute("bill", bill);
                request.getRequestDispatcher("/my-account.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?action=login");
            }
        } catch (ServletException e) {
            response.sendRedirect("user?action=login");
        }
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("home");
    }

    private void showSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "checkLogin":
                checkLogin(request, response);
                break;
            case "updateInfo":
                updateInfo(request, response);
                break;
            case "signup":
                signup(request, response);
                break;

            default:
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_email = request.getParameter("user_email");
        if (!ValidateUtils.isEmail(user_email)) {
            request.setAttribute("error_email", "Email không hợp lệ. Hãy nhập lại...");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
        String user_pass = request.getParameter("user_pass");
        String re_pass = request.getParameter("re_pass");
        if (!user_pass.equals(re_pass)) {
            request.setAttribute("error_pass", "Mật khẩu không trùng khớp. Hãy nhập lại...");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        } else {
            User a = userDAO.checkAcc(user_email);
            if (a == null) {
                userDAO.signup(user_email, user_pass);
                request.setAttribute("message", "Đăng ký thành công");
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
            } else {
                request.setAttribute("emailavailable", "Email đã tồn tại!");
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
            }
        }
    }

    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("user?action=login");
            } else {
                String user_name = request.getParameter("user_name");
                if (!ValidateUtils.isFullName(user_name)) {
                    request.setAttribute("error_name", "Tên của bạn không hợp lệ. Hãy nhập lại...");
                    request.getRequestDispatcher("/my-account.jsp").forward(request, response);
                }
                String user_pass = request.getParameter("user_pass");
                int user_id = user.getUser_id();
                userDAO.updateUser(user_id, user_name, user_pass);
                User user1 = new User(user.getUser_id(), user_name, user.getUser_email(), user_pass, user.getRole());
                session.setAttribute("user", user1);
                request.setAttribute("message", "Đã cập nhật thành công");
                request.getRequestDispatcher("/my-account.jsp").forward(request, response);

            }
        } catch (Exception e) {
//            response.sendRedirect("user?action=login");
            e.printStackTrace();
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_email = request.getParameter("user_email");
        String user_pass = request.getParameter("user_pass");
        String remember = request.getParameter("remember");
        User user = userDAO.checkUser(user_email, user_pass);
        if (user == null) {
            request.setAttribute("error", "Tài khoản không tồn tại hoặc mật khẩu không đúng !");
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
//            response.sendRedirect("user?action=login");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie email = new Cookie("email", user_email);
            Cookie pass = new Cookie("pass", user_pass);
            Cookie rem = new Cookie("remember", remember);
            if (remember != null) {
                email.setMaxAge(60 * 60 * 24 * 30);
                pass.setMaxAge(60 * 60 * 24 * 3);
                rem.setMaxAge(60 * 60 * 24 * 30);
            } else {
                email.setMaxAge(0);
                pass.setMaxAge(0);
                rem.setMaxAge(0);
            }
            response.addCookie(email);
            response.addCookie(pass);
            response.addCookie(rem);
            response.sendRedirect("home");
        }
    }

    @Override
    public void destroy() {
    }
}
