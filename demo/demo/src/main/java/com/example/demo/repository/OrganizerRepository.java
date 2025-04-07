package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    public Organizer getByEmail(String email);
}