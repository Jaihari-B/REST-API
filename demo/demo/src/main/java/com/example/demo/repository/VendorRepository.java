package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    public Vendor getByCategory(String category);
}