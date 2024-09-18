package com.kundhantering.controller;

import com.kundhantering.model.Kund;
import com.kundhantering.service.KundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;


import java.util.List;

@RestController
@RequestMapping("/digg/user")
public class KundController {

    @Autowired
    private KundService kundService;

    // Lägg till ny kund
    @PostMapping
    public ResponseEntity<String> addKund(@RequestBody Kund kund) {
        try {
            kundService.addKund(kund);
            return new ResponseEntity<>("Kund tillagd", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Kunde inte lägga till kund", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Hämta alla kunder med paginering
    @GetMapping
    public List<Kund> getAllaKunder(@RequestParam(defaultValue = "0") int page, 
                                   @RequestParam(defaultValue = "10") int size) {
        List<Kund> allaKunder = kundService.getAllaKunder();
        int start = page * size;
        if (start >= allaKunder.size()) {

            // returnera en oföränderlig tom lista
            return Collections.emptyList(); // Om det inte finns fler kunder, returnera en tom lista
        }
        int end = Math.min((start + size), allaKunder.size());
        return allaKunder.subList(start, end);
    }
}
