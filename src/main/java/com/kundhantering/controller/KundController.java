package com.kundhantering.controller;

import com.kundhantering.model.Kund;
import com.kundhantering.service.KundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digg/user")
public class KundController {

    @Autowired
    private KundService kundService;

    // lägg till ny kund
    @PostMapping("/user")
    public void addKund(@RequestBody Kund kund) {
        kundService.addKund(kund);
    }

    // hämta alla kunder
    @GetMapping("/user")
    public List<Kund> getAllKunder() {
        return kundService.getAllKunder();
    }
}
