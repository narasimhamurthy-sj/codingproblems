package problemset3;
/*
{10,4,2,1,15}
{10,4,2,1,15}


-check length of both the arrays
-check any one of array is empty or length 0
_   -   -       -   -   -       -   -   -   -   -       --

1. equal elemnts
2. 2 arrays length is different
3. array with length 0
4. Two arrays sum is same but ordering of element is different new int[]{1,4,2},new int[]{1,2,4}
5.Two array -last elemtnt is not matching
6. First elemnt is not matching
7.Mid element is not matching
8. duplicat elements
9. Array with -ve and +ve elements


 */

import java.util.Arrays;

public class EqualityOfTwoArrays {


    public static void main(String[] args) {
        System.out.println(new EqualityOfTwoArrays().isArraysEqual(new int[]{-2, 2, -2}, new int[]{-2, 2, -2}));
    }

    public boolean isArraysEqual(int[] array1, int[] array2) {

        boolean isEqual = true;
        if (array1.length != array2.length) {
            System.out.println("Arrays lenth are different, not equal");
            return false;
        }

        if (array1.length == 0 && array2.length == 0) {
            System.out.println("Empty arrays");
            return false;
        }

        if (Arrays.stream(array1).sum() != Arrays.stream(array2).sum()) {
            System.out.println("Arrays sum not matching");
            return false;
        }

        int indexFromLast = array1.length - 1;

        for (int indexFromFirst = 0; indexFromFirst < (array1.length - 1) / 2; indexFromFirst++, indexFromLast--) {

            if (array1[indexFromFirst] != array2[indexFromFirst] || array1[indexFromLast] != array2[indexFromLast]) {
                isEqual = false;
                break;
            }

        }
        return isEqual;
    }
}
