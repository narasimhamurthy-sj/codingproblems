package problemset1;

public class FindShortestAndLongestWordInString {
/*
1.  string with single word
2. Empty string
3. String having multiple space characters for each word
4. shortest and longest words at end of string
5. shortest and longest words at mid of string
6. shortest and longest words at start of string
7. shortest and longest words at scattered of string
8. String with leading and trailing spaces
9.String having apostrophe
10.  string having brackets and parenthesis
11. String with punctuation marks
12. Longest and shortest words with same duplicate or same length of different words
 */


    public static String[] findLongestAndShortestWord(String inputString) {


        if (inputString.isEmpty() || inputString == null) {
            System.err.println("String doesn't have data");
            return new String[]{};
        }
        inputString = inputString.trim();

        inputString = inputString.replaceAll("[-\\.!\\?\\(\\)_\\*,'\\+]+", "");
        String[] wordsArray = inputString.split("\s+");

        String shortestWord = wordsArray[0];
        String longestWord = wordsArray[0];
        int minLength = wordsArray[0].length();
        int maxLength = wordsArray[0].length();

        if (wordsArray.length == 1) {
            System.out.println("String has single word");
            return new String[]{inputString};
        }

        for (int indexOfwordsArray = 1; indexOfwordsArray < wordsArray.length; indexOfwordsArray++) {

            if (wordsArray[indexOfwordsArray].length() < minLength) {
                minLength = wordsArray[indexOfwordsArray].length();
                shortestWord = wordsArray[indexOfwordsArray];
            }

            if (wordsArray[indexOfwordsArray].length() > maxLength) {
                maxLength = wordsArray[indexOfwordsArray].length();
                longestWord = wordsArray[indexOfwordsArray];
            }
        }

        System.out.println("Shortest word:" + shortestWord + "\nLongest word:" + longestWord);
        return new String[]{shortestWord, longestWord};
    }


    public static void main(String[] args) {
        findLongestAndShortestWord("abc abcd abcde (abcd'ef-).!(*+),_");
    }
}
