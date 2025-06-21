package problemset5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Two strings are anagrams if they contain the same characters with the same frequency, but possibly in a different order.

✔️ Examples:

"eat" → "tea" → "ate" → ✅ all anagrams

"tan" vs "nat" → ✅ anagrams

"bat" → ❌ no other matching anagram

Input: ["eat", "tea", "tan", "ate", "nat", "bat"]

A list of groups, where each group contains strings that are anagrams.

✅ Output:
[
  ["eat", "tea", "ate"],
  ["tan", "nat"],
  ["bat"]
]
 */
public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram anagramObj = new GroupAnagram();
        ArrayList<String> inputList = new ArrayList<>();
        //"eat", "tea", "tan", "ate", "nat", "bat"
        //"eat","nat", "bat"
        // "eat","nat", "bat","eat"
        //"eat","eat","eat"
        //"eat","nat","eat", "tea", "tan", "ate", "nat", "bat", "bat","eat"
        //"eatnat", "tan", "bc","teatan", "tan", "ate", "nat", "atebat", "bat","abcd","bcda","cdab","dabc"
        List<String> list = new ArrayList<>(List.of("eat", "tea", "tan", "ate", "nat", "bat"));

        System.out.println(anagramObj.improvedSoln(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> improvedSoln(String[] strArr) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        String sortedStr = null;
        //Store each str in map by sorting char, if repeated str encounted add as value from str array
        for (String str : strArr) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            sortedStr = new String(charArr);

            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        //retrieve only values as it has anagram group
        return new ArrayList<>(anagramMap.values());
    }

    public List<ArrayList<String>> findAnagramGroups(List<String> inputAnagramList) {
        String strFromList = "", nextStrFromList = "";
        int k;
        boolean isStrMatching = false;
        List<ArrayList<String>> anagramGroup = new ArrayList<>();
        String sortedStr = "", mainSortedStr = "";
        while (!inputAnagramList.isEmpty()) {
            //Take first string
            strFromList = inputAnagramList.getFirst();
            //conver to char arr and sort
            char[] charMainArr = strFromList.toCharArray();
            Arrays.sort(charMainArr);
            mainSortedStr = new String(charMainArr);

            ArrayList<String> anagramList = new ArrayList<>();
            //Take next str, start checking whether anagram
            if (inputAnagramList.size() > 1) {
                for (int j = 1; j < inputAnagramList.size(); j++) {

                    //Start from next str
                    nextStrFromList = inputAnagramList.get(j);
                    if (strFromList.length() == nextStrFromList.length()) {
                   /* k = 0;

                    while (k < strFromList.length()) {
                        if (nextStrFromList.contains(String.valueOf(strFromList.charAt(k)))) {
                            isStrMatching = true;
                        } else {
                            isStrMatching = false;
                            break;
                        }
                        k++;
                    }*/
                        //sort and check whether anagram
                        char[] chArr = nextStrFromList.toCharArray();
                        Arrays.sort(chArr);
                        sortedStr = new String(chArr);
                        isStrMatching = mainSortedStr.equalsIgnoreCase(sortedStr);


                    } else {
                        isStrMatching = false;
                    }
                    if (isStrMatching) {

                        //group by same anagram
                        anagramList.add(nextStrFromList);
                        //As we are removing str,to maintain correct index,decrement jth index
                        j--;

                        inputAnagramList.remove(nextStrFromList);
                    }

                }//end of jth loop
            }//end of if

//add main str to same anagram list and remove it from input list
            anagramList.add(strFromList);
            inputAnagramList.remove(strFromList);
            //Form final anagram list in anagram group
            anagramGroup.add(anagramList);
        }//end of outer loop
        return anagramGroup;
    }
}
