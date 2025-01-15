package datastructureset2;

public class ReverseDoublyList {

static     DoublyLinkedList.Node makeFirstNode;
    DoublyLinkedList.Node left;
    DoublyLinkedList.Node cur;
    DoublyLinkedList.Node right;
    //returns last node
    public DoublyLinkedList.Node reverseDoublyList(DoublyLinkedList.Node node){

        if(node!=null && node.rLink==null ){
            makeFirstNode = node;
        }
        if(node==null) {

            return node;
        }

        reverseDoublyList(node.rLink);


       // cur=node;
            left = node.lLink;
            right = node.rLink;
        node.rLink = left;
        node.lLink = right;
return node;


    }
   /*  public DoublyLinkedList.Node reverseDoublyList(DoublyLinkedList.Node node){

        if(node!=null && node.rLink==null ){
            makeFirstNode = node;
        }
        if(node.rLink==null) {

            return node ;
        }

       node= reverseDoublyList(node.rLink);


       // cur=node;
            left = node.lLink;
            right = node.rLink;
        node.rLink = left;
        node.lLink = right;
return node.rLink;


    }*/
    public static void main(String[] args) {

        DoublyLinkedList.Node head= DoublyLinkedList.createDoublyLinkedList(new int[]{10,100,1,8,9});

        DoublyLinkedList.printDoublyList(head);

        ReverseDoublyList obj=new ReverseDoublyList();

        DoublyLinkedList.Node lastNode=new ReverseDoublyList().reverseDoublyList(head);

        DoublyLinkedList.printDoublyList(makeFirstNode);
        DoublyLinkedList.printDoublyListInReverseDirection(lastNode);
    }
}
