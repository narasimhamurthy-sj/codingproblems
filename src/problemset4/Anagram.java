package problemset4;

import java.util.regex.Pattern;

/*
Two strings are said to be anagram if they contain same set of characters but in different order.
For example, “Mother In Law” and “Hitler Woman” are anagrams.

str1="aaab"  str2="abaa"


 */

public class Anagram {

    public static void main(String[] args) {
        Anagram findAnagram = new Anagram();
  /*     System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("Mother In Law","Hitler Woman"));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("aaaa","a a a a"));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("1234","4321"));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("c1,2!34","4,!321c"));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("aaaa","aaaa         "));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("Big sentence format","sentence format Big"));

        System.out.println( "areGivenStringAnagram :"+findAnagram.areGivenStringAnagram("",""));*/

        System.out.println("areGivenStringAnagram :" + findAnagram.areGivenStringAnagram("c.1/2*", "/*12.c"));
    }

    public boolean areGivenStringAnagram(String str1, String str2) {

        str1 = str1.replaceAll("\s", "").toLowerCase();

        str2 = str2.replaceAll("\s", "").toLowerCase();
        /*System.out.println("str1:"+str1);
        System.out.println("str2:"+str2);
        */
        boolean isAnagram = false;
        if (str1.isEmpty() || str2.isEmpty()) {
            System.out.println("One of the or both Given Strings are empty");
            return isAnagram;
        }
        if (str1.length() != str2.length()) {
            System.out.println("Not Anagram. Given String lengths are different");
            return isAnagram;
        }
        int index = 0;
        while (str2.length() > 0) {
            if (str2.contains(String.valueOf(str1.charAt(index)))) {
                isAnagram = true;
                if (str1.charAt(index) == '/' || str1.charAt(index) == '.' || str1.charAt(index) == '*') {

                    Pattern specialChar = Pattern.compile(Pattern.quote(String.valueOf(str1.charAt(index))));

                    if (specialChar.matcher(str2).find()) {
                        System.out.println("String before replace " + str2);
                        str2 = specialChar.matcher(str2).replaceFirst("");
                        System.out.println("String after replace " + str2);

                    }

                } else {
                    str2 = str2.replaceFirst(String.valueOf(str1.charAt(index)), "");
                }
                //  System.out.println("After replace:"+str2);
            } else {
                isAnagram = false;
                break;
            }
            index++;
        }//end of while
        return isAnagram;
    }
}
