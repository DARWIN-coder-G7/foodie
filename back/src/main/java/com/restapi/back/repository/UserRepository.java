package com.restapi.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.restapi.back.entity.UserData;

public interface UserRepository extends JpaRepository<UserData,Long> {
	@Query(value = "select * from user where user_name = :name and user_pass = :pass" , nativeQuery = true)
	UserData logincheck(String name,String pass);
}
