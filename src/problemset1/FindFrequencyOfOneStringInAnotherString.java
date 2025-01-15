package problemset1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
String str1="abc";
String str2="abc abcd ab abc";
 */
public class FindFrequencyOfOneStringInAnotherString {


    public static int findFrequency(String string1, String string2) {
        /*
String str1="abc";
String str2="abc abcd ab abc";
o/p: abc abc abc    and count:3
Includes char matchig in other words as well


1.  search string is present at beginning and last
2.  Serach string is scattered over all over the string
3.  Search string is associated with other words
    Ex: search str=abc, mainString="abc abcd abcdef"
4.  Search string having single char
5.  Search string having multiple words
6.  Search string having empty string
7.  Main string is empty or null
8.  Search string having alphanumeric string
 */
        Matcher match = Pattern.compile(string1).matcher(string2);
        int count = 0;
        while (match.find()) {
            System.out.println(match.group());
            count++;
        }
        System.out.println("count:" + count);
        return count;

    }


    public static int findFrequencyByExactWords(String string1, String string2) {
/*
String str1="abc";
String str2="abc abcd ab abc";
o/p: abc abc  and count:2
 */
        String regX = "\\b" + string1 + "\\b";
        Matcher match = Pattern.compile(regX).matcher(string2);
        int count = 0;
        while (match.find()) {
            System.out.println(match.group());
            count++;
        }
        System.out.println("count:" + count);
        return count;

    }

    public static int usingIndexOfMethod(String inputString, String targetString) {
        int count = 0;
        int beginIndex = 0;


        while (beginIndex != -1) {

            beginIndex = inputString.indexOf(targetString, beginIndex);
            System.out.println("beginIndex before match:" + beginIndex);
            if (beginIndex != -1) {

                //target string found
                count++;
                beginIndex += targetString.length();
                System.out.println("beginIndex after match:" + beginIndex);
            }
        }
        System.out.println("Frequency:" + count);
        return count;
    }


    public static void main(String[] args) {

       // findFrequencyByExactWords("abcx", "abc abcd ab abc");

        usingIndexOfMethod("abc abcd ab abc","abc");
    }
}
