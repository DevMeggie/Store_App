package org.Store_App.service.serviceImpl;

import org.Store_App.exceptions.NotFoundException;
import org.Store_App.exceptions.OutOfStockException;
import org.Store_App.model.Customer;
import org.Store_App.model.Product;
import org.Store_App.model.Store;
import org.Store_App.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public String fundWallet(Customer customer, double amount) {
        double walletBalance = customer.getWallet();
        walletBalance += amount;
        customer.setWallet(walletBalance);
        System.out.println("Your wallet has been funded with " + amount);
        return "Your wallet has been funded with " + amount;
    }

    // method to add to cart
    @Override
    public String addToCart(Store store, Customer customer, String name, int quantity) {
        Product foundProduct = searchForProduct(store, name);
        if (foundProduct.getQty() < 1) {
            System.out.println("OUT OF STOCK");
            throw new OutOfStockException("OUT OF STOCK");
        } else {
            Product product1 = new Product(foundProduct.getId(), foundProduct.getName(), foundProduct.getDescription(),
                    foundProduct.getPrice(), quantity, foundProduct.getCategory());
            customer.getCart().add(product1);
            foundProduct.setQty(foundProduct.getQty() - quantity);
        }
        return "Added to cart";
    }

    private static Product searchForProduct (Store store, String name) {
//        int index = -1;
//        for (int i = 0; i < store.getProductList().size(); i++) {
//            if (store.getProductList().get(i).getName().equalsIgnoreCase(name)) {
//                index = i;
//            }
       // }
       return store.getProductList().stream()
               .filter(product -> product.getName().equalsIgnoreCase(name))
               .findFirst().orElseThrow(()->new NotFoundException("Product not enough in store"));
//        throw new RuntimeException("Product not enough in store");
//        if (index < 0) {
//            System.out.println("Product not found");
//            throw new NotFoundException("Product not found");}
//        return store.getProductList().get(index);
    }

//    @Override
//    public void joinQueue(Customer customer, Store store) {
//        try {
//            store.getQueueList().add(customer);
//        } catch (IndexOutOfBoundsException e) {
//            throw new RuntimeException("Product not enough in store");
//        }
//
//    }

}
