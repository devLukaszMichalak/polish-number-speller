package dev.lukaszmichalak;

import dev.lukaszmichalak.spell.Speller;

public class Main {
    public static void main(String[] args) {
        String s = new Speller().numberWithCurrency("-0.9");
        System.out.println(s);
    }
    
}