package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phn;
    private String category;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonIgnore
    private Organizer organizer;

    @ManyToMany(mappedBy = "vendors")
    @JsonIgnore
    private List<User> users;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
