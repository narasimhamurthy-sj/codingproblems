package datastructureset2;

public class RecursiveBinarySearch {

    //1,2,3,4,5

    public static void main(String[] args) {

        int mid = new RecursiveBinarySearch().findElement(new int[]{1, 2, 3, 4, 5}, 4, 0, 4);

        if (mid == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found position: " + (mid + 1));
        }
    }

    public int findElement(int[] arr, int searchKey, int firstElementIndex, int lastElementIndex) {

        if (arr.length == 0)
            return -1;

        if (firstElementIndex > lastElementIndex)
            return -1;

        int mid = (firstElementIndex + lastElementIndex) / 2;

        if (arr[mid] == searchKey)
            return mid;

        else if (searchKey < arr[mid])
            mid = findElement(arr, searchKey, 0, mid - 1);

        else
            mid = findElement(arr, searchKey, mid + 1, lastElementIndex);

        return mid;

    }
}
