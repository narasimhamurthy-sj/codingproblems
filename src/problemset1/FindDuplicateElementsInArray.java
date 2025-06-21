package problemset1;


import java.util.*;

/*
Is it for numerics or String? or both

Input: 1,2,1,3,3,4,1
o/p: duplicate
1.Take first element and check any duplicate present in subsequent array index
2. Break the loop if duplicate element encountered


 */
public class FindDuplicateElementsInArray {


    public static HashSet<Integer> isArrayDuplicate(Integer[] array) {

        boolean isDuplicate = false;
        HashSet<Integer> duplicateElementsList = new HashSet<Integer>();
        HashMap<Integer, Integer> duplicateElementDetails = new HashMap<Integer, Integer>();
        ArrayList<Integer> arrAsList = new ArrayList<Integer>(Arrays.asList(array));

        System.out.println("Array : " + arrAsList);

        for (int arrIndex = 0; arrIndex < arrAsList.size(); ) {

            Integer elementToBeCheckedForDuplicate = (Integer) arrAsList.remove(arrIndex);
            //  System.out.println("elementToBeCheckedForDuplicate : " + elementToBeCheckedForDuplicate);

            if (!arrAsList.isEmpty()) {
                int duplicateOcuurance = 1;

                while (arrAsList.contains(elementToBeCheckedForDuplicate)) {
                    duplicateOcuurance++;
                    arrAsList.remove(elementToBeCheckedForDuplicate);
                    //  System.out.println("duplicate element: " + elementToBeCheckedForDuplicate + " Occurance: " + duplicateOcuurance);
                    duplicateElementsList.add(elementToBeCheckedForDuplicate);
                    duplicateElementDetails.put(elementToBeCheckedForDuplicate, duplicateOcuurance);

                }
            }
        }


        duplicateElementDetails.forEach((key, value) -> System.out.println("Duplicate element: " + key + ", Occurance: " + value));
        return duplicateElementsList;
    }


    public static HashSet<Integer> efficientWayToFindDuplicateElements(Integer[] array) {

        HashSet<Integer> storeIdentifiedDuplicatesInSet = new HashSet<>();
        HashSet<Integer> storeUniqueArrayElements = new HashSet<>();

        HashMap<Integer, Integer> duplicateElementsAndOccurances = new HashMap<>();

//        for (Integer arrayElement : array) {
//            if (!storeUniqueArrayElements.add(arrayElement)) {
//                storeIdentifiedDuplicatesInSet.add(arrayElement);
//            }
//
//        }


        Arrays.stream(array)
                .forEach(arrayElement -> {

                    if (!storeUniqueArrayElements.add(arrayElement)) {

                        storeIdentifiedDuplicatesInSet.add(arrayElement);

                    }
                });


        System.out.println("Duplicate:" + storeIdentifiedDuplicatesInSet);
        return storeIdentifiedDuplicatesInSet;
    }

    public static boolean findDuplicatesinArrayUsingMap(Integer[] array) {

        HashMap<Integer, Integer> elementsWithOccurance = new HashMap<>();
        int occuranceCount = 1;
        for (Integer arrayElement : array) {

            // elementsWithOccurance.put(arrayElement,)
            if (elementsWithOccurance.containsKey(arrayElement)) {
                occuranceCount = elementsWithOccurance.get(arrayElement);
                occuranceCount++;

            }
            elementsWithOccurance.put(arrayElement, occuranceCount);
            occuranceCount = 1;
        }

        boolean isDuplicateAbsent = false;
        for (Map.Entry<Integer, Integer> entry : elementsWithOccurance.entrySet()) {

            if (entry.getValue() > 1) {
                isDuplicateAbsent = true;
                System.out.println("Duplicate Element:" + entry.getKey() + " Duplicate Count:" + entry.getValue());


                // elementsWithOccurance.get(1).
            }
        }

        return isDuplicateAbsent;
    }

    public static void main(String[] args) {

        /*
        1,2,3,4,1
        1,2,3,4,5
        1,2,2,3,4
        1,2,3,4,4
        1,1,1,1,1

        1,2,3,3,4

For finding dup elements:
1,1,2,2,3,3,1,1,1
 1,1,1,1,1
 1,2,3,4,5
 1,2,3,4,1
  1,2,2,3,4
1,2,3,4,4
01,2,1,3,04,4


         */

        //  HashSet<Integer> list=isArrayDuplicate( new Integer []{ 01,2,1,3,04,4});
       /* HashSet<Integer> list=efficientWayToFindDuplicateElements( new Integer []{ 1,2,1,3,4,4});
      if( list.isEmpty()){
           System.out.println("Array doesn't have duplicate element ");
       }else{

          System.out.println("duplicate element "+list);
      }*/

        if (!findDuplicatesinArrayUsingMap(new Integer[]{1, 2, 2, 3, 4}))
            System.out.println("Array doesn't have duplicate element ");
    }
}
