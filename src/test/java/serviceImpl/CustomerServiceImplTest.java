package serviceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.Store_App.enums.Gender;
import org.Store_App.exceptions.NotFoundException;
import org.Store_App.exceptions.OutOfStockException;
import org.Store_App.model.Customer;
import org.Store_App.model.Product;
import org.Store_App.model.Store;
import org.Store_App.service.CustomerService;
import org.Store_App.service.serviceImpl.CustomerServiceImpl;

import java.util.ArrayList;

class CustomerServiceImplTest {

    @Test
    void shouldFundCustomersWallet () {
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer= new Customer(2,"ebuka","daniel","+348958", Gender.MALE,
                "ed@gmail.com","lagos",3_000,new ArrayList<>());
        String expected = "Your wallet has been funded with 3000.0";

        Assertions.assertEquals(expected, customerService.fundWallet(customer, 3_000));
    }

    @Test
    void shouldAddProductToCustomersCart () throws Exception {
        CustomerService customerService = new CustomerServiceImpl();
        Store store= new Store();
        Customer customer= new Customer(2,"ebuka","daniel","+348958", Gender.MALE,
                "ed@gmail.com","lagos",30_00,new ArrayList<>());
        Product product=new Product(11,"cup", "grey color cup",1_000,2,"plastic");
        store.getProductList().add(product);

        customerService.addToCart(store, customer, "cup",1);

        Assertions.assertEquals(1, customer.getCart().size());
    }

    @Test
    void shouldReturnAddedToCartWhenCustomerSuccessfullyAddToCart() throws Exception {
        CustomerService customerService = new CustomerServiceImpl();
        Store store= new Store();
        Customer customer= new Customer(2,"ebuka","daniel","+348958", Gender.MALE,
                "ed@gmail.com","lagos",30_00,new ArrayList<>());
        Product product=new Product(11,"water bottle", "40ml waterbottle",1_000,1,"plastic" );
        store.getProductList().add(product);
        customerService.addToCart(store, customer,"water bottle",1);
        Assertions.assertEquals(1,customer.getCart().size());
    }

    @Test
    void ShouldReturnOutOfStockWhenProductIsUnavailable() {
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer(2, "ebuka", "daniel", "53683938", Gender.MALE,
                "ed@gmail.com", "lagos", 30000, new ArrayList<>());
        Store store = new Store();
        Product product1 = new Product(1, "cup", "good for outdoor", 2000, 0, "house hold");
        store.getProductList().add(product1);
        Assertions.assertThrows(OutOfStockException.class, () -> customerService.addToCart(store, customer, "cup",7));
    }

    @Test
    void ShouldReturnProductNotFoundWhenCustomerWantsToBuyWhatIsNotInTheStore(){
        CustomerService customerService = new CustomerServiceImpl();

        Customer customer = new Customer(2, "ebuka", "daniel", "53683938", Gender.MALE,
                "ed@gmail.com", "lagos", 30000, new ArrayList<>());
        Store store = new Store();
        Assertions.assertThrows(NotFoundException.class,() -> customerService.addToCart(store,customer,"orange",4));
    }

}