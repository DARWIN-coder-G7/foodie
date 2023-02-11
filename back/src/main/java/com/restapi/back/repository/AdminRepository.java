package com.restapi.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restapi.back.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,Integer>{
	@Query(value = "select * from admin where adminname = :name and adminkey = :pass" , nativeQuery = true)
	Admin logincheck(String name,String pass);
	@Query(value = "update admin set adminkey = :pass where admid =1;", nativeQuery = true)
	void changepass(String pass);
}
