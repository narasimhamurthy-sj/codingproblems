package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Print {

    public static void printArrayList(ArrayList<String> list){

        //for loop
        for(String str:list){
            System.out.println(str);
        }
       //foreach
        list.forEach(System.out::println);

        //lambda
        list.forEach(str->System.out.println(str));
    }



    public static void printHashMapIterator(HashMap<String,Integer> map) {
        //Entry set
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("k:" + iterator.next());
           // System.out.println("val:"+map.get(iterator.next()));

        }
    }


    public static void printHashMap(HashMap<String,Integer> map){
        //Entry set
        for(Map.Entry<String,Integer> studentMap:map.entrySet()){
            System.out.println(studentMap.getKey());
            System.out.println(studentMap.getValue());

        }




        //keyset
        for(String str: map.keySet()){

            System.out.println("key"+str);
            System.out.println("value"+map.get(str));
        }

        //
        map.forEach((key,value)->System.out.println("key"+key+" value"+value));
    }

    public static void main(String[] args) {

    }
}
