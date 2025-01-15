package problemset1;

import java.util.HashMap;

public class PrintCountOfDuplicateCharacters {
/*
STEPS:
BEGIN
1. Use any loop to check for duplicate characters until string length is 0
     1.1 store string length in a variable in each iteration
     1.2 Take first character from string, replace it by empty string. Basically we are removing all occurrences of character in string.
         As character is removed from string, string doesn't contain all occurrences of first character.
     1.3 Now we can get the count of occurrences of first character by performing subtraction
         i.e.,   countOfCharacterOccurrences=StringLengthBeforeReplacement - StringLengthAfterReplacementOfCharacter
     1.4 Check countOfCharacterOccurrences >1 and print duplicate character details
END OF LOOP
END

1. Test a string in which duplicate character is present at the first and last position of the string
    "abcda"
2. Test a string in which duplicate character is present consecutively
   "aaabcd"
3. Test a string in which duplicate character is scattered all over the string
    "abcadeafa";
4. Test a string in which multiple different duplicate characters are present
    "abbacabac"
5. Test a string in which all the duplicates are of same characters
    "aaaaa"
6. Test a string which contains alphanumeric characters
    "a12a12"
7. Test a string which contains lower and upper case characters
    "aAbBcCD"
8. Test a string which contains space characters
    "ab  acab ac"
9. Test for empty string or null string object
10.Test a string which contains only one character


 */

    public void findDuplicateCharacterCount(String inputString) {

        if (inputString.isEmpty() || inputString == null) {
            System.err.println("String doesn't contain characters");
            return;
        }

        //Converting lower case to handle String with character upper and lower case Ex: aAAbBcd
        inputString = inputString.toLowerCase();
        char characterFromString;
        int stringLengthBeforeReplacementOfCharacter;
        int countOfEachCharacter;

        //Until String is empty check for duplicate characters
        while (inputString.length() > 0) {

            //Store string length in the current iteration
            stringLengthBeforeReplacementOfCharacter = inputString.length();

            //Take first character from string
            characterFromString = inputString.charAt(0);

            //Replace first character with empty string for all occurrences in string. Indirectly we are deleting all occurrences of character
            inputString = inputString.replaceAll(String.valueOf(characterFromString), "");

            //Now we can get the duplicate count of first character by   (stringLengthBeforeReplacementOfCharacter -stringLengthAfterReplacement)
            countOfEachCharacter = stringLengthBeforeReplacementOfCharacter - (inputString.length());

            //Print only duplicate characters details
            if (countOfEachCharacter > 1) {
                System.out.println("Character:" + characterFromString + " Count:" + countOfEachCharacter);
            }

        }
    }

    public static void findCountOfDuplicates(String inputString) {

        inputString = inputString.toLowerCase();


        HashMap<Character, Integer> characterAndCountInHashmap = new HashMap<>();

        for (char character : inputString.toCharArray()) {

            if (characterAndCountInHashmap.containsKey(character)) {
                characterAndCountInHashmap.put(character, characterAndCountInHashmap.get(character) + 1);
            } else {
                characterAndCountInHashmap.put(character, 1);
            }
        }

        characterAndCountInHashmap.forEach((k, v) -> System.out.println("Character:" + k + " Count:" + v));

    }

    public static void main(String[] args) {
        // findCountOfDuplicates("a");
        //  System.out.println("Method 2...........................\n");
        /*
        **
         ++


         */
        new PrintCountOfDuplicateCharacters().findDuplicateCharacterCount("a");
    }
}
