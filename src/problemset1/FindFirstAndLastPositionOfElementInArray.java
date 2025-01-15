package problemset1;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInArray {
/*
input 1: 1,2,3,4,4,5
    [3,4]
input 2: 1,2,3,3,3,3,4
    [2,5]

input 3: single target element(Expected?)
1,2,3,3,3,3,5  T:5
    []

input 4: All target elementa are same
3,3,3,3,3,3  T:3
    [0,5]
Input 5: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


Input 6: nums = [], target = 0
Output: [-1,-1]

 */



    public static int[] findFirstAndLastPosition(int[] inputArray,int target){

         Integer[] inputArrObj=new Integer[inputArray.length];
        for (int i = 0; i <inputArray.length ; i++) {
            inputArrObj[i]=inputArray[i];
        }
        if(inputArray.length==0){
            System.out.println("Empty array");
            return new int[] {-1,-1};
        }
        ArrayList<Integer> arrayAsList=new ArrayList(Arrays.asList(inputArrObj));

        return new int[]{arrayAsList.indexOf(target),arrayAsList.lastIndexOf(target)};

    }


    public int[] indexOfFirstAndLastPosition(int[] arr,int target){

        int firstPosition=findPositionViaBinarySearch(arr,target,true);
        System.out.println("firstPosition:"+firstPosition);
        if(firstPosition==-1){
            return new int[]{-1,-1};
        }
        int lastPosition=findPositionViaBinarySearch(arr,target,false);
        System.out.println("lastPosition:"+lastPosition);

        return new int[]{firstPosition,lastPosition};


    }

    public static int findPositionViaBinarySearch(int[] inputArray, int target, boolean isFirstOccuranceSearch){

        int leftIndex=0;
        int rightIndex=inputArray.length-1;
        int position=-1;
        int mid;

        while(leftIndex<=rightIndex){

            mid=(leftIndex+rightIndex)/2;

            if(isFirstOccuranceSearch){

                if(inputArray[mid]>=target){
                    rightIndex=mid-1;
                    if(inputArray[mid]==target){
                        position=mid;
                    }
                }else{
                    leftIndex=mid+1;
                }
            }else{
                //last position of element search

                if(inputArray[mid]<=target){
                    leftIndex=mid+1;
                    if(inputArray[mid]==target){
                        position=mid;
                    }
                }else{
                    rightIndex=mid-1;
                }
            }
        }

        return position;
    }
    public static void main(String[] args) {

       // Arrays.stream(findFirstAndLastPosition(new int[]{3,3,3,3,3,3},3)).forEach(element->System.out.println(element));

       // new FindFirstAndLastPositionOfElementInArray().searchRange(new int[]{3,3,3,3,3,3},3)

        Arrays.stream(new FindFirstAndLastPositionOfElementInArray().indexOfFirstAndLastPosition(new int[]{2,2,2,3,3,4,4},4)).forEach(element->System.out.println(element));

    }
}
