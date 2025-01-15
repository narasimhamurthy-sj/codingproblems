package problemset1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumInArray {
    /*
You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Steps:

Take  element in array by index one by one,

    if(array[i]<target)
    then only go for jth for loop
    with jth loop, start checking next element
        If array[j]< target
        if(target==array[i]+array[j])
        return new int[] {i,j];



     */
    public static int[] calculateTwoSum(int[] inputArray,int target){

        int[]  twoSumIndicies={};
        for (int i = 0; i < inputArray.length; i++) {

            if(inputArray[i]<0 || inputArray[i]<target){

                for (int j = i+1; j < inputArray.length; j++) {

                    if(inputArray[j]<0 || inputArray[j]<target){

                        if(target==inputArray[i]+inputArray[j]){
                            System.out.println("found at indicies- i:"+i+" j:"+j);
                            return twoSumIndicies=new int[] {i,j};
                        }
                    }

                }
            }

        }

        if(twoSumIndicies.length==0){
            System.out.println("Two sum indicies doesn't exist");
        }

        return twoSumIndicies;
    }



    public static int[] simpleApproach(int[] inputArray, int target) throws Exception {

        HashMap<Integer,Integer> storeArrayData=new HashMap<>();

        int complement;
        for (int i = 0; i < inputArray.length; i++) {

            complement=target-inputArray[i];

            if(storeArrayData.containsKey(complement)){

                return new int[]{storeArrayData.get(complement),i};
            }

            storeArrayData.put(inputArray[i],i);

        }


        throw new Exception("Two sum indicied doesn't exist");
    }
    public static void main(String[] args) throws Exception {
/*
4. sum doesn't exist
3,3 -8
5.sum exists in middle of arr
    3,1,2,4,3,9,9,9,10
6.sum exists in 3rd pos
  1,1,3,4,3,9,9,3,10
7.sum exists in end
  1,1,0,4,0,9,9,3,3
 8.try with -ve
 1,1,0,-4,-4,9,9,3

 */


        Arrays.stream(simpleApproach(new int[]{2,3,0,-4,9,9,-4},-8)).forEach(arrayElement->System.out.println(arrayElement));
    }
}
