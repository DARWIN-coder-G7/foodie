package com.restapi.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.restapi.back.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query( value ="select * from order_data where user_id = :query",
			nativeQuery = true)	
	List<Order>ByUserId(long query);
}
