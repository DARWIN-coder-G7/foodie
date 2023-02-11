package com.restapi.back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.back.entity.Admin;
import com.restapi.back.service.AdminService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/admin")
public class Admincontroller {
     public Admincontroller(AdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}

	private AdminService adminservice;
	//to check admin login
	//http://localhost:8080/api/admin/admin/@dmin
	@GetMapping("/{username}/{pass}")
	public ResponseEntity<Admin> validatelogin(@PathVariable("username") String username,
			@PathVariable("pass") String pass){
	return new ResponseEntity<Admin>(adminservice.checkuser(username, pass),HttpStatus.OK);
		
	}
	// an api to change password
	//
	/*@GetMapping("/{pass}")
	//public ResponseEntity<String> changepin(@PathVariable("pass") String pass){
	//adminservice.changepassword(pass);
	//return new ResponseEntity<String>("sucess!",HttpStatus.OK);
	//}*/
	//http://localhost:8080/api/admin/1
	@PutMapping("{id}")
	public ResponseEntity<Admin> changepin(@PathVariable("id") int id,
			@RequestBody Admin admin){
		
		return new ResponseEntity<Admin>(adminservice.Updatepassword(admin, id),HttpStatus.OK);
	}
}
