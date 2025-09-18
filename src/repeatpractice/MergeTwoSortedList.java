package repeatpractice;

import datastructureset2.Node;

/*
You are given two singly linked lists, each already sorted in ascending order.
Your task is to merge them into one sorted linked list, and return the head of the merged list.

The merged list should also be sorted.

You cannot just copy values into an array and sort — you must merge by rearranging links (typical interview expectation).
 Approach:
 Run the step1 in loop until list1 or list2 reaches to null or end
 1.Compare list1 element to list2 element
   if list1 element is smaller
   store in some reference object the current node
   Go to next node in List1

   else
   list2 element is smaller
   store in some reference object the current node
   Go to next node in List2
 2. Take this reference object and start building merged list linking next reference object in each iteration
 3.Check  List1 and List2 still have elements
   if so, attach merged list link to these

Test scenarios:
1. one of the list is bigger than other.   L1:1,4,5         L2:2,3,6,7
2.Alternative next number in list.    L1:1,3,5,7         L2:2,4,6
3.both the list have same numbers.    L1:3,3,3         L2:3,3,3
4.Few numbers with duplicate.    L1:1,3,3,5         L2:2,2,6,7
5.one of the list with quite bigger size.    L1:10         L2:2,2,6,7,8,9,10
6. one of the list is empty    L1:null         L2:2,2,6,7,8,9,10
7.Both the lists empty    L1:null         L2:null
8. Two lists having sorted data one after other. L1:1,2,3,4         L2:5,6,7,8


 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        Node list1 = Node.createLLWithManualEntryData(new int[]{1,2,3,4 });
        System.out.println("List1");
        Node.printLL(list1);
        System.out.println("\nList2");
        Node list2 = Node.createLLWithManualEntryData(new int[]{5,6,7,8});
        Node.printLL(list2);
        MergeTwoSortedList mergeList = new MergeTwoSortedList();
        mergeList.mergeLists(list1, list2);
    }

    public Node mergeLists(Node list1, Node list2) {

        if (list1 == null || list2 == null) {
            System.out.println("One of the list is empty");
            return null;
        }
        Node mergedList = null, mergeNode = null, curList1Node = list1, curList2Node = list2, mergedListHead = null;
        while (curList1Node != null && curList2Node != null) {

            if (curList1Node.info <= curList2Node.info) {
                mergeNode = curList1Node;
                curList1Node = curList1Node.link;
            } else {
                mergeNode = curList2Node;
                curList2Node = curList2Node.link;
            }
            if (mergedListHead == null) {
                mergedList = mergeNode;
                mergedListHead = mergeNode;
            } else {
                mergedList.link = mergeNode;
                mergedList = mergedList.link;
            }
        }//end of while

        if (curList1Node != null) {
            mergedList.link = curList1Node;
        }
        if (curList2Node != null) {
            mergedList.link = curList2Node;
        }
        System.out.println("\nMerged List");
        Node.printLL(mergedListHead);
        return mergedListHead;
    }
}
