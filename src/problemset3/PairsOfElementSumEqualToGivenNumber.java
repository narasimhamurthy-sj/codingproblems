package problemset3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static java.lang.Math.abs;

/*
{-10,-2,5,6,1,12}

n-12   (11,1,10,2,9,3,8,4,7,5,6,6,)

Take first element
check whether greater than given num,if so,go for next element
take complement-   10-12  =2 (negate)
Take next num
check nextnum <=complement
    check first+nextElement == givenNum
    iif so, print pair
//- -   -   -   -       -   -   --      -   -   --
1.  +ve case check various num which sums to given num
2. Try the same for -ve sum and num
3. Try for sum doesnt exists with given num
4. Try to put same num which sums up to given num {1,2,1,2,1,2}  givn num=3;
5.match pair present at 1st element and last element (To check conditions written properly and executing till end of array)
6. match pair present at last but second element and last element
7. Empty array
8. Array with single element







 */
public class PairsOfElementSumEqualToGivenNumber {


    public static HashMap<Integer,Integer> findPairsOfElementInArray(int[] inputArray,int givenNum){

        int complement;
        int[][] matchedPairsArray=new int[inputArray.length*4][2];
        int row=0;
        int column=0;
        HashMap<Integer,Integer> pairs=new HashMap<>();

        for (int indexOfOuterLoop = 0;  indexOfOuterLoop<inputArray.length-2 ; indexOfOuterLoop++) {

            if(inputArray[indexOfOuterLoop]>0) {
                if (inputArray[indexOfOuterLoop] >= givenNum) {
                    System.out.println("Element is greater than or equal to given num:" + inputArray[indexOfOuterLoop]);
                    continue;
                }
            }
            complement=Math.abs(inputArray[indexOfOuterLoop]-givenNum);

            for (int innerLoop = indexOfOuterLoop+1; innerLoop < inputArray.length-1; innerLoop++) {

                if(inputArray[innerLoop]<=complement){

                    if(inputArray[indexOfOuterLoop]+inputArray[innerLoop]==givenNum){

                        pairs.put(inputArray[indexOfOuterLoop],inputArray[innerLoop]);
                        matchedPairsArray[row][column]=inputArray[indexOfOuterLoop];
                        matchedPairsArray[row][column+1]=inputArray[innerLoop];
                        row++;

                    }
                }

            }

        }

        if(pairs.isEmpty()){
            System.out.println("No pairs");
        }else {
          //  pairs.forEach((k, v) -> System.out.println("(" + k + ", " + v + ")"));



            Arrays.stream(matchedPairsArray).forEach((printRowise)->{
                Arrays.stream(printRowise).forEach(element-> System.out.print(element+" "));
                System.out.println();
            });
        }

        return pairs;

    }

    // o(n) approach but some pairs of data is missing
    ///Ex new int[]{0,-1,2,1,-1,-2},-3)  o/p:(-2 -1)

    public static void usingHashSetApproach(int[] inputarray,int givenNumber){

        HashSet<Integer> arrayDataInSet=new HashSet<>();

        int complement;
        boolean isPairFound=false;
        for (int arrayElement: inputarray){
            complement=givenNumber-arrayElement;
            if(arrayDataInSet.contains(complement)){
                System.out.println("("+arrayElement+" "+complement+")");
                isPairFound=true;
            }
            arrayDataInSet.add(arrayElement);
        }
        if(!isPairFound){
            System.out.println("noPairFound");
        }
    }

    //n(logn) approach
    // in case of duplicate elements fails to identify all combinations
    //new int[]{2,2,2,2,2,2}

    public static void twoPointerApproach(int[] inputArray,int givenNum){
        Arrays.sort(inputArray);
        int startingIndex=0;
        int lastIndex=inputArray.length-1;

        while(startingIndex<lastIndex){

            if(inputArray[startingIndex]+inputArray[lastIndex]==givenNum){
                System.out.println("("+inputArray[startingIndex]+", "+inputArray[lastIndex]+")");
                startingIndex++;
                lastIndex--;
            }
            else if(inputArray[startingIndex]<givenNum){
                startingIndex++;
            }else{
                lastIndex--;
            }
        }




    }
    public static void main(String[] args) {
       // findPairsOfElementInArray(new int[]{0,1,2,1,2,-1,2,1,2,1,2},2);
        //usingHashSetApproach(new int[]{0,-1,2,-1,-2,1,2,-1,-2},-3);
      //  twoPointerApproach(new int[]{0,-1,2,-1,-2,1,2,-1,-2},-3);

        twoPointerApproach(new int[]{2,2,2,1,2,3},4);
    }
}
