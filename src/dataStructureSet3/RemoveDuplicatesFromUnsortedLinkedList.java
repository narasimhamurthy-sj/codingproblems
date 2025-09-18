package dataStructureset3;

import datastructureset2.Node;

import java.util.HashSet;

/*
Approach:
Use hashset to identify duplicates
Traverse list and keep on store it in hashset
if duplicate is encountered,adding data into hashset returns false
Now link previous node to next node, so that current node is duplicate and eliminating from the list

Scenarios:
1. Test with entire list with same duplicate numbers
   1,1,1,1
2. Test multiple different duplicate numbers
    1,5,2,8,10,1,5,2
3. Test end of the list is repeated with duplicate numbers
    6,2,9,3,4,4,4
4.Test a list which doesn't have duplicate numbers
   7,6,1,9,2,5
5.Test with a list having single node
   2
6.Test with a list having empty node
7.Test with a list having first and last nodes are duplicate
   7,6,1,9,2,7
8.Test with a list having mid and last nodes are duplicate
   7,6,10,9,2,10
9.Test with a list having -ve numbers with duplicate
   1,-5,-2,8,10,-1,5,-2
10. test with 2 nodes with duplicates
    10,10

 */
public class RemoveDuplicatesFromUnsortedLinkedList {

    public static void main(String[] args) {

        int[][] inputListArray = {
                {1, 4, 2, 60, 1, 1, 60, 4},
                {10, 10},
                {1, 1, 1, 1},
                {6, 2, 9, 3, 4, 4, 4},
                {7, 6, 1, 9, 2, 5},
                {2},
                {},
                {7, 6, 1, 9, 2, 7},
                {1, -5, -2, 8, 10, -1, 5, -2},
                {7, 6, 10, 9, 2, 10}
        };
        RemoveDuplicatesFromUnsortedLinkedList removeDuplicateObject = new RemoveDuplicatesFromUnsortedLinkedList();
        for (int i = 0; i < inputListArray.length; i++) {


            Node list = Node.createLLWithManualEntryData(inputListArray[i]);
            System.out.println("\n" + (i + 1) + ".Before removing duplicates");
            Node.printLL(list);
            System.out.println("\nAfter removing duplicates");
            Node.printLL(removeDuplicateObject.removeDuplicates(list));
        }

    }

    public Node removeDuplicates(Node list) {

        if (list == null || list.link == null) {
            System.out.println("List has less than 2 nodes,can't remove duplicates");
            return list;
        }
        Node currentNode = list, previousNode = null, nextNode = null;
        HashSet<Integer> listData = new HashSet<>();
        while (currentNode != null) {

            if (listData.add(currentNode.info)) {
                previousNode = currentNode;
                currentNode = currentNode.link;
            } else {
                nextNode = currentNode.link;
                previousNode.link = nextNode;
                currentNode = nextNode;
            }
        }
        return list;
    }

}
