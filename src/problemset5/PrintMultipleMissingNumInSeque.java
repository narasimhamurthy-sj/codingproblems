package problemset5;

import java.util.ArrayList;
import java.util.List;

/*
1,2,6,7,10,11,15
Missing num=3,4,5,   8,9,   12,13,14

in loop:
check i value not equal to array value
while(i< arrayVal){
i++;
 print i and add in list

}

 */
public class PrintMultipleMissingNumInSeque {


    public static void main(String[] args) {
        PrintMultipleMissingNumInSeque missingNumObject = new PrintMultipleMissingNumInSeque();
        // missingNumObject.findMissingNum(new int[]{1,2,6,7,10,11,15});

        ArrayList<Integer> startNumList = new ArrayList<>();

        int[][] inputArr = {
                {1, 2, 6, 7, 10, 11, 15},
                {1, 6, 11, 15},
                {1, 100, 200},
                {1100, 1200}

        };
        startNumList.add(1);
        startNumList.add(1);
        startNumList.add(1);
        startNumList.add(1000);
        for (int i = 0; i < inputArr.length; i++) {

            missingNumObject.findMissingNum(inputArr[i], startNumList.get(i));
            System.out.println();
        }
    }

    public List<Integer> findMissingNum(int[] array, int startNum) {

        int count = startNum;
        ArrayList<Integer> missingList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {

            if (array[i] != count) {

                while (count < array[i]) {

                    System.out.print(count + "  ");
                    missingList.add(count);
                    count++;
                }
            }
            count++;
        }
        return missingList;
    }


}
