package com.kundhantering.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kundhantering.model.Kund;

@Service
public class KundService {

    private List<Kund> kunder = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(KundService.class);

    public void addKund(Kund kund) {
        try {
            if (kund == null) {
                logger.error("Kundobjektet är null och kan inte läggas till.");
                throw new IllegalArgumentException("Kund kan inte vara null.");
            }

            // Validera om viktiga fält är tomma
            if (kund.getName() == null || kund.getName().isEmpty()) {
                logger.error("Kundnamn saknas.");
                throw new IllegalArgumentException("Kundnamn är obligatoriskt.");
            }

            // Lägg till kunden
            kunder.add(kund);
            logger.info("Kund har lagts till: {}", kund.getName(), kund.getAddress(), kund.getEmail(), kund.getTelephone());

        } catch (IllegalArgumentException e) {
            logger.error("Ett fel uppstod när kunden skulle läggas till: {}", e.getMessage());
            throw e; // Kasta vidare undantaget så att controller kan hantera det och returnera lämpligt svar till klienten
        } catch (Exception e) {
            logger.error("Ett oväntat fel uppstod: {}", e.getMessage());
            throw new RuntimeException("Ett oväntat fel uppstod vid tillägg av kund.");
        }
    }

    public List<Kund> getAllaKunder() {
        return kunder;
    }

    public void generate20Customers() {
        for(int i = 1; i <= 20; i++) {
            addKund(new Kund("Kund " + i, "Adress " + i, "kund" + i + "@exempelkund.se", "07012345" + i));
        }
    }
}
