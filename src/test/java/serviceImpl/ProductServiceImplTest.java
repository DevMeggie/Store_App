package serviceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.Store_App.file_reader.ProductReader;
import org.Store_App.model.Store;
import org.Store_App.service.ProductService;
import org.Store_App.service.serviceImpl.ProductServiceImpl;

import java.io.IOException;

class ProductServiceImplTest {

//    @Test
//    void addProductToStoreProducts() {
//        Store store = new Store();
//        ProductReader pr = new ProductReader();
//
//
//
//    }
//
    @Test
    void shouldReturnProductsAddedToListWhenProductIsReadFromCSV () throws IOException {
        Store store = new Store();
        ProductReader pr = new ProductReader();
        ProductService ps = new ProductServiceImpl();

        String expected = "Products have been added to store!";

        Assertions.assertEquals(expected, ps.addProductToStoreProducts(store) );



    }


}