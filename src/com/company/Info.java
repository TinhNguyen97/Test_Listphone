package com.company;


public class Info {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String facebook;

    public Info(String name, String phone, String address, String email, String facebook) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
    }

    public Info() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return name + ", " + phone+", " + address + ", " + email + ", " + facebook;
    }
}
