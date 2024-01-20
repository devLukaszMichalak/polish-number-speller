# polish-number-speller

The Polish Number Speller is a lightweight Java library designed to seamlessly convert numerical values into their corresponding words in the Polish language.

## Example usage

```java
Speller speller = new Speller();

String result = speller.spell("11");
System.out.println(result); // jedenaście

String resultWithCurrency = speller.spellWithCurrency("11");
System.out.println(resultWithCurrency); // jedenaście złotych
``` 

Spelling is limited to 2 decimal places:
```java
String result = speller.spell("11.1");
System.out.println(result); // jedenaście i dziesięć setnych 

String resultWithCurrency = speller.spellWithCurrency("11.10");
System.out.println(resultWithCurrency); // jedenaście złotych i dziesięć groszy 
``` 