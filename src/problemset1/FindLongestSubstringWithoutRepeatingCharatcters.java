package problemset1;

import java.util.HashSet;

public class FindLongestSubstringWithoutRepeatingCharatcters {
    /*
    input:MyNameIsJack
    o/p:MyNameIsJ

    input:abbcabbcxyzabc
    o/p: bcxyza

    input:aaaaaa
    o/p:a

STEPS:
1.Convert given string to char array so that we can traverse each character to check sub-string
2.Use HashSet to identify repeating character. i.e., HashSet returns false while adding repeated character. Make use of this feature.
3.Iterate each char in given string using a LOOP
    3.1 Keep on adding characters in HashSet until it encounters repeated character.
        3.1.1 Store these chars in string to form a substring.
        3.1.2 Maintain a boolean variable to handle if string is completely unique and doesn't contain duplicate character
        3.1.3 SET duplicateCharacterFound to FALSE

    3.2 if HashSet returns false meaning that repeating char is found. Now we are ready with sub string which is formed in step 3.1.1
        3.2.1 SET duplicateCharacterFound to TRUE

        3.2.2 IF current substring length is smaller than newly formed substring
                3.2.2.1 Make MaxLengthSubstring as newly formed substring
                Note: Initially  SET current substring length to 0 (As any sub-string is not yet checked)

        3.2.3  Let's check for next substring as we have to check for the longest sub string.
                Clear HashSet
                HashSet returns false while forming next substring if it contains any
                repeating character of previously stored characters. Hence clear previously stored characters.

        3.2.4   SET substring value to  empty so that previously stored substring data will be cleared.
                SET substring value to previously encountered repeated character because next substring starts from previously encountered duplicate character.
                Ex:Given String is XYZXPQR
                First sub-string is XYZ
                Next sub-string will be XPQR
                Observe that XPQR started previously encountered repeated character "X" which is positioned in 4th place of given string

        3.2.5 As explained in 3.2.4, in HashSet as well, add previously encountered repeated character.

END OF LOOP

4.0  IF duplicateCharacterFound is FALSE i.e., given string or substring is unique( EX: ABCD)
     SET longestSubString as the string which is formed in step 3.1.1

END

     */


    public static String printLongestSubString(String inputString) {

        inputString=inputString.toLowerCase();
        HashSet<Character> storeInputStringInSet = new HashSet<>();
        String newSubString = "";
        int previousSubStringMaxLength = 0;
        String longestSubString = "";
        boolean isdupicateCharFound = false;

        if (inputString.isEmpty()) {
            System.out.println("Empty String");
            return "";
        }
        // Convert given string to char array. Iterate through each char using for loop
        for (char charAtEachIndex : inputString.toCharArray()) {
            // Add each char in hashSet until it encounters duplicate char. HashSet returns false if it finds duplicate element before adding it to the SET
            if (storeInputStringInSet.add(charAtEachIndex)) {
                // Keep on storing chars and form a sub string until it finds duplicate char in input string
                newSubString += charAtEachIndex;
                isdupicateCharFound = false;
            } else {
                //If HashSet returns false, that means duplicate char is found
                isdupicateCharFound = true;
                //If substring length is smaller than newly formed substring. Make the longest substring as new substring
                if (previousSubStringMaxLength < newSubString.length()) {
                    previousSubStringMaxLength = newSubString.length();
                    longestSubString = newSubString;
                }
                //Clear previously stored sub-string data and SET with previously encountered repeated character
                newSubString = "" + charAtEachIndex;
                //Similarly for HashSet as well clear the data
                storeInputStringInSet.clear();
                //add  previously encountered repeated character in HashSet as well
                storeInputStringInSet.add(charAtEachIndex);
            }
        }
        //If input string contains completely unique characters, then longest sub-string is input string itself
        if (!isdupicateCharFound) {
            longestSubString = newSubString;
        }
        System.out.println("Longest substring:" + longestSubString + " maxLength:" + longestSubString.length());
        return longestSubString;
    }


    public static void main(String[] args) {

        /*
    For all of the below scenarios our code should capable to find the longest substring:
        1. Test a String which contains single repeating character
           Ex: abca
        2. Test a String which contains multiple repeating characters
           Ex: abcabcdxyzxyza
        3. Test a String which contains all unique characters
           Ex: abcd
        4. Test a String in which longest Sub-string present at the end of string
           Ex: abcaxyz
        5. Test a String in which entire characters are duplicate
           Ex: aaaaaa
        6. Test a String in which duplicate characters are present in the combination of lower and upper case
           Ex: abcAbcde
        7. Test a String which contains alphanumeric
           Ex: abca1234
        8. Test a String which contains numbers
           Ex: 1231234
        9. Test a String which contains special characters
           Ex: abc@abc!@#4d
        10.Test a String which contains with space
           Ex: abca xyz
        11.Test a String which contains punctuation sign
           Ex: abca.:',

        1231234
        1234
        12abcd34
        12abcd3412abcd34
         */
        printLongestSubString("abca.:',");
    }
}
