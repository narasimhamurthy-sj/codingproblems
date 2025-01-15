package problemset4;

import java.util.regex.Pattern;

public class CheckVowelInStr {

    public boolean isVowelPresent(String inputStr){
        if(inputStr==null || inputStr.isEmpty()){
            System.out.println("String is empty or null");
            return false;
        }

        String regEx="(?i)[aeiou]";
        if(Pattern.compile(regEx).matcher(inputStr).find()){
            System.out.println("Vowel present");
            return true;
        }else{
            System.out.println("Vowel not present");
            return false;
        }

    }


    public static void main(String[] args) {
        CheckVowelInStr vowel=new CheckVowelInStr();
        vowel.isVowelPresent("123,./;' nmbc  jhge");
    }
}
