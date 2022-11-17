package org.Store_App;

import org.Store_App.enums.Gender;
import org.Store_App.model.Cashier;
import org.Store_App.model.Customer;
import org.Store_App.model.Product;
import org.Store_App.model.Store;
import org.Store_App.service.CashierService;
import org.Store_App.service.CustomerService;
import org.Store_App.service.ProductService;
import org.Store_App.service.serviceImpl.CashierServiceImpl;
import org.Store_App.service.serviceImpl.CustomerServiceImpl;
import org.Store_App.service.serviceImpl.ProductServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        Store store = new Store();
        Cashier cashier = new Cashier();
        CustomerService customerService = new CustomerServiceImpl();
        CashierService cashierService = new CashierServiceImpl();
        ProductService productService = new ProductServiceImpl();
        productService.addProductToStoreProducts(store);

        for (Product product1 : store.getProductList()) {
            System.out.println(product1);
        }

        Customer ebuka = new Customer(1, "Ebuka", "Daniel", "076543456787", Gender.MALE,
                "ebuka@gmail.com", "Abuja", 100000, new ArrayList<>());

        Customer olivia= new Customer(2, "olivia", "oko", "076543456787", Gender.FEMALE,
                "oouka@gmail.com", "Abuja", 100000, new ArrayList<>());

        Customer chidera = new Customer(3, "chidera", "adams", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());

        Customer paul = new Customer(4, "paul", "martins", "076543456787", Gender.MALE,
                "pm@gmail.com", "Abuja", 100000, new ArrayList<>());



        customerService.addToCart(store, ebuka, "CuP", 4);

        customerService.addToCart(store, olivia, "CuP", 13);

        customerService.addToCart(store, chidera, "CuP", 6);

        customerService.addToCart(store, paul, "CuP",1);


        //   Selling Using Priority Queue
//        store.getQueueList().add(ebuka);
//        store.getQueueList().add(oliva);
//        store.getQueueList().add(chidera);
//        store.getQueueList().add(paul);

        //CV   System.out.println("3333333333" + store.getQueueList().peek());
//        cashierService.sellUsingPriorityQueue(store,cashier);

//
//        // Selling Using FIFO
        store.getFifoList().add(ebuka);
        store.getFifoList().add(olivia);
        store.getFifoList().add(chidera);
        store.getFifoList().add(paul);

        cashierService.sellByFifo(store, cashier);

    }

}