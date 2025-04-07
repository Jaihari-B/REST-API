package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
    public Vendor getByCategory(String category){
        return vendorRepository.getByCategory(category);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
