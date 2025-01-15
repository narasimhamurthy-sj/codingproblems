package datastructureset2;

public class RemoveDuplicateElementsInLinkedList {

    /*
    Problem statement: Linked list contains sorted data in terms of integer numbers. Any duplicate data information should be deleted and output
    should be with unique elements.
    Input: 10,20,30,30,30,30,40
    Output:10,20,30,40

    Approach in short description: will visit each node data one by one. If data is  matching for current node and next node,will set
     flag as duplicate.and will continue to travese till current node and next node data are different. Once we found
     different node data.Store current node in object/pointer lets say  p1. Let's connect p1 node link/address to the next node. So that
      all duplicate nodes in between will be unlinked from linked list and will be having only unique nodes data.

    step 1: Traverse liked list till  end of the node using loop.
         1.1  lets make current node as head/first node of linked list
         In For loop:
         1.2 travese current node till it reaches to end of linked list
         1.3  lets SET next node in some variable using currentnode which contains link address or object reference of next node
         1.4 Now we have current node and next node data information.

             IF current node data is equal to next node data
             1.4.1 maintain a flag isDuplicate as true

             ELSE  current node data is not equal with next node.
               1.4.1  Here we have check whether previous  consecutive nodes were duplicate and next node is not duplicate.If so,
                      we have to eliminate duplicate nodes and link directly to non duplicate element
                      Ex: 20,20,30
                      20(previous node),20(current node),30(next node)

                      In above case, previous node link/address should point to node 30. So that duplicate node will be removed from
                      Linked list.
                      Let's assume next node  is pointing at 30.Here last 2 nodes are duplicate.
                      In this case, whatever we have maintained p1 node which is pointing to first node 20.
                      Now we have to connect p1 link address/object reference as nextnode. So that middle node 20 will be deleted. We
                      are directly linking with 30
                      SET p1 node link/object reference to next node

               1.4.2  Will move p1 pointer to next node position.
               1.4.3 as current and next node are not equal, SET flag isDuplicate as false

               END OF ELSE

           1.5  As we have to traverse till last node. will SET curnode as nextnode
                curNode=nextNode
           END OF FOR

     */
    public static void removeDuplicate(Node head){

        Node currendNode,nextNode,p1;

        if(head==null){
            System.out.println("Empty list");
            return;
        }
        currendNode=p1=head;
        boolean isDuplicate=false,isListUnique=true;
        while(currendNode!=null){

            nextNode=currendNode.link;

            if(nextNode!=null && currendNode.info== nextNode.info){
                isDuplicate=true;
                isListUnique=false;
            }else{
                if(isDuplicate){
                    p1.link=nextNode;
                }
                p1=nextNode;
                isDuplicate=false;
            }
            currendNode=nextNode;
        }
        if(isListUnique){
            System.out.println("List doesn't have duplicate data");
        }
    }

    public static void main(String[] args) {

        Node emptyList=null;
        Node ll = Node.createLLWithManualEntryData(new int[]{1,2,2,3});
        Node.printLL(ll);

        System.out.println("\n after removing duplicate");
        removeDuplicate(ll);
        Node.printLL(ll);

/*
    1. Check for single occurance of duplicate data
       Ex: 1,2,2,2,3,4,5
    2. Check for multiple occurance of duplicate data
       Ex: 1,2,2,2,3,3,4,4,4,5,5,5,6
    3. Check whether your code works if duplicate data occurance is at first node onwards
       Ex: 1,1,1,2,3,4,5
    4. Check whether your code works if duplicate data occurance is at last node
       Ex: 1,2,3,4,5,5,5,5,5
    5. Check whether your code works if all the nodes have duplicate data
       Ex: 6,6,6,6,6,6
    6. Check whether your code works if linked list having with single node
       Ex: 1
    7. Check whether your code works if linked list having all the nodes with unique data
       Ex: 1,2,3,4,5,6
    8. Check whether your code works if linked list with zero node
    9. Check whether your code works if linked list has negative nodes data
       Ex: -1,-1,-2,-2,-3









 */

    }
}
