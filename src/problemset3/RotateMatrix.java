package problemset3;

public class RotateMatrix {


    public static void printMatrix(int[][] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

       /* int[][] array = {

                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12},{13,14,15,16}
        };*/

        /*int[][] array = {

                {1, 2}, {5, 6}

        };*/

       /* int[][] array = {

                {1, 2}

        };*/

       /* int[][] array = {

                {1, 2, 3}, {4,5, 6},
                {7,8,9},{10, 11, 12}
        };*/

       /* int[][] array = {

                {1, 2, 3, 4,21,31}, {5, 6, 7, 8,22,32},
                {9, 10, 11, 12,23,33},{13,14,15,16,24,34}
        };*/


       /* int[][] array = {
                {1, 2, 3, 4,21}, {5, 6, 7, 8,22},
                {9, 10, 11, 12,23},{13,14,15,16,24}
        };
*/
        /*int[][] array = {

                {1, 2, 3}, {4,5, 6},
                {7,8,9},{10, 11, 12},{13,14,15}
        };*/

        int[][] array = {

                {1, 2, 3, 4, 2, 3, 4, 5},
                {5, 6, 7, 8, 2, 3, 4, 4},
                {9, 1, 2, 4, 3, 6, 5, 4},
                {3, 4, 5, 6, 4, 4, 7, 8},
                {1, 2, 3, 4, 5, 6, 7, 8},
                {0, 8, 7, 6, 5, 4, 3, 2},
                {1, 2, 3, 4, 1, 2, 3, 4},
                {1, 4, 3, 4, 1, 6, 3, 4}
        };
        System.out.println("Before rotate");
        printMatrix(array);

        new RotateMatrix().rotate(array);

    }

    public int traverseMatrix(int[][] array, int row, int column, int currentNumber, String varyingElement, String movement, int length) {

        int nextNumber;
        int numberOfIteration = 1;


        /*if (varyingElement.equalsIgnoreCase("column")) {
          //  length = (array[0].length)-1;
            numberOfIteration = column;

                --numberOfIteration;

        } else {
          //  length = (array.length)-1;
            numberOfIteration = row;

                --numberOfIteration;

        }*/


        if (movement.equalsIgnoreCase("increment")) {
            while (numberOfIteration < length) {
                if (varyingElement.equalsIgnoreCase("column")) {

                    nextNumber = array[row][++column];
                    // numberOfIteration = column;
                } else {

                    nextNumber = array[++row][column];
                    //  numberOfIteration = row;
                }


                array[row][column] = currentNumber;
                currentNumber = nextNumber;
                numberOfIteration++;
            }


        } else {

            while (length > 1) {
                if (varyingElement.equalsIgnoreCase("column")) {

                    nextNumber = array[row][--column];
                    //  numberOfIteration = column;
                } else {

                    nextNumber = array[--row][column];
                    // numberOfIteration = row;
                }


                array[row][column] = currentNumber;
                currentNumber = nextNumber;
                --length;
            }

        }

        return currentNumber;

    }

    public void rotate(int[][] array) {

        int rowLength = array.length;
        int columnLength = array[0].length;

        if (rowLength <= 1) {
            System.out.println("Given matrix has lessa than or equal to 1 row, can't rotate");
            return;
        }

        //  System.out.println("Row length:" + rowLength);
        //  System.out.println("column length:" + columnLength);

        int currentNumber, nextNum;
        currentNumber = array[0][0];
        int cLength, rLength;
        for (int i = 0; i < (rowLength / 2); i++) {
            currentNumber = array[i][i];
            // cLength=(((columnLength)/(i+1)));
            cLength = columnLength - (i * 2);
            rLength = rowLength - (i * 2);

            // rLength=(((rowLength)/(i+1)));

            /*if(i==0){
                --cLength;
                --rLength;
            }

            if(((rowLength%2)==0 && i!=0)){
                --rLength;
            }

            if(((columnLength%2)==0)&& i!=0){
                --cLength;
            }
*/

            if (cLength != 1) {
                currentNumber = traverseMatrix(array, i, i, currentNumber, "column", "increment", cLength);

            /*printMatrix(array);
            System.out.println();*/
                currentNumber = traverseMatrix(array, i, columnLength - 1 - i, currentNumber, "row", "increment", rLength);

           /* printMatrix(array);
            System.out.println();*/
                currentNumber = traverseMatrix(array, rowLength - 1 - i, columnLength - 1 - i, currentNumber, "column", "decrement", cLength);
            /*printMatrix(array);
            System.out.println();*/
                currentNumber = traverseMatrix(array, rowLength - 1 - i, i, currentNumber, "row", "decrement", rLength);
            } else {
                System.out.println("Column length is one, can't rotate, encoutered iteration: " + i);
            }
          /* printMatrix(array);

            System.out.println();*/
        }
        System.out.println("After rotate");
        printMatrix(array);
    }


}




