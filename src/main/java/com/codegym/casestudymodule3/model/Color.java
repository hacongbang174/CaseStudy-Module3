
package com.codegym.casestudymodule3.model;


public class Color {
    String product_id;
    String color;

    public Color() {
    }

    public Color(String product_id, String color) {
        this.product_id = product_id;
        this.color = color;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
