package datastructure;

public class QueueUsingLinkedList {

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static void enQueue(Node newNode) {
        System.out.println("Insering element:" + newNode.data);
        if (head == null && tail == null) {
            head = tail = newNode;

        } else {
            tail.link = newNode;
            tail = tail.link;

        }
        size++;

    }

    public static int deQueue() {
        int deletedItem;
        if (head == null) {
            tail = null;
            System.out.println("Queue is empty,can't delete");
            return -1;
        } else {
            deletedItem = head.data;
            Node tempNode = head.link;
            head.link = null;
            head = tempNode;
            size--;
        }
        System.out.println("Deleted item:" + deletedItem);
        return deletedItem;

    }

    public static void printQueue() {
        System.out.println("Printing Queue");
        if (head == null) {
            System.out.println("Queue is empty,nothing to print");
            return;
        }
        Node curNode = head;

        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.link;
        }
    }

    public static void main(String[] args) {
        enQueue(new QueueUsingLinkedList().new Node(10));
        enQueue(new QueueUsingLinkedList().new Node(20));
        //   System.out.println("Size"+size);
        printQueue();
        deQueue();
        printQueue();


        deQueue();
        printQueue();

        deQueue();


        System.out.println("After empty-----------");
        enQueue(new QueueUsingLinkedList().new Node(10));
        enQueue(new QueueUsingLinkedList().new Node(20));
        printQueue();
        deQueue();
        printQueue();
        deQueue();
        printQueue();
        deQueue();
    }

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

}
