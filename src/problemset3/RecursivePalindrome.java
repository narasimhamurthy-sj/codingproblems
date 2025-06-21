package problemset3;

import java.util.Arrays;

public class RecursivePalindrome {
    /*
    str1="abc"
    o/p:cba

    -write a recursive method which returns reversed string
     param: str and length
        until string length is o, call recursively
        if length==0
         return str.charAt(length)

         String reversedStr=str.charAt(length)+revevrse(str, length-1)

         return reversedStr;
     */


    public static void main(String[] args) {
        //  String baseString="abc";
        //    String baseString="abcD";
        String[] inputStrings = new String[]{"ab", "a", "abcBA.", "abcBA", "", "123  321", "123321", "a#$ad12", "aaaa", "a2bc1", "abc", "abcD"};
        //String  reversedString="";

        Arrays.stream(inputStrings).forEach(inputStr -> {

            if (inputStr.isEmpty()) {
                System.out.println("Input String is empty");
            } else {
                String reversedString = new RecursivePalindrome().reverseString(inputStr, inputStr.length() - 1);
                // System.out.println(reversedString) ;
                if (inputStr.equalsIgnoreCase(reversedString)) {
                    System.out.println("Given String:" + inputStr + " is palindrome");
                } else {
                    System.out.println("Given String:" + inputStr + " is not palindrome. Reversed Str is:" + reversedString);
                }
            }
        });
        //  System.out.println( new RecursivePalindrome().reverseString(baseString,baseString.length()-1));
    }

    public String reverseString(String inputString, int lengthOfStringInIndex) {

        if (lengthOfStringInIndex == 0) {
            return String.valueOf(inputString.charAt(lengthOfStringInIndex));
        }

        return inputString.charAt(lengthOfStringInIndex) + reverseString(inputString, lengthOfStringInIndex - 1);

        //return reversedStr;
    }


}
