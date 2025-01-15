package problemset4;


import java.util.*;

/*
 Input: nums = [1,1,1,2,2,3], k = 2;
 Output: [1, 2]

 Q1: if multiple frequent elements present,if k=1, do we need to print the element which has the most duplicate elements?
 Q2: if k=10 but only one frequent element present,in this case what should we print?
 Q3: if k=2 but no frequent repeating element present,what should we print as output?
 Q4: will input always be number or it could be other data type?






 */

public class FindK_FrequentElements {


    public static void main(String[] args) {


        FindK_FrequentElements frequentElementsObject = new FindK_FrequentElements();
       /* frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,1,1,2,2,3,3,4},3);

        //Multiple frequent elements present but k=1 is given
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,1,1,2,2,3,3,4},1);

        //k=1 is given but there is no frequent elemet
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,2,3,4},1);

        //k=0
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,1,1,2,2,3,3,4},0);

        //k=10 but Multiple frequent elements present are only  3
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,1,1,2,2,3,3,4},10);
        //Empty array
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{},1);
        //array elements not in sorted order
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{1,2,1,2,3,1,2,3,3,4},3);
        //array elements with -ve numbers
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{-1,2,-1,2,3,1,-2,-3,-3,4},3);
        // whole array with same element
        frequentElementsObject.printFrequentElementsBasedOnValue_k(new int[]{6,6,6,6,6,6,6,6},1);*/


//duplicate
        // frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,1,1,2,2,3,3,4},3);
        //many elements present in array but restricting k=3
        // frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,1,2,2,3,3,4},3);

        //starting with frequent and ending with non frequent
        // frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{6,6,6,1,1,2,2,3,3,4,10},3);

        //Combination of strating with non frequent, frequent, again unique followed by frequent
        // frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,2,3,4,4,4,4,4,5,5,5,6,8,8,8},3);

        //starting with non frequent elements followed by frequent elements
        //frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,2,3,4,4,4,4,4,5,5,5,6,8,8,8,90,90,90,89,9,9,9},10);

        //duplicate scenario
        //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,2,3,4},4);

        //all multiple frequency element with k!= elememts in array
        //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,1,2,2,3,3,4,4},10);

        // print all unique elements with different frequency
        // frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{5,1,1,2,2,10,3,3,4,4,6},7);

        //multiple different frequency along with unique frequency with k != elements in array
        //frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{5,5,1,1,1,1,2,2,2,2,10,10,3,3,3,3,4,4,4,4,6},20);

        //two elements in which one of them is multiple frequency
        //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,2,2},3);

        //different elements with single frequency
        //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1,2,3},1);
        //Single element with multiple frequency
      //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1, 1, 1, 1, 1, 1}, 1);
//single element with single frequency
      //  frequentElementsObject.printTopFrequentElementsBasedOnValue_k(new int[]{1}, 1);


       // frequentElementsObject.improvedTopKElmentSolution(new int[]{1, 1, 1, 1, 1, 1}, 1);
        frequentElementsObject.improvedTopKElmentSolution(new int[]{1,2,3,4,4,4,4,4,5,5,5,6,8,8,8,90,90,90,89,9,9,9},10);
    }





