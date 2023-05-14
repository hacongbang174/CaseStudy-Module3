
package com.codegym.casestudymodule3.model;

import com.codegym.casestudymodule3.utils.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;


public class Cart {

    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // số lượng 1 sản phẩm trong giỏ - khách sẽ mua
    public int getQuantityById(String id) {
        return getItemById(id).getQuantity();
    }

    public Item getItemById(String id) {
        for (Item i : items) {
            if (i.getProduct().getProduct_id().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Item CheckItem(String id, String size, String color) {
        for (Item i : items) {
            if (i.getProduct().getProduct_id().equals(id) && i.size.equals(size) && i.color.endsWith(color)) {
                return i;
            }
        }
        return null;
    }

    // add 1 sản phẩm vào giỏ, nếu có rồi thì tăng số lượng
    public void addItem(Item t) {
        if (getItemById(t.getProduct().getProduct_id()) != null && CheckItem(t.getProduct().getProduct_id(), t.size, t.color) != null) {
            Item m = getItemById(t.getProduct().getProduct_id());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }
    //loại sản phẩm khỏi giỏ

    public void removeItem(String id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    //tổng tiền của cả giỏ hàng – sẽ add vào bảng Order

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getProduct().product_price);
        }
        return t;
    }

    public String getBillDetailPrice(double price) {
        String priceNew = CurrencyFormat.covertPriceToString(price);
        return priceNew;
    }
}
