package dev.lukaszmichalak.spell;

class CurrencyNumber {
    
    private final boolean isPositive;
    private final NumberPart zlote;
    private final NumberPart grosze;
    
    CurrencyNumber(String number) {
        
        if (number.startsWith("-")) {
            isPositive = false;
            number = number.replace("-", "");
        } else {
            isPositive = true;
        }
        
        if (number.contains(".")) {
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
        }
    }
    
    CurrencyNumber(int zlote) {
        isPositive = zlote > 0;
        this.zlote = isPositive ? new NumberPart(zlote) : new NumberPart(Math.negateExact(zlote));
        grosze = new NumberPart(0);
    }
    
    int zlote() {
        return zlote.get();
    }
    
    int grosze() {
        return grosze.get();
    }
    
    String spellWithCurrency() {
        if (isZero()) {
            return "zero złotych";
        }
        
        String znak = !isPositive() ? "minus " : "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(znak);
        
        if (zlote() > 0 && grosze() == 0) {
            return sb
                    .append(spellZlote())
                    .append(" ")
                    .append(getZloteWord())
                    .toString();
            
        } else if (zlote() > 0 && grosze() > 0) {
            return sb
                    .append(spellZlote())
                    .append(" ")
                    .append(getZloteWord())
                    .append(" i ").append(spellGrosze())
                    .append(" ")
                    .append(getGroszeWord())
                    .toString();
            
        } else if (zlote() == 0 && grosze() > 0) {
            return sb
                    .append(spellGrosze())
                    .append(" ")
                    .append(getGroszeWord())
                    .toString();
        } else {
            return "";
        }
    }
    
    String spell() {
        if (isZero()) {
            return "zero złotych";
        }
        
        String znak = !isPositive() ? "minus " : "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(znak);
        
        if (zlote() > 0 && grosze() == 0) {
            return sb
                    .append(spellZlote())
                    .toString();
            
        } else if (zlote() > 0 && grosze() > 0) {
            return sb
                    .append(spellZlote())
                    .append(" i ").append(spellGrosze())
                    .append(" ")
                    .append(getSetneWord())
                    .toString();
            
        } else if (zlote() == 0 && grosze() > 0) {
            return sb
                    .append(spellGrosze())
                    .append(" ")
                    .append(getSetneWord())
                    .toString();
        } else {
            return "";
        }
    }
    
    
    private boolean isZero() {
        return zlote.isZero() && grosze.isZero();
    }
    
    private StringBuilder spellGrosze() {
        return NumberSpeller.spellNumber(grosze());
    }
    
    private StringBuilder spellZlote() {
        return NumberSpeller.spellNumber(zlote());
    }
    
    private String getZloteWord() {
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
    
    private String getGroszeWord() {
        if (grosze() == 1) {
            return "grosz";
        } else if (grosze() % 10 >= 2 && grosze() % 10 <= 4 && grosze() / 10 != 1) {
            return "grosze";
        } else {
            return "groszy";
        }
    }
    
    private String getSetneWord() {
        if (grosze() == 1) {
            return "setna";
        } else if (grosze() % 10 >= 2 && grosze() % 10 <= 4 && grosze() / 10 != 1) {
            return "setne";
        } else {
            return "setnych";
        }
    }
    
    private boolean isPositive() {
        return isPositive;
    }
}
