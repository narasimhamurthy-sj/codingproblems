package datastructureset2;

public class MergeTwoSortedLinkedLists {


    public Node mergeListWithoutCreatingNewList(Node list1,Node list2){

        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;

        Node mergedList=null;
        if(list1.info<=list2.info){
            mergedList=merge(list1,list2);
        }else{
            mergedList=merge(list2,list1);
        }

        return mergedList;
    }

    public Node merge(Node list1,Node list2){

        Node list1CurNode,list2CurNode,list1NextNode,list2NextNode;
        list1CurNode=list1;
        list2CurNode=list2;
        list1NextNode=list1.link;
        list2NextNode=list2.link;

        while(list2CurNode!=null && list1NextNode!=null){

            if(list2CurNode.info>=list1CurNode.info && list2CurNode.info<=list1NextNode.info){

                list2NextNode=list2CurNode.link;
                list1CurNode.link=list2CurNode;
                list2CurNode.link=list1NextNode;

                list1CurNode=list2CurNode;
                list2CurNode=list2NextNode;

            }else{
                if(list1NextNode.link!=null){
                    list1CurNode=list1CurNode.link;
                    list1NextNode=list1NextNode.link;
                }else{
                    list1NextNode.link=list2CurNode;
                    break;
                }
            }
        }//End of while

        return list1;
    }


    //own approach
    public Node mergeList(Node list1Head,Node list2Head){

        Node list1Node=list1Head;
        Node list2Node=list2Head;
        Node tempNode=null;
        Node previousNode=null;
        Node list1NodePreviousNode=null;
        Node headOfMergedList=null;
        Node startingNode=null;
        Node listNode2LinkedToList1=null;


        while(list1Node!=null) {
           if(list2Node!=null && list1Node.info <= list2Node.info) {

               while (list1Node!=null && list1Node.info <= list2Node.info  ) {
                   previousNode=list1Node;
                   list1Node = list1Node.link;

               }

               if(list1Node!=null ) {
                   tempNode = list2Node.link;
                   previousNode.link = list2Node;
                   listNode2LinkedToList1=list2Node;
                   list2Node.link = list1Node;
                   list2Node = tempNode;

                   if(list2Node==null) {
                       break;
                   }
               }
           }else{

               if(list2Node!=null) {
                   startingNode=list2Node;
                  while (list2Node != null && list1Node.info > list2Node.info  ) {
                      previousNode = list2Node;
                      list2Node = list2Node.link;
                  }

                  //First iteration of while loop on some cases, this statement will be true
                   //Ex:input- L1:5,10,15,20      L2:1,2,3,4
                   //L1:6,8,9,20,55    L2:2,50,51
                  if(list1NodePreviousNode==null) {
                      headOfMergedList=list2Head;
                      tempNode=previousNode.link;
                      previousNode.link = list1Node;
                      list2Node=tempNode;
                  }else{

                      // when multiple nodes are lesser than node1 - we should give node1List link to starting node of node2list which was pointing
                      //to before execution of while loop
                      list1NodePreviousNode.link=startingNode;
                      previousNode.link=list1Node;
                  }

                  if(list2Node==null)
                      break;
              }
           }

           if(list1Node!=null) {
               if(list1Node.info<list2Node.info) {
                   list1NodePreviousNode = list1Node;
                   list1Node = list1Node.link;
               }else{
                   list1NodePreviousNode=listNode2LinkedToList1;
               }
           }else{
               list1NodePreviousNode=previousNode;
           }
        }//End of while

        if(headOfMergedList==null) {
            headOfMergedList = list1Head;
        }
        if(list2Node!=null && list1Node!=null){
            list1Node.link=list2Node;
        }

        //All the list1Nodes are compared and reached null but in list2 still few nodes are left
        //in this case connect all remaining nodes to list1
        if(list1Node==null && list2Node!=null){
            list1NodePreviousNode.link=list2Node;
        }


        return headOfMergedList;
    }


    // using recursive approach
    public Node mergeListViaRecursiveApproach(Node list1,Node list2){

        Node currentNode=null;
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;

        if(list1.info<=list2.info){
            currentNode=list1;
            currentNode.link=mergeListViaRecursiveApproach(list1.link,list2);
        } else {
            currentNode=list2;
            currentNode.link=mergeListViaRecursiveApproach(list1,list2.link);
        }
        return currentNode;
    }


    public Node mergeListViaIterativeApproachWithNewLinkedList(Node list1,Node list2){
        Node head=null;
        Node tail=null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        //Initialize head and tail
        if(list1.info<=list2.info){
            head=tail=list1;
            list1=list1.link;
        }else{
            head=tail=list2;
            list2=list2.link;
        }


        while(list1!=null && list2!=null){

            if(list1.info<=list2.info){
                tail.link=list1;
                tail=tail.link;
                list1=list1.link;
            }else{
                tail.link=list2;
                tail=tail.link;
                list2=list2.link;
            }
        }//end of while

        //Attach remaining nodes
        tail.link=(list1!=null)? list1:list2;

        return head;
    }


    public static void main(String[] args) {
        Node  linkedList1Head= Node.createLLWithManualEntryData(new int[]{1,3,5,7 });
        System.out.print("List1: ");
        Node.printLL(linkedList1Head);
        Node  linkedList2Head= Node.createLLWithManualEntryData(new int[]{2,3,5,6,10,20,30});
        System.out.print("       List2: ");
        Node.printLL(linkedList2Head);
        System.out.print("\nMergedList: ");
      /* Node mergedList= new MergeTwoSortedLinkedLists().mergeList(linkedList1Head,linkedList2Head);
        Node.printLL(mergedList);*/

       /* Node mergedList= new MergeTwoSortedLinkedLists().mergeListViaRecursiveApproach(linkedList1Head,linkedList2Head);
        Node.printLL(mergedList);*/

       /* Node mergedList= new MergeTwoSortedLinkedLists().mergeListViaIterativeApproachWithNewLinkedList(linkedList1Head,linkedList2Head);
        Node.printLL(mergedList);*/

        Node mergedList= new MergeTwoSortedLinkedLists().mergeListWithoutCreatingNewList(linkedList1Head,linkedList2Head);
        Node.printLL(mergedList);

    }
}
/*
Test cases:
1. input 1:
   L1: 1,2,3,4  L2: 5,6,7,8

2.  L1: 1  L2: 5,6,7,8

3. L1: 50  L2: 5,6,7,8

4. L1: 5,6,7,8  L2: 1

5. L1: 5,6,7,8  L2: 50

6. L1: 5,7,9  L2: 6,8,10

7. L1: 5,5,5  L2: 5,5,5

8. L1: 5,5,5  L2: 6,6,6

9. L1: 6,6,6 L2: 5,5,5

10. L1: 1,3,5,7 L2: 2,3,5,6,10,20,30

11. L1: 6,8,9,20,21,55,60 L2: 2,50,51,52,53


 */