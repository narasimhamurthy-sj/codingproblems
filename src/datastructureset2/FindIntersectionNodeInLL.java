package datastructureset2;

import java.util.Random;

public class FindIntersectionNodeInLL {

    static int currentListCount = 0;

    /*
     1. Take first node from L1
        Compare whether it is equal with all the nodes of L2
        repeat the same action till last node of L1

     */
    public static void checkWhetherIntersection(Node l1, Node l2) {

        Node curL1 = l1;
        Node next;
        Node nodeL2 = l2;
        boolean isIntersectionNode = false;

        if (nodeL2.link != null && curL1.link != null) {

            outerloop:
            while (curL1 != null) {

                nodeL2 = l2;

                while (nodeL2 != null) {

                    if (curL1 == nodeL2.link) {
                        isIntersectionNode = true;
                        System.out.println("\nIntersection node found:" + curL1.info);
                        break outerloop;
                    }
                    //if (nodeL2.link != null) {
                    nodeL2 = nodeL2.link;
                    //}
                }


                //  if (curL1.link != null) {
                curL1 = curL1.link;

                //  }


            }
        }


    }

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

    public static void printLL(Node head) {
        // System.out.println("Data:");
        Node cur = head;
        while (cur != null) {

            System.out.print("  " + cur.info);
            cur = cur.link;

        }
    }

    public static void createIntersectionNodeLL(Node l1, Node l2, int intersectionPoint, int connectPositionFromL2) {
        int i = 1;
        Node list1 = l1;
        Node list2 = l2;
        while (i < intersectionPoint) {
            list1 = list1.link;
            i++;
        }
        Node intersectionNodeFromL1 = list1;
        int j = 1;
        while (j < connectPositionFromL2) {
            list2 = list2.link;
            j++;
        }
        Node secondNodeFromL2 = list2;

        //make intersection point
        secondNodeFromL2.link = intersectionNodeFromL1;
        System.out.println("\n LL 1:");
        printLL(l1);
        System.out.println("\n LL 2:");
        printLL(l2);
    }

    public static void main(String[] args) {

        Node linkedList1 = createLL(5);
        System.out.println("\ncount:" + currentListCount);
        printLL(linkedList1);
        Node linkedList2 = createLL(5);
        System.out.println("\ncount:" + currentListCount);


        // System.out.println("\ncount:"+new Node().totalNodeCount);
        printLL(linkedList2);
        System.out.println("\n intersection LL");
        createIntersectionNodeLL(linkedList1, linkedList2, 1, 5);

        System.out.println("\n Post intersection");
        System.out.println("\n L1");
        printLL(linkedList1);
        System.out.println("\n L2");
        printLL(linkedList2);
        System.out.println("\n Checking intersection point");
        checkWhetherIntersection(linkedList1, linkedList2);
    }

    static class Node {

        public Node link;
        public int info;
        public int totalNodeCount;
        boolean visited;

        public Node() {

        }

        public Node(int info) {
            link = null;
            this.info = info;
            visited = false;
            totalNodeCount++;
        }

        public int getCount() {
            return totalNodeCount;
        }
    }

}
