package problemset3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
1. string with lower case abd check vowels and consonants
2. String with upper case
3. String with lower and upper case
4. aplphanumeric
5. only digits
6. special chars, dot
7. space char ,traiing spaces
8. quotes
9. empty string

 */


public class CountVowelsAndConsonants {


    public static String regXMatch(String regX, String baseString) {
        int count = 0;
        String matchedString = "";
        Matcher matchObject = Pattern.compile(regX).matcher(baseString);
        while (matchObject.find()) {
            // System.out.print("  "+matchObject.group());
            count++;
            matchedString += matchObject.group();
        }
        System.out.println("Count:" + count);
        System.out.println("matchedString:" + matchedString);
        return matchedString;

    }

    public static void findCountOfVowelsAndConsonants(String inputString) {

        if (inputString == null || inputString.isEmpty()) {
            return;
        }
        System.out.println("Input string:" + inputString);

        String regXForconsonants = "[a-zA-Z&&[^aeiouAEIOU]]";
        String regXForVowels = "[aeiouAEIOU]";
        System.out.println("consonants:");
        regXMatch(regXForconsonants, inputString);
        System.out.println("Vowels:");
        regXMatch(regXForVowels, inputString);

    }

    public static void main(String[] args) {

        findCountOfVowelsAndConsonants("aAb 9090 ?+-/\" BeEdD@!#$ ");
    }
}
