package org.Store_App.service;

import org.Store_App.model.Store;

import java.io.IOException;

public interface ProductService {

    String addProductToStoreProducts (Store store) throws IOException;
}
