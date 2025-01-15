package datastructureset2;

import java.util.ArrayList;
import java.util.HashMap;

public class EvaluateExpression {

    /*
    Input: exp = “[()]{}{[()()]()}”
Output: Balanced

Input: exp = “[(])”
Output: Not Balanced

Input {{[[(())]]}}
Output: Balanced


Assumptions:
In given str,only brackets are given and no other characters are given like letters,numbers and special char
matchingPairMap ('}','{')
Steps:
1.read each char till end of str

1. 1  if first char is one among right brackets } ] )
    print not balanced and exit

1.2  if last char is one among left brackets { [ (
    print not balanced and exit

1.3  if str length is one
    print not balanced and exit

1.3 if its one among left brackets i.e. { [ (  insert element in arraylist

    else
1.4    ExpectedLeftbracket=matchingPairMap.get(character)

1.4.1    ActualBracket=StoredArraylistBrackets.get(arraylist.size()-1)

1.4.2    if(ExpectedLeftbracket==ActualBracket)
1.4.2.1    IsbracketPairMatched=true
1.4.2.2    Remove element from StoredArraylistBrackets.get(arraylist.size()-1)
1.4.3     else
           IsbracketPairMatched=false
           exit


2.



     */


    public static void main(String[] args) {

        System.out.println("balanced: " + new EvaluateExpression().isBalanced("{[()]}"));
        System.out.println("balanced: " + new EvaluateExpression().isBalanced(")}}]]])"));
        System.out.println("balanced: " + new EvaluateExpression().isBalanced("({{[[((("));
        System.out.println("balanced: " + new EvaluateExpression().isBalanced("()]{}{[()()]()}"));


        Boolean balanced = new EvaluateExpression().isBalanced("[(])");
        System.out.println("balanced: " + new EvaluateExpression().isBalanced("[(])"));

        System.out.println("balanced: " + new EvaluateExpression().isBalanced("[()]{}{[()()]()}"));
        System.out.println("balanced: " + new EvaluateExpression().isBalanced("[()]{}{[()()]()}"));

        System.out.println("balanced: " + new EvaluateExpression().isBalanced("{{[[(())]]}}"));

        System.out.println("balanced: " + new EvaluateExpression().isBalanced("{{[[(())]]}"));
    }

    public boolean isBalanced(String str) {
        boolean isbracketPairMatched = false;
        char expectedLeftbracket = 0;
        HashMap matchingOppositeRightBracket = new HashMap<Character, Character>();

        matchingOppositeRightBracket.put('}', '{');
        matchingOppositeRightBracket.put(']', '[');
        matchingOppositeRightBracket.put(')', '(');

        ArrayList storeBracketsInArrayList = new ArrayList<Character>();
        String leftBrackets = "{[(";
        String rightBrackets = ")]}";
        char actualBracket = 0;
        char ch;


        if (str.isEmpty() || str.length() == 1) {
            isbracketPairMatched = false;
        } else if (rightBrackets.contains(String.valueOf(str.charAt(0)))) {
            isbracketPairMatched = false;

        } else if (leftBrackets.contains(String.valueOf(str.charAt(str.length() - 1)))) {
            isbracketPairMatched = false;

        } else {
            for (int i = 0; i < str.length(); i++) {

                ch = str.charAt(i);
                if (leftBrackets.contains(String.valueOf(ch))) {

                    storeBracketsInArrayList.add(ch);
                } else {


                    try {
                        expectedLeftbracket = (Character) matchingOppositeRightBracket.get(ch);
                    } catch (NullPointerException e) {
                        System.err.println("Entered string has other than bracket character");
                        e.printStackTrace();

                    }
                    if (storeBracketsInArrayList.size() > 0) {
                        actualBracket = (char) storeBracketsInArrayList.get(storeBracketsInArrayList.size() - 1);
                    } else {
                        isbracketPairMatched = false;
                        break;
                    }

                    if (expectedLeftbracket == actualBracket) {
                        isbracketPairMatched = true;

                        storeBracketsInArrayList.remove(storeBracketsInArrayList.size() - 1);

                    } else {
                        isbracketPairMatched = false;
                        break;
                    }
                }

            }//end of for loop
        }
        // System.out.println("Array size:"+storeBracketsInArrayList.size());
        if (storeBracketsInArrayList.size() > 0) {
            isbracketPairMatched = false;
        }
        return isbracketPairMatched;
    }

}
