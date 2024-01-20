package dev.lukaszmichalak.spell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpellerTest {
    
    @Test
    void maxIntNumberWithCurrency() {
        String s = new Speller().numberWithCurrency(Integer.MAX_VALUE);
        assertThat(s).isEqualTo("dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem złotych");
    }
    
    @Test
    void minIntNumberWithCurrency() {
        String s = new Speller().numberWithCurrency(Integer.MIN_VALUE + 1);
        assertThat(s).isEqualTo("minus dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem złotych");
    }
    
    @ParameterizedTest
    @ArgumentsSource(NumberArgumentProvider.class)
    void numberWithCurrency(String number, String result) {
        String s = new Speller().numberWithCurrency(number);
        assertThat(s).isEqualTo(result);
    }
}