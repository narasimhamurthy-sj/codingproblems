package problemset3;

public class ToggleCharacter {
  /*
  Ex:  aPplE
  o/p: ApPLe



  1.read each character
  2. check is it in lower case
      if so, replace it with upper case
      else
      replace with lower case

/-  -   -   -   -   -   -   -   -   -       -   -   -   -   -       -   -   -


1.  all lower case
2. all upper case
3.mix of lower and upper
4.aphanumeric
5. string with special chars
6.only digits
7. with space char
8. empty string or null
   */

    public static String changeLowerToUppercaseAndViceVersa(String inputString){

       if(inputString==null ||inputString.isEmpty() ){
           System.out.println("String soesn't contain characters");
           return inputString;
       }
        System.out.println("Input String:"+inputString);
        char[] characterArray=inputString.toCharArray();
        char characterFromArray;
        for (char indexOfCharacterArray=0;indexOfCharacterArray<=characterArray.length-1;indexOfCharacterArray++ ){

            if(Character.isLowerCase(characterArray[indexOfCharacterArray])){
                characterArray[indexOfCharacterArray]=Character.toUpperCase(characterArray[indexOfCharacterArray]);
            }else{
                characterArray[indexOfCharacterArray]=Character.toLowerCase(characterArray[indexOfCharacterArray]);
            }
        }
        System.out.println("Toggled string:"+new String(characterArray));
        return new String(characterArray);
    }

    public static void main(String[] args) {

        changeLowerToUppercaseAndViceVersa("123 applE");
    }

}
