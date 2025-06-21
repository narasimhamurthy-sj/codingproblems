package repeatpractice;

/*

Generate all permutations of a string (e.g., "abc" → `["abc", "acb", "bac", ...]`)

Recursive approach:
Ex: abc
from abc, we can get permutations
abc,
bac,
cab
to generate this, take each char and loop until last char
      1. in case of abc, first char is "a" and remaining chars are bc.
        firstChar=str.charAt(i)
        to find remaining chars,use substring
        remainingStr=substring(0,i)+subString(i+)   //substring(0,1)+subString(2)=""+bc=bc

      2.  Similarly bac, first char is "b" and remaining chars are ac.

     But from abc or bac etc.. we can find further permutations.
     a -bc -> abc,acb
     b -ac-> bac,bca
     c -ab->  cab,cba
     Hence we have to call function  recursively

     permuatations(remainingStr,""+firstChar)

     Here second argument keeps on adding chars which eventually forms string permutations.

     For breaking out recursion call, if substring length reaches 0, return








 */
public class PermutationString {
    // Recursive method to generate permutations
    public static void permute(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            //char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            //  System.out.println(ch+remaining);
            permute(remaining, prefix + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations of " + input + ":");
        permute(input, "");
    }
}
