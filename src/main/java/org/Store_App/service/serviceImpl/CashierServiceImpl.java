package org.Store_App.service.serviceImpl;

import org.Store_App.exceptions.InsufficientFundsException;
import org.Store_App.exceptions.SorryYourCartIsEmptyException;
import org.Store_App.model.Cashier;
import org.Store_App.model.Customer;
import org.Store_App.model.Store;
import org.Store_App.service.CashierService;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CashierServiceImpl implements CashierService {
    @Override
    public String sell(Customer customer, Cashier cashier, Store store) {
        if (customer.getCart().isEmpty()) {

            throw new SorryYourCartIsEmptyException("Sorry your cart is empty");
        } else {
            if (getTotal(customer) > customer.getWallet()) {

                throw new InsufficientFundsException("Insufficient Fund");
            } else {
                System.out.println(getTotal(customer));
                payment(customer);
                System.out.println(issueReceipt(customer));
                customer.getCart().clear();
            }
        }
        return "Thanks for shopping with us, Come again soon!";
    }

    @Override
    public String sellUsingPriorityQueue(Store store, Cashier cashier) {
        Queue<Customer> queue = store.getQueueList();
        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            Customer o1 = queue.poll();
           System.out.println(o1 .getFirstName() + "is being attended to");
            sell(o1,cashier,store);
        }
        return "Finished selling";
    }

    @Override
    public String sellByFifo(Store store, Cashier cashier) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        int customerNumInFifo = store.getFifoList().size();
      //  for (Customer customer : store.getFifoList()) {
        store.getFifoList().forEach(customer ->
            executorService.execute(() -> {
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(customer.getFirstName() + " is being attended to on " + Thread.currentThread().getName());
                sell(customer, cashier, store);
                System.out.println(customer.getFirstName() + " has been attended to");



            }));
//            customerNumInFifo--;
        executorService.shutdown();
         return "Finished selling";

        }
//        executorService.shutdown();
//        return "Finished selling";






    public static double getTotal(Customer customer) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
//
//        for (Product product1 : customer.getCart()) {
//           total.updateAndGet(v -> new Double((double) (v + product1.getPrice() * product1.getQty())));
      //  }
        customer.getCart().forEach(product -> {
            total.updateAndGet(v -> (v + product.getPrice() * product.getQty()));
        });
        return total.get();
    }

    public static void payment(Customer customer) {
        double walletBalance = customer.getWallet();
        walletBalance -= getTotal(customer);
        customer.setWallet(walletBalance);
    }

    public static String issueReceipt(Customer customer) {
        return "======================= RECEIPT ======================= \n" +
                "Total ================= " + getTotal(customer);
    }

}
