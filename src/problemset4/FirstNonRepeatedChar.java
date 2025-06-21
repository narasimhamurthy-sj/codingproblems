package problemset4;


/*

str1="aabcc"; o/p:b
str2="aabc"; o/p:b
str3="abc"; o/p:a
str4="ababc"; o/p:c

Steps:
take first char and form substring excluding first char
Check substring contains first char
if doesn't contain, it's first non repeated char. stop iterations
Repeat same steps until end of str if not found with non repeated char
 */
public class FirstNonRepeatedChar {
    char charFromStr = 0;
    String subStr = "";

    public static void main(String[] args) {
        FirstNonRepeatedChar objFirstNonRepeatedChar = new FirstNonRepeatedChar();
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("aaaaaa"));
        //mid pos
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("abc@qwerabc"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("0aaaaaaa"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("aa1"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("abc"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("abcabcabcabc"));
        //lower and upper case
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("abcabcabcabcA"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("1abcabcabcabc1"));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("aaabbbcccddd."));
        System.out.println("FirstNonRepeatedChar: " + objFirstNonRepeatedChar.findFirstNonRepeatedChar("123451234"));
    }

    public char findFirstNonRepeatedChar(String str) {
        while (!str.isEmpty()) {
            charFromStr = str.charAt(0);
            if (str.length() == 1) {
                return charFromStr;

            } else {
                //form substring excluding first char
                subStr = str.substring(1);
            }
            if (subStr.contains(String.valueOf(charFromStr))) {
                // remove char from str which is already checked
                str = str.replace(String.valueOf(charFromStr), "");
            } else {
                return charFromStr;
            }
        }
        return 0;
    }

}
