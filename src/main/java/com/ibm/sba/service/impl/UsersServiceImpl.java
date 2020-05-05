package com.ibm.sba.service.impl;

import com.ibm.sba.domain.Users;
import com.ibm.sba.repository.UsersRepository;
import com.ibm.sba.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users getUserByUserId(int userId) {
        Users users = this.usersRepository.findById(userId).orElse(null);
        return users;
    }

    @Override
    public List<Users> getUsersList(Users users) {
        List<Users> usersList = this.usersRepository.findAll();
        return usersList;
    }

    @Override
    public Users addUser(Users users) {
        this.usersRepository.save(users);
        return users;
    }

    @Override
    public Users updateUser(Users users) {
        Users usersNew = this.usersRepository.findById(users.getUserId()).orElse(null);
        usersNew.setUserName(users.getUserName());
        usersNew.setPassword(users.getPassword());
        usersNew.setEmail(users.getEmail());
        this.usersRepository.save(usersNew);
        return usersNew;
    }

    @Override
    public Users deleteUser(int userId) {
        Users users = this.usersRepository.findById(userId).orElse(null);
        users.setActive(0);
        this.usersRepository.save(users);
        return users;
    }

    @Override
    public Users login(String userName) {
        Users users = this.usersRepository.findUsersByUserName(userName);
        return users;
    }
}
