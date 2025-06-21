package problemset5;

/*
{9,4,10,3,12,9}
min=3, max=12

initialize min and max with first num

in loop, go to next num
compare if it's less than min value,reassign it to min
compare if it's greater than max value,reassign it to max
 */
public class FindMinAndMaxValueInUnsortedArr {

    public static void main(String[] args) {
        FindMinAndMaxValueInUnsortedArr findMinMaxObject = new FindMinAndMaxValueInUnsortedArr();
        int[][] inputArr = {
                {9, 4, 10, 3, 12, 9},
                {19, 4, 10, 3, 12, 1},
                {1, 4, 10, 3, 12, 19},
                {1, 19, 1, 19, 1, 19},
                {1, 1, 1, 1},
                {1, 1, 1, 1, 0, 12, 3, 4},
                {1, 1, 1, 1, 0, 12, -3, -4},
                {-1, -2, -3, -4, -5}

        };
        for (int i = 0; i < inputArr.length; i++) {
            findMinMaxObject.printMinAndMaxValue(inputArr[i]);
        }
    }

    public void printMinAndMaxValue(int[] inputArray) {
        int min = inputArray[0], max = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {

            if (inputArray[i] < min) {
                min = inputArray[i];
            }
            if (inputArray[i] > max) {
                max = inputArray[i];
            }
        }

        System.out.println("min:" + min + " max:" + max);
    }

}