    public void improvedTopKElmentSolution(int[] inputArray,int k){

        HashMap<Integer,Integer> elementFrequencuMap=new HashMap<>();

        for(int element:inputArray){
            elementFrequencuMap.put(element,elementFrequencuMap.getOrDefault(element,0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> descendingSortedList=new ArrayList<>(elementFrequencuMap.entrySet());
        Collections.sort(descendingSortedList,(k1,k2)->{
            if(k1.getValue()== k2.getValue()){
                return k2.getKey()-k1.getKey();
            }else{
               return k2.getValue()-k1.getValue();
            }

        } );

        for (int descendingSortedListIndex = 0; descendingSortedListIndex <k && descendingSortedListIndex<descendingSortedList.size(); descendingSortedListIndex++) {

            System.out.println("key:"+descendingSortedList.get(descendingSortedListIndex).getKey()+" value:"+descendingSortedList.get(descendingSortedListIndex).getValue());
        }

    }
    public void printFrequencyElements(LinkedHashMap<Integer, Integer> descendingFrequencyMap, int k) {


        System.out.println("---------Element along with their frequency----------------");
        if (descendingFrequencyMap.size() <= 0) {
            System.out.println("Elements size is less than or equal to 0");
            return;
        }

        int printingCount = 1;

        boolean isFrequentElementPresent = false;
        TreeMap<Integer, Integer> sameFrequencyMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());


        Iterator<Integer> keyIterator = descendingFrequencyMap.keySet().iterator();
        int previousKey, previousValue, currentKeyElement, sameFrequencyKey, sameFrequencyValue;
        previousKey = previousValue = 0;
        Iterator<Integer> sameFrequencyIterator = null;

        if (keyIterator.hasNext()) {
            previousKey = keyIterator.next();
            previousValue = descendingFrequencyMap.get(previousKey);
        }


        if (descendingFrequencyMap.size() == 1) {
            System.out.println("Single element present");
            System.out.println("Key: " + previousKey + ", Value: " + previousValue);
            return;

        }

        outerloop:
        while (keyIterator.hasNext()) {

            if (printingCount <= k) {

                currentKeyElement = keyIterator.next();

                if (previousValue == descendingFrequencyMap.get(currentKeyElement)) {
                    sameFrequencyMap.put(previousKey, previousValue);
                    sameFrequencyMap.put(currentKeyElement, descendingFrequencyMap.get(currentKeyElement));

                } else {

                    if (!sameFrequencyMap.isEmpty()) {

                        sameFrequencyIterator = sameFrequencyMap.keySet().iterator();
                        while (sameFrequencyIterator.hasNext()) {
                            sameFrequencyKey = sameFrequencyIterator.next();
                            sameFrequencyValue = sameFrequencyMap.get(sameFrequencyKey);

                            if (printingCount <= k) {
                                System.out.println("Key: " + sameFrequencyKey + ", Value: " + sameFrequencyValue);
                                printingCount++;
                            } else {
                                break outerloop;
                            }
                        }//end of while

                        sameFrequencyMap.clear();

                    } else {
                        System.out.println("Key: " + previousKey + ", Value: " + previousValue);
                        printingCount++;
                    }
                }
                previousKey = currentKeyElement;
                previousValue = descendingFrequencyMap.get(currentKeyElement);


                if (printingCount <= k && printingCount == descendingFrequencyMap.size()) {
                    System.out.println("Key: " + previousKey + ", Value: " + previousValue);
                    printingCount++;
                }


            } else {
                break;
            }
        }//while outer loop

//sameFrequencyIterator!=null &&
        if ((!sameFrequencyMap.isEmpty())) {
            Iterator<Integer> frequencyIterator = sameFrequencyMap.keySet().iterator();
            while (frequencyIterator.hasNext()) {
                sameFrequencyKey = frequencyIterator.next();
                sameFrequencyValue = sameFrequencyMap.get(sameFrequencyKey);

                if (printingCount <= k) {
                    System.out.println("Key: " + sameFrequencyKey + ", Value: " + sameFrequencyValue);
                    printingCount++;
                } else {
                    break;
                }
            }//end of while
        }


        if (printingCount <= k) {
            System.out.println("Elements are not available in the array as that of k=" + k + " ");
        }


    }

    public void printTopFrequentElementsBasedOnValue_k(int[] inputArray, int k) {

        if (k <= 0) {
            System.out.println("K value is less than or equal 0. k should be grater than 0");
            return;
        }
        if (inputArray.length <= 0) {
            System.out.println("Input array is empty");
            return;
        }
        HashMap<Integer, Integer> elementWithTheirFrequencyMap = new HashMap<>();
        int frequencyCount = 1;
        for (int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++) {

            if (elementWithTheirFrequencyMap.containsKey(inputArray[arrayIndex])) {

                frequencyCount = elementWithTheirFrequencyMap.get(inputArray[arrayIndex]);
                ++frequencyCount;
                elementWithTheirFrequencyMap.put(inputArray[arrayIndex], frequencyCount);
            } else {

                elementWithTheirFrequencyMap.put(inputArray[arrayIndex], 1);
            }
        }//end of for loop
        List<Map.Entry<Integer, Integer>> mapDescendingList = new ArrayList<>(elementWithTheirFrequencyMap.entrySet());
        mapDescendingList.sort((mapValue1, mapValue2) -> mapValue2.getValue().compareTo(mapValue1.getValue()));

        LinkedHashMap<Integer, Integer> descendingFrequencyMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> listElement : mapDescendingList) {
            descendingFrequencyMap.put(listElement.getKey(), listElement.getValue());
        }
        System.out.println("Stored elements");
        descendingFrequencyMap.forEach((k1, v) -> System.out.println("key:" + k1 + " value:" + v));


        printFrequencyElements(descendingFrequencyMap, k);


    }//end of method

    public void printFrequentElementsBasedOnValue_k(int[] inputArray, int k) {

        if (k <= 0) {
            System.out.println("K value is less than or equal 0. k should be grater than 0");
            return;
        }
        if (inputArray.length <= 0) {
            System.out.println("Input array is empty");
            return;
        }
        HashMap<Integer, Integer> elementWithTheirFrequencyMap = new HashMap<>();
        int frequencyCount = 1;
        for (int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++) {

            if (elementWithTheirFrequencyMap.containsKey(inputArray[arrayIndex])) {

                frequencyCount = elementWithTheirFrequencyMap.get(inputArray[arrayIndex]);
                ++frequencyCount;
                elementWithTheirFrequencyMap.put(inputArray[arrayIndex], frequencyCount);
            } else {

                elementWithTheirFrequencyMap.put(inputArray[arrayIndex], 1);
            }
        }//end of for loop
        List<Map.Entry<Integer, Integer>> mapDescendingList = new ArrayList<>(elementWithTheirFrequencyMap.entrySet());
        mapDescendingList.sort((mapValue1, mapValue2) -> mapValue2.getValue().compareTo(mapValue1.getValue()));

        LinkedHashMap<Integer, Integer> descendingFrequencyMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> listElement : mapDescendingList) {
            descendingFrequencyMap.put(listElement.getKey(), listElement.getValue());
        }
        // descendingFrequencyMap.forEach((k,v)-> {System.out.println("key:"+k+" value:"+v)});

        System.out.println("---------Element along with their frequency----------------");

        int printingCount = 1;

        boolean isFrequentElementPresent = false;
        for (Map.Entry<Integer, Integer> mapElement : descendingFrequencyMap.entrySet()) {

            if (printingCount <= k) {

                if (mapElement.getValue() > 1) {
                    System.out.println("Key: " + mapElement.getKey() + ", Value: " + mapElement.getValue());
                    isFrequentElementPresent = true;

                } else {
                    System.out.println("Frequent values are not equal to  " + "k= " + k);
                    break;
                }
            } else {
                break;
            }

            printingCount++;
        }
        if (!isFrequentElementPresent) {
            System.out.println("Any Frequent Element not Present");
        }


    }//end of method

}
