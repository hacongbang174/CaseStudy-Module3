package com.codegym.casestudymodule3.controller.Home;


import com.codegym.casestudymodule3.DAO.ProductDAO;
import com.codegym.casestudymodule3.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action ="";
        }
        switch (action) {
            case "showCart":
                showCart(request, response);
                break;
            default:
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addCart":
                addCart(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            default:
        }
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String product_id = request.getParameter("product_id");
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String Squantity = request.getParameter("quantity");
        if (Squantity == "") {
            request.setAttribute("error", "Số lượng không đúng! Vui lòng chọn lại...");
            showProductDetail(request,response);
        }else {
            try {
                int quanity = Integer.parseInt(Squantity);
                Product product = productDAO.getProductByID(product_id);
                Item item = new Item(product, quanity, size, color);
                cart.addItem(item);
            } catch (Exception e) {

            }
            List<Item> list = cart.getItems();
            double surcharge = 30000.0;
            session.setAttribute("cart", cart);
            session.setAttribute("surcharge",surcharge);
            session.setAttribute("total", cart.getTotalMoney());
            session.setAttribute("size", list.size());
            request.setAttribute("message", "Thêm sản phẩm thành công");
            showProductDetail(request,response);
        }
    }
    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        List<Size> sizeList = productDAO.getSizeByID(product_id);
        List<Color> colorList = productDAO.getColorByID(product_id);
        Product product = productDAO.getProductByID(product_id);
        int category_id = product.getCate().getCategoryID();
        List<Product> productByCategory = productDAO.getProductByCategory(category_id);
        request.setAttribute("ProductData", product);
        request.setAttribute("SizeData", sizeList);
        request.setAttribute("ColorData", colorList);
        request.setAttribute("ProductByCategory", productByCategory);
        request.getRequestDispatcher("/product-details.jsp").forward(request, response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String product_id = request.getParameter("txtId");
        cart.removeItem(product_id);
        List<Item> list = cart.getItems();
        double surcharge = 30000.0;
        session.setAttribute("cart", cart);
        session.setAttribute("surcharge", surcharge);
        session.setAttribute("total", cart.getTotalMoney());
        session.setAttribute("size", list.size());
        request.setAttribute("message", "Xóa sản phẩm thành công");
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    @Override
    public void destroy() {

    }
}
