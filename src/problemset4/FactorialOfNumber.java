package problemset4;

public class FactorialOfNumber {

    public static void main(String[] args) {
        FactorialOfNumber FactorialNumObject = new FactorialOfNumber();
        System.out.println(FactorialNumObject.calculateFactorial(5));
    }

    public int calculateFactorial(int number) {
        if (number < 0) {
            System.out.println("Number should be +ve");
            return 1;
        }
        if (number == 1 || number == 0) {
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }
}
