package com.kundhantering.service;

import com.kundhantering.model.Kund;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KundServiceTest {

    private KundService kundService;

    @BeforeEach
    public void setUp() {
        kundService = new KundService();  
    }

    @Test
    public void testAddKund() {
        // Arrange
        Kund kund = new Kund("Test Namn", "Test Adress", "test@test.com", "0701234567");

        // Act
        kundService.addKund(kund);
        List<Kund> kunder = kundService.getAllKunder();

        // Assert
        assertEquals(1, kunder.size());  // Kontrollera att en kund har lagts till
        assertEquals("Test Namn", kunder.get(0).getName());  // Kontrollera kundens namn
    }

    @Test
    public void testGetAllKunder() {
        // Arrange
        Kund kund1 = new Kund("Kund 1", "Adress 1", "kund1@test.com", "0701234561");
        Kund kund2 = new Kund("Kund 2", "Adress 2", "kund2@test.com", "0701234562");

        // Act
        kundService.addKund(kund1);
        kundService.addKund(kund2);
        List<Kund> kunder = kundService.getAllKunder();

        // Assert
        assertEquals(2, kunder.size());  // Kontrollera att två kunder finns
        assertEquals("Kund 2", kunder.get(1).getName());  // Kontrollera den andra kundens namn
    }
}
