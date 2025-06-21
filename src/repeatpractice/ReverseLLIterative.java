package repeatpractice;

/*
cur=head.link;
prev=head;
in loop,traverse LL
prev=cur;
cur=cur.link;
next=cur



 */
public class ReverseLLIterative {

    public static void main(String[] args) {
        ReverseLLIterative rvrslList = new ReverseLLIterative();
        Node head = rvrslList.insertNode(new int[]{1});
        rvrslList.print(head);
        head = rvrslList.reverseNodes(head);
        System.out.println("\nAfter reverse");
        rvrslList.print(head);
    }

    public Node insertNode(int[] arr) {

        Node head = null, cur = null;
        for (int i = 0; i < arr.length; i++) {

            if (head == null) {
                head = new Node(arr[i]);
                cur = head;
            } else {
                cur.link = new Node(arr[i]);
                cur = cur.link;

            }
        }
        return head;
    }

    public void print(Node head) {

        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.link;
        }
    }


    public Node reverseNodes(Node head) {

        Node cur = head.link, prev = head, next;

        prev.link = null;
        while (cur != null) {

            next = cur.link;
            cur.link = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    static class Node {
        Node link;
        int data;

        Node(int data) {
            this.data = data;
            link = null;
        }
    }
}
