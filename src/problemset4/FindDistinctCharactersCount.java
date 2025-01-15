package problemset4;

import java.util.HashMap;

/*

String input="abcd"
String input="aaaa"
String input="abcac"


 */
public class FindDistinctCharactersCount {

    public static void main(String[] args) {
        FindDistinctCharactersCount charCount=new FindDistinctCharactersCount();
     /*  System.out.println( charCount.printDistinctCharCount("abcd"));
        System.out.println( charCount.printDistinctCharCount("abcdabcd"));
        System.out.println( charCount.printDistinctCharCount("aaaa"));
        System.out.println( charCount.printDistinctCharCount("abacd"));
        System.out.println( charCount.printDistinctCharCount("abcda"));
        System.out.println( charCount.printDistinctCharCount(""));
        System.out.println( charCount.printDistinctCharCount("aabbccdd"));
        System.out.println( charCount.printDistinctCharCount("1234"));
        System.out.println( charCount.printDistinctCharCount("a1bb2ccc3dddd4"));*/
      //  System.out.println( charCount.printDistinctCharCount("!"));
        //@@#$%^&*()
        /*HashMap<Character,Integer> charCountMap=charCount.printDistinctCharCount("!");
        charCountMap.forEach((k,v)->System.out.println("key:"+k+" val:"+v));*/

        System.out.println( charCount.printDistinctCharCount("\"a-+_{}[]<>|`  ?,'b cd./"));

    }
    public HashMap<Character,Integer> printDistinctCharCount(String inputStr){
        if(inputStr.length()<=0){
            System.out.println("String is empty");
            return null;
        }
        char charFromStr;
        int strLengthBeforeReplaceOfChar,strLengthAfterReplaceOfChar,charCount;
        HashMap<Character,Integer> characterCountMap=new HashMap<>();
        while(inputStr.length()>0){
            charFromStr=inputStr.charAt(0);
            strLengthBeforeReplaceOfChar=inputStr.length();
           // System.out.println("String value:"+String.valueOf(charFromStr));
           inputStr= inputStr.replace(String.valueOf(charFromStr),"");
          // System.out.println("String after replacement:"+inputStr);
            strLengthAfterReplaceOfChar=inputStr.length();
            charCount=strLengthBeforeReplaceOfChar-strLengthAfterReplaceOfChar;
            characterCountMap.put(charFromStr,charCount);
        }

        return characterCountMap;
    }

}
