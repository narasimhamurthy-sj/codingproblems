package problemset1;

import java.util.Arrays;

public class RemoveElementInArray {

    /*

    Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]

Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]

Input: nums = [6,6,6,6], val = 6
Output: 0, nums = [_,_,_,_,_]

Input: nums = [3,2,2,1], val = 3
Output: 2, nums = [2,2,_,_]

Input: nums = [3,2,3,3], val = 3
Output: 2, nums = [2,2,_,_]

Steps:
total elemets=array size

while array size is >= zero
if given num matching array element
  matchCount++
  if swappedIndex-1 is same as given num
    swap n-1  element(swappedIndex=swappedIndex-2)
    place underscore at the n-1 and nth position
    maintain swapped index as n-1(swappedIndex-2)
    reducearraySize by 2


   swap with swappedIndex-1
    place underscore at swappedIndex-1
    maintain swappedIndex-1
    reducearraySize by 1
  As swapped, new element present. do not increment index count.

else
increment index count

     */


    public static int removeDuplicateElementsInArray(int[] inputArray, int deleteElement) {

        int totalElementsInArray = inputArray.length - 1;
        int indexOfinputArray = 0;
        int matchCount = 0;
        int swappedElementIndex = inputArray.length - 1;
        int k = 0;

        while (indexOfinputArray <= totalElementsInArray) {

            if (inputArray[indexOfinputArray] == deleteElement) {


                if (inputArray[swappedElementIndex] == deleteElement) {

                    inputArray[indexOfinputArray] = inputArray[swappedElementIndex - 1];
                    inputArray[swappedElementIndex] = '_';
                    inputArray[swappedElementIndex - 1] = '_';
                    swappedElementIndex = swappedElementIndex - 2;
                    totalElementsInArray = totalElementsInArray - 2;
                    matchCount = matchCount + 2;
                } else {
                    inputArray[indexOfinputArray] = inputArray[swappedElementIndex];
                    inputArray[swappedElementIndex] = '_';
                    swappedElementIndex--;
                    totalElementsInArray--;
                    matchCount++;
                }
            } else {
                indexOfinputArray++;
            }
        }

        System.out.println("Found occurances:" + matchCount);
        k = inputArray.length - matchCount;
        Arrays.stream(inputArray).forEach(element -> System.out.println(element));
        return k;
    }


    public static int simpleApproach(int[] inputArray, int value) {
        int kValues = 0;

        for (int inputArrayIndex = 0; inputArrayIndex < inputArray.length; inputArrayIndex++) {

            if (inputArray[inputArrayIndex] != value) {
                inputArray[kValues] = inputArray[inputArrayIndex];
                kValues++;
            }

        }
        Arrays.stream(inputArray).forEach(arrayElement -> System.out.println(arrayElement));
        return kValues;
    }

    public static void main(String[] args) {

        //  System.out.println("K:"+removeDuplicateElementsInArray(new int[]{3,2,3,3},3));
        System.out.println("K:" + simpleApproach(new int[]{3, 1, 2, 3, 0, 2, 2, 3, 3}, 3));


    }
}
