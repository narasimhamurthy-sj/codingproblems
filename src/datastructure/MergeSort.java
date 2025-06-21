package datastructure;

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


    // Utility function to print the array
    private static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();


    }


 /*   private void divideArrayIntoTwoParts1(int[] array,int left,int right){

        if(!(left<right)) {
            return;
        }

            int midIndex = (left + right) / 2;
            divideArrayIntoTwoParts1(array, left, midIndex);
            divideArrayIntoTwoParts1(array,midIndex+1, right);
            mergeArrays(array, left, midIndex, right);

    }*/

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        // int[] arr={5,4,3,2,1};
        // int[] arr={10,1,9,2,8,3,7,4,6,5};
        int[] arr = {1, 1, 6, 8, 8, 2, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        //   int[] arr={10,1,9,2,6};
        /*mergeSort.divideArrayIntoTwoParts1(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(data->System.out.print(data+"  "));*/
        //  printArray(arr);

       /* mergeSort.sort(arr,0,arr.length-1);
        System.out.println("\nSorted array");
        printArray(arr);*/

        mergeSort.divideArrayIntoTwoPartition(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(data -> System.out.print(data + "  "));


        MergeSort sort = new MergeSort();
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.mergeSort(array, 0, array.length - 1);

    }

    private void mergeArrays(int[] array, int firstIndex, int midIndex, int lastIndex) {

        int n1 = midIndex - firstIndex + 1;
        int n2 = lastIndex - midIndex;
        int[] leftPartArray = new int[n1];
        int[] rightPartArray = new int[n2];

        // int startingIndex=firstIndex;
        for (int i = 0; i < n1; ++i)
            leftPartArray[i] = array[firstIndex + i];

        //  startingIndex=midIndex+1;
        for (int j = 0; j < n2; ++j)
            rightPartArray[j] = array[midIndex + 1 + j];

        int i = 0, j = 0;

        int k = firstIndex;
        while (i < n1 && j < n2) {

            if (leftPartArray[i] <= rightPartArray[j]) {

                array[k] = leftPartArray[i];
                i++;
            } else {
                array[k] = rightPartArray[j];
                j++;

            }
            k++;
        }

        while (i < n1) {
            array[k] = leftPartArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightPartArray[j];

            j++;
            k++;
        }

    }

    // Function to merge two subarrays
    private void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void mergeDividedArrays(int[] array, int firstIndex, int midIndex, int lastIndex) {

        //array1 till mid index
        //  int[] firstArray=new int[midIndex-firstIndex+1];
        //array2 after mid index
        //     int[] secondArray=new int[lastIndex-midIndex];

        //Copy data array1
        //   Arrays.copyOfRange(array,0,)

        /*for (int i = 0; i < firstArray.length; i++) {
            firstArray[i]=array[firstIndex+i];
        }*/
        //midIndex with +1 is given, last index will be exclusive. i.e.,
        //Copy elements from index 2 (inclusive) to 5 (exclusive),it copies from index 2 to 4
        int[] firstArray = Arrays.copyOfRange(array, firstIndex, midIndex + 1);

        //copy data array2
        /*for (int i = 0; i < secondArray.length; i++) {
            secondArray[i]=array[midIndex+1+i];
        }*/
        int[] secondArray = Arrays.copyOfRange(array, midIndex + 1, lastIndex + 1);
        //Compare array1 and array2 data and place lowest one in original array
        int i = 0, j = 0;
        int k = firstIndex;
        while (i < firstArray.length && j < secondArray.length) {

            if (firstArray[i] < secondArray[j]) {
                array[k++] = firstArray[i++];
            } else {
                array[k++] = secondArray[j++];
            }
        }

        //Copy left over data into main array
        while (i < firstArray.length) {
            array[k++] = firstArray[i++];
        }
        while (j < secondArray.length) {
            array[k++] = secondArray[j++];
        }


    }

    public void divideArrayIntoTwoPartition(int[] array, int firstIndex, int lastIndex) {

        //condition to break recursive call
        if (!(firstIndex < lastIndex)) {
            return;
        }

        int midIndex = (firstIndex + lastIndex) / 2;
        divideArrayIntoTwoPartition(array, firstIndex, midIndex);
        divideArrayIntoTwoPartition(array, midIndex + 1, lastIndex);
        mergeDividedArrays(array, firstIndex, midIndex, lastIndex);


    }

    //Better soln
    public void mergeSort(int[] arr, int startingIndex, int lastIndex) {

        if (startingIndex < lastIndex) {
            int midIndex = (startingIndex + lastIndex) / 2;
            mergeSort(arr, startingIndex, midIndex);
            mergeSort(arr, midIndex + 1, lastIndex);
            merge(arr, Arrays.copyOfRange(arr, startingIndex, midIndex + 1), Arrays.copyOfRange(arr, midIndex + 1, lastIndex + 1), startingIndex);
        }
    }

    //Better soln
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
}
