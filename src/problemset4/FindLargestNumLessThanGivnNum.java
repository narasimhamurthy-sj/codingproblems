package problemset4;

public class FindLargestNumLessThanGivnNum {

    /*
    Write a Java program to find the largest number ‘L’ less than a given number ‘N’ which should not contain a given digit ‘D’.
     For example, If 145 is the given number and 4 is the given digit,
     then you should find the largest number less than 145 such that it should not contain 4 in it.
     In this case, 139 will be the answer.

     Ex:999  D=9
     o/p:888

     Ex2:889 D=9
     o/p:888

     Ex3:898 D=9
     o/p:888

     Ex4:988 D=9
     o/p:888

     Ex5: 145  D=4
     o/p:139

     Ex6: 253  D=5
     0/p:249

     : 765 D=6
     759

     special case:693 D=9
     688

     : 788 D=8
     779






    Steps:
    Get each digit using loop
    SET digitPos=1, largestNum=givenNum;
    1. WHILE num >0
       calculate remainder of given num
       check remainder==d
        largestNum=call subtractNumBasedOnPosition(largestNum,digitPos)
        SET num= num/ 10
        ENDWHILE


    subtractNumBasedOnPosition(largestNum,digitPos){

    switch(digitPos){
    case 1: largestNum=largestNum-1;
            break;
    case 2: largestNum=largestNum-10;
            break;
    case 3: largestNum=largestNum-100;
            break;
    case 4: largestNum=largestNum-1000;
            break;
    case 5: largestNum=largestNum-10000;
            break;
    case 6: largestNum=largestNum-100000;
            break;
    case 7: largestNum=largestNum-1000000;
            break;
    case 8: largestNum=largestNum-10000000;
            break;
    default: print "supports only 8 digits position num"
    break;

    return largestNum;
    }

   */

    public int subtractNumBasedOnPosition(int largestNum, int digitPosition) {
        switch (digitPosition) {
            case 1:
                largestNum = largestNum - 1;
                break;
            case 2:
                largestNum = largestNum - 10;
                break;
            case 3:
                largestNum = largestNum - 100;
                break;
            case 4:
                largestNum = largestNum - 1000;
                break;
            case 5:
                largestNum = largestNum - 10000;
                break;
            case 6:
                largestNum = largestNum - 100000;
                break;
            case 7:
                largestNum = largestNum - 1000000;
                break;
            case 8:
                largestNum = largestNum - 10000000;
                break;
            default:
                System.out.println("supports only 8 digits position num");
                break;



        }
        return largestNum;
    }

    public int findLargestNumber(int num, int d) {

        int largestNum = num, digitPosition = 1;
        int remainder;
        while (num > 0) {

            remainder = num % 10;
            if (remainder == d) {

                largestNum=subtractNumBasedOnPosition(largestNum,digitPosition);
            }
            num = num / 10;
            digitPosition++;
        }

        System.out.println("largestNum:"+largestNum);
        return largestNum;
    }

    /*


    String numStr=num;
    largestNum=num;
    String strD=d;
    boolean isDPresent=false;;
    if(numStr.contains(strD)){
     int dIndex=numStr.indexOf(strD);


    isDPresent=true;
     while(isDPresent){
      if((dIndex+1)<numStr.length()){
      remainingDigit=numStr.subString(i+1);
      }else{
      remainingDigit="0";
      }
      remainingDigitInteger=Integer.parseInt(remainingDigit);

      largestNum=largestNum-(remainingDigitInteger+1)


      if(String.valueOf(largestNum).contains(strD)){
      isDPresent=true;
      dIndex=largestNum.indexOf(strD);
    }else{
    isDPresent==false;
    }


   }//end of while



    }else{
    print "Given num doesn't have D and no need to find largest num"
    }



    //---------------------------
     */


    public int findNearestLargerNumberBasedOnDigitD(int num,int d){


        String numStr=String.valueOf(num);
        int largestNum=num,remainingDigitInteger;
        String strD=String.valueOf(d);
        boolean isDPresent=false;
        String remainingDigitStr;
        if(numStr.contains(strD)){
            int dIndex=numStr.indexOf(strD);


            isDPresent=true;
            while(isDPresent){

                if((dIndex+1)<numStr.length()){
                    remainingDigitStr=numStr.substring(dIndex+1);
                }else{
                    remainingDigitStr="0";
                }
                remainingDigitInteger=Integer.parseInt(remainingDigitStr);

                largestNum=largestNum-(remainingDigitInteger+1);


                if(String.valueOf(largestNum).contains(strD)){
                    isDPresent=true;
                    dIndex=String.valueOf(largestNum).indexOf(strD);
                    numStr=String.valueOf(largestNum);
                }else{

                    isDPresent=false;
                }


            }//end of while



        }else{
            System.out.println( "Given num doesn't have D and no need to find largest num");
        }


        System.out.println("largestNum:"+largestNum);
        return largestNum;

    }

    public static void main(String[] args) {
        FindLargestNumLessThanGivnNum lrgstNum=new FindLargestNumLessThanGivnNum();
       /* lrgstNum.findNearestLargerNumberBasedOnDigitD(145,4);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(1200,0);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(1862,2);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(2862,2);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(9999,9);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(1,1);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(22,2);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(27,2);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(27,7);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(193,9);
         lrgstNum.findNearestLargerNumberBasedOnDigitD(98765321,8);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(98765555,5);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(0,0);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(98765555,4);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(92,9);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(15,5);
        lrgstNum.findNearestLargerNumberBasedOnDigitD(298,8);
 lrgstNum.findNearestLargerNumberBasedOnDigitD(906,9);
 lrgstNum.findNearestLargerNumberBasedOnDigitD(00004,0);
  lrgstNum.findNearestLargerNumberBasedOnDigitD(40000,0);
  lrgstNum.findNearestLargerNumberBasedOnDigitD(5000001,0);
    //random positions d=9
        lrgstNum.findNearestLargerNumberBasedOnDigitD(9897969,9);
  //All starting digits same but ending with different digit
        lrgstNum.findNearestLargerNumberBasedOnDigitD(66661,6);

        */

        //All starting digits same but ending with different digit
        lrgstNum.findNearestLargerNumberBasedOnDigitD(66661,6);






    }
}
