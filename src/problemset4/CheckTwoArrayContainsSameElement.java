package problemset4;

import java.util.Arrays;
import java.util.List;

/*

arr1{1,2,3,4} arr2{4,5,6}

same elements
arr1{1,1,1,1} arr2{1,1,1,1}

same element at mid position
arr1{1,2,3,4} arr2{4,2,6}

one of the array is empty

Both the arrays are empty

same elements not present in array
arr1{1,2,3,4} arr2{9,5,6}

one array has bigger length and another has very lesser length
arr1{1,2,3,4,9,5,6} arr2{6}

Both array having duplicate elements
arr1{1,2,3,4} arr2{1,2,3,4}

Array with -ve numbers
arr1{-1,2,-3,-4} arr2{-1,2,-3,4}

Same element is present more than once in another array
arr1{1,2,3,4} arr2{1,1,1,4}

array1 contains same element and array2 contains single element but it is same element as that of array1
arr1{1,1,1,1} arr2{1}



 */

public class CheckTwoArrayContainsSameElement {

    public static void main(String[] args) {
        CheckTwoArrayContainsSameElement checkArray = new CheckTwoArrayContainsSameElement();
        System.out.println("DoesArrayContainSameElement:" + checkArray.doesArrayContainSameElement(new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 4}));
    }

    int compareList(List<Integer> array1List, List<Integer> array2List, int sameElementCount) {
        for (int array1ListElement : array1List) {
            if (array2List.contains(array1ListElement)) {
                sameElementCount++;
                System.out.print(array1ListElement + ", ");
            }
        }
        return sameElementCount;
    }

    public boolean doesArrayContainSameElement(int[] inputArray1, int[] inputArray2) {
        boolean isSameElementFound = false;
        int sameElementCount = 0;

        if (inputArray1.length == 0 || inputArray2.length == 0) {
            System.out.println("One of the array is empty, can't compare elements");
            return isSameElementFound;
        }

        List<Integer> array1List = Arrays.stream(inputArray1).boxed().toList();
        List<Integer> array2List = Arrays.stream(inputArray2).boxed().toList();

        if (array1List.size() <= array2List.size()) {
            sameElementCount = compareList(array1List, array2List, sameElementCount);
        } else {
            sameElementCount = compareList(array2List, array1List, sameElementCount);
        }

        if (sameElementCount > 0) {
            isSameElementFound = true;
        }
        System.out.println("\nsameElementCount:" + sameElementCount);
        return isSameElementFound;
    }


}
