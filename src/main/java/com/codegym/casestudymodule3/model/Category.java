package com.codegym.casestudymodule3.model;

import java.util.ArrayList;


public class Category {
    private int category_id;
    private String category_name;
    private ArrayList<Product> product = new ArrayList<>();

    public Category() {
    }

    public Category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public Category(int category_id) {
        this.category_id = category_id;
    }

    public int getCategoryID() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

}
