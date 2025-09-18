package problemset5;
/*
Problem Statement Breakdown:
Input:
An array of integers (e.g., [2, 7, 11, 15]) and a target integer (e.g., 9).
Goal:
Find two numbers in the array that, when added together, equal the target sum.
Output:
The indices (positions in the array) of the two numbers that satisfy the condition. For example, for the array [2, 7, 11, 15] and target 9, the output would be [0, 1] (since 2 + 7 = 9, and their indices are 0 and 1).
Constraints:
There is exactly one solution.
You cannot use the same element twice in the sum.
The order of the indices in the output does not matter
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 convert array to arraylist
 iterate through list
 - take first element
 -calculate it's complement
 -check complement is present under list
 -if so, store index in array and break the loop
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum sumObject = new TwoSum();
        int[][] inputArr = {
                {3, 3},
                {4, 3, 6, 1, 2},
                {1, 2, 3, 4, 6},
                {4, 3, 6, 1, 2},
                {4, 3, 6, 1, 2, 8},
                {8},
                {-1, 2, 4, -3}

        };
        List<Integer> targetList = new ArrayList<>(List.of(6, 8, 6, 6, 8, 8, 1));
        int[] outputPair;
        for (int i = 0; i < inputArr.length; i++) {
           // outputPair = sumObject.findPairThatMatchesToTarget(inputArr[i], targetList.get(i));
            outputPair = sumObject.improvedSolution(inputArr[i], targetList.get(i));
            if (outputPair.length == 0) {
                System.out.println("No matching pair found for target:" + targetList.get(i));
            } else {
                Arrays.stream(outputPair).forEach(element -> System.out.print(element + "  "));
                System.out.println();
            }
        }
    }

    public int[] findPairThatMatchesToTarget(int[] inputArray, int target) {
        List<Integer> inputList = Arrays.stream(inputArray).boxed().toList();
        int elementFromList, complement;
        for (int i = 0; i < inputList.size(); i++) {

            complement = target - inputList.get(i);
            List<Integer> copiedList = new ArrayList<>(inputList);
            //sometimes complement can be same number from that we substracted using list.get(i)
            //Hence we should remove ex: 4=8(target)-4(number)
            copiedList.remove(inputList.get(i));
            if (copiedList.contains(complement)) {

                return new int[]{i, inputList.lastIndexOf(complement)};
            }

        }
        return new int[]{};
    }

    public int[] improvedSolution(int[] inputArray,int target){
        HashMap<Integer,Integer> elementsMap=new HashMap<>();
        int complement;
        for (int i = 0; i < inputArray.length; i++) {
            complement=target-inputArray[i];
            if(elementsMap.containsKey(complement)){
                return new int[]{i, elementsMap.get(complement)};
            }
            elementsMap.put(inputArray[i],i);
        }
        return new int[] {};
    }
}
