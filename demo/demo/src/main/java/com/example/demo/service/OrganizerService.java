package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer saveOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
    
    public Organizer getByEmail(String email){
        return organizerRepository.getByEmail(email);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}
