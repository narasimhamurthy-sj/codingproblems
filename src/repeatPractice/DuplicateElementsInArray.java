package repeatPractice;

import java.util.HashMap;

public class DuplicateElementsInArray {

    public static HashMap<Integer,Integer> findDuplicateElementsInArray(int[] array){

        HashMap<Integer,Integer> storeDuplicateCountInMap=new HashMap<>();
        HashMap<Integer,Integer> duplicateElementsMap=new HashMap<>();
        int count=1;

        for(int arrayElement: array){

            if(storeDuplicateCountInMap.containsKey(arrayElement)){
                count=storeDuplicateCountInMap.get(arrayElement);
                count++;
            }
            storeDuplicateCountInMap.put(arrayElement,count);
            count=1;
        }
        storeDuplicateCountInMap.forEach((element,elementCount)->{
            if(elementCount>1){
                System.out.println("Element:"+element+" count:"+elementCount);
                duplicateElementsMap.put(element,elementCount);
            }
        });

        return duplicateElementsMap;
    }


    public static void main(String[] args) {
        findDuplicateElementsInArray(new int[]{1,2,3,2,2,3,6,1});
    }
}
