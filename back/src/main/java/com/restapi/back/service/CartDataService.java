package com.restapi.back.service;

import java.util.List;

import com.restapi.back.entity.CartData;

public interface CartDataService {
CartData saveCart(CartData cartdata);
List<CartData> getCartByUserid(long userid);
void delCartByUserid(long userid);
void deleteCartdata(long id);
}
