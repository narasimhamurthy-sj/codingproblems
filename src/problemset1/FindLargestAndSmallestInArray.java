package problemset1;

import java.util.Arrays;

public class FindLargestAndSmallestInArray {
    /*

    Iterate each element
    SET min and max as first element
    Take next element
    if arr[nextelement] < min
    SET min= arr[nextelement]

    if(arr[nextElement]>max)
    SET max= arr[nextelement]

1. soreted array
2.unsorted array
3. All same elements
4.Element doesn't exist.Emty array
5.multiple min and max
[1,1,1,5,5,5,2]
6. -ve values in array
[-1,-2,-3,-4]
7.Array with single element
8. array with +ve and -ve nums



     */


    public static int[] findMinAndMaxElement(int[] inputArray) {

        if (inputArray.length == 0) {
            System.out.println("Empty array");
            return new int[]{};
        }
        int minValue = inputArray[0];
        int maxValue = inputArray[0];
        for (int indexOfInputArray = 1; indexOfInputArray < inputArray.length; indexOfInputArray++) {

            if (inputArray[indexOfInputArray] < minValue) {

                minValue = inputArray[indexOfInputArray];
            }

            if (inputArray[indexOfInputArray] > maxValue) {

                maxValue = inputArray[indexOfInputArray];
            }
        }
        System.out.println("Max:" + maxValue + " Min value:" + minValue);
        return new int[]{minValue, maxValue};
    }

    public static void usingInbuilt(int[] arr) {

        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

    public static void main(String[] args) {

        // usingInbuilt(new int[]{1,5,2,3,4});
        findMinAndMaxElement(new int[]{-1, 2, 3, 0});
    }
}
