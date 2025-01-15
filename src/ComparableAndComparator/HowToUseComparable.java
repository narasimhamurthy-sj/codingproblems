package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;

public class HowToUseComparable {


    public static void main(String[] args) {
        ArrayList<LogicClassOrComparableImplementedClass> list = new ArrayList();
        list.add(new LogicClassOrComparableImplementedClass("anil", 10));
        list.add(new LogicClassOrComparableImplementedClass("alex", 20));
        list.add(new LogicClassOrComparableImplementedClass("alex", 5));
        list.add(new LogicClassOrComparableImplementedClass("beck", 20));
        list.add(new LogicClassOrComparableImplementedClass("camil", 5));

        Collections.sort(list);
        list.forEach(System.out::println);

    }
}
