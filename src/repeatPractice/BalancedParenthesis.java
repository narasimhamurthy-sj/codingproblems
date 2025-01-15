package repeatPractice;

import java.util.ArrayList;
import java.util.HashMap;

/*
input1: {[]}

wil store open and close brackets in openBracketStandardMap


read char by char
 check char is open bracket
  stor in list open bracket list
  else
  //encountered closed brackets
 if( Map.get(getLastElemetInOpenBracket)==char)
  remove last elementfrom  open bracket list
  else
  set bracketsBalanced=false
  break



 */
public class BalancedParenthesis {

    public static boolean isBalancedParanthesis(String brackets){

        boolean isBracketsBalanced=true;
        HashMap<Character,Character> standardBrackets=new HashMap<>();
        standardBrackets.put('[',']');
        standardBrackets.put('{','}');
        standardBrackets.put('(',')');

        ArrayList<Character> openBracketList=new ArrayList<>();
        for(char bracket:brackets.toCharArray()){
            if(standardBrackets.containsKey(bracket)){
                openBracketList.add(bracket);
            }else{

                if(standardBrackets.get(openBracketList.getLast())==bracket){
                    openBracketList.removeLast();
                }else{
                    isBracketsBalanced=false;
                    System.out.println("Mismatch with open bracket:"+openBracketList.getLast()+" Closed bracket:"+bracket);
                    break;
                }
            }
        }

        return isBracketsBalanced;
    }


    public static void main(String[] args) {
       System.out.println( isBalancedParanthesis("{[}"));
    }

}
