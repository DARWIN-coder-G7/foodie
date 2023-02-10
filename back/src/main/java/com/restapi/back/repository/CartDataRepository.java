package com.restapi.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.back.entity.CartData;

public interface CartDataRepository extends JpaRepository<CartData,Long>{

	@Query( value ="select * from cart_data where user_id = :query",
			nativeQuery = true)	
	List<CartData>ByUserId(long query);
	@Modifying
	@Transactional
	@Query( value ="delete from cart_data where user_id = :query",
			nativeQuery = true)	
	void delByUserId(long query);
}
