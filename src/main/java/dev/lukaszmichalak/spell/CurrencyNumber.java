package dev.lukaszmichalak.spell;

class CurrencyNumber {
    
    private boolean isPositive;
    private NumberPart zlote;
    private final NumberPart grosze;
    
    CurrencyNumber(String number) {
        if (number.contains(".")) {
            
            if (number.startsWith("-")) {
                isPositive = false;
                number = number.replace("-", "");
            } else {
                isPositive = true;
            }
            
            number = number + "00";
            String licznik = number.strip().substring(0, number.indexOf(".") + 3);
            String[] zloteGrosze = licznik.split("\\.");
            String zloteRaw = zloteGrosze[0];
            String groszeRaw = zloteGrosze[1];
            zlote = new NumberPart(zloteRaw);
            grosze = new NumberPart(groszeRaw);
            
        } else {
            zlote = new NumberPart(number);
            grosze = new NumberPart(0);
            isPositive = zlote() > 0;
        }
    }
    
    CurrencyNumber(int zlote) {
        this.zlote = new NumberPart(zlote);
        this.grosze = new NumberPart(0);
        this.isPositive = zlote() > 0;
    }
    
    int zlote() {
        return zlote.get();
    }
    
    int grosze() {
        return grosze.get();
    }
    
    boolean isZero() {
        return zlote.isZero() && grosze.isZero();
    }
    
    String spellGrosze() {
        return NumberSpeller.spellNumber(grosze());
    }
    
    String spellZlote() {
        return NumberSpeller.spellNumber(zlote());
    }
    
    String getZloteWord() {
        String nominal;
        
        if (zlote() % 10 == 1 && zlote() % 100 != 11) {
            nominal = "złoty";
        } else if (
                zlote() % 10 >= 2 &&
                zlote() % 10 <= 4 &&
                !(zlote() % 100 >= 12 && zlote() % 100 <= 14)
        ) {
            nominal = "złote";
        } else {
            nominal = "złotych";
        }
        
        return nominal;
    }
    
    String getGroszeWord() {
        if (grosze() == 1) {
            return "jeden grosz";
        } else if (grosze() % 10 >= 2 && grosze() % 10 <= 4 && grosze() / 10 != 1) {
            return " grosze";
        } else {
            return " groszy";
        }
    }
    
    public boolean isPositive() {
        return isPositive;
    }
}
