package problemset4;

import java.util.ArrayList;

/*
Examples:

Input: mat[][] = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}}
Output: {{7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}}


Input: mat[][] = {{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11,12}
                             {13, 14, 15, 16}}
Output: {{13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}



 Determine row and column length


 //swap in circular approach
 Determine no of cycle - matrix.length/2
 Now swap the elements in circle. Repeat this based on no of cycles
 cycleCount=1
 while(cycleCount<=matrix.length/2)

   rowIndex=cycleCount-1;
   swapColumnIndex=matrix[0].length-cycleCount;
    pushRowElementsToColumn(rowIndex,swapColumnIndex)

rowIndex=matrix.length-cycleCount;
swapColumnIndex=matrix[0].length-cycleCount-1;
//increment each iteration to control loop execution
excludeColumn=0;
pushColumnElementsToRowUsingList(cycleCount,rowIndex,swapColumnIndex,matrix,excludeColumn)


rowIndex=matrix.length-cycleCount-1;
swapColumnIndex=excludeColumn;
pushRowElementsToColumnBottomToTopUsingList(rowIndex,swapColumnIndex,matrix,excludeColumn)



rowIndex=excludeColumn;
swapColumnIndex=cycleCount;
pushRowElementsToColumnBottomToTopUsingList(rowIndex,swapColumnIndex,matrix,excludeColumn)






 increment cycleCount
 increment excludeColumn







 //-----------------------------
 pushRowElementsToColumnLeftToRight(cycleCount,rowIndex,swapColumnIndex,matrix)

int columnIndex=cycleCount-1;
int swapRowIndex=cycleCount-1;
 for(swapIteration=cycleCount;swapIteration<=swapColumnIndex;swapIteration;swapIteration++){
     ArrayList.add(matrix[swapRowIndex][swapColumnIndex])
    matrix[swapRowIndex++][swapColumnIndex]=matrix[rowIndex][columnIndex++];
   }//end of for
   //store last column element before swap
    ArrayList.add(matrix[swapRowIndex][swapColumnIndex])

    //swap
    matrix[swapRowIndex][swapColumnIndex]=ArrayList.getFirst()
    //Remove already assigned data as there is no use of that element and also improve space complexity
   ArrayList. remove(0)


 }


//-----------------------------
 pushColumnElementsToRowUsingList(rowIndex,swapColumnIndex,matrix,excludeColumn){

 itr=swapColumnIndex-excludeColumn;
 while(itr>=0){

  list.add(matrix[rowIndex][swapColumnIndex]);
  matrix[rowIndex][swapColumnIndex]=list.getFirst();
  list.remove(0);

 swapColumnIndex--;
 itr--;
 }

 }



//-----------------------------
 pushRowElementsToColumnBottomToTopUsingList(rowIndex,swapColumnIndex,matrix,excludeColumn){

int  itr=rowIndex-excludeColumn;
while(itr>=0){


  list.add(matrix[rowIndex][swapColumnIndex]);
  matrix[rowIndex--][swapColumnIndex]=list.getFirst();
  list.remove(0);


 itr--;


}

}




//-----------------------------
 pushRowElementsToToprowBasedOnCycle(rowIndex,swapColumnIndex,matrix,excludeColumn){
int itr=matrix.length-cc-excludeColumn-1;
while(itr>=0){

 matrix[rowIndex][swapColumnIndex++]=list.getFirst();
 itr--;


}





 */
