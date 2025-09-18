package problemset5;

import java.util.Arrays;

/*
Given an array of integers, move all zeroes to the end of the array while maintaining the relative order of the non-zero elements.
Input:
nums = [0, 1, 0, 3, 12]
Output:
[1, 3, 12, 0, 0]
Explanation:
Non-zero elements: [1, 3, 12]
Zeroes are moved to the end.
The order of non-zero elements is preserved.

Constraints:
You must do this in-place without making a copy of the array.

Minimize the total number of operations.
 */
public class MoveZerosToEndInArray {

    public int[] moveZeroesToEnd(int[] inputArray){

        int zeroCount=0,nonZeroElementIndex=0;
        if(inputArray.length==0){
            System.out.print("Empty array  ");
            return inputArray;
        }
        for (int i = 0; i < inputArray.length; i++) {

            if(inputArray[i]==0){
                zeroCount++;
            }else{
                inputArray[nonZeroElementIndex++]=inputArray[i];
            }
        }
        if(zeroCount>0){
            int startingIndexToFillZero=inputArray.length-zeroCount;
            while(startingIndexToFillZero<inputArray.length){
                inputArray[startingIndexToFillZero++]=0;
            }
        }
        return inputArray;
    }


    public static void main(String[] args) {
        int[][] inputArr={
                {0,1,0,2,0,3},
                {0,0,0,0,5},
                {12,0,1,6,0,0},
                {1,2,3,4,5,6},
                {0,0,0,0,0},
                {1,2,3,4,0,0,0,0},
                {0,0,0,0,0,1,2,3},
                {0},
                {0,10},
                {}
        };
        MoveZerosToEndInArray moveZeroesObject=new MoveZerosToEndInArray();
        for (int i = 0; i <inputArr.length ; i++) {
           int[] outPutArray= moveZeroesObject.moveZeroesToEnd(inputArr[i]);
            System.out.println(Arrays.toString(outPutArray));;
        }
    }
}
