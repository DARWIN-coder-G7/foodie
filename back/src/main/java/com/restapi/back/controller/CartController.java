package com.restapi.back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.back.entity.CartData;
import com.restapi.back.service.CartDataService;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/cart")
public class CartController {
public CartController(CartDataService cdi) {
		super();
		this.cdi = cdi;
	}
private CartDataService cdi;
//To add new cart
	@PostMapping()
	public ResponseEntity<CartData> saveUser(@RequestBody CartData cartdata){
		System.out.println(cartdata);
		return new ResponseEntity<CartData>(cdi.saveCart(cartdata),HttpStatus.CREATED);
	}
	// an api to get cart details by user id
	@GetMapping("/byuser")
	public ResponseEntity<List<CartData>> getbyuser(@RequestParam("userid") long userid){
		return new ResponseEntity<List<CartData>>(cdi.getCartByUserid(userid),HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletecartbyid(@PathVariable("id") long id){
		cdi.deleteCartdata(id);;
		return new ResponseEntity<String>("sucess!",HttpStatus.OK);
	}
	@DeleteMapping("/deluser")
	public ResponseEntity<String> deleteproducts(@RequestParam("userid") long id){
		cdi.delCartByUserid(id);
		return new ResponseEntity<String>("sucess!",HttpStatus.OK);
	}
}
