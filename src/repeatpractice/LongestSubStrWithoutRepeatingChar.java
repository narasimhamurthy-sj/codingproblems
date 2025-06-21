package repeatpractice;

import java.util.HashSet;

/*
Find the length of the longest substring with unique characters (e.g., "abcabcbb" → 3).
Steps:
read string char by char
store in hashSet to identify duplicate char while reading
form a string if char is unique

if duplicate char encountered,
add formed unique substr in set
initialize unique substr with current iteration char


 */
public class LongestSubStrWithoutRepeatingChar {


    public static void main(String[] args) {
        LongestSubStrWithoutRepeatingChar objLongstSubStr = new LongestSubStrWithoutRepeatingChar();
        objLongstSubStr.findLongestSubStr("abcabcbb");
        objLongstSubStr.findLongestSubStr("aaaa");
        objLongstSubStr.findLongestSubStr("aaaaq");
        objLongstSubStr.findLongestSubStr("abcabcd");
        objLongstSubStr.findLongestSubStr("abcd");
        objLongstSubStr.findLongestSubStr("ab ab");
        objLongstSubStr.findLongestSubStr("abcde abc");
        objLongstSubStr.findLongestSubStr("abcdeabcxyz1234abcde");
        objLongstSubStr.findLongestSubStr("abcdeabcxyz1234abcde");
        //all unique chars
        objLongstSubStr.findLongestSubStr("abcxyz123qwe");
        objLongstSubStr.findLongestSubStr("12345612309876123098");
        objLongstSubStr.findLongestSubStr("abccbaaxdssdxa");

    }

    public String findLongestSubStr(String str) {

        String currentSubStr = "";
        HashSet<Character> eliminateDuplicateCharSet = new HashSet<>();
        String previousSubStr = "", longestSubStr = "";

        if (str == null || str.isEmpty()) {
            System.out.println("Empty string");
            return str;
        }
        int index = 0;
        while (index < str.length()) {
            char charFromStr = str.charAt(index);

            if (eliminateDuplicateCharSet.add(charFromStr)) {
                currentSubStr += charFromStr;
                //This is a case where longest subStr appears at the end of string
                //or entire string is unique
                if (index == str.length() - 1) {

                    if (previousSubStr.length() < currentSubStr.length()) {
                        longestSubStr = currentSubStr;
                    }
                }
            } else {

                if (previousSubStr.length() < currentSubStr.length()) {
                    previousSubStr = currentSubStr;
                    longestSubStr = currentSubStr;
                }
                currentSubStr = "";
                eliminateDuplicateCharSet.clear();
                eliminateDuplicateCharSet.add(charFromStr);
                currentSubStr += charFromStr;
            }
            index++;
        }
        System.out.println("longestSubStr:" + longestSubStr + " and length:" + longestSubStr.length());
        return longestSubStr;
    }
}
