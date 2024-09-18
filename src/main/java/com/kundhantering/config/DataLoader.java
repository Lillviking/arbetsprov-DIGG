package com.kundhantering.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.kundhantering.service.KundService;

@Component

public class DataLoader implements CommandLineRunner{

    private final KundService kundService;

    public DataLoader(KundService kundService) {
        this.kundService = kundService;
    }
    
    @Override
    public void run(String... args) throws Exception {

                // Generera 20 kunder vid uppstart
                kundService.generate20Customers();
                System.out.println("20 kunder har skapats!");
    }

}
