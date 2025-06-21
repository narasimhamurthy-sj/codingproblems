package problemset1;

public class ReverseWordsInString {
/*

Trail the string
split by space
Iterate array in reverse order
    if array element not empty
    Add to the reversedString

    if arrayIndex!=0
    Add space to the string
input 1: String with single space
inout 2: String with 3 spaces in each word
input 3:trailing spaces
4:with zero space or one word
5.empty string
6. Mixed single space and multiple spaces among different words



 */

    public static String reverseWords(String inputString) {

        if (inputString.isEmpty()) {

            System.out.println("Empty string");
            return "";
        }
        String reversedWords = "";
        inputString = inputString.trim();
        String[] wordsStoredInArray = inputString.split(" ");

        for (int i = wordsStoredInArray.length - 1; i >= 0; i--) {

            if (!wordsStoredInArray[i].isEmpty()) {
                reversedWords += wordsStoredInArray[i];

                if (i != 0) {
                    reversedWords += " ";
                }
            }
        }


        System.out.println("string length:" + reversedWords.length());
        return reversedWords;
    }

    public static String simpleApproach(String inputString) {

        String[] wordsArray = inputString.trim().split("\\s+");
        String reversedWord = "";
        for (int indexOfWordsArray = wordsArray.length - 1; indexOfWordsArray >= 0; indexOfWordsArray--) {

            reversedWord += wordsArray[indexOfWordsArray];

            if (indexOfWordsArray > 0) {
                reversedWord += " ";
            }
        }
        return reversedWord;
    }

    public static void main(String[] args) {
        System.out.println(simpleApproach("word a   b   c     d   "));


    }
}
