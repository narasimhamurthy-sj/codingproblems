package repeatpractice;

import java.util.Arrays;

public class MSortPractice {

    public static void main(String[] args) {
        MSortPractice srt = new MSortPractice();
        int[] arr = {4, 3, 1, 2};
        srt.mSort(0, arr.length - 1, arr);
        Arrays.stream(arr).forEach(e -> System.out.println(e));
    }

    public void merge(int[] arr1, int[] arr2, int strtIndex, int[] originalArray) {

        int i = 0, j = 0;//k=strtIndex
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                originalArray[strtIndex++] = arr1[i++];
            } else {
                originalArray[strtIndex++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            originalArray[strtIndex++] = arr1[i++];
        }
        while (j < arr2.length) {
            originalArray[strtIndex++] = arr2[j++];
        }

    }

    public void mSort(int strtIndx, int lastIndx, int[] arr) {

        // if(strtIndx<lastIndx) {

        if (strtIndx == lastIndx)
            return;
        int mid = (strtIndx + lastIndx) / 2;
        mSort(strtIndx, mid, arr);
        mSort(mid + 1, lastIndx, arr);
        merge(Arrays.copyOfRange(arr, strtIndx, mid + 1), Arrays.copyOfRange(arr, mid + 1, lastIndx + 1), strtIndx, arr);
        //  }
    }
}
