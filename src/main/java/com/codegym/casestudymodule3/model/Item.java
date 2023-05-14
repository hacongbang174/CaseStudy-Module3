
package com.codegym.casestudymodule3.model;


public class Item {
    Product product;
    int quantity;
    String size;
    String color;

    public Item() {
    }

    public Item(Product product, int quantity, String size, String color) {
        this.product = product;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
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


}
