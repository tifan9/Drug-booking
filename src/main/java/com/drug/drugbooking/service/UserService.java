package com.drug.drugbooking.service;

import com.drug.drugbooking.domain.Users;
import com.drug.drugbooking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    // save users
    public void saveUser(Users user) {
        if(user!=null){
            userRepo.save(user);
        }
    }
    // find user by email
    public List<Users> allUsers(){
        return userRepo.findAll();
    }
    public Users findUser(int userId){
        return userRepo.findById(userId).orElse(null);
    }
    public void deleteUser (int userId){
        userRepo.deleteById(userId);
    }
}
