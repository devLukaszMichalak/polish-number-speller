package dev.lukaszmichalak.spell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellerTest {
    
    @Test
    void numberWithCurrency() {
        String s = new Speller().numberWithCurrency("-0.9");
        assertEquals("minus dziewięćdziesiąt groszy", s);
    }
    
    @Test
    void testNumberWithCurrency() {
        String s = new Speller().numberWithCurrency(20);
        assertEquals("dwadzieścia złotych", s);
    }
}