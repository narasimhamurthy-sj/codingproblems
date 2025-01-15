package problemset3;

import java.util.ArrayList;

/*
String str="abcd"                                charArrayLoop
1. abcd     7.bacd      13.cabd     19.dabc      Take string str -abcd
2.abdc      8.badc      14.cadb     20.dacb      Store first level combination in list1
3.acbd      9.bcda      15.cbda     21.dbca      loop till length of arraylist
                                                 Take first string from list
4. acdb    10.bcad      16.cbad     22.dbac      Form substring from 2nd char onwards
5.adbc      11.bdac     17.cdab     23.dcab       If substring length>2, form first level combination in substringlist
6. adcb     12.bdca     18.cdba     24.dcba      loop till length of sub string arraylist
                                                Take first substring from substring list

// 3 chars          1.keep first char as it is
                      store in str1+=firstChar
abc     abc         2.Take sub-string after first char
bca     acb         3.check substring length >2
                      store it on list2
cab     bca            If so, repeat step 1,2
acd     bac         4. check substrngLength==2
cba                   print takecharfrom str1 + substring
                      print takecharfrom str1 + swapped substring
bac

abcde
a, bcde         bcd,cbd,dbc
b,cde
abc,de
abcd
abdc
                abcde,bcdea,cdeab               abcd
bcd,bdc         bcde,cdeb,debc,ebcd             a,bcd           bcd,cbd,dbc
                cde dec ecd
                de



                deb ebd bde

cdb,cbd
dbc,dcb


 */
public class PermutationOfAString {

    static ArrayList<String> finalStringList = new ArrayList<>();
    public static String excludedCharFromSubStr = "";

    //abcd
    //bcda, acdb,abdc,abcd
//    abcd     7.bacd      13.cabd     19.dabc
    public static ArrayList<String> constructPermutations(ArrayList<String> list, String str) {

        String permutationString = "";

        char[] strCharArray = str.toCharArray();
        ArrayList<Character> charArrayList = new ArrayList<>();
        char characterToBePlacedatTheEnd;
        char ch;
        int count = 0;



        list.add(str);
        for (int i = 1; i < strCharArray.length; i++) {

            characterToBePlacedatTheEnd = strCharArray[i];
            count = i;
            permutationString = String.valueOf(strCharArray[i]);

            for (int j = 0; j < strCharArray.length; j++) {

                if (count == j) {
                    continue;
                } else {
                    permutationString += strCharArray[j];
                }
            }
            list.add(permutationString);

        }
        // System.out.println(list);

        return list;
    }

/*
abcde,bcdea,cdeab
bcd,bdc         abcde
               a, bcde, cbde,dbce,ebcd
               ab, cde dec ecd

               ac,bde,dbe,ebd,
 */

    public static void subStringPermutation(String str) {
        ArrayList<String> subStrPermutationsInList = new ArrayList<>();
        String stringSentForsublevelPermutation = "";
        String swappedString;
        String lastStrFromList = "";
        String strToaddInList="";

        if (str.length() <= 2) {
            System.out.println("can't form sub string");
            return;
        }

        stringSentForsublevelPermutation=str.substring(1);
        subStrPermutationsInList = subLevelPermutation(subStrPermutationsInList, str);

            while (subStrPermutationsInList.size() != 0) {

                lastStrFromList = subStrPermutationsInList.getLast();
                if (lastStrFromList.length() <= 3) {

                    strToaddInList=excludedCharFromSubStr + lastStrFromList;
                    finalStringList.add(strToaddInList);
                    swappedString = swap(lastStrFromList.substring(1));
                    // System.out.print(excludedCharFromSubStr+strFromList.charAt(0)+swappedString+"  ");
                    strToaddInList=excludedCharFromSubStr +String.valueOf(lastStrFromList.charAt(0)) + swappedString;
                    finalStringList.add(strToaddInList);
                    //delete
                    subStrPermutationsInList.remove(subStrPermutationsInList.removeLast());

                }

               else if(lastStrFromList.length()>3){
                    subStrPermutationsInList.remove(stringSentForsublevelPermutation);
                    excludedCharFromSubStr= excludedCharFromSubStr.replace(String.valueOf(stringSentForsublevelPermutation.charAt(0)),"");
                    stringSentForsublevelPermutation=lastStrFromList;
                    excludedCharFromSubStr+=stringSentForsublevelPermutation.charAt(0);
                    subStrPermutationsInList = subLevelPermutation(subStrPermutationsInList, stringSentForsublevelPermutation);
                }


            }





    }





public static String swap(String str) {
    String swappedStr = "";
    String firstChar =String.valueOf( str.charAt(0));
    String secondChar =String.valueOf( str.charAt(1));
    swappedStr += secondChar + firstChar;
    return swappedStr;
}


public static void findPermutaions(String inputString) {

    ArrayList<String> stringPermutationsInList = new ArrayList<>();
    stringPermutationsInList = constructPermutations(stringPermutationsInList, inputString);
    stringPermutationsInList.forEach(str->subStringPermutation(str));
    //subStringPermutation("abcd");


}


    public static ArrayList<String> subLevelPermutation(ArrayList<String> list, String str){

        String subStr;
        excludedCharFromSubStr="";

        if(str.length()<=3){
            list.add(str);
        }else {
            for (int i = 1; i < str.length() - 2; i++) {
                excludedCharFromSubStr += str.charAt(i - 1);
                subStr = str.substring(i);
                if (subStr.length() > 2) {
                    list = constructPermutations(list, subStr);
                }
            }
        }
            return list;
        }





public static void main(String[] args) {
    findPermutaions("abcde");

   System.out.println( finalStringList.size());
   finalStringList.forEach(el->System.out.print(el+"  "));


}




}
