package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService usr;

    @GetMapping("/users")
    public List<User> getUsers(){
        return usr.getUsers();
    }

    @GetMapping("/count")
    public Long countUsers(){
        return usr.countUsers();
    }
    

    @PostMapping("/post-user")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        if(usr.isEmailExists(user.getEmail())){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        if(usr.isPhnExits(user.getPhn())){
            return ResponseEntity.badRequest().body("Phone number already exists");
        }
        usr.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    @PutMapping("/updatePhn/{id}")
    public ResponseEntity<String> updatePhn(@PathVariable Long id, @RequestParam String phn) {
        boolean updated = usr.updatePhn(id, phn);
        return updated ? ResponseEntity.ok("Updated") : ResponseEntity.badRequest().body("User not found with ID: " + id);
    }

    @PostMapping("/postusers")
    public List<User> postUsers(@RequestBody List<User> users) {
        return usr.postUsers(users);
    }
    @GetMapping("/age")
    public List<User> getUserByAge(@RequestParam int age){
        return usr.getUserByAge(age);
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return usr.getUserById(id);
    }

    @GetMapping("/get-users-pagination")
    public List<User> getUsersWithPagination(@RequestParam int page, @RequestParam int size) {
        return usr.getUsersWithPagination(page, size);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = usr.deleteUser(id);
        return deleted ? ResponseEntity.ok("Deleted") : ResponseEntity.badRequest().body("User not found with ID: " + id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByAge(@RequestParam int age){
        boolean deleted = usr.deleteByAge(age);
        return deleted ? ResponseEntity.ok("Deleted") : ResponseEntity.badRequest().body("Invalid");
    }

    @GetMapping("/get-users-pagination-sorting")
    public List<User> getUsersWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {
        return usr.getUsersWithPaginationAndSorting(page, size, sortBy, direction);
    }

}
