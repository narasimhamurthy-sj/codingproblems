package datastructureset2;

public class CalculateSumInString {
    /*
    input str=12abc20yz68
    o/p:100

    Set digitInStr to empty string, sum=0
Step 1: Find digits by traversing each character in String
            for i=0 to n-1 where n=length of string
Step 1.1: If it is digit,store it in the variable digitInStr
            if str.charAt[i] is digit
            digitInStr+=str.charAt[i]

Step 1.2:  else
Step 1.3:  if digitInStr is not empty, then only go for sum calculation
Step 1.4:  sum the number and reset digitInStr to empty string to store new numbers in String
             sum+=Inger.parseInt(digitInStr);
             digitInStr=''
Step 2:In case of string ends with numbers,this will be missed in sum calculation in loop. Check if  digitInStr
        is not empty, if so add it in sum

        if digitInStr is not empty
         sum+=Inger.parseInt(digitInStr);


     */

    public static int calculateSum(String str) {
        String digitInStr = "";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                digitInStr += str.charAt(i);
            } else {

                if (!(digitInStr.isEmpty())) {
                    sum += Integer.parseInt(digitInStr);
                    digitInStr = "";
                }
            }
        }//end of for loop
        if (!(digitInStr.isEmpty())) {
            sum += Integer.parseInt(digitInStr);
        }

        return sum;
    }

    public static int calculateSumUsingRegx(String str) {
        String[] arr = str.split("\\D");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (!(arr[i].isEmpty())) {

                sum += Integer.parseInt(arr[i]);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
      //  System.out.println(calculateSum("12abc20yz68$10#00!04*200(10000ss"));
        System.out.println(calculateSum(" 12abc20 2yz68$10 "));
        System.out.println(calculateSumUsingRegx(" 12abc20 2yz68$10 "));

    }

}
