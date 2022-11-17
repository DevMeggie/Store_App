package org.Store_App.service.serviceImpl;

import org.Store_App.file_reader.ProductReader;
import org.Store_App.model.Store;
import org.Store_App.service.ProductService;

import java.io.IOException;

public class ProductServiceImpl implements ProductService {
    @Override
    public String addProductToStoreProducts(Store store) throws IOException {
        ProductReader pr = new ProductReader();
        pr.readProduct();

//        for (Product productInProductReader : pr.getProductsList()) {
//            Product newProduct = new Product(
//                    productInProductReader.getId(),
//                    productInProductReader.getName(),
//                    productInProductReader.getDescription(),
//                    productInProductReader.getPrice(),
//                    productInProductReader.getQty(),
//                    productInProductReader.getCategory()
//            );
//            store.getProductList().add(newProduct);
//        }
        pr.getProductsList().forEach(product -> store.getProductList().add(product));
        return "Products have been added to store!";
    }


}
