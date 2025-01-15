package problemset3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Str="Animal"

str2=iaanlm

1. str1 and str2 having same char but varies in whitespace or string1 and string2 doesn't having same number of words
2. In s1,s2, different chars having upper and lower case
3. s1,s2 having different length
4.String having comma,full stop,special char(check these need to be considered as part of anagram
 or only letters need to be considered
5.Empty string or null
6.alphanumeric
7. only numbers
8. String having same char duplicate chars
9. String having multiple duplicate chars
10.String having trailing spaces

 */
public class CheckWhetherAnagram {

    public static String matchPattern(String str){
        String matchedString="";
        Matcher match= Pattern.compile("[a-zA-Z0-9]+").matcher(str);
        while(match.find()){
            matchedString+=match.group();
        }
        return matchedString;
    }


    public static boolean isGivenStringAnagram(String inputString1,String inputString2){

        inputString1= matchPattern(inputString1).toLowerCase();
        inputString2= matchPattern(inputString2).toLowerCase();

        if(inputString1.length()!=inputString2.length()){
            System.out.println("Not anagram");
            return false;
        }
        boolean isAnagram=true;


        for (char characterFromString1: inputString1.toCharArray()){

            if(inputString2.contains(String.valueOf(characterFromString1))){

                inputString2=inputString2.replaceFirst(String.valueOf(characterFromString1),"");
            }else{
                isAnagram=false;
                break;
            }
        }
        return isAnagram;

    }


    public static void main(String[] args) {

        System.out.println(isGivenStringAnagram(" bbaaaa "," aa bb aa "));

    }
}
