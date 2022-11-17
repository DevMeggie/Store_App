package org.Store_App.service;

import org.Store_App.model.Customer;
import org.Store_App.model.Store;


public interface CustomerService {
    String fundWallet(Customer customer, double amount);

    String addToCart (Store store, Customer customer, String name, int quantity) throws Exception;

//    void joinQueue(Customer customer, Store store);
}
