package com.restapi.back.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.back.entity.CartData;
import com.restapi.back.exception.ResourceNotFoundException;
import com.restapi.back.repository.CartDataRepository;
import com.restapi.back.service.CartDataService;

@Service
public class CartDataImplementation implements CartDataService {
   public CartDataImplementation(CartDataRepository cdr) {
		super();
		this.cdr = cdr;
	}

private CartDataRepository cdr;

@Override
public CartData saveCart(CartData cartdata) {
	// TODO Auto-generated method stub
	return cdr.save(cartdata);
}

@Override
public List<CartData> getCartByUserid(long userid) {
	// TODO Auto-generated method stub
	return cdr.ByUserId(userid);
}

@Override
public void delCartByUserid(long userid) {
	// TODO Auto-generated method stub
	cdr.delByUserId(userid);
}

@Override
public void deleteCartdata(long id) {
	// TODO Auto-generated method stub
	cdr.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Products","id",id));
	cdr.deleteById(id);
}
}
