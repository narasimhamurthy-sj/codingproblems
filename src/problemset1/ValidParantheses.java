package problemset1;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidParantheses {
/*
is string just contain only bracket characters? or along with text?
Does this contain complex structure like below?
{[({()})]}


Input1: (){}[]
input 2: ((()))
input 3: missed cloesd bracket
{[({()})]

input 4:invalid bracket
  ((())}

input 5:invalid bracket
    ({[]}){
input 6:invalid bracket (so many closed but corresponding open doesn't exists)
    ({[]})}])

input 7: multi set open and close(Invalid case)
[{()}][{()}

input 8: other than brackets
 ({})abc

input 9: All with open brackets
{{{{{

input 10: All with closed brackets
]]]]]

input 11: Not in the correct order
({[])}

Steps:
store closed brackets in map
Read each char in str using loop
  if read char is open bracket
    add in arraylist
  if read char is closed bracket
    get corresponding open bracket from map
    if openbracketFromMap is equal to last char in Arraylist
    open and close brackets matching
    Remove open bracket from Arraylist
    else
    bracket missmatch
    break the loop



 */


    public static boolean isParanthesisValid(String inputString) {
        boolean isValid = true;

        HashMap<Character, Character> closedBrackets = new HashMap<>();
        ArrayList<Character> openBrackets = new ArrayList<>();
        ArrayList<Character> storeBrockets = new ArrayList<>();

        //Store closed brackets
        closedBrackets.put(')', '(');
        closedBrackets.put('}', '{');
        closedBrackets.put(']', '[');


        openBrackets.add('(');
        openBrackets.add('{');
        openBrackets.add('[');

        for (Character character : inputString.toCharArray()) {

            if (openBrackets.contains(character)) {
                storeBrockets.add(character);
            } else if (closedBrackets.containsKey(character)) {

                if (storeBrockets.isEmpty()) {
                    System.out.println("For closed brackets, corresponding open brackets are not available ");
                    return false;
                }
                if (closedBrackets.get(character) == storeBrockets.getLast()) {
                    System.out.println("Character " + storeBrockets.getLast() + " has closing and opening brackets");
                    storeBrockets.remove(storeBrockets.size() - 1);
                } else {

                    isValid = false;
                    System.out.println("Miss-match brackets found\n closed bracket" + character + " open bracket:" + storeBrockets.getLast());
                    break;

                }

            } else {
                System.out.println("Invalid character found:" + character);
                return false;


            }


        }

        System.out.println("Stored bracket size:" + storeBrockets.size());

        if (storeBrockets.size() > 0 && isValid) {
            System.out.println("Stored bracket has still open bracket and corresponding closed bracket not exists in string");
            isValid = false;
        }

        return isValid;
    }


    public static void main(String[] args) {
        System.out.println(isParanthesisValid("({[])}"));
    }
}
