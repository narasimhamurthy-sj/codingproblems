package problemset2;
/*
{1,2,3,4,5}
-- Take clarify whether it will be in ascending or descending order of sorting
1. {1,5,7,8}
2. {8,12,16}
3. -ve num
4. No missing,all available
5.mix of +ve and -ve
6.{1,100,101}
7.{1,2,100}
8.{1,2,100,101}
9. Array with duplicate elements {1,1,1,2,3,6}
10 Array with duplicate elements {1,2,2,3,3,4,4,6}


1.Get the last element form array
2.Get the first element form array
3. -get next element from array
- iterate a loop till lastElementNumber
-start checking from firstElementNumber
-SET startingNumber+1
- indexofArray =0


    - IF nextElement!=startingNumber
      print startingNumber

     -ELSE
      -get next element from array


    -startingNumber++
-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -

 */

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MissingValuesInSortedArray {

    /*
    {1,3,4,5,6}
    mid=2, arr[mid]=4

    is mid+1==arr[mid]
     */

    //Using binary search
    public static int oneMissingElementInArray(int[] inputArray) {

        int startingIndex = 0;
        int lastIndex = inputArray.length - 1;
        int midElementIndex;

        while (startingIndex <= lastIndex) {

            midElementIndex = (startingIndex + lastIndex) / 2;

            if (inputArray[midElementIndex] != midElementIndex + 1 && (midElementIndex == 0 || inputArray[midElementIndex - 1] == midElementIndex)) {
                return midElementIndex + 1;
            }
            if (inputArray[midElementIndex] == midElementIndex + 1) {
                startingIndex = midElementIndex + 1;
            } else {
                lastIndex = midElementIndex - 1;
            }

        }
        return -1;
    }


    public static void printMissingNumbersInArray(int[] inputArray) {

        if (inputArray.length <= 1) {
            System.out.println("array should have more than one elements");
            return;
        }
        int startFromNumber = (inputArray[0]);
        int nextElementFromArray = inputArray[1];
        int arrayIndex = 1;
        boolean isMissingNumPresent = false;

        while (startFromNumber < inputArray[inputArray.length - 1]) {
            //to handle duplicates
            if (startFromNumber == nextElementFromArray) {
                startFromNumber = nextElementFromArray;
                nextElementFromArray = inputArray[++arrayIndex];
            } else {
                startFromNumber++;
                if (startFromNumber != nextElementFromArray) {
                    //Missing num
                    System.out.print(" " + startFromNumber);
                    isMissingNumPresent = true;
                }
            }
        }
        if (!isMissingNumPresent) {
            System.out.println("All elements are present. No missing  num");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // printMissingNumbersInArray(new int[]{-50, -1, 10, 11});

        //  System.out.println(oneMissingElementInArray(new int[]{1,2,4}));





      /*
      Write a program in Java to count the digits in a number

. Write a program in Java to calculate the number of times a digit ‘D’ appears in a number N. You have to take N and D as inputs from the user.

       */


        Scanner input = new Scanner(System.in);

        System.out.println("Enter number");
        BigInteger num = input.nextBigInteger();

        // int num=121345;
        String str = String.valueOf(num);
        System.out.println("length:" + str.length());
        str.matches("1");
        Matcher match = Pattern.compile("1").matcher(str);

        while (match.find()) {
            System.out.println(match.group());
        }
    }
}
