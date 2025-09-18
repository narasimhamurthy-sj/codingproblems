package problemset5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a collection of intervals, where each interval is represented as a pair of integers:
[start, end], indicating the start and end of an interval.

Your task is to merge all overlapping intervals and return an array of the non-overlapping
 intervals that cover all the intervals in the input.
 Input:
 intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output:
 [[1,6],[8,10],[15,18]]
Approach:
As array intervals can be present in any order, sort the array based on row.
Ex:{{4,5},{2,3},{1,2}} after sort:{{1,2},{2,3},{4,5}}
Initialize currentArr with first array
Start loop from second array as we have already first array with currentArr
 Compare currentArr(first arr) and nextArr(from loop)
 To determine merging intervals,
 Check nextArr first element <= last Elemnt of currentArr.
   Sometimes nextArr can be lesser range or that range could be covered by firstArr.Ex: {1,10},{6,8}
   Hence Check the condition,
   nextArr last elemnt > currentArr last Elemnt.
    If above conditions holds good, then merge the intervals
  END Loop


 */
public class MergeIntervals {

    public Integer[][] mergeIntervalsAmongArrays(Integer[][] inputArrays){

        Arrays.sort(inputArrays, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println("Input sorted array: "+Arrays.deepToString(inputArrays));
        //Make first array as current array
        Integer[] currentArray=inputArrays[0];
        Integer[] nextArray;
        Integer[][] mergedArray=new Integer[inputArrays.length][2];
        int mergedArrayIndex=0;
        boolean isLastArrMergable=false;
        //start the loop from 2nd array
        for (int i = 1; i < inputArrays.length; i++) {
            nextArray=inputArrays[i];
            //compare current array and next array.To merge, first element of nextArr should be <= last element of currentArr
            if(nextArray[0]<=currentArray[currentArray.length-1]){
                //if nextArr interval range lesser than currentArr i.e., nextArr interval range covered by currentArr itself. Ex:[1,6][2,4]
                //Hence check last element of nextArr should be > last element of currentArr
                if (nextArray[nextArray.length-1]>currentArray[currentArray.length-1]){
                    currentArray= new Integer[]{currentArray[0],nextArray[nextArray.length-1]};
                }
            }else{
                //after comparing arrays, no mergeable intervals not found. Hence add currentArr in final mergedArr
                //Make nextArr as currentArr
                mergedArray[mergedArrayIndex]=currentArray;
                mergedArrayIndex++;
                currentArray=nextArray;
            }

        }
      //Add last element in mergedArray. It can be either merged arr or distinct arr at the end
            mergedArray[mergedArrayIndex]=currentArray;

        return mergedArray;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to hold merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Iterate through the intervals
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add next interval
                current = interval;
                merged.add(current);
            }
        }

        // Step 4: Convert List to 2D array
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {

        ArrayList<Integer[][]> inputArrayList=new ArrayList<>();
        inputArrayList.add(new Integer[][]{ {1,3},{2,6},{8,10},{15,18}});
        inputArrayList.add(new Integer[][]{ {1,6},{2,6},{8,10},{15,18}});
        inputArrayList.add(new Integer[][]{ {1,6},{1,6},{1,6},{1,6}});
        inputArrayList.add(new Integer[][]{ {1,6},{6,6},{8,10},{15,18}});
        inputArrayList.add(new Integer[][]{ {1,6},{6,7},{1,7},{8,10},{1,8}});
        inputArrayList.add(new Integer[][]{ {1,3},{5,7},{8,10},{11,14},{15,20}});
        inputArrayList.add(new Integer[][]{ {1,20},{1,15},{1,10},{1,5},{1,2}});
        inputArrayList.add(new Integer[][]{ {1,20}});

        ArrayList<int[][]> inputArrayList2=new ArrayList<>();
        inputArrayList2.add(new int[][]{ {1,3},{2,6},{8,10},{15,18}});
        inputArrayList2.add(new int[][]{ {1,6},{2,6},{8,10},{15,18}});
        inputArrayList2.add(new int[][]{ {1,6},{1,6},{1,6},{1,6}});
        inputArrayList2.add(new int[][]{ {1,6},{6,6},{8,10},{15,18}});
        inputArrayList2.add(new int[][]{ {1,6},{6,7},{1,7},{8,10},{1,8}});
        inputArrayList2.add(new int[][]{ {1,3},{5,7},{8,10},{11,14},{15,20}});
        inputArrayList2.add(new int[][]{ {1,20},{1,15},{1,10},{1,5},{1,2}});
        inputArrayList2.add(new int[][]{ {1,20}});
        MergeIntervals merge=new MergeIntervals();
        /*for (Integer[][] array:inputArrayList) {
            Integer[][] mergedArr = merge.mergeIntervalsAmongArrays(array);
            System.out.println(Arrays.deepToString(mergedArr));
        }*/

        for (int[][] array:inputArrayList2) {
            int[][] mergedArr = merge(array);
            System.out.println(Arrays.deepToString(mergedArr));
        }


    }
}
