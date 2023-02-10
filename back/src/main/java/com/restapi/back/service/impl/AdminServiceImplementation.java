package com.restapi.back.service.impl;

import org.springframework.stereotype.Service;

import com.restapi.back.entity.Admin;
import com.restapi.back.exception.ResourceNotFoundException;
import com.restapi.back.repository.AdminRepository;
import com.restapi.back.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {
public AdminServiceImplementation(AdminRepository adminrepo) {
		super();
		this.adminrepo = adminrepo;
	}

private AdminRepository adminrepo;

@Override
public Admin getbyid(int id) {
	return adminrepo.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("UserData","id",id));
	
}

@Override
public Admin checkuser(String username, String pass) {
	
	return adminrepo.logincheck(username, pass);
}

@Override
public Admin Updatepassword(Admin admin, int id) {
	Admin existing = adminrepo.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Admin","id",id));
	existing.setAdminName(admin.getAdminName());
	existing.setAdminKey(admin.getAdminKey());
	adminrepo.save(existing);
	return existing;
}


}
