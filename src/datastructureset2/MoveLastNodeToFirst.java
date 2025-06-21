package datastructureset2;

public class MoveLastNodeToFirst {

    public static Node shiftLastNodeToFirst(Node head) {

        Node currentNode = head, lastButOneNode, lastNode;
        if (head.link == null) {

            System.out.println("\n Single node,shifting is not possible");
            return head;
        }
        while (currentNode.link.link != null) {

            currentNode = currentNode.link;
        }
        lastButOneNode = currentNode;
        lastNode = currentNode.link;
        //SET last node as first node and link to previous first node
        lastNode.link = head;
        head = lastNode;
        lastButOneNode.link = null;

        return head;
    }


    public static void main(String[] args) {

        Node head = Node.createLL(1);
        Node.printLL(head);
        System.out.println("\n After shift");
        Node.printLL(shiftLastNodeToFirst(head));
    }
}
