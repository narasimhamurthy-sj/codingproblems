package problemset4;

import java.util.ArrayList;

public class OddNumber {

    public boolean checkListHasOddNum(ArrayList<Integer> list){

        boolean isOdd=false;
        int lastIndex=list.size()-1;
        for (int listIndex = 0; listIndex <= list.size()/2; listIndex++,lastIndex--) {
           if( list.get(listIndex)%2!=0 || list.get(lastIndex)%2!=0){
               isOdd=true;
               break;
           }
        }
        System.out.println("isOdd: "+isOdd);
        return isOdd;
    }


    public boolean checkListHasAllOddNum(ArrayList<Integer> list){

        boolean isOdd=true;
        int lastIndex=list.size()-1;
        for (int listIndex = 0; listIndex <= list.size()/2; listIndex++,lastIndex--) {
            if( list.get(listIndex)%2==0 || list.get(lastIndex)%2==0){
                isOdd=false;
                break;
            }
        }
        System.out.println("isOdd: "+isOdd);
        return isOdd;
    }





    public static void main(String[] args) {
        OddNumber oddNumObject=new OddNumber();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);


       // oddNumObject.checkListHasOddNum(list);
        oddNumObject.checkListHasAllOddNum(list);
    }
}
