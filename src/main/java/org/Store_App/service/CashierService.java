package org.Store_App.service;

import org.Store_App.model.Cashier;
import org.Store_App.model.Customer;
import org.Store_App.model.Store;


public interface CashierService {

    String sell(Customer customer, Cashier cashier, Store store);

    String sellUsingPriorityQueue(Store store, Cashier cashier);

    String sellByFifo(Store store, Cashier cashier);
}
