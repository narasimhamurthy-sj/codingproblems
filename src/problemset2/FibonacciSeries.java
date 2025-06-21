package problemset2;


/*
1,2,3,5,8,13

 */
public class FibonacciSeries {
    boolean isFirstRecursiveCall = true;

    public static void generateFibonacciSeries(int firstNumber, int secondNumber, int countOfNumbersToGenerate) {

        if (countOfNumbersToGenerate <= 2) {
            System.err.println("countOfNumbersToGenerate should be more than two");
            return;
        }
        System.out.print(firstNumber + " " + secondNumber);
        int count = 2, fibonacciNumber;

        while (count < countOfNumbersToGenerate) {
            fibonacciNumber = firstNumber + secondNumber;
            System.out.print(" " + fibonacciNumber);
            firstNumber = secondNumber;
            secondNumber = fibonacciNumber;
            count++;
        }
    }

    public static void main(String[] args) {
        // generateFibonacciSeries(0,1,10);
        new FibonacciSeries().recursiveFibonacci(1, 2, 4);
    }

    public void recursiveFibonacci(int firstNum, int secondNum, int maxCount) {

        if (maxCount <= 2) {
            return;
        }

        if (isFirstRecursiveCall) {
            System.out.print(firstNum + " " + secondNum);
            isFirstRecursiveCall = false;
        }
        if (maxCount == 2) {
            return;
        }
        int fibNum = firstNum + secondNum;
        System.out.print(" " + fibNum);
        recursiveFibonacci(secondNum, fibNum, --maxCount);
    }
}
