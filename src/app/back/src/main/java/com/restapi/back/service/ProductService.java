package com.restapi.back.service;

import java.util.List;

import com.restapi.back.entity.Products;

public interface ProductService {
Products saveProducts(Products products);
List<Products> getAllProducts();
Products getProductsbyId(long id);
Products updateProducts(Products products,long id);
void deleteProduct(long id);
List<Products> searcProducts(String query);
List<Products> filterProducts(String query);
List<Products> limitbyProducts(int query);
List<Products> sortbyprice();
List<Products> showalltocustopmer();
}
