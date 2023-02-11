package com.restapi.back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.back.entity.UserData;
import com.restapi.back.service.UserService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class UserController {

	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	private UserService userservice;
	
	// To create a new user
	@PostMapping()
	public ResponseEntity<UserData> saveUser(@RequestBody UserData userdata){
		return new ResponseEntity<UserData>(userservice.saveUser(userdata),HttpStatus.CREATED);
	}
	//To get userDetails by id
	@GetMapping("{id}")
	public ResponseEntity<UserData> getUser(@PathVariable long id){
		return new ResponseEntity<UserData>(userservice.getUserById(id),HttpStatus.OK);
		
	}
	@PostMapping("/log")
	public ResponseEntity<?> loginuser(@RequestBody UserData userdata){
		UserData user =  userservice.getUserById(userdata.getUserid());
		if(user.getUserpass().equals(userdata.getUserpass()))
			return ResponseEntity.ok(user);
		
		return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
	//http://localhost:8080/api/user/seeman/Seem@n
	@GetMapping("/{username}/{pass}")
	public ResponseEntity<UserData> validatelogin(@PathVariable("username") String username,
			@PathVariable("pass") String pass){
	return new ResponseEntity<UserData>(userservice.checkuser(username, pass),HttpStatus.OK);
		
	}
	/*@GetMapping("/checker")
	public ResponseEntity<UserData> validateclogin(){
		String username = "sarathi";
		String pass = "S@rathi";
	return new ResponseEntity<UserData>(userservice.checkuser(username, pass),HttpStatus.OK);
		
	}*/
}
