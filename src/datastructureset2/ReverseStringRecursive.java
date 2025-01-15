package datastructureset2;

public class ReverseStringRecursive {

    String temp="";
    String base="abc";
    public String reverse(String str,int length){
try {
    if (str.length() <= 0) {
        return "";
    }// else {


  //  }
}catch(Exception e){
    e.printStackTrace();
}
        return str.substring(length - 1) + reverse(str.substring(0, --length), length);
    }


    public String reverse2(String str){
        try {
            if (str.length()<= 0) {
                return "";
            }// else {


            //  }
        }catch(Exception e){
            e.printStackTrace();
        }
        return str.substring(str.length() - 1) + reverse2(str.substring(0, str.length()-1));
    }



    public static void main(String[] args) {
        //ReverseStringRecursive obj=new ReverseStringRecursive();

               //System.out.println("Reversed str: "+ new ReverseStringRecursive().reverse("abc",3));
        System.out.println("Reversed str: "+ new ReverseStringRecursive().reverse2("abc"));

        System.out.println("iNPUT STR: AAA Reversed str: "+ new ReverseStringRecursive().reverse2("AAA"));

        System.out.println("iNPUT STR: 123 Reversed str: "+ new ReverseStringRecursive().reverse2("123"));
       // System.out.println("Reversed str: "+ obj.reverse("abc",3));


       /* String a="Abcd";
        System.out.println("sub: "+a.substring(a.length()-1));

        //a.substring(a.length()-1)+a.substring()
        System.out.println("sub: "+a.substring(0,1));
*/


    }
}
