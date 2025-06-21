package dummytest;

public class Test1 {


    public static void main(String[] args) {

        Test1 t1 = new Test1();
        Test1 t3 = new Test1();
        Test1 t2 = t1;
       /* if(t1==t3){
            System.out.println("Matched");
        }
*/
        String s1 = new String("abc");
        String s2 = new String("abc");
        if (!(s1 == s2)) {
            System.out.println("not Matched");
        }
    }
}
