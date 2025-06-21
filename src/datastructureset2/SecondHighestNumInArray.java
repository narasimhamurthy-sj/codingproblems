package datastructureset2;

import java.util.Arrays;

public class SecondHighestNumInArray {

    /*
     * arr[4,5,6,2], arr[],arr[2,2,2,2], arr[2,2,3,3,3]
     *
     * check if array is empty, if not go for finding element
     * sort the array
     *found=false
     * if arr[n-1] and arr[n-2] are equal
     * lastElementInArray=arr[n-1]
     * lengthOfArray=arr.length
     *
     * Begin while(lengthOfArray>1)
     * traverse from lastElementInArray is not equal other elements in array
     * if lastElementInArray != arr[lengthOfArray-2]
     * else
     *    found=true
     *    secondHighestElement=arr[lengthOfArray]
     *
     * lengthOfArray--
     *
     * END of while
     *else
     *    secondHighestElement=arr[n-2]
     *    found=true
     *
     * if(found)
     * print secondHighestElement
     * else
     * print data is unique. hence no second highest element
     * */
    public static int findSecondHighest(int[] arr) {

        int secondHighestElement = 0;
        try {
            if (arr.length != 0 && arr.length != 1) {
                Arrays.sort(arr);
                boolean found = false;

                int n = arr.length;
                if (arr[n - 1] == arr[n - 2]) {
                    int lastElementInArray = arr[n - 1];
                    int lengthOfArray = arr.length;
                    while (lengthOfArray > 1) {

                        if (lastElementInArray != arr[lengthOfArray - 2]) {
                            found = true;
                            secondHighestElement = arr[lengthOfArray - 2];
                            break;
                        }
                        lengthOfArray--;

                    }
                } else {
                    found = true;
                    secondHighestElement = arr[n - 2];
                }
                if (found) {
                    System.out.println("Second Highest elemet: " + secondHighestElement);
                } else {
                    System.out.println("Array elements are unique");
                }
            } else {
                System.out.println("Array elements are empty or having single element");
            }

        } catch (Exception e) {

            System.out.println("Exception at findSecondHighest" + e.getMessage());
            e.printStackTrace();
        }
        return secondHighestElement;
    }


    public static void main(String[] args) {

        findSecondHighest(new int[]{4, 3, 2, 1});
        System.out.println("Input 2");

        findSecondHighest(new int[]{2, 2, 2, 2});
        System.out.println("Input 3");
        findSecondHighest(new int[]{2, 2, 3, 3, 3});
        System.out.println("Input 4");
        findSecondHighest(new int[]{2, -2, 3, 3, 3});
        System.out.println("Input 5");
        findSecondHighest(new int[]{0, 0, 0, 0, 0, 1});
        System.out.println("Input 6");
        findSecondHighest(new int[]{0, 0, 0, 0, 0, 0});
        System.out.println("Input 7");
        findSecondHighest(new int[]{0, 0, 2, 2, 3, 3, 1, 1, 99, 99});
        System.out.println("Input 8: only 2 elements");
        findSecondHighest(new int[]{3, 1});
        System.out.println("Input 9: only 1 elements");
        findSecondHighest(new int[]{10});


    }

}
