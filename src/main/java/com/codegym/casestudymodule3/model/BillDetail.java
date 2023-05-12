
package com.codegym.casestudymodule3.model;

import com.codegym.casestudymodule3.utils.CurrencyFormat;

public class BillDetail {
    int detail_id;
    int bill_id;
    Product product;
    int quantity;
    String size;
    String color;
    double price;

    public BillDetail() {
    }

    public BillDetail(int detail_id, int bill_id, Product product, int quantity, String size, String color) {
        this.detail_id = detail_id;
        this.bill_id = bill_id;
        this.product = product;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
    }
    
    public BillDetail(int detail_id, Product product, int quantity, String size, String color, double price) {
        this.detail_id = detail_id;
        this.product = product;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBillDetailPrice(double price) {
        String priceNew = CurrencyFormat.covertPriceToString(price);
        return priceNew;
    }
}
