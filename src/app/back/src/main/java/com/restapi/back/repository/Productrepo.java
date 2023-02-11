package com.restapi.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restapi.back.entity.Products;

public interface Productrepo extends JpaRepository<Products,Long>{
	//search 
@Query( value ="SELECT * FROM products where pr_status = 1 and pr_name like concat('%',:query,'%')or pr_desc like concat('%',:query,'%')",
nativeQuery = true)	
List<Products> searchPrroducts(String query);
//filter by genre
@Query(value = "SELECT * FROM products where pr_status = 1 and pr_type like concat('%', :query ,'%')",
                nativeQuery = true)
List<Products> filterbytype(String query);
  // limit the no of products for carousel and popular products
@Query(value = "SELECT * FROM products where pr_status = 1 LIMIT :query" , nativeQuery = true)
List<Products> limitProducts(int query);

//sortby price
@Query(value = "select * from products where pr_status = 1  order by pr_price desc;" , nativeQuery = true)
List<Products> sortProducts();
// an api for getting all products to list down it to the customer
@Query(value = "select * from products where pr_status = 1 " , nativeQuery = true)
List<Products> showallforcustomerProducts();
}
