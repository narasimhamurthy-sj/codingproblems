package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HowToApplyComparator {


    public static void ByAnonymousClass(ArrayList<ClassObjectThatNeedsSorting> list) {

        //For integer fields sort
        Comparator<ClassObjectThatNeedsSorting> compareByEmployeeNumber = new Comparator<ClassObjectThatNeedsSorting>() {

            @Override
            public int compare(ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) {
                return Integer.compare(obj1.empNumber, obj2.empNumber);
            }
        };
        System.out.println("Sort by emp No");
        Collections.sort(list, compareByEmployeeNumber);
        list.forEach(el -> System.out.println(el));

        //For String fields sorting
        Comparator<ClassObjectThatNeedsSorting> sortByName = new Comparator<>() {

            @Override
            public int compare(ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) {
                return obj1.name.compareTo(obj2.name);
            }
        };
        System.out.println("Sort by Name-    --  --  -   -   --      --  --  ");
        Collections.sort(list, sortByName);
        list.forEach(System.out::println);


    }

    public static void byUsingLamdaExpression(ArrayList<ClassObjectThatNeedsSorting> list) {

        //Sort by emp ID

        Comparator<ClassObjectThatNeedsSorting> sortByEmpName = (ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) -> Integer.compare(obj1.empNumber, obj2.empNumber);
        Collections.sort(list, sortByEmpName);
        list.forEach(System.out::println);


        //For String fields sorting
        System.out.println("String fields sorting- - - - - - - - - -----");
        Comparator<ClassObjectThatNeedsSorting> sortByName = (ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) -> obj1.name.compareTo(obj2.name);
        Collections.sort(list, sortByName);
        list.forEach(System.out::println);
    }

    public static void sortByMultipleFields(ArrayList<ClassObjectThatNeedsSorting> list) {

        Comparator<ClassObjectThatNeedsSorting> multiSort = Comparator.comparing(ClassObjectThatNeedsSorting::getName).thenComparing(ClassObjectThatNeedsSorting::getEmpNumber);
        Collections.sort(list, multiSort);
        list.forEach(System.out::println);
    }


    public static void byUsingLamdaExpressionForArray(ClassObjectThatNeedsSorting[] array) {

        //Sort by emp ID

        Comparator<ClassObjectThatNeedsSorting> sortByEmpName = (ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) -> Integer.compare(obj1.empNumber, obj2.empNumber);
        Arrays.sort(array, sortByEmpName);
        Arrays.stream(array).forEach(System.out::println);


        //For String fields sorting
        System.out.println("String fields sorting- - - - - - - - - -----");
        Comparator<ClassObjectThatNeedsSorting> sortByName = (ClassObjectThatNeedsSorting obj1, ClassObjectThatNeedsSorting obj2) -> obj1.name.compareTo(obj2.name);
        Arrays.sort(array, sortByName);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void main(String[] args) {

    /*    ArrayList<ClassObjectThatNeedsSorting> list = new ArrayList();
        list.add(new ClassObjectThatNeedsSorting("anil", 10));
        list.add(new ClassObjectThatNeedsSorting("alex", 20));
        list.add(new ClassObjectThatNeedsSorting("alex", 5));
        list.add(new ClassObjectThatNeedsSorting("beck", 20));
        list.add(new ClassObjectThatNeedsSorting("camil", 5));
        */


        // ByAnonymousClass(list);
        //  byUsingLamdaExpression(list);
        // sortByMultipleFields(list);

        ClassObjectThatNeedsSorting[] arrayThatNeedToBeSorted = new ClassObjectThatNeedsSorting[]{new ClassObjectThatNeedsSorting("beck", 20), new ClassObjectThatNeedsSorting("alex", 5), new ClassObjectThatNeedsSorting("alex", 20), new ClassObjectThatNeedsSorting("anil", 10), new ClassObjectThatNeedsSorting("camil", 5)};
        byUsingLamdaExpressionForArray(arrayThatNeedToBeSorted);
    }
}
