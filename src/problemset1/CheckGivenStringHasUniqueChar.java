package problemset1;

import java.util.HashSet;

public class CheckGivenStringHasUniqueChar {
    /*
    input: alphabet
    o/p: not unique

    input: abc
    o/p:  unique


    Iterate by each char
    Take first char, check remaining sub str contains this char
    if conrains break loop


     */


    public static boolean isStringUnique(String givenString) {
        boolean isUnique = true;

        /*for (String ch:givenString){

        }*/

        givenString = givenString.toLowerCase();
        System.out.println("givenString" + givenString);
        char charByIndex = 0;
        String subString = "";
        for (int givenStringIndex = 0; givenStringIndex < givenString.length(); givenStringIndex++) {

            charByIndex = givenString.charAt(givenStringIndex);

            if (givenStringIndex != givenString.length() - 1) {
                subString = givenString.substring(givenStringIndex + 1);

                if (subString.contains(String.valueOf(charByIndex))) {
                    isUnique = false;
                }

            }


        }


        return isUnique;
    }


    public static boolean simpleApproach(String str) {

        str = str.toLowerCase();
        HashSet<Character> storeCharArr = new HashSet<>();
        for (char charAtEachIndex : str.toCharArray()) {

            if (!storeCharArr.add(charAtEachIndex)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // String res= isStringUnique("abcd")==true?"Unique":"Not Unique";
        /*abcd

        aaaa
        aabb ccaa

         */

        System.out.println(isStringUnique("abcdA") == true ? "Unique" : "Not Unique");
        System.out.println(simpleApproach("abcdA") == true ? "Unique" : "Not Unique");
    }


}
