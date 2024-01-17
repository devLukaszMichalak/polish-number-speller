package dev.lukaszmichalak.spell;

public class Speller {
    
    public String numberWithCurrency(int number) {
        CurrencyNumber currency = new CurrencyNumber(number);
        
        return spellWithCurrency(currency);
    }
    
    public String numberWithCurrency(String number) {
        if (number.isBlank()) {
            return "";
        }
        
        CurrencyNumber currency = new CurrencyNumber(number);
        
        return spellWithCurrency(currency);
    }
    
    private String spellWithCurrency(CurrencyNumber currency) {
        if (currency.isZero()) {
            return "zero złotych";
        }
        
        String znak = !currency.isPositive() ? "minus" : "";
        
        if (currency.zlote() > 0 && currency.grosze() == 0){
            return znak +  currency.spellZlote() + " " + currency.getZloteWord();
        } else if(currency.zlote() > 0 && currency.grosze() > 0) {
            return znak + currency.spellZlote() + currency.getZloteWord() + " i " + currency.spellGrosze() + currency.getGroszeWord();
        } else if (currency.zlote() == 0 && currency.grosze() > 0) {
            return znak + currency.spellGrosze() + currency.getGroszeWord();
        } else {
            return "";
        }
        
    }
    
}
