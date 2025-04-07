package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByName(String name);
    Optional<User> findById(Long id);
    void deleteById(Long id);

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findByAge(@Param("age") int age);

    boolean existsByPhn(String phn);
    boolean existsByEmail(String email);

    @Query("SELECT COUNT(u) FROM User u")
    long countUsers();

    boolean existsByAge(int age);
    
    @Modifying
    @Query("DELETE FROM User u WHERE u.age = :age")
    int deleteByAge(@Param("age") int age);
}