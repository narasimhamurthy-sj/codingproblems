package datastructureset2;

public class DoublyLinkedList {

    static Node lastNode = null;

    public static Node createDoublyLinkedList(int[] arr) {


        Node head = null;
        Node cur = null;
        Node prev = null;
        if (arr.length == 0) {
            System.out.println("Array is empty and can't create List");
            return null;
        }

        Node newNode;
        for (int i = 0; i < arr.length; i++) {

            if (head == null) {

                head = new Node(arr[i]);
                cur = head;
            } else {
                // prev=cur;
                newNode = new Node(arr[i]);
                   /*if(cur!=head) {
                       cur.lLink = prev;
                   }
                   cur=cur.rLink;

                   if(i==arr.length-1)
                       lastNode=cur;*/

                newNode.lLink = cur;
                cur.rLink = newNode;
                cur = newNode;

            }
        }
        lastNode = cur;

        return head;
    }

    public static void printDoublyList(Node node) {
        System.out.println("Forward direction traversal...");
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.rLink;
        }
        System.out.println();
    }

    public static void printDoublyListInReverseDirection(Node node) {

        System.out.println("Reverse direction traversal...");
        // Node node=lastNode;
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.lLink;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = createDoublyLinkedList(new int[]{1});
        printDoublyList(head);
        //   printDoublyListInReverseDirection();
    }

    public static class Node {

        public Node lLink;
        public Node rLink;

        public int data;

        public Node() {

        }

        public Node(int data) {
            rLink = null;
            lLink = null;
            this.data = data;
        }

    }
}
