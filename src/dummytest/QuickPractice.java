package dummytest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class QuickPractice {

    public static void all() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("name1", 1);

        for (Map.Entry<String, Integer> elment : map.entrySet()) {
            System.out.println("k:" + elment.getKey() + " v:" + elment.getValue());
        }

        Iterator<Map.Entry<String, Integer>> mapIterator = map.entrySet().iterator();
        Map.Entry<String, Integer> k;
        // String k;
        while (mapIterator.hasNext()) {
            k = mapIterator.next();
            System.out.println("k:" + k);
            System.out.println("v:" + k.getValue());
        }


        //convert array to list
        int[] arr1 = new int[2];
        int[] arr = {1, 2, 3};

        List<Integer> list = IntStream.of(arr).boxed().toList();

        System.out.println("ArrayList");
        for (Integer listelement : list) {
            System.out.println(listelement);
        }

        System.out.println("String array");
        String str[] = {"abc", "c", "d"};
        ArrayList alist = new ArrayList<>(Arrays.asList(str));
        alist.forEach(el -> System.out.println(el));

        //Regular exp
        System.out.println("Regular exp");
        String regEx = "\\s";
        String input = "a b c d a";

        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(input);
        int cnt = 0;
        while (mat.find()) {
            cnt++;
            //mat.group   to print matched string
        }
        System.out.print("cnt:" + cnt);

        System.out.println("Hash Set printing");

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        for (Integer elment : set) {
            System.out.println(elment);
        }

        //or
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {

        all();
    }
}
