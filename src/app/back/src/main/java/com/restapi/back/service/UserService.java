package com.restapi.back.service;

import com.restapi.back.entity.UserData;

public interface UserService {
UserData saveUser(UserData userdata);
UserData getUserById(long id);
UserData checkuser(String username,String pass);
}
