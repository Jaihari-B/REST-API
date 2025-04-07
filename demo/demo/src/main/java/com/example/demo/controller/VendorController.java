package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/register")
    public ResponseEntity<Vendor> registerVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.saveVendor(vendor));
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }
    @GetMapping("/category")
    public Vendor getByCategory(@RequestParam String category){
        return vendorService.getByCategory(category);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vendor>> getVendor(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Vendor deleted successfully");
    }
}