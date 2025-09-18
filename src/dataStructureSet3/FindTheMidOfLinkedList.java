package dataStructureset3;

import datastructureset2.Node;

/*
Given a singly linked list, write an algorithm to find its middle node.

If the number of nodes is odd, return the middle node.

If the number of nodes is even, interviewers may expect:

Either return the second middle (most common requirement, e.g. LeetCode).

Or specify clearly if they want the first middle.

Approach: slow and fast pointer
Traverse linked list with two nodes n1 and n2. One node n1 jumps to next single node and other node n2 jumps to 2 nodes using loop.
Once n2 node reaches end or null, n1 node would be at mid of node.
Now print n1 which is mid of linked list.

Test scenarios:
1. Test with linked list having even nodes count
   Ex: linked list size is 6
2. Test with linked list having odd nodes count
   Ex: linked list size is 7
3. Test with linked list having only one node
4. Test with linked list having only 2 nodes
5. Test with empty node linked list
6. Test with linked list having different type of data like String,integer,decimal etc..,
   Ex: A list with integer or a list with string
 */
public class FindTheMidOfLinkedList {

    public static void main(String[] args) {
        // Node list=new Node();
        Node list = Node.createLL(3);
        Node.printLL(list);
        new FindTheMidOfLinkedList().findMiddleNode(list);
    }

    public Node findMiddleNode(Node listHead) {
        Node n1 = listHead, n2 = listHead, list = listHead;
        if (list == null) {
            System.out.println("\nGiven List is empty");
            return null;
        }
        if (list.link == null || list.link.link == null) {
            System.out.println("\nNode counts are below 3");
        }
        while (n2.link != null && n2.link.link != null) {
            n2 = n2.link.link;
            n1 = n1.link;
        }
        if (n2.link != null) {
            System.out.println("\nSecong mid node:" + n1.link.info);
            return n1.link;
        } else {
            System.out.println("\nFirst mid node:" + n1.info);
            return n1;
        }
    }
}
