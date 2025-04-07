package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    private String category;
    private String phn;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonIgnore
    private Organizer organizer;

    @ManyToMany
    @JoinTable(
        name = "user_vendor",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    @JsonIgnore
    private List<Vendor> vendors;

    // Constructors
    public User() {}

    public User(String name, String email, int age, String category, String phn, Organizer organizer) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.category = category;
        this.phn = phn;
        this.organizer = organizer;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }
}
