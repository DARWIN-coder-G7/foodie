package com.restapi.back.service.impl;

import org.springframework.stereotype.Service;

import com.restapi.back.entity.UserData;
import com.restapi.back.exception.ResourceNotFoundException;
import com.restapi.back.repository.UserRepository;
import com.restapi.back.service.UserService;
@Service
public class UserServiceImplementation implements UserService {
 
	public UserServiceImplementation(UserRepository userepo) {
		super();
		this.userepo = userepo;
	}

	private UserRepository userepo;
	@Override
	public UserData saveUser(UserData userdata) {
		// TODO Auto-generated method stub
		return userepo.save(userdata);
	}

	@Override
	public UserData getUserById(long id) {
		// TODO Auto-generated method stub
		return userepo.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("UserData","id",id));
	}

	@Override
	public UserData checkuser(String username, String pass) {
		// TODO Auto-generated method stub
		return userepo.logincheck(username, pass);
	}

}