public class RotateImage90Degree {
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,}

        };

        int[][] arr2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };

        int[][] arr3 = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

        };
        int[][] arr4 = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}

        };

        int[][] arr5 = {{1, 2},
                {3, 4},


        };

        int[][] arr6 = {{1, 2},


        };


        RotateImage90Degree rotateObject = new RotateImage90Degree();
        // rotateObject.rotateMatrixBy90(arr);
        // rotateObject.rotateByCircularMotion(arr);
        rotateObject.rotateByCircularMotion(arr6);
    }

    int[][] pushTopRowElementsToColumn(int rowIndex, int swapColumnIndex, int cycleCount, int[][] matrix) {

        int columnIndex = cycleCount - 1;
        int swapRowIndex = cycleCount - 1;
        for (int pushIteration = cycleCount; pushIteration <= swapColumnIndex; pushIteration++) {
            list.add(matrix[swapRowIndex][swapColumnIndex]);
            matrix[swapRowIndex++][swapColumnIndex] = matrix[rowIndex][columnIndex++];
        }//end of for
        //store last column element before swap
        list.add(matrix[swapRowIndex][swapColumnIndex]);

        //push
        matrix[swapRowIndex][swapColumnIndex] = list.getFirst();
        //System.out.println("List data:"+list.toString());
        //Remove already assigned data as there is no use of that element and also improve space complexity
        list.removeFirst();

        return matrix;
    }

    int[][] pushColumnElementsToRowUsingList(int cycleCount, int rowIndex, int swapColumnIndex, int[][] matrix, int excludeColumn) {

        int itr = swapColumnIndex - excludeColumn;
        while (itr >= 0) {

            list.add(matrix[rowIndex][swapColumnIndex]);
            matrix[rowIndex][swapColumnIndex] = list.getFirst();
            // System.out.println("List data:"+list.toString());
            list.remove(0);

            swapColumnIndex--;
            itr--;
        }


        return matrix;
    }

    int[][] pushRowElementsToColumnBottomToTopUsingList(int rowIndex, int swapColumnIndex, int[][] matrix, int excludeColumn) {

        int itr = rowIndex - excludeColumn;
        while (itr >= 0) {


            list.add(matrix[rowIndex][swapColumnIndex]);
            matrix[rowIndex--][swapColumnIndex] = list.getFirst();
            // System.out.println("List data:"+list.toString());
            list.removeFirst();


            itr--;


        }

        return matrix;

    }

    int[][] pushColumnElementsToTopRowUsingList(int rowIndex, int swapColumnIndex, int[][] matrix, int excludeColumn, int cycleCount) {

        // int itr = matrix.length - cycleCount - excludeColumn - 2;
        int itr;
        if (cycleCount == 1) {
            itr = matrix.length - cycleCount - 2;
        } else {
            itr = matrix.length - cycleCount - excludeColumn - 1;
        }


        while (itr >= 0) {

            matrix[rowIndex][swapColumnIndex++] = list.getFirst();
            // System.out.println("List data:"+list.toString());
            list.removeFirst();
            itr--;


        }

        return matrix;
    }

    void rotateByCircularMotion(int[][] matrix) {


        int totalRows = matrix.length;
        int totalColumn = matrix[0].length;

        int totalCycles = matrix.length / 2;
        int cycleCount = 1;
        int rowIndex, swapColumnIndex, excludeColumn;
        printMatrix(matrix);
        excludeColumn = 0;
        while (cycleCount <= totalCycles) {

            //  System.out.println("start of Itr: "+cycleCount+"");
            // push top row elements to last column
            rowIndex = cycleCount - 1;
            swapColumnIndex = matrix[0].length - cycleCount;
            matrix = pushTopRowElementsToColumn(rowIndex, swapColumnIndex, cycleCount, matrix);
            //   System.out.println("- ----------------------");
            // printMatrix(matrix);

            // push last column elements to last row
            rowIndex = matrix.length - cycleCount;
            swapColumnIndex = matrix[0].length - cycleCount - 1;
            //increment excludeColumn, each iteration to control loop execution

            matrix = pushColumnElementsToRowUsingList(cycleCount, rowIndex, swapColumnIndex, matrix, excludeColumn);
            //  System.out.println("- ----------------------");
            //  printMatrix(matrix);


            // push last row elements to first column
            rowIndex = matrix.length - cycleCount - 1;
            swapColumnIndex = excludeColumn;
            matrix = pushRowElementsToColumnBottomToTopUsingList(rowIndex, swapColumnIndex, matrix, excludeColumn);
            //  System.out.println("- ----------------------");
            //  printMatrix(matrix);


            // push first column elements to first row
            rowIndex = excludeColumn;
            swapColumnIndex = cycleCount;
            matrix = pushColumnElementsToTopRowUsingList(rowIndex, swapColumnIndex, matrix, excludeColumn, cycleCount);
            //  System.out.println("- ----------------------");
            //  printMatrix(matrix);
            System.out.println("Itr" + cycleCount + " is completed");
            cycleCount++;
            excludeColumn++;

            list.clear();

        }


        System.out.println("After rotate");
        printMatrix(matrix);


    }

    void rotateMatrixBy90(int[][] matrix) {

        int totalRowsInMatrix = matrix.length;
        int totalColumnInMatrix = matrix[0].length;

        printMatrix(matrix);
        ArrayList<Integer> rotatedDataInList = new ArrayList<>();
        int rowIndex, columnIndex;
        for (int i = 0; i < totalRowsInMatrix; i++) {
            rowIndex = totalRowsInMatrix - 1;
            columnIndex = i;
            for (int j = 0; j < totalColumnInMatrix; j++) {

                rotatedDataInList.add(matrix[rowIndex][columnIndex]);
                rowIndex--;
            }
        }

        int listIndex = 0;
        for (int i = 0; i < totalRowsInMatrix; i++) {
            for (int j = 0; j < totalColumnInMatrix; j++) {
                matrix[i][j] = rotatedDataInList.get(listIndex++);

            }

        }


        rotatedDataInList.clear();
        //print matrix
        System.out.println("After rotation");
        printMatrix(matrix);

    }

    void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }
    }
}
