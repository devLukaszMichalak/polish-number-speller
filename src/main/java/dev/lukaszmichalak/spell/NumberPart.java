package dev.lukaszmichalak.spell;

class NumberPart {
    
    private final int number;
    
    NumberPart(int number) {
        this.number = number;
    }
    
    NumberPart(String number) {
        this.number = Integer.parseInt(number);
    }
    
    int get() {
        return number;
    }
    
    int getInverse() {
        return -number;
    }
    
    boolean isZero() {
        return number == 0;
    }
}
