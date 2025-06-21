package basic;

public class PrintCharCountInString {

/*

ddddaaabbcccaaadd --> d4a3b2c3a3d2


aabccc
a2b1c3

read char
   next is same
    cntchr
   else

    print- curchar and count

    index=5
 */


    public static void main(String[] args) {
        PrintCharCountInString countObject = new PrintCharCountInString();
        System.out.println(countObject.findCharCount("ddddaaabbcccaaadd"));
    }

    public String findCharCount(String inputStr) {

        char charFromStr = 0;
        int countOfChar = 1;
        String outPutStr = "";
        boolean isLatCharDuplicate = false;
        for (int i = 0; i < inputStr.length(); i++) {

            charFromStr = inputStr.charAt(i);

            if (i != inputStr.length() - 1) {
                if (charFromStr == inputStr.charAt(i + 1)) {
                    countOfChar++;

                    if (i == inputStr.length() - 2) {
                        isLatCharDuplicate = true;
                    }
                } else {
                    //   System.out.println(charFromStr + countOfChar);
                    outPutStr += charFromStr + "" + countOfChar;
                    countOfChar = 1;

                }
            }

        }
        if (isLatCharDuplicate) {
            outPutStr += charFromStr + "" + countOfChar;
        }


        return outPutStr;
    }

}
