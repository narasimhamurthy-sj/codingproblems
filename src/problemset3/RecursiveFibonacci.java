package problemset3;

public class RecursiveFibonacci {
    /*
    fib num: 0,1,1,2,3,5,8,13
    size- n

    firstNum=0, secondNum=1,n=5

    fib(n1,n2,n){

    if(n==0)
    return;

    print fibNum=n1+n2

    fib(n2,fibNum);
    }



     */

    public static void main(String[] args) {
        int firstNum = 1;
        int secondNum = 1;
        new RecursiveFibonacci().fibonacciNum(firstNum, secondNum, 6);
    }

    public void fibonacciNum(int firstNum, int secondNum, int lengthOfFibonacciSeries) {

        if (lengthOfFibonacciSeries == 0) {
            return;
        }
        int fibNum = firstNum + secondNum;
        System.out.println(fibNum);

        fibonacciNum(secondNum, fibNum, lengthOfFibonacciSeries - 1);
    }


}
