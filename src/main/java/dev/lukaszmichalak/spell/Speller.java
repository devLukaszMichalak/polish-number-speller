package dev.lukaszmichalak.spell;

public class Speller {
    
    public String spellWithCurrency(int number) {
        return new CurrencyNumber(number).spellWithCurrency();
    }
    
    public String spellWithCurrency(String number) {
        if (number.isBlank()) {
            return "";
        }
        
        return new CurrencyNumber(number).spellWithCurrency();
    }
    
    public String spell(int number) {
        return new CurrencyNumber(number).spell();
    }
    
    public String spell(String number) {
        if (number.isBlank()) {
            return "";
        }
        
        return new CurrencyNumber(number).spell();
    }
}
