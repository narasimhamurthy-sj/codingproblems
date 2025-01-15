package datastructureset2;

public class ReverseALinkedList {

    /*
    1,2,3,4,5

   Make
    cur=head.lnk;
    head.link=null;


    loop:iterate till until curNode is null
    prevNode=cur;//4
    cur=cur.link//5
    nextNode=cur.link//null
    cur.link=prevNode//4

    cur=nextNode//null


    */

    public static FindIntersectionNodeInLL.Node revreseNode(FindIntersectionNodeInLL.Node head) {

        if (head.link == null) {
            System.out.println("\n Single node");
            return head;
        }
        FindIntersectionNodeInLL.Node currentNode = head;
        FindIntersectionNodeInLL.Node prevNode = currentNode;
        FindIntersectionNodeInLL.Node nextNode = currentNode.link;

        currentNode.link = prevNode;
        prevNode.link = null;

        while (nextNode != null) {
            if (nextNode.link == null) {
                head = nextNode;
                nextNode.link = currentNode;
                break;
            }
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.link;
            currentNode.link = prevNode;
        }


        return head;
    }




    public static FindIntersectionNodeInLL.Node reverseLL(FindIntersectionNodeInLL.Node head){

        FindIntersectionNodeInLL.Node prev=null;
        FindIntersectionNodeInLL.Node cur=head;
        FindIntersectionNodeInLL.Node next;

        while(cur!=null){

            next=cur.link;
            cur.link=prev;
            prev=cur;
            cur=next;

        }

        head=prev;

        return head;
    }
    public static void main(String[] args) {

        FindIntersectionNodeInLL.Node ll = FindIntersectionNodeInLL.createLL(10);
        FindIntersectionNodeInLL.printLL(ll);

        System.out.println("\n after reverse");
       // FindIntersectionNodeInLL.printLL(revreseNode(ll));


        FindIntersectionNodeInLL.printLL(reverseLL(ll));
    }
}
