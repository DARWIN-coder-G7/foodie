package com.restapi.back.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.back.entity.Order;
import com.restapi.back.repository.OrderRepository;
import com.restapi.back.service.Orderservice;

@Service
public class OrderImpl implements Orderservice {
public OrderImpl(OrderRepository ordrepo) {
		super();
		this.ordrepo = ordrepo;
	}

private OrderRepository ordrepo;
	@Override
	public List<Order> getByuserId(long userid) {
		// TODO Auto-generated method stub
		return ordrepo.ByUserId(userid);
	}

	@Override
	public Order saveOrder(Order orderdata) {
		// TODO Auto-generated method stub
		return ordrepo.save(orderdata);
	}

}
