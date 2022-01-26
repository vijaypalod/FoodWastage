package com.yp.dashboard;

public class model1 {
    int id;
    String name,email,mobile,address,date,food,quantity;

    public model1(int id, String name, String email, String mobile, String address, String date, String food, String quantity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.food = food;
        this.quantity = quantity;
    }

    public model1(String name, String email, String mobile, String address, String date, String food, String quantity) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.date = date;
        this.food = food;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String Quantity) {
        this.quantity = quantity;
    }
}
