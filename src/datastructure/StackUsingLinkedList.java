package datastructure;

public class StackUsingLinkedList {

    static class Node {
        int data;
        Node link;
        Node previousNode;

        Node(int data) {
            this.data = data;
            this.link = null;
            this.previousNode = null;
        }
    }

    static Node top = null;
    static int capacity = 2;
    static int currentNodes = 0;
    // static Node tail=null;

    public static void push(Node newNode) {

        if (currentNodes == capacity) {
            System.out.println("Stack is full");
            return;
        }
        if (top == null) {
            top = newNode;

        } else {
            top.link = newNode;
            newNode.previousNode = top;
            top = top.link;
        }

        currentNodes++;
    }


    public static void pop() {
        if (currentNodes <= 0 || top == null) {
            System.out.println("Stack is Empty, can't delete ");
            return;
        }
        System.out.println("Deleted data:" + top.data);
        Node tempNode = top.previousNode;
        top.previousNode = null;
        top = tempNode;
        currentNodes--;

    }


    public static void printStackElements() {
        Node currentNode = top;
        if (currentNodes <= 0 || top == null) {
            System.out.println("Stack is Empty, can't print ");
            return;
        }

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.previousNode;
        }

    }
//optmized soln from net
/*
    public static void push(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) { // if ll is empty then the newNode will be directly made the head
        head = newNode;
        return;
    } // since in stack elements are added from top
    newNode.next = head; // the current head will be stored in the next of new node
    head = newNode; // new node will be declared as head
}

    public static int pop() {
        if (isEmpty() == true)
            return -1;
        int top = head.data;
        head = head.next; // sinc ethe current head is popped, the new head will be the one stored in the
        // current head's next
        return top;
    }

    public static int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }
}


public static void main(String args[]) {
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    while (!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
    }
}
*/

    public static void main(String[] args) {
        push(new Node(10));
        push(new Node(20));
        push(new Node(30));
        printStackElements();
        pop();
        printStackElements();
        System.out.println("currentNodes:"+currentNodes);
        pop();
        pop();
        System.out.println("currentNodes:"+currentNodes);
        pop();
        push(new Node(10));
        push(new Node(20));
        printStackElements();
        System.out.println("currentNodes:"+currentNodes);
        pop();
        System.out.println("currentNodes:"+currentNodes);
        push(new Node(10));
        push(new Node(20));
        printStackElements();


    }

}
