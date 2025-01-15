package datastructureset2;

/* input: abcd, aaaa, aacbb,dddq, 1221, abc123xbz, !@##, !asn12@, frenchLanguage, AAaaBV, ab c, +{,.}:,11-12-2220
*
* whats the limit of string size
*
* */
public class ReverseString {
    public static String reversedStr(String str) {
    String reversedStr="";
    try{

        if(!str.isEmpty()){

           char[] array= str.toCharArray();
           char temp;
           int length=array.length;
           for(int i=0;i<array.length/2;i++,length--){
               temp=array[i];
               array[i]=array[length-1];
               array[length-1]=temp;
           }
            reversedStr= new String(array);

            
        }
    }catch(Exception e){

        e.printStackTrace();
    }
    System.out.println("Actual string: "+str+" ReversedStr: "+reversedStr);
    return reversedStr;
}

    public static void main(String[] args) {
       //abcd, aaaa, aacbb,dddq, 1221, abc123xbz, !@##, !asn12@, frenchLanguage, AAaaBV, ab c, +{,.}:,11-12-2220
        reversedStr("abcd");
        reversedStr("aaaa");
        reversedStr("aacbb");
        reversedStr("dddq");
        reversedStr("1221");
        reversedStr("abc123xbz");
        reversedStr("!@##");
        reversedStr("!asn12@");
        reversedStr("AAaaBV");
        reversedStr("ab c");
        reversedStr("+{,.}:");
        reversedStr("11-12-2220");



    }

}
