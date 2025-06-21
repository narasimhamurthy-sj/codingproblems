package problemset3;

/*
5!=5*4*3*2*1


 */
public class FactorialOfANumber {

    public static void main(String[] args) {
        System.out.println("Result:" + new FactorialOfANumber().calculateFactorial(15));
    }

    public int calculateFactorial(int number) {
        if (number == 0)
            return 1;
        return number * calculateFactorial(number - 1);
    }
}
