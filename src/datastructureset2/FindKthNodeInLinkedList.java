package datastructureset2;

import java.util.Random;

public class FindKthNodeInLinkedList {
    /*
    Statement: Print node info counting from end of LL
    Ex: if there are  3 nodes with data- 10 20 30 40
    Input :count=1
    output: 30
    appraoch 1:
    1. while inserting nodes maintain TotalCount
    2. Get the input count number: count
    3. calculate node from end
       3.1  nodeNumber= (TotalCount-count)+1
    4. traverse in LL until the iterations =nodeNumber and print node info

     */
//
    public static int totalNodeCount;
    public static Node last = null;
    public static Node head = null;

    public static void inserNode(Node n) {

        if (head == null) {
            head = n;
        } else if (head.link == null) {
            head.link = n;
        } else {
            Node cur = head;
            while (cur.link != null) {

                cur = cur.link;
            }
            cur.link = n;
        }
    }

    public static void printLL() {


        if (head == null) {
            System.out.println("Empty LL");
        }/*else if (head.lnk==null){
                System.out.println(head.info);
            }*/ else {
            Node cur = head;
            while (cur.link != null) {

                System.out.println(cur.info);
                cur = cur.link;
            }
            System.out.println(cur.info);
        }
    }

    public static void SearchNodeByCountFromEnd(int count) {


        if (!(count <= totalNodeCount)) {
            System.out.println("Entered count doesn't exists");
            return;
        }
        int nodeNumberFromEnd = (totalNodeCount - count);
        Node cur = head;
        int i = 0;
        while (i < nodeNumberFromEnd) {
            cur = cur.link;
            i++;
        }

        System.out.println("Search Count:" + count + " info:" + cur.info);

    }

    public static void traverseNodeAndPrint(int nodeNumber) {
        Node cur = head;
        int i = 0;
        while (i < nodeNumber) {
            cur = cur.link;
            i++;
        }

        System.out.println("Search Count:" + nodeNumber + " info:" + cur.info);


    }

    public static void searchNodeByTwoPointers(int count) {

        Node p1;
        Node p2;

        p1 = head;
        p2 = head;
        int i = 0;
        while (p2 != null) {

            if (i < count) {

                p2 = p2.link;
            } else {

                p1 = p1.link;
                p2 = p2.link;
            }


            i++;
        }
        //p1=p1.link;
        System.out.println("Node count:" + count + "   , data:" + p1.info);

    }
   /* public static void SearchNodeByCountFromEndViaBinarySearch(int count){
        if(!(count<=totalNodeCount)){
            System.out.println("Entered count doesn't exists");
            return;
        }
        int nodeNumber=(totalNodeCount-count)+1;//3
        int high=totalNodeCount;
        int first=1;
       Node cur=head;
        int mid;

       while(cur!=null) {
            mid = (first + high) / 2;//2

           if (nodeNumber == mid) {
               traverseNodeAndPrint(count);
               break;
           } else if ( nodeNumber<mid) {

               high = mid-1;//1
           } else if ( nodeNumber>mid) {

               first = mid+1;//3
           }

           cur=cur.link;
       }
    }
*/

    public static void main(String[] args) {

        // Node n=new Node(10);
        for (int i = 0; i < 5; i++) {

            inserNode(new Node(new Random().nextInt(1000)));

            // inserNode(new Node(10));
        }

        printLL();
        System.out.println("totalNodeCount:" + totalNodeCount);

        /*SearchNodeByCountFromEnd(1);
        SearchNodeByCountFromEnd(9);
        SearchNodeByCountFromEnd(3);
        SearchNodeByCountFromEnd(10);
*/
        searchNodeByTwoPointers(1);
        searchNodeByTwoPointers(2);
        searchNodeByTwoPointers(3);
        searchNodeByTwoPointers(4);
        searchNodeByTwoPointers(5);

    }

    static class Node {

        public Node link;
        public int info;

        public Node(int info1) {
            link = null;
            info = info1;
            totalNodeCount++;
        }
    }
}
