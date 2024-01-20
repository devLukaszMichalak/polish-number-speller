package dev.lukaszmichalak.spell;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumberArgumentProvider implements ArgumentsProvider {
    
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                arguments("0.01", "jeden grosz"),
                arguments("0.11", "jedenaście groszy"),
                arguments("-0.9", "minus dziewięćdziesiąt groszy"),
                arguments("0.90", "dziewięćdziesiąt groszy"),
                arguments("0.23", "dwadzieścia trzy grosze"),
                arguments("1", "jeden złoty"),
                arguments("13", "trzynaście złotych"),
                arguments("22", "dwadzieścia dwa złote"),
                arguments("25", "dwadzieścia pięć złotych"),
                arguments("-25", "minus dwadzieścia pięć złotych"),
                arguments("125", "sto dwadzieścia pięć złotych"),
                arguments("1125", "jeden tysiąc sto dwadzieścia pięć złotych")
        );
    }
}
