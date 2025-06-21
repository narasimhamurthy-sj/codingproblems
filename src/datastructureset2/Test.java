package datastructureset2;

public class Test {


    public static void main(String[] args) {


        String str = "4abc123$5#6@7";
        //The \D metacharacter matches non-digit characters
        String[] arr = str.split("\\D");
        System.out.println("length:" + arr.length);
        String regexForMatchVowel = "\\D";
        for (String ind : arr) {

            System.out.println(ind);
        }


//        Pattern p = Pattern.compile(regexForMatchVowel);
//        Matcher matcher = p.matcher(str);
//        if( matcher.find()){
//
//        }
//        else{
//
//        }


    }
}
