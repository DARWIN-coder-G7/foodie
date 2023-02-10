package com.restapi.back.service;

import com.restapi.back.entity.Admin;

public interface AdminService {
Admin getbyid(int id);
Admin checkuser(String username,String pass);
Admin Updatepassword(Admin admin,int id);
}
