package com.codegym.casestudymodule3.controller.Admin;

import com.codegym.casestudymodule3.DAO.BillDAO;
import com.codegym.casestudymodule3.DAO.ProductDAO;
import com.codegym.casestudymodule3.DAO.UserDAO;
import com.codegym.casestudymodule3.model.*;
import com.codegym.casestudymodule3.utils.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productManagerServlet", urlPatterns = "/productManager")
public class ProductManagerServlet extends HttpServlet {
    private ProductDAO productDAO;
    private BillDAO billDAO;
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        billDAO = new BillDAO();
        userDAO = new UserDAO();
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
            case "productLow":
                showProductLow(request, response);
                break;
            case "insert":
                showInsertProduct(request, response);
                break;
            default:
                showProduct(request, response);
        }
    }

    private void showProductLow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Product> product = productDAO.getProductLow();
            List<Size> size = productDAO.getSize();
            List<Color> color = productDAO.getColor();
            List<Category> category = productDAO.getCategory();
            request.setAttribute("CategoryData", category);
            request.setAttribute("ProductLow", product);
            request.setAttribute("SizeData", size);
            request.setAttribute("ColorData", color);
            request.getRequestDispatcher("/admin/productLow.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getRole().equalsIgnoreCase("true")) {
                List<Product> product = productDAO.getProduct();
                List<Size> size = productDAO.getSize();
                List<Color> color = productDAO.getColor();
                List<Category> category = productDAO.getCategory();
                request.setAttribute("CategoryData", category);
                request.setAttribute("ProductData", product);
                request.setAttribute("SizeData", size);
                request.setAttribute("ColorData", color);
                request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?action=login");
            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    private void showInsertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> category = productDAO.getCategory();
            request.setAttribute("CategoryData", category);
            request.getRequestDispatcher("/admin/insertProduct.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
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
            case "insertCategory":
                insertCategory(request, response);
                break;
            case "insertProduct":
                insertProduct(request, response);
                break;
            case "updateProduct":
                updateProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            default:
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String product_id = request.getParameter("product_id");
            productDAO.ProductDelete(product_id);
//            request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
            response.sendRedirect("/productManager");
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String product_id = request.getParameter("product_id");
            String category_id = request.getParameter("category_id");
            String product_name = request.getParameter("product_name");
            String product_price = request.getParameter("product_price");
            String product_size = request.getParameter("product_size");
            String product_color = request.getParameter("product_color");
            String product_quantity = request.getParameter("product_quantity");
            String product_img;
            if (request.getParameter("product_img") == null || request.getParameter("product_img") == "") {
                product_img = productDAO.getProductByID(product_id).getImg();
            } else {
                product_img = "images/" + request.getParameter("product_img");
            }
            String product_describe = request.getParameter("product_describe");
            int quantity = Integer.parseInt(product_quantity);
            Float price = Float.parseFloat(product_price);
            int cid = Integer.parseInt(category_id);
            Category cate = new Category(cid);
            String[] size_rw = product_size.split("\\s*,\\s*");
            String[] color_rw = product_color.split("\\s*,\\s*");
            int[] size = new int[size_rw.length];
            int[] color = new int[color_rw.length];
            //size
            List<Size> list = new ArrayList<>();
            try {
                for (int i = 0; i < size.length; i++) {
                    Size s = new Size(product_id, size_rw[i]);
                    list.add(s);
                }
            } catch (Exception e) {
            }
            // color
            List<Color> list2 = new ArrayList<>();
            try {
                for (int i = 0; i < color.length; i++) {
                    Color s1 = new Color(product_id, color_rw[i]);
                    list2.add(s1);
                }
            } catch (Exception e) {
            }

            Product product = new Product();
            product.setCate(cate);
            product.setProduct_id(product_id);
            product.setProduct_name(product_name);
            product.setProduct_price(price);
            product.setProduct_describe(product_describe);
            product.setQuantity(quantity);
            product.setImg(product_img);
            product.setSize(list);
            product.setColor(list2);
            productDAO.updateProduct(product);
            response.sendRedirect("productManager");
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> errors = new ArrayList<>();
        Product product = new Product();
        try {
            String product_id = request.getParameter("product_id");

            validateProductId(request,errors,product, product_id);
            validateProductName(request,errors,product);
            validatePrice(request,errors,product);

            String category_id = request.getParameter("category_id");

            String product_size = request.getParameter("size");
            String product_color = request.getParameter("color");

            String product_quantity = request.getParameter("quantity");
            String product_img = "images/" + request.getParameter("product_img");
            String product_describe = request.getParameter("describe");
            int quantity = Integer.parseInt(product_quantity);
            int cid = Integer.parseInt(category_id);
            Category cate = new Category(cid);
            String[] size_rw = product_size.split("\\s*,\\s*");
            String[] color_rw = product_color.split("\\s*,\\s*");
            int[] size = new int[size_rw.length];
            int[] color = new int[color_rw.length];
            List<Size> sizeList = new ArrayList<>();
            try {
                for (int i = 0; i < size.length; i++) {
                    Size s = new Size(product_id, size_rw[i]);
                    sizeList.add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // color
            List<Color> colorList = new ArrayList<>();
            try {
                for (int i = 0; i < color.length; i++) {
                    Color color1 = new Color(product_id, color_rw[i]);
                    colorList.add(color1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            product.setCate(cate);
            product.setProduct_describe(product_describe);
            product.setQuantity(quantity);
            product.setImg(product_img);
            product.setSize(sizeList);
            product.setColor(colorList);
            productDAO.insertProduct(product);
            request.setAttribute("message", "Thêm sản phẩm thành công");
            request.getRequestDispatcher("/admin/insertProduct.jsp").forward(request, response);
//            response.sendRedirect("/productManager?action=insertProduct");
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            Category category = productDAO.getCategoryByName(name);
            if (category != null) {
                request.setAttribute("error", name + " already");
                request.getRequestDispatcher("admin/insertProduct.jsp").forward(request, response);
            } else {
                productDAO.insertCategory(name);
                request.getRequestDispatcher("productManager?action=insert").forward(request, response);

            }
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }
    }

    private void validateProductId(HttpServletRequest req, List<String> errors, Product product, String product_id) {
        if (!ValidateUtils.isIdProduct(product_id)) {
            errors.add("Id không hợp lệ. Phải bắt đầu là chữ và không quá 10 kí tự!");
        }
        product.setProduct_id(product_id);
    }

    private void validateProductName(HttpServletRequest req, List<String> errors, Product product) {
        String product_name = req.getParameter("product_name");
        if (!ValidateUtils.isNameProduct(product_name)) {
            errors.add("Tên sản phẩm không hợp lệ. Phải bắt đầu là chữ số và có từ 6-255 kí tự!");
        }
        product.setProduct_id(product_name);
    }
    private void validatePrice(HttpServletRequest req, List<String> errors, Product product) {
        try {
            double price = Double.parseDouble(req.getParameter("price"));
            if (price < 0 || price > 10000000) {
                errors.add("Giá phải lớn hơn 0 và nhỏ hơn 10000000");
            }else{
                product.setProduct_price(price);
            }
        } catch (NumberFormatException numberFormatException) {
            errors.add("Định dạng giá không hợp lệ");
        }
    }

    @Override
    public void destroy() {

    }
}
