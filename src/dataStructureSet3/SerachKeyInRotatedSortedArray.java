package dataStructureSet3;

/*
A sorted array like:
[0, 1, 2, 4, 5, 6, 7]
...is rotated at some pivot to become something like:
[4, 5, 6, 7, 0, 1, 2]

So it's partially sorted:
[4, 5, 6, 7] and [0, 1, 2] are individually sorted
But the full array is not sorted end-to-end


if the length of array is big, in some cases we can observe, half of the array
 is partially sorted and  remaining half completely sorted.

 Note: For any array, at least one of the half is always sorted.
 */
public class SerachKeyInRotatedSortedArray {

    public static void main(String[] args) {
        SerachKeyInRotatedSortedArray seaechObject = new SerachKeyInRotatedSortedArray();

        int[][] inputArr = {
                {5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4},
                {8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7}

        };
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println("Found at index: " + seaechObject.searchKey(8, inputArr[i]));
        }

    }

    public int searchKey(int key, int[] arr) {

        int startIndex = 0, lastIndex = arr.length - 1, midIndex;

        while (startIndex <= lastIndex) {
            midIndex = (startIndex + lastIndex) / 2;
            if (arr[midIndex] == key) {
                return midIndex;
            }

            //check left part is whether sorted. Compare mid element with first element
            //and should be lesser or equal to mid element to consider as sorted
            if (arr[startIndex] <= arr[midIndex]) {
                //Check search key present in sorted elemnts range
                if (arr[startIndex] <= key && key < arr[midIndex]) {
                    //shift searching on left part
                    lastIndex = midIndex - 1;
                } else {
                    // As key not present in sorted arr part, shift search on right part
                    startIndex = midIndex + 1;
                }
            } else {
                //Right part is sorted, check key present in the range
                if (arr[midIndex] < key && key <= arr[lastIndex]) {
                    //shift searching on right part
                    startIndex = midIndex + 1;
                } else {
                    //key is not present in sorted elements part
                    //Shift search back to left part
                    lastIndex = midIndex - 1;
                }
            }

        }
        //if key not found
        return -1;
    }
}

