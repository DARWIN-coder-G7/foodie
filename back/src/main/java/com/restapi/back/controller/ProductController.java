package com.restapi.back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.back.entity.Products;
import com.restapi.back.service.ProductService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/products")
public class ProductController {
public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

private ProductService productservice;
//api for creating movie
@PostMapping()
public ResponseEntity<Products> saveProduct(@RequestBody Products products){
	return new ResponseEntity<Products>(productservice.saveProducts(products),HttpStatus.CREATED);
}
//api for getting all movies
@GetMapping
public List<Products> getallproducts(){
	return productservice.getAllProducts();
}
// api for getting movies by id
@GetMapping("{id}")
public ResponseEntity<Products> getProductbyId(@PathVariable("id") long id){
	return new ResponseEntity<Products>(productservice.getProductsbyId(id),HttpStatus.OK);
}
//update movie details api
@PutMapping("{id}")
public ResponseEntity<Products> updateProducts(@PathVariable("id") long id
		  ,@RequestBody Products products){
	return new ResponseEntity<Products>(productservice.updateProducts(products, id),HttpStatus.OK);
}
//api for deleting a movie
@DeleteMapping("{id}")
public ResponseEntity<String> deleteproducts(@PathVariable("id") long id){
	productservice.deleteProduct(id);
	return new ResponseEntity<String>("sucess!",HttpStatus.OK);
}
//http://localhost:8080/api/products/search?query=berry
// an api to search data
@GetMapping("/search")
public ResponseEntity<?> searchProducts(@RequestParam("query") String query){
	List<Products> prod = productservice.searcProducts(query);
	if(prod != null)
	return new ResponseEntity<List<Products>>(prod,HttpStatus.OK);
	return new ResponseEntity<String>("no data",HttpStatus.INTERNAL_SERVER_ERROR);
}
//filter by genre
//http://localhost:8080/api/products/search/filterby?genre=mobile
@GetMapping("/search/filterby")
public ResponseEntity<List<Products>> filterProducts(@RequestParam("genre") String genre){
	//System.out.println(genre);
	return ResponseEntity.ok(productservice.filterProducts(genre));
}
//an api for limiting the data dynamically by no 
//http://localhost:8080/api/products/search/limitby?limit=2
@GetMapping("/search/limitby")
public ResponseEntity<List<Products>> limitbynoProducts(@RequestParam("limit") int limit){
	return ResponseEntity.ok(productservice.limitbyProducts(limit));
}
// an api to sort products by price
//http://localhost:8080/api/products/sort
@GetMapping("/sort")
public ResponseEntity<List<Products>> pricesortProducts(){
	return ResponseEntity.ok(productservice.sortbyprice());
}
// an api to show enabled movies alone to the customer
//http://localhost:8080/api/products/show
@GetMapping("/show")
public ResponseEntity<List<Products>> showreadyProducts(){
	return ResponseEntity.ok(productservice.showalltocustopmer());
}
}
