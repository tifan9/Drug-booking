package com.drug.drugbooking.controller;

import com.drug.drugbooking.domain.Users;
import com.drug.drugbooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    // save user
    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody Users user){
        if(user != null){
            Users existingUser = userService.findUser(user.getUserId());
            if(existingUser == null){
                userService.saveUser(user);
                return ResponseEntity.ok("User saved successfully");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
            }
        }
        return new ResponseEntity<>("user is null", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user){
        Users existingUser = userService.findUser(user.getUserId());
        if(existingUser!=null && user.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    // allUsers
    @GetMapping("/allUsers")
    public ResponseEntity<?> allUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }
    //delete user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }




}
