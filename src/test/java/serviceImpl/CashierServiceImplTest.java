package serviceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.Store_App.enums.Gender;
import org.Store_App.enums.Qualification;
import org.Store_App.enums.Role;
import org.Store_App.exceptions.InsufficientFundsException;
import org.Store_App.exceptions.SorryYourCartIsEmptyException;
import org.Store_App.model.Cashier;
import org.Store_App.model.Customer;
import org.Store_App.model.Product;
import org.Store_App.model.Store;
import org.Store_App.service.CashierService;
import org.Store_App.service.serviceImpl.CashierServiceImpl;

import java.util.ArrayList;
import java.util.Queue;

class CashierServiceImplTest {

    @Test
    void shouldBeAbleToDeductTotalPriceOfItemsFromCustomersWallet() {
        CashierService cashierService = new CashierServiceImpl();
        Store store = new Store();
        Cashier cashier = new Cashier(2, "vida", "sebastine", "+236789",
                Gender.FEMALE, "vs@gmail.com", "lagos", Role.CASHIER, Qualification.BSC);

        Customer customer = new Customer(1, "ebuka", "daniel", "+2340087654",
                Gender.MALE, "ed@gmail.com", "lagos", 11_000, new ArrayList<>());

        Product product = new Product(1, "bag", "fine bag like Magreth's own", 2_000, 5, "fashion");
        customer.getCart().add(product);

        cashierService.sell(customer, cashier, store);
        Assertions.assertEquals(1_000, customer.getWallet());
    }

    @Test
    void shouldReturnYouHaveNotAddedAnyItemToYourCartIfCartIsEmpty() {
        CashierService cashierService = new CashierServiceImpl();

        Cashier cashier = new Cashier(2, "vida", "sebastine", "+236789",
                Gender.FEMALE, "vs@gmail.com", "lagos", Role.CASHIER, Qualification.BSC);

        Customer customer = new Customer(1, "ebuka", "daniel", "+2340087654",
                Gender.MALE, "ed@gmail.com", "lagos", 3_000, new ArrayList<>());
        Store store = new Store();

        Assertions.assertThrows(SorryYourCartIsEmptyException.class, () -> cashierService.sell(customer, cashier, store));
    }

    @Test
    void shouldReturnInsufficientFundsIfTotalPriceOfItemsIsGreaterThanCustomersWalletBalance() {
        CashierService cashierService = new CashierServiceImpl();

        Product waterBottles = new Product(01, "water bottles", "this is a 40ml water bottle, great for outdoor",
                5_000, 5, "home made");

        Cashier cashier = new Cashier(2, "vida", "sebastine", "+236789",
                Gender.FEMALE, "vs@gmail.com", "lagos", Role.CASHIER, Qualification.BSC);

        Customer customer = new Customer(1, "ebuka", "daniel", "+2340087654",
                Gender.MALE, "ed@gmail.com", "lagos", 1_000, new ArrayList<>());
        customer.getCart().add(waterBottles);
        Store store = new Store();
        Assertions.assertThrows(InsufficientFundsException.class, () -> cashierService.sell(customer, cashier, store));
    }

    @Test
    void ShouldSellUsingPriorityQueue(){
        Store store = new Store();
        CashierService cs = new CashierServiceImpl();
        Queue<Customer> testQueue = store.getQueueList();

        Cashier cashier = new Cashier(2, "vida","sebastine","+2356764",
             Gender.FEMALE, "vs@gmail.com","lagos",Role.CASHIER, Qualification.BSC);


        Customer paul = new Customer(3, "paul", "martins", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());

     Customer chidera = new Customer(3, "chidera", "adams", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());

        Customer ebuka = new Customer(1, "Ebuka", "Daniel", "076543456787", Gender.MALE,
               "ebuka@gmail.com", "Abuja", 100000, new ArrayList<>());





        paul.getCart().add(new Product(2,"cup","20 ml grey color cup",1000,6,"house hold" ));
        ebuka.getCart().add(new Product(2,"cup","20 ml grey color cup",1000,2,"house hold" ));
        chidera.getCart().add(new Product(2,"cup","20 ml grey color cup",1000,9,"house hold" ));


        testQueue.add(paul);
        testQueue.add(chidera);
        testQueue.add(ebuka);
        String expectedValue = "Finished selling";

        Assertions.assertEquals(expectedValue,cs.sellUsingPriorityQueue(store,cashier));

    }

    @Test
    void ShouldReturnSellByFifo(){
        Store store= new Store();
        Queue<Customer> testQueue = store.getFifoList();
        CashierService cashierService = new CashierServiceImpl();
        Cashier cashier = new Cashier(2, "vida","sebastine","+2356764",
                Gender.FEMALE, "vs@gmail.com","lagos",Role.CASHIER, Qualification.BSC);


        Customer ebuka = new Customer(3, "chidera", "adams", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());
        Product product1 = new Product(2,"cup","20 ml grey color cup",1000,4,"house hold" );
        ebuka.getCart().add(product1);

        Customer oliva = new Customer(3, "chidera", "adams", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());
        Product product2 = new Product(2,"cup","20 ml grey color cup",1000,2,"house hold" );
        oliva.getCart().add(product2);

        Customer chidera = new Customer(3, "chidera", "adams", "076543456787", Gender.MALE,
                "cauka@gmail.com", "Abuja", 100000, new ArrayList<>());
        Product product3 = new Product(2,"cup","20 ml grey color cup",1000,8,"house hold" );
        chidera.getCart().add(product3);


        testQueue.add(oliva);
        testQueue.add(chidera);
        testQueue.add(ebuka);
        String expectedValue = "Finished selling";

        Assertions.assertEquals(expectedValue,cashierService.sellByFifo(store,cashier));


    }

}