package com.codegym.casestudymodule3.controller.Home;


import com.codegym.casestudymodule3.DAO.ProductDAO;
import com.codegym.casestudymodule3.model.Category;
import com.codegym.casestudymodule3.model.Color;
import com.codegym.casestudymodule3.model.Product;
import com.codegym.casestudymodule3.model.Size;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
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
            action = "";
        }
        switch (action) {
            case "listByCategory":
                showlistByCategory(request, response);
                break;
            case "productDetail":
                showProductDetail(request, response);
                break;
            case "sortProductByPriceDesc":
                showSortProductByPriceDesc(request, response);
                break;
            case "sortProductByPriceAsc":
                showSortProductByPriceAsc(request, response);
                break;
            case "sortProductByName":
                showSortProductByName(request, response);
                break;

            default:
                showList(request, response);
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

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getProduct();
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 0 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }

    private void showlistByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_id = request.getParameter("category_id");
        int category_id1 = Integer.parseInt(category_id);
        List<Product> productList = productDAO.getProductByCategory(category_id1);
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 0 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }
    private void showSortProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getProductByName();
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 0 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }

    private void showSortProductByPriceAsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getProductByPriceAsc();
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 0 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }

    private void showSortProductByPriceDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getProductByPriceDesc();
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 0 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchProduct(request, response);
                break;
            default:
        }
    }
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        List<Product> productList = productDAO.SearchAll(text);
        List<Category> category = productDAO.getCategory();
        int page, numperpage = 6;
        int size = productList.size();
        int num = (size % 6 == 6 ? (size / 6) : ((size / 6)) + 1);//so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> product = productDAO.getListByPage(productList, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("CategoryData", category);
        request.setAttribute("ProductData", product);
        request.getRequestDispatcher("/shop_category.jsp").forward(request, response);
    }
    @Override
    public void destroy() {

    }
}
