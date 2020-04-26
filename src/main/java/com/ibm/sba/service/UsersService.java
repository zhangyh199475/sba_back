package com.ibm.sba.service;


import com.ibm.sba.domain.Users;

import java.util.List;

public interface UsersService {
    Users getUserByUserId(int userId);
    List<Users> getUsersList(Users users);
    Users addUser(Users users);
    Users updateUser(Users users);
    Users deleteUser(int userId);
    Users login(String userName);
}
