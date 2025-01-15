package datastructureset2;

import java.util.Arrays;
import java.util.Random;

public class Node {
    public Node link;
    public int info;
    boolean visited;
    public Node() {

    }

    public Node(int info) {
        link = null;
        this.info = info;
        visited = false;
        totalNodeCount++;

    }







    static int currentListCount = 0;


    public int totalNodeCount;

    public static Node createLL(int lengthOfLL) {
        currentListCount = 0;
        Node head = null;
        Node cur;
        for (int i = 0; i < lengthOfLL; i++) {

            if (head == null) {
                head = new Node(new Random().nextInt(1000));
                currentListCount++;
            } else {
                cur = head;
                while (cur.link != null) {

                    cur = cur.link;
                }
                cur.link = new Node(new Random().nextInt(1000));
                currentListCount++;
            }
        }


        return head;
    }

    public static Node createLLWithDuplicateData(int lengthOfLL) {
        currentListCount = 0;
        Node head = null;
        Node cur;
        int duplicateArr[] = new int[lengthOfLL];

//        for (Integer arr:duplicateArr) {
//            arr=new Random().nextInt(3);
//        }
        for (int i = 0; i < duplicateArr.length; i++) {
            duplicateArr[i] = new Random().nextInt(3);
        }

        Arrays.sort(duplicateArr);
        for (int i = 0; i < lengthOfLL; i++) {

            if (head == null) {
                head = new Node(duplicateArr[i]);
                currentListCount++;
            } else {
                cur = head;
                while (cur.link != null) {

                    cur = cur.link;
                }
                cur.link = new Node(duplicateArr[i]);
                currentListCount++;
            }
        }


        return head;
    }

    public static Node createLLWithManualEntryData(int[] duplicateArr) {
        currentListCount = 0;
        Node head = null;
        Node cur=null;
     //   int duplicateArr[] = new int[]{1,2,3,2,1};

//        for (Integer arr:duplicateArr) {
//            arr=new Random().nextInt(3);
//        }

        //Arrays.sort(duplicateArr);
        for (int i = 0; i < duplicateArr.length; i++) {

            if (head == null) {
                head = new Node(duplicateArr[i]);
                currentListCount++;
            } else {
                cur = head;
                while (cur.link != null) {

                    cur = cur.link;
                }
                cur.link = new Node(duplicateArr[i]);
                currentListCount++;
            }
        }


        return head;
    }

    public static void printLL(Node head) {
        // System.out.println("Data:");
        Node cur = head;
        while (cur != null) {

            System.out.print("  " + cur.info);
            cur = cur.link;

        }
    }

    public int getCount() {
        return totalNodeCount;
    }

}
