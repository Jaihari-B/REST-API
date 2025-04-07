package com.example.demo.service;

import com.example.demo.entity.Organizer;
import com.example.demo.entity.User;
import com.example.demo.repository.OrganizerRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private OrganizerRepository organizerRepo;

    public List<User> getUsers(){
        return repo.findAll();
    }
    public boolean isPhnExits(String phn){
        return repo.existsByPhn(phn);
    }
    public boolean isEmailExists(String email){
        return repo.existsByEmail(email);
    }
    public User saveUser(User user) {
        if (user.getOrganizer() != null) {
            Organizer organizer = user.getOrganizer();
            if (organizer.getId() == null) {
                organizer = organizerRepo.save(organizer);
            } else {
                organizer = organizerRepo.findById(organizer.getId())
                        .orElseThrow(() -> new RuntimeException("Organizer not found"));
            }
            user.setOrganizer(organizer);
        }
        return repo.save(user);
    }

    public List<User> postUsers(List<User> users){
        return repo.saveAll(users);
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }
    public List<User> getUserByAge(int age){
        return repo.findByAge(age);
    }
    public boolean updatePhn(Long id,String phn){
        Optional<User> userOptional = repo.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setPhn(phn);
            repo.save(user);
            return true;
        }
        return false;
    }
    public List<User> getUsersWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = repo.findAll(pageable);
        return userPage.getContent();
    }

    public Long countUsers(){
        return repo.countUsers();
    }
    public boolean deleteUser(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        } 
        return false;
    }
    @Transactional
    public boolean deleteByAge(int age) {
        return repo.deleteByAge(age) > 0; // Returns true if at least one record was deleted  
    }

    public List<User> getUsersWithPaginationAndSorting(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable).getContent();
    }
}
