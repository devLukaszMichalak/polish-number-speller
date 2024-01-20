package dev.lukaszmichalak.spell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpellerTest {
    
    @Test
    void shouldSpellMaxIntNumberWithCurrency() {
        String s = new Speller().spellWithCurrency(Integer.MAX_VALUE);
        assertThat(s).isEqualTo("dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem złotych");
    }
    
    @Test
    void shouldSpellMinIntNumberWithCurrency() {
        String s = new Speller().spellWithCurrency(Integer.MIN_VALUE + 1);
        assertThat(s).isEqualTo("minus dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem złotych");
    }
    
    @Test
    void shouldSpellMaxInt() {
        String s = new Speller().spell(Integer.MAX_VALUE);
        assertThat(s).isEqualTo("dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem");
    }
    
    @Test
    void shouldSpellMinInt() {
        String s = new Speller().spell(Integer.MIN_VALUE + 1);
        assertThat(s).isEqualTo("minus dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem");
    }
    
    @Test
    void shouldSpell() {
        String s = new Speller().spell("123.123");
        assertThat(s).isEqualTo("sto dwadzieścia trzy i dwanaście setnych");
    }
    
    @ParameterizedTest
    @ArgumentsSource(NumberArgumentProvider.class)
    void shouldSpellNumberWithCurrency(String number, String result) {
        String s = new Speller().spellWithCurrency(number);
        assertThat(s).isEqualTo(result);
    }
}