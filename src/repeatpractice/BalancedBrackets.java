package repeatpractice;

import java.util.ArrayList;
import java.util.HashMap;

/*
Check if a string of brackets (`()`, `[]`, `{}`) is balanced (e.g., `"{[()]}"` → `true`)

str1={[()]}

Store open brackets as keys and respective closed brackets as value
Read string char by char
check given char belongs to open bracket
 store in list
else
 it should belong closed bracket.
 Take last elemnt from list, get corresponding closed bracket from map.
 Check whether this closed bracket is matching current char from str
    remove last char from list
 else
 return false. Exit as it doesn't have balanced brackets.


 */
public class BalancedBrackets {

    public static void main(String[] args) {
        BalancedBrackets bracketObject = new BalancedBrackets();
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[()]}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[()]}}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[("));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket(")]}}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[()]"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[()[]{}]}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[([()])]}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{(}[)]"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{[()]}"));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket(""));
        System.out.println("Result:" + bracketObject.doesGivenStringHasBalancedBracket("{"));

    }

    public boolean doesGivenStringHasBalancedBracket(String str) {

        if (str == null || str.isEmpty()) {
            System.out.println("String doesn't have char");
            return false;
        }
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('{', '}');
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');

        ArrayList<Character> openBracketList = new ArrayList<>();

        boolean isBalanced = false;

        char bracket;
        for (int i = 0; i < str.length(); i++) {
            bracket = str.charAt(i);

            if (bracketMap.containsKey(bracket)) {
                openBracketList.add(bracket);
            } else {
                if (openBracketList.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (bracketMap.get(openBracketList.getLast()) == bracket) {
                    openBracketList.removeLast();
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (!openBracketList.isEmpty()) {
            isBalanced = false;
        }
        return isBalanced;
    }

}
