package problemset4;

import java.util.Arrays;

/*
Rotate an array to the right by k steps (e.g., [1,2,3,4,5] rotated by 2 becomes [4,5,1,2,3])
 */
public class RotateAnArrayByKtimes {

    public static void main(String[] args) {
        RotateAnArrayByKtimes objectRotateArray = new RotateAnArrayByKtimes();

        Arrays.stream(objectRotateArray.improvedSolution(new int[]{1, 2, 3, 4, 5}, 6)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.improvedSolution(new int[]{1, 2}, 3)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.improvedSolution(new int[]{1, 2, 3}, 2)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();



        /* Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2, 3, 4, 5}, 6)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2}, 3)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2,3}, 2)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1}, 2)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{}, 2)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2, 3, 4, 5,6,7,8,9,10}, 99)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2, 3, 4, 5,6,7,8,9,10}, 1)).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(objectRotateArray.rotateByK_Times(new int[]{1, 2, 3, 4, 5,6,7,8,9,10}, 10)).forEach(e -> System.out.print(e + "\t"));
*/
    }

    public int[] rotateByK_Times(int[] array, int k) {
        if (array.length == 0) {
            System.out.println("Empty array");
            return array;
        } else if (array.length == 1) {
            System.out.println("Array has single element, no need of rotation");
            return array;
        }

        k = k % array.length;
        int[] subArray = new int[k];

        int replaceIndexFromBottom = array.length - k;
        //  int noOfSwapIterations=replaceIndexFromBottom;
        int swapElementsFromIndex = replaceIndexFromBottom - 1;
        for (int i = 0; i < k; i++) {
            subArray[i] = array[replaceIndexFromBottom++];
        }


        int lastIndex = array.length - 1;
        while (swapElementsFromIndex >= 0) {
            array[lastIndex--] = array[swapElementsFromIndex--];
        }

        for (int j = 0; j < subArray.length; j++) {
            array[j] = subArray[j];
        }

        return array;
    }

    public void reverse(int[] arr, int startingIndex, int lastElement) {

        int temp;
        while (startingIndex < lastElement) {
            temp = arr[startingIndex];
            arr[startingIndex] = arr[lastElement];
            arr[lastElement] = temp;
            startingIndex++;
            lastElement--;
        }

    }

    public int[] improvedSolution(int[] array, int k) {

        int arrLength = array.length;

        k = k % arrLength;
        reverse(array, 0, arrLength - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, arrLength - 1);
        return array;

    }
}
