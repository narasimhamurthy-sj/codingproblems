package repeatpractice;

import java.util.Arrays;

/*
arr{9,8,7,6,5,4,3,2,1}

Merge sort follows divide and conquer approach:
Divide given array until it reaches single element
As we get 2 parts each time, store these as separate array
Compare element from firstpart array to secondPart
based on lesser element,store this in given array. this is Merging process
Some cases, either in array1( firstpart) or in array2(secondPart),some elements might left out
if length of both arrays are different or type of elements it contains
Hence simply copy the remaining elements to the main array



-divide array into 2 parts
  -if(startingIndex<lastIndex) //Repeat until single element
  -find mid pos
-further divide
 mergeSort(startingIndex,mid)
 mergeSort(mid+1,lastIndex)

 //create arr1 using index startingIndex and mid
 //create arr2 using index mid+1 and lastIndex
 //Pass startingIndex which helps in copying elements from arr1 or arr2 to the right
 //index of original array

merge(arr, arr1,arr2,startingIndex)

 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        //Testing with different inputs
        int[][] arrays = new int[][]{
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4},
                {1, 9, 2, 8, 3, 7, 4, 6, 5},
                {2, 2, 2, 2, 2},
                {1, 2, 3, 6, 5, 4},
                {},
                {10},
                {1, 2, 3, -1, -2, -3, 0},
                {1, 2, 3, -1, 1, -2, 2, -3, 3, 0, 0},
                {-1, -50, -2, -60, -3, -70}
        };

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length == 0) {
                System.out.print("Empty array");
            }
            sort.mergeSort(arrays[i], 0, arrays[i].length - 1);
            Arrays.stream(arrays[i]).forEach(e -> System.out.print(e + "  "));
            System.out.println();
        }

    }

    public void merge(int[] arr, int[] arr1, int[] arr2, int startingIndex) {

        int i = 0, j = 0, k = startingIndex;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
            ;
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }

    }

    public void mergeSort(int[] arr, int startingIndex, int lastIndex) {

        if (startingIndex < lastIndex) {
            int midIndex = (startingIndex + lastIndex) / 2;
            mergeSort(arr, startingIndex, midIndex);
            mergeSort(arr, midIndex + 1, lastIndex);
            merge(arr, Arrays.copyOfRange(arr, startingIndex, midIndex + 1), Arrays.copyOfRange(arr, midIndex + 1, lastIndex + 1), startingIndex);
        }
    }

}
