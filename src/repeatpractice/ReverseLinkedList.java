package repeatpractice;

public class ReverseLinkedList {

    static Node head;

    public static void main(String[] args) {
        ReverseLinkedList listObject = new ReverseLinkedList();
        Node list = listObject.insert(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        listObject.reverse(list);
        listObject.print(head);


    }

    public Node reverse(Node node) {

        if (node.link == null) {
            head = node;
            return node;
        }

        Node returnedNode = reverse(node.link);
        returnedNode.link = node;
        node.link = null;
        return node;

    }


    public Node insert(int[] arr) {

        Node curNode = null;
        for (int data : arr) {
            if (head == null) {
                head = new Node(data);
                curNode = head;
            } else {
                curNode.link = new Node(data);
                curNode = curNode.link;
            }
        }
        return head;
    }

    public void print(Node list) {

        Node curNode = list;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.link;
        }
    }

    static class Node {
        Node link;
        int data;

        public Node(int data) {
            link = null;
            this.data = data;
        }
    }
}
