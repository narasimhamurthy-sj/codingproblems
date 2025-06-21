package problemset4;

import java.util.ArrayList;
import java.util.HashMap;

/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

 */
public class SubArraySumEqualsK {


    public static void main(String[] args) {
        SubArraySumEqualsK subArrayCnt = new SubArraySumEqualsK();
        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{1, 1, 1}, 2));

        System.out.println("--------------------------------------------------------------");
        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{1, 1, 1, 3, 5, 2, 3}, 5));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3}, 6));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{-1, -1, -1, -3, -5, -2, -3}, -5));
        System.out.println("--------------------------------------------------------------");
        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{-1, 1, -1, 5, -5, 0, -3, 3}, 0));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{-4, 1, -1, 5, -5, 1, -3, 3}, 1));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{-4, 1, -1, 5, -5, 1, -3, 3}, 100));
        System.out.println("--------------------------------------------------------------");
        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{2, 2, 2, 2, 2, 2, 2, 2}, 4));
        System.out.println("--------------------------------------------------------------");
        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{2, 4, 2, 2, 2, 6, 4, 2, 4, 2, 2, 2, 2}, 6));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{2, -4, -2, 2, 2, -6, 4, 2, 4, 2, 2, 2, 2}, 6));
        System.out.println("--------------------------------------------------------------");

        System.out.println("count:" + subArrayCnt.totalCountOfSubArrayBasedOnSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println("--------------------------------------------------------------");
        System.out.println("count:" + subArrayCnt.improvedSolution(new int[]{2, -4, -2, 2, 2, -6, 4, 2, 4, 2, 2, 2, 2}, 6));

    }

    public int improvedSolution(int[] inputArray, int k) {
        int sum = 0;
        int subArrayCount = 0;
        HashMap<Integer, Integer> storedSumInMap = new HashMap<>();
        //if sum-k =0, intialize with 0 and frequency with 1 and if sub array found, manage with frequency count
        storedSumInMap.put(0, 1);

        //iterate all elements in array
        for (int arrayElement : inputArray) {
            sum += arrayElement;
            if (storedSumInMap.containsKey(sum - k))
                subArrayCount += storedSumInMap.get(sum - k);
            storedSumInMap.put(sum, storedSumInMap.getOrDefault(sum, 0) + 1);

        }
        return subArrayCount;
    }

    public int totalCountOfSubArrayBasedOnSum(int[] inputArray, int k) {

        System.out.println("k:" + k);
        int sum = 0;
        int subArrayCount = 0;
        ArrayList<Integer> subArrayElemets = new ArrayList<>();
        for (int outerLoopIndex = 0; outerLoopIndex < inputArray.length; outerLoopIndex++) {

            sum = 0;
            subArrayElemets.clear();
            for (int innerLopIndex = outerLoopIndex; innerLopIndex < inputArray.length; innerLopIndex++) {

                sum += inputArray[innerLopIndex];
                subArrayElemets.add(inputArray[innerLopIndex]);
                if (sum == k) {
                    subArrayCount++;
                    System.out.println(subArrayElemets.toString());


                    //  break;
                } /*else if(sum<0  ){

                    if(sum<k && k<0){

                   //     break;
                    }
                }
                else if (k>0 && sum>k) {

                //    break;
                }
                */


            }
        }//ourt loop

        return subArrayCount;
    }
/*
2
3
7
3
11
8
0
7
9
10
 */
}
