package datastructure;

import java.util.Arrays;

public class MergeSort {


    private void mergeArrays(int[] array,int firstIndex,int midIndex,int lastIndex){

        int n1=midIndex-firstIndex+1;
        int n2=lastIndex-midIndex;
        int[] leftPartArray=new int[n1];
        int[] rightPartArray=new int[n2];

       // int startingIndex=firstIndex;
        for (int i = 0; i <n1 ; ++i)
            leftPartArray[i]=array[firstIndex + i];

       //  startingIndex=midIndex+1;
        for (int j = 0; j<n2 ; ++j)
            rightPartArray[j]=array[midIndex + 1 + j];

        int i=0,j=0;

        int k=firstIndex;
        while (i<n1 && j<n2){

            if(leftPartArray[i]<=rightPartArray[j]){

                array[k]=leftPartArray[i];
                i++;
            }else{
                array[k]=rightPartArray[j];
                j++;

            }
            k++;
        }

        while(i<n1){
            array[k]=leftPartArray[i];
            i++;
            k++;
        }

        while(j<n2){
            array[k]=rightPartArray[j];

            j++;
            k++;
        }

    }


    private void divideArrayIntoTwoParts1(int[] array,int left,int right){

        if(!(left<right)) {
            return;
        }

            int midIndex = (left + right) / 2;
            divideArrayIntoTwoParts1(array, left, midIndex);
            divideArrayIntoTwoParts1(array,midIndex+1, right);
            mergeArrays(array, left, midIndex, right);

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

    // Main function that sorts array[left...right] using merge()
    private void sort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Utility function to print the array
    private static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();


    }




    public void mergeDividedArrays(int[] array,int firstIndex,int midIndex,int lastIndex){

        //array1 till mid index
      //  int[] firstArray=new int[midIndex-firstIndex+1];
        //array2 after mid index
   //     int[] secondArray=new int[lastIndex-midIndex];

        //Copy data array1
     //   Arrays.copyOfRange(array,0,)

        /*for (int i = 0; i < firstArray.length; i++) {
            firstArray[i]=array[firstIndex+i];
        }*/
        int[] firstArray= Arrays.copyOfRange(array,firstIndex,midIndex+1);

        //copy data array2
        /*for (int i = 0; i < secondArray.length; i++) {
            secondArray[i]=array[midIndex+1+i];
        }*/
        int[] secondArray= Arrays.copyOfRange(array,midIndex+1,lastIndex+1);
        //Compare array1 and array2 data and place lowest one in original array
        int i=0,j=0;
        int k=firstIndex;
        while(i<firstArray.length && j<secondArray.length){

            if(firstArray[i]<secondArray[j]){
                array[k++]=firstArray[i++];
            }else{
                array[k++]=secondArray[j++];
            }
        }

        //Copy left over data into main array
        while(i<firstArray.length){
            array[k++]=firstArray[i++];
        }
        while(j<secondArray.length){
            array[k++]=secondArray[j++];
        }


    }
public void divideArrayIntoTwoPartition(int[] array, int firstIndex,int lastIndex){

        //condition to break recursive call
        if(!(firstIndex<lastIndex)){
            return;
        }

        int midIndex=(firstIndex+lastIndex)/2;
        divideArrayIntoTwoPartition(array,firstIndex,midIndex);
        divideArrayIntoTwoPartition(array,midIndex+1,lastIndex);
        mergeDividedArrays(array,firstIndex,midIndex,lastIndex);


}






    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
       // int[] arr={5,4,3,2,1};
       // int[] arr={10,1,9,2,8,3,7,4,6,5};
        int[] arr={1,1,6,8,8,2,2,3,4,5,6,7,8,9,0};
     //   int[] arr={10,1,9,2,6};
        /*mergeSort.divideArrayIntoTwoParts1(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(data->System.out.print(data+"  "));*/
      //  printArray(arr);

       /* mergeSort.sort(arr,0,arr.length-1);
        System.out.println("\nSorted array");
        printArray(arr);*/

        mergeSort.divideArrayIntoTwoPartition(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(data->System.out.print(data+"  "));

    }
}
