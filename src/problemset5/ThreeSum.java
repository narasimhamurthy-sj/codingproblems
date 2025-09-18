package problemset5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
find all unique triplets (groups of three numbers) within a given array that sum to zero.
In other words, given an array of integers, you need to identify all distinct sets of
three elements (a, b, c) where a + b + c = 0

Input:
An array of integers (e.g., [-1, 0, 1, 2, -1, -4]).
Output:
A list of lists, where each inner list represents a unique triplet that sums to zero. (e.g., [[-1, 0, 1], [-1, -1, 2]]).
Constraints:
The triplets must be unique. No duplicate triplets should be included in the output.
The order of elements within a triplet doesn't matter (e.g., [-1, 0, 1] is considered the same as [1, 0, -1]).
Example:
For the input [-1, 0, 1, 2, -1, -4], a possible solution is [[-1, 0, 1], [-1, -1, 2]]
 */
public class ThreeSum {
    public static void main(String[] args) {

        ThreeSum threeSumObject = new ThreeSum();
        /*int[][] inputArr={
                {-1, 0, 1, 2, -1, -4},
                {-1, 0, 1, 2, -1, -4,1,0,-1},
                {-2,2,0},
                {0,3,2,1,-2,-1,-1},
                {1,2,3},
                {-1,1},
                {0,0,0,-1,-2,-3,-4,-5,1,2,3,4,5},
                {-1,0,1,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
                {-1,0,1,2,2,2,2,2,2,2,2}
        };*/
        int[][] inputArr = {

                {1, 2, 1, 4},
                {10, 3, 20, 4, 30, 1, 40, 5, 50, 150},
                {10, 3, 20, 4, 30, 1, 40, 5, 50, 22},
                {10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30},
                {5, 5, 5, 5, 5, 5, 5, 5},
                {5, -5, 5, -5, 5, 15},
                {5, -5, 5, 0, -5, 5, 15, 6, -6, 4, -4},

        };
        ArrayList<Integer> targetList = new ArrayList<>(List.of(4, 100, 33, 60, 15, 15, 15));

        for (int i = 0; i < inputArr.length; i++) {
            List<List<Integer>> pairList = threeSumObject.findThreeNumPairsThatSumsToTarget(inputArr[i], targetList.get(i));
            if (pairList.isEmpty()) {
                System.out.println("No pair found");
            } else {
                pairList.forEach(elemet -> System.out.print(elemet.toString()));
                System.out.println();
            }
        }

    }

    public List<List<Integer>> findThreeNumPairsThatSumsToTarget(int[] inputArray, int target) {
        //final results storing list of list
        List<List<Integer>> pairList = new ArrayList<>();
        if (inputArray.length < 3) {
            System.out.print("Array doesn't have 3 nums. Hence can't form 3 nums pair. ");
            return pairList;
        }
        //Sort the given array,so that duplicates can be skipped
        Arrays.sort(inputArray);
        //check each number with remaining array numbers with 2 pointers
        for (int i = 0; i < inputArray.length - 2; i++) {

            //if previous num and current num are same. It's duplicate num and no need of
            //checking for 3 sum with remaining nums because it's duplicate effort and
            //duplicate pairs need to be avoided as per constraint
            if (i > 0 && inputArray[i] == inputArray[i - 1])
                continue;
            //pointer1 which checks from left side of the array
            int leftIndex = i + 1;
            //pointer2 which checks from end of the array
            int rightIndex = inputArray.length - 1;

            //Iterate through array and check Using pointer1 and pointer2 nums, check whether sum=0
            while (leftIndex < rightIndex) {

                int sum = inputArray[i] + inputArray[leftIndex] + inputArray[rightIndex];
                //if sum =target, we found pair with 3 nums
                if (sum == target) {
                    pairList.add(List.of(inputArray[i], inputArray[leftIndex], inputArray[rightIndex]));
                    //check next left index num is duplicate of current,if so skip that num
                    while (leftIndex < rightIndex) {
                        if (inputArray[leftIndex] == inputArray[leftIndex + 1]) {
                            leftIndex++;
                        } else {
                            break;
                        }
                    }
                    //check next right index num is duplicate of current,if so skip that num
                    while (leftIndex < rightIndex) {
                        if (inputArray[rightIndex] == inputArray[rightIndex - 1]) {
                            rightIndex--;
                        } else {
                            break;
                        }
                    }
                    leftIndex++;
                    rightIndex--;
                } else if (sum < target) {
                    //if sum below target, go for next left element to match target
                    leftIndex++;
                } else {
                    //if sum above target, go for next right element to match target
                    rightIndex--;
                }
            }//end of while

        }//end of for

        return pairList;
    }

    public List<List<Integer>> findThreeNumPairsThatSumsToZero(int[] inputArray) {
        //final results storing list of list
        List<List<Integer>> pairList = new ArrayList<>();
        if (inputArray.length < 3) {
            System.out.print("Array doesn't have 3 nums. Hence can't form 3 nums pair. ");
            return pairList;
        }
        //Sort the given array,so that duplicates can be skipped
        Arrays.sort(inputArray);
        //check each number with remaining array numbers with 2 pointers
        for (int i = 0; i < inputArray.length - 2; i++) {

            //if previous num and current num are same. It's duplicate num and no need of
            //checking for 3 sum with remaining nums because it's duplicate effort and
            //duplicate pairs need to be avoided as per constraint
            if (i > 0 && inputArray[i] == inputArray[i - 1])
                continue;
            //pointer1 which checks from left side of the array
            int leftIndex = i + 1;
            //pointer2 which checks from end of the array
            int rightIndex = inputArray.length - 1;

            //Iterate through array and check Using pointer1 and pointer2 nums, check whether sum=0
            while (leftIndex < rightIndex) {

                int sum = inputArray[i] + inputArray[leftIndex] + inputArray[rightIndex];
                //if sum 0, we found pair with 3 nums
                if (sum == 0) {
                    pairList.add(List.of(inputArray[i], inputArray[leftIndex], inputArray[rightIndex]));
                    //check next left index num is duplicate of current,if so skip that num
                    while (leftIndex < rightIndex) {
                        if (inputArray[leftIndex] == inputArray[leftIndex + 1]) {
                            leftIndex++;
                        } else {
                            break;
                        }
                    }
                    //check next right index num is duplicate of current,if so skip that num
                    while (leftIndex < rightIndex) {
                        if (inputArray[rightIndex] == inputArray[rightIndex - 1]) {
                            rightIndex--;
                        } else {
                            break;
                        }
                    }
                    leftIndex++;
                    rightIndex--;
                } else if (sum < 0) {
                    //if sum below 0 means left array with -ve numbers. check next left index num
                    leftIndex++;
                } else {
                    //if sum above 0 means right array with +ve numbers. check next right index num from end
                    rightIndex--;
                }
            }//end of while

        }//end of for

        return pairList;
    }
}
