package datastructureset2;

import java.util.Arrays;

public class BubbleSort {
    /*
    input:arr[5,4,3,2,1]
    O(n2)

    Need 2 loops.
    Outer loop: Each iteration the biggest value will be shifted to end
    Inner loop:
                2 elements, current and next elements are compared
                IF nextElemnt <current element
                swap elements

As each big  element will shifted at each outer loop iteration.
Innerloop has to execute j<n-i
To avoid index out of bound, we should reduce n-1 as well
i.e,   j<n-1-i

 1st outer loop iteration :4,3,2,1,5
 2nd outer loop iteration :3,2,1,4..
 3rd:2,1,3 ...
 4th:1,2...





     */


    public static int[] bubbleSort(int[] inputArray) {

        if(inputArray.length==0){
            System.out.println("Empty array");
            return inputArray;
        }
        System.out.println("Before Sort");
        Arrays.stream(inputArray).forEach(element->System.out.println(element));

        int temporaryElementToStoreData;
        for (int i = 0; i < inputArray.length - 1; i++) {

            for (int j = 0; j < inputArray.length - 1 - i; j++) {

                if (inputArray[j + 1] < inputArray[j]) {
                    temporaryElementToStoreData = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temporaryElementToStoreData;
                }
            }
        }

        System.out.println("After Sort");
        Arrays.stream(inputArray).forEach(element->System.out.print(element+"\t"));

        return inputArray;
    }


    public static void main(String[] args) {
        /*
        1. 5,0,4,1,3,2  (scattered)
        2. 1,2,3,4,5
        3. 5,4,3,2,1
        4. 5,1
        5. 1
        6.  -1,-2,-3,-4
        7.  4,0,3,-1,-2
        8. Empty array
        9. 1,1,1,1,1
        10. 1,2,5,3,4 (mid element is not sorted)
         */

        bubbleSort(new int[] {1,2,5,3,4});
    }
}
