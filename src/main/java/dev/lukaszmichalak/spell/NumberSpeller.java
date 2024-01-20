package dev.lukaszmichalak.spell;

class NumberSpeller {
    
    static StringBuilder spellNumber(int number) {
        if (number == 0) {
            return new StringBuilder("zero");
        }
        
        StringBuilder result = new StringBuilder();
        int group = 0;
        
        while (number > 0) {
            int hundred = number % 1000 / 100;
            int teen = 0;
            int ten = number % 100 / 10;
            int one = number % 10;
            
            if (ten == 1 && one > 0) {
                teen = one;
                ten = 0;
                one = 0;
            }
            
            int groupType = getGroupType(one, hundred, ten, teen);
            
            if (hundred + ten + teen + one > 0) {
                
                addGroupIfNeeded(group, groupType, result);
                
                if (teen > 0) {
                    addTeens(result, teen, hundred);
                } else {
                    addNormal(result, one, ten, hundred);
                }
            }
            
            group++;
            number = number / 1000;
        }
        
        return result;
    }
    
    private static void addNormal(StringBuilder result, int one, int ten, int hundred) {
        result.insert(0, ones[one]);
        
        if (ten > 0 && one > 0) {
            result.insert(0, " ");
        }
        result.insert(0, tens[ten]);
        
        if (hundred > 0 && ten > 0 || hundred > 0 && one > 0) {
            result.insert(0, " ");
        }
        result.insert(0, hundreds[hundred]);
    }
    
    private static void addTeens(StringBuilder result, int teen, int hundred) {
        result.insert(0, teens[teen]);
        
        if (hundred > 0) {
            result.insert(0, " ");
        }
        result.insert(0, hundreds[hundred]);
    }
    
    private static void addGroupIfNeeded(int group, int groupType, StringBuilder result) {
        if (!groups[group][groupType].isBlank()) {
            result.insert(0, " ");
            result.insert(0, groups[group][groupType]);
            result.insert(0, " ");
        }
    }
    
    private static int getGroupType(int one, int hundred, int ten, int teen) {
        int groupType;
        if (one == 1 && hundred + ten + teen == 0) {
            groupType = 0;
        } else if (one == 2 || one == 3 || one == 4) {
            groupType = 1;
        } else {
            groupType = 2;
        }
        return groupType;
    }
    
    private static final String[] ones = {
            "",
            "jeden",
            "dwa",
            "trzy",
            "cztery",
            "pięć",
            "sześć",
            "siedem",
            "osiem",
            "dziewięć"
    };
    
    private final static String[] teens = {
            "",
            "jedenaście",
            "dwanaście",
            "trzynaście",
            "czternaście",
            "piętnaście",
            "szesnaście",
            "siedemnaście",
            "osiemnaście",
            "dziewiętnaście"
    };
    
    private final static String[] tens = {
            "",
            "dziesięć",
            "dwadzieścia",
            "trzydzieści",
            "czterdzieści",
            "pięćdziesiąt",
            "sześćdziesiąt",
            "siedemdziesiąt",
            "osiemdziesiąt",
            "dziewięćdziesiąt"
    };
    
    private final static String[] hundreds = {
            "",
            "sto",
            "dwieście",
            "trzysta",
            "czterysta",
            "pięćset",
            "sześćset",
            "siedemset",
            "osiemset",
            "dziewięćset"
    };
    
    private final static String[][] groups = {
            {"", "", ""},
            {"tysiąc", "tysiące", "tysięcy"},
            {"milion", "miliony", "milionów"},
            {"miliard", "miliardy", "miliardów"},
            {"bilion", "biliony", "bilionów"},
            {"biliard", "biliardy", "biliardów"},
            {"trylion", "tryliony", "trylionów"}
    };
}
