package com.restapi.back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.restapi.back.entity.Order;
import com.restapi.back.service.Orderservice;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/order")
public class OrderController {
public OrderController(Orderservice ordserv) {
		super();
		this.ordserv = ordserv;
	}

private Orderservice ordserv;
@PostMapping()
public ResponseEntity<Order> saveUser(@RequestBody Order orderdata){
	
	return new ResponseEntity<Order>(ordserv.saveOrder(orderdata),HttpStatus.CREATED);
}
@GetMapping("/byuser")
public ResponseEntity<List<Order>> getbyuser(@RequestParam("userid") long userid){
	return new ResponseEntity<List<Order>>(ordserv.getByuserId(userid),HttpStatus.OK);
	
}
}
