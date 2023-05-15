package com.codegym.casestudymodule3.model;

import com.codegym.casestudymodule3.utils.CurrencyFormat;

import java.sql.Date;
import java.util.Calendar;

public class Bill {
    int bill_id;
    User user;
    double total;
    String payment;
    String address;
    Date createDate;
    String phone;

    public Bill() {
    }

    public Bill(int bill_id, User user, double total, String payment, String address, Date date, String phone) {
        this.bill_id = bill_id;
        this.user = user;
        this.total = total;
        this.payment = payment;
        this.address = address;
        this.createDate = date;
        this.phone = phone;
    }

    public Bill(int bill_id, double total, Date date) {
        this.bill_id = bill_id;
        this.total = total;
        this.createDate = date;
    }

    public Bill(int bill_id, double total, String payment, String address, Date date, String phone) {
        this.bill_id = bill_id;
        this.total = total;
        this.payment = payment;
        this.address = address;
        this.createDate = date;
        this.phone = phone;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBillTotal(double total) {
        String totalNew = CurrencyFormat.covertPriceToString(total);
        return totalNew;
    }
    public int getMonthFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1; // Tháng trong Calendar được đánh số từ 0 đến 11, nên cần cộng 1.
    }
}
