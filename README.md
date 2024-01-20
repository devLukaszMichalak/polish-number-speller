﻿# polish-number-speller

The Polish Number Speller is a lightweight Java library designed to seamlessly convert numerical values into their corresponding words in the Polish language.

## Example usage

```java
Speller speller = new Speller();

String result = speller.spell("11");
System.out.println(result); // jedenaście

String resultWithCurrency = speller.spellWithCurrency("11");
System.out.println(resultWithCurrency); // jedenaście złotych
``` 
