package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Organizer;
import com.example.demo.service.OrganizerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/register")
    public ResponseEntity<Organizer> registerOrganizer(@RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.saveOrganizer(organizer));
    }

    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Organizer>> getOrganizer(@PathVariable Long id) {
        return ResponseEntity.ok(organizerService.getOrganizerById(id));
    }

    @GetMapping("/email")
    public Organizer getByEmail(@RequestParam String email){
        return organizerService.getByEmail(email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.ok("Organizer deleted successfully");
    }
}
