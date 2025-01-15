package problemset2;

/*
input1: "abcd"
         dcba

2:         1234
         4321

 3:        String with double quotes axvc"

 4.     aaaa
        aaaa

5.      a@#$%bc
         cb%$#@a
6.    abc123wer
7.String with space - abc xyz
8. Empty string
9. Test when there is 2 chars in string
10. Test when there is single char in string



 */
public class ReverseAString {

    public static String reverseString(String inputString){
        char tempVariable;
        if(inputString.isEmpty()){
            System.out.println("String is Empty");
            return inputString;
        }
        char[] inputStringArray= inputString.toCharArray();
        //String reversedString="";

        int indexCountingFromBack=inputStringArray.length-1;
        for (int indexOfInputString = 0; indexOfInputString <=(inputStringArray.length-1)/2; indexOfInputString++,indexCountingFromBack--) {

            tempVariable=inputStringArray[indexOfInputString];
            inputStringArray[indexOfInputString]=inputStringArray[indexCountingFromBack];
            inputStringArray[indexCountingFromBack]=tempVariable;


        }

        System.out.print("Reversed string:");
       for (char ch:inputStringArray){
           System.out.print(ch);

       }
        System.out.println();
       //System.out.println("\nreversedString:"+new String(inputStringArray));
       return new String(inputStringArray);
    }


    public static void main(String[] args) {

        reverseString("1");
    }

}
