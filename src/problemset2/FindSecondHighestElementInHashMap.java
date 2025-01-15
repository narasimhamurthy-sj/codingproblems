package problemset2;

import java.util.HashMap;

/*
k1 10
k2 2
k3 50
k4 25

h=10, sh=10
h=10   sh=2

h=50
check prev h> sh  ---> sh=10


h=50          sh:   check nextnum>sh  -->sh=nextNum
----    --- -   -   -   -       -   -   -   -   -   -   --      -   -   -   -

1. unsored map
2. sorted map
3.empty map or null object
4. All are duplicate elements
5. -ve values in map
6. single element in map
7. map wwith descending order elements
8. Except first elements, all are duplicates
9.Except last elemnet, all are duplicate
10.Except mid elemnet, all are duplicate
-__     -   --  ------- --  -       -   -   -   -   -  --  -------

k1 10
k2 8
k3 6
k4 4

-   -   -   -       -   -   -   -   -   -   -   -   -   -   -   -   -   -

1. store first hashmap k,v in integer variables firstHighest ans secondHighest
2.start iterating map elements
    2.1 IF mapElement is greater than firsthighest
            -check firstHighest is greater than secondHoghest
              store secondHoghest=firsthighest

        Now store firsthighest as mapElement
    2.1 Else
         2.11 To handle descending elements in map, maintain descendingElements count
            also store secondElement as it will be second highest in descending elements

         2.12   Check whether mapElement is greater than second highest
                - make second highest as mapElement
            Else
            increase descendingElements count

3. IF given map elements are in descending order, print secondElement from 2.11 as second highest
   Else
   print computed secondHighest

 */
public class FindSecondHighestElementInHashMap {


    public static int findSecondHighestElement(HashMap<Integer, Integer> givenMap) {
        int firstHighest;
        int secondHighest;
        int keyForSecondHighest;
        int keyForFirstHighest;
        int descendingCount=1;
        int secondElement=0;
        int secondElementKey=0;


        firstHighest = secondHighest = givenMap.entrySet().iterator().next().getValue();
        keyForFirstHighest = keyForSecondHighest = givenMap.entrySet().iterator().next().getKey();
        int k, v;
        for (HashMap.Entry<Integer, Integer> entry : givenMap.entrySet()) {
            k = entry.getKey();
            v = entry.getValue();

            if (v > firstHighest) {
                if (firstHighest > secondHighest) {
                    secondHighest = firstHighest;
                    keyForSecondHighest = keyForFirstHighest;
                }
                firstHighest = v;
                keyForFirstHighest = k;
            } else {
                if(descendingCount==2){
                    secondElement=v;
                    secondElementKey=k;
                }
                if (v > secondHighest) {
                    secondHighest = v;
                    keyForSecondHighest = k;
                }else{
                    descendingCount++;
                }
            }
        }
        if((descendingCount-1)==givenMap.size()){
            System.out.println("\nSecond Highest Key:" + secondElementKey + " Value:" + secondElement);
        }else {
            System.out.println("\nSecond Highest Key:" + keyForSecondHighest + " Value:" + secondHighest);
        }

        return secondHighest;
    }

    //simplest approach
    public static Integer findSecondHighest(HashMap<Integer, Integer> map) {
        Integer highest = Integer.MIN_VALUE;
        Integer secondHighest = Integer.MIN_VALUE;

        System.out.println("highest"+highest);
        System.out.println("secondHighest"+secondHighest);

        for (Integer value : map.values()) {
            if (value > highest) {
                secondHighest = highest;
                highest = value;
            } else if (value > secondHighest && value != highest) {
                secondHighest = value;
            }
        }

        System.out.println("Second Highest:"+secondHighest);
        return secondHighest;
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
       /* map.put(1, 10);
        map.put(2, 9);
        map.put(3, 8);
        map.put(4, 7);
*/

        map.put(1, -1);
        map.put(2, -2);
        map.put(3, -3);
        map.put(4, -4);
       // map.put(5, 20);
        // map.put(5,5);

      //  findSecondHighestElement(map);

        findSecondHighest(map);
    }
}
