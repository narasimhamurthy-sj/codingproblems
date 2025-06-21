package problemset5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBrackets {


    //iterative approach
    public static List<String> generateParenthesisIterative(int n) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesisState> queue = new LinkedList<>();
        //insert initial values in queue- empty str, left and right bracket count as 0
        queue.offer(new ParenthesisState("", 0, 0));

        while (!queue.isEmpty()) {
            //fetch and remove first data in queue and point to the reference current formed brackets state
            ParenthesisState state = queue.poll();

            //if open and close brackets reaches to n, meaning expected brackets have been formed. Add in list
            if (state.openBracketCount == n && state.closeBracketCount == n) {
                result.add(state.formedBrackets);
            }
            //if openbracket count not more than n, add open bracket and store in queue.
            if (state.openBracketCount < n) {
                queue.offer(new ParenthesisState(state.formedBrackets + "(", state.openBracketCount + 1, state.closeBracketCount));
            }
            //closeBracketCount should be less than openBracketCount to form valid bracket sequence
            if (state.closeBracketCount < state.openBracketCount) {
                queue.offer(new ParenthesisState(state.formedBrackets + ")", state.openBracketCount, state.closeBracketCount + 1));
            }
        }

        return result;
    }

    //recursive approach
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add '(' if open < max
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add ')' if close < open
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int[] inputArr = {0, 1, 2, 4, -1, 10};
        for (int n : inputArr) {
            System.out.println(generateParenthesis(n));
            System.out.println(generateParenthesisIterative(n));

        }

    }

    static class ParenthesisState {
        String formedBrackets;
        int openBracketCount;
        int closeBracketCount;

        ParenthesisState(String formedBrackets, int openBracketCount, int closeBracketCount) {
            this.formedBrackets = formedBrackets;
            this.openBracketCount = openBracketCount;
            this.closeBracketCount = closeBracketCount;
        }
    }


}
