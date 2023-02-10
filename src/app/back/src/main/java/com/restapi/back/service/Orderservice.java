package com.restapi.back.service;

import java.util.List;

import com.restapi.back.entity.Order;

public interface Orderservice {
List<Order>getByuserId(long userid);
Order saveOrder(Order orderdata);
}
