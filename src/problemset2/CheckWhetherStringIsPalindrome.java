package problemset2;


/*
1.  aaa1aaa
2.special char
3. aabbccdccbbaa
4.12321
5. 2 char
6. 1 char
7. empty char
8.alphanumeric
9. char with empty space
10. String with trailing spaces

 */

public class CheckWhetherStringIsPalindrome {


    public static boolean isStringPalindrome(String inputString) {

        String stringBeforeMidElement;
        String stringAfterMidElement;
        boolean isPalindrome = false;
        int midIndexOfString;
        if (inputString.isEmpty() || inputString == null) {
            System.err.println("String doesn't have characters");
            return false;
        }
        inputString = inputString.trim();
        if (inputString.length() == 1) {
            System.out.println("Single character");
            return true;
        }


        midIndexOfString = (inputString.length() - 1) / 2;
        stringAfterMidElement = inputString.substring(midIndexOfString + 1);
        if ((inputString.length() % 2) != 0) {
            stringBeforeMidElement = inputString.substring(0, midIndexOfString);
            System.out.println("stringBeforeMidElement:" + stringBeforeMidElement);
        } else {
            stringBeforeMidElement = inputString.substring(0, midIndexOfString + 1);
            System.out.println("stringBeforeMidElement:" + stringBeforeMidElement);
        }

        if (stringBeforeMidElement.equalsIgnoreCase(stringAfterMidElement)) {
            System.out.println("Calling without reverse func");
            isPalindrome = true;
        } else {
            System.out.println("String before reverse:" + stringAfterMidElement);

            return stringBeforeMidElement.equalsIgnoreCase(ReverseAString.reverseString(stringAfterMidElement));
        }
        return isPalindrome;

    }


    public static void main(String[] args) {

        System.out.println(isStringPalindrome("12321"));
    }
}
