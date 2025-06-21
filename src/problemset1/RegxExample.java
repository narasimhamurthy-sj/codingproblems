package problemset1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxExample {

    public static void main(String[] args) {
        String text = "abc abc abcd cde";
        String regXToMatchWord = "\\babc\\b";
        String regX = "abc";


        Pattern patternObject = Pattern.compile(regX);

        Matcher matcherObject = patternObject.matcher(text);

        while (matcherObject.find()) {

            System.out.println(matcherObject.group());
        }


    }
}
