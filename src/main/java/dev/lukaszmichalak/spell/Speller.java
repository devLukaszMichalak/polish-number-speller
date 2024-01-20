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
        
        String znak = !currency.isPositive() ? "minus " : "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(znak);
        
        if (currency.zlote() > 0 && currency.grosze() == 0) {
            return sb
                    .append(currency.spellZlote())
                    .append(" ")
                    .append(currency.getZloteWord())
                    .toString();
            
        } else if (currency.zlote() > 0 && currency.grosze() > 0) {
            return sb
                    .append(currency.spellZlote())
                    .append(" ")
                    .append(currency.getZloteWord())
                    .append(" i ").append(currency.spellGrosze())
                    .append(" ")
                    .append(currency.getGroszeWord())
                    .toString();
            
        } else if (currency.zlote() == 0 && currency.grosze() > 0) {
            return sb
                    .append(currency.spellGrosze())
                    .append(" ")
                    .append(currency.getGroszeWord())
                    .toString();
        } else {
            return "";
        }
        
    }
    
}
