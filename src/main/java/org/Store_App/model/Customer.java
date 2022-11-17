package org.Store_App.model;

import org.Store_App.enums.Gender;

import java.util.List;

public class Customer extends Person {

    private double wallet;

    private List<Product> cart;


    public Customer(int id, String firstName, String lastName, String phoneNo, Gender gender,
                    String email, String address, double wallet, List<Product> cart) {
        super(id, firstName, lastName, phoneNo, gender, email, address);
        this.wallet = wallet;
        this.cart = cart;
    }

    public Customer() {

    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNo='" + getPhoneNo() + '\'' +
                ", gender=" + getGender() +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "wallet=" + wallet +
                '}';
    }
}

