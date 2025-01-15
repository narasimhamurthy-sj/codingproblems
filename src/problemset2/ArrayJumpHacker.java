package problemset2;

import java.util.Scanner;

public class ArrayJumpHacker {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        boolean winResult=false;
        int index=0;


        if(game.length<2 || leap<0){
            return winResult;
        }
outerloop:
        while(index<game.length){

            if(index+leap >= game.length){
                winResult=true;
                break;
            }else if(game[index+leap]==0 ){
                if( (index+leap) == (game.length-1)){
                    winResult=true;
                    break;
                }else{
                    index=index+leap;

                    if(game[index+1]!=0 && game[index-1]!=0){

                       if((index+leap)<game.length) {
                           if (game[index + leap] != 0) {
                               index = index - leap;
                               if (game[index + 1] == 0) {
                                   index++;
                               }else{
                                   break outerloop;
                               }
                           }
                       }
                    }





                }
            }else if(game[index+1]==0 ){
                index++;
            }

            else if(index>0 && game[index-1]==0){
                index=index-1;


                while(game[index]==0 && index>=0){

                    if(game[index+leap]==0){
                        index=index+leap;
                        if(index==game.length-1){
                            winResult=true;
                            break outerloop;
                        }
                        break;
                    }else{
                        if(index==0) {
                            break outerloop;
                        }

                        index--;


                    }

                }

            }else{
                break;
            }


        }

        return winResult;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many times you want to test different array? :");
        int q = scan.nextInt();
       // System.out.println("Enter array size :");
        while (q-- > 0) {
            System.out.println("Enter array size :");
            int n = scan.nextInt();
            System.out.println("Enter leap :");
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Enter elements :");
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
