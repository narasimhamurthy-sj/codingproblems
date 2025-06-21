package problemset2;
/*
2,3,5,7,11,13,17,19

1. set i=2 , set primeNum=3, cond: i<primeNum, i++

    If primeNum%i==0
    SET primeNum++
    SET i=1


    else
    isPrime=true


    if(i==primeNum-1)
        if(isPrime)
        currentPrimeCount++;
        print primeNum
        i=1
        primeNum++

    if currentPrimeCount==primeNumCount
        break;
//-     -   -   -   -   -   --      --  -   -   -   --      --  -

1. give 0 input to generate prime
2.Give 1
3. give 20
4. Give -ve num
5.
//- -   --  --  -   --  -   -   -   -   -   --  -   -   -   -

num 50

49, 51



 */


public class GeneratePrimeNum {

    public static void primeNumber(int countOfPrimeNumbersToBeGenerated) {
        int currentPrimeCount = 0;
        int numberToBeCheckedForPrime = 3;
        if (countOfPrimeNumbersToBeGenerated <= 0) {
            System.out.print("countOfPrimeNumbersToBeGenerated Should be above zero");
            return;
        }
        for (int number = 2; number < numberToBeCheckedForPrime; number++) {
            //count <=countOfPrimeNumbersToBeGenerated
            if ((numberToBeCheckedForPrime % number) == 0) {
                numberToBeCheckedForPrime++;
                number = 1;
            }
            if (number == (numberToBeCheckedForPrime - 1)) {
                //prime Num
                System.out.print(" " + numberToBeCheckedForPrime);
                numberToBeCheckedForPrime++;
                currentPrimeCount++;
                number = 1;
            }
            if (currentPrimeCount == countOfPrimeNumbersToBeGenerated) {
                break;
            }
        }
    }


    public static void generatePrimeNumberWithinLimit(int limitNumber) {
        //  int currentPrimeCount = 0;
        int numberToBeCheckedForPrime = 3;
        if (limitNumber <= 0) {
            System.out.print("limitNumber Should be above zero");
            return;
        }
        for (int number = 2; number < numberToBeCheckedForPrime; number++) {
            if ((numberToBeCheckedForPrime % number) == 0) {
                numberToBeCheckedForPrime++;
                number = 1;
            }
            if (number == (numberToBeCheckedForPrime - 1)) {
                //prime Num
                if (numberToBeCheckedForPrime < limitNumber) {
                    System.out.print(" " + numberToBeCheckedForPrime);
                    numberToBeCheckedForPrime++;
                    number = 1;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // primeNumber(50);

        generatePrimeNumberWithinLimit(100);
    }
}
