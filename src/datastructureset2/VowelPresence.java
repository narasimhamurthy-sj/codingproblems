package datastructureset2;

import java.util.regex.Pattern;

public class VowelPresence {


    public static boolean isVowelPresentViaRegx(String str) {

        boolean containsVowel = false;

        try {

            if (Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE).matcher(str).find()) {
                System.out.println("Match found");
                containsVowel = true;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return containsVowel;
    }


    public static boolean isVowelPresent(String str) {

        boolean containsVowel = false;

        String[] strArr = {"a", "e", "i", "o", "u"};

        try {

            // via Enum
            Vowels[] vowelsArrayy = Vowels.values();

            for (Vowels v : vowelsArrayy) {

                if (str.toLowerCase().contains(v.toString())) {

                    System.out.println(v);
                    containsVowel = true;
                    break;

                }
            }
            //Via String arr. Either via enum or String arr can be executed
            for (String arr : strArr) {

                if (str.toLowerCase().contains(arr)) {

                    System.out.println(arr);
                    containsVowel = true;
                    break;

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return containsVowel;
    }
    //    static boolean containsVowel=false;

    public static void main(String[] args) {

        //  System.out.println("Is vowel present: " +isVowelPresent("A"));

        System.out.println("Is vowel present: " + isVowelPresentViaRegx("132aaeeiioouu"));
    }

    /*
    input :123ppze



     */
    public enum Vowels {a, e, i, o, u}
}
