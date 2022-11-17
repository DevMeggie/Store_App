package org.Store_App.file_reader;

import org.Store_App.model.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProductReader {

    private  ArrayList<Product> productsList =new ArrayList<>();

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public  void readProduct() throws IOException {
        try {
            Path path = Path.of("src/main/resources/product.csv");

            Files.lines(path)
                    .skip(1)
                    .map(ProductReader::getProduct)
                    .forEach(fields -> {
                        Product product = new Product (
                                Integer.parseInt(fields[0]),
                                fields[1],
                                fields[2],
                                Double.parseDouble(fields[3]),
                                Integer.parseInt(fields[4]),
                                fields[5]
                        );
                        productsList.add(product);
                    });
        } catch (IOException e) {
            throw new FileNotFoundException("File could not be accessed");
        }
    }

//    public  List<Product> readProduct(Store store) throws IOException {
//        List<Product> productList = store.getProductList();
//        try {
//            Path path = Path.of("src/main/resources/product.csv");
//
//            Files.lines(path)
//                    .skip(1)
//                    .map(ProductReader::getProduct)
//                    .forEach(fields -> {
//                        Product product = new Product (
//                                Integer.parseInt(fields[0]),
//                                fields[1],
//                                fields[2],
//                                Double.parseDouble(fields[3]),
//                                Integer.parseInt(fields[4]),
//                                fields[5]
//                        );
//                        productList.add(product);
//                    });
//        } catch (IOException e) {
//            throw new FileNotFoundException("File could not be accessed");
//        }
//        return productList;
//    }



    private static String [] getProduct (String line) {
        String[] fields = line.split(",");
        if (fields.length != 6){
            throw new RuntimeException("Invalid line " + line);
        }
        return fields;
    }

}
