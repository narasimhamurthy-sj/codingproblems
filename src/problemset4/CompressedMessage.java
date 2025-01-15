package problemset4;

import java.util.HashSet;

/*
input:abaasass
o/p:aba2sas2
 */
public class CompressedMessage {
    static String compressedMessage="";

    public static int logicToCompress(char currentChar,int i,String message){


      //  currentChar=message.charAt(i);
       char repeatedChar=0;
        boolean isRepeatedChar=false;
        int repeatedCount=1;

        while (i<message.length()-1){

            if(currentChar==message.charAt(i+1)){
                repeatedChar=currentChar;
                isRepeatedChar=true;
                repeatedCount++;

            }else{
                break;
            }
            i++;
        }//end of while

        if(isRepeatedChar){
            compressedMessage+=repeatedChar+String.valueOf(repeatedCount);
        }else {

            compressedMessage+=String.valueOf(currentChar);
        }
        isRepeatedChar=false;
        repeatedCount=1;

        return i;
    }
    public static String compressGivenMessage(String message){
       // String compressedMessage="";
        HashSet<Character> uniqueChar=new HashSet<>();
        char currentChar,repeatedChar;
        repeatedChar=0;
        boolean isRepeatedChar=false;
        int repeatedCount=1;

        for (int i = 0; i < message.length(); i++) {

            if(uniqueChar.contains(message.charAt(i))){

                currentChar=message.charAt(i);
                 i=logicToCompress(currentChar,i,message);



            }else{
                uniqueChar.add(message.charAt(i));
                currentChar=message.charAt(i);
                i= logicToCompress(currentChar,i,message);

            }

        }//end of for

        System.out.println("Compressed Msg:"+compressedMessage);

       return compressedMessage;

    }//end of method


    public static String anotherApproach(String message){
       // String compressedMessage="";
        int characterRepeatedCount=1;
        if(message==null || message.isEmpty()){
            return "";
        }

        message=message.replaceAll("\\s","");
        char previousChar=message.charAt(0);
        char currentChar;
        StringBuilder compressedMessage=new StringBuilder();
        for (int characterInMessageIndex = 1; characterInMessageIndex < message.length(); characterInMessageIndex++) {
            currentChar=message.charAt(characterInMessageIndex);
            if(previousChar==currentChar){
                characterRepeatedCount++;
            }else{
                compressedMessage.append(previousChar);
                if(characterRepeatedCount>1){
                    compressedMessage.append(characterRepeatedCount);
                  //Re-set value
                    characterRepeatedCount=1;
                }
                previousChar=currentChar;
            }
        }//end of for

//update last char in Message
        compressedMessage.append(previousChar);
        if(characterRepeatedCount>1){
            compressedMessage.append(characterRepeatedCount);
        }
        System.out.println(compressedMessage.toString());
        return compressedMessage.toString();

    }

    public static void main(String[] args) {
        anotherApproach("cbbabbaac");
        anotherApproach("ancgv");
        anotherApproach("111abc111");
        anotherApproach("abaabbabbcaaccc");
        anotherApproach("aaaaa");
        anotherApproach("aaabbbcccdddd");
        anotherApproach("a b c aa bb d    ");
        anotherApproach("a*aa.a;a'aa");


    }
}
