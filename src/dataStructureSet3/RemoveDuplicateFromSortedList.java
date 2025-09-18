package dataStructureset3;

import datastructureset2.Node;

/*
Traverse the list, compare current element with next element
check both are same
if so, give the current node link to next to next node
else
make current node as next node


Scenarios:
1. Test with entire list with same duplicate numbers
   1,1,1,1
2. Test multiple different duplicate numbers
    1,1,2,2,2,3,3
3.Test a list which doesn't have duplicate numbers
   7,6,1,9,2,5
4.Test with a list having single node
   2
5.Test with a list having empty node
6.Test with a list having -ve numbers with duplicate
   -2,-2,-1,-1,-1,0,0,0,1,1,98,98
7. test with 2 nodes with duplicates
    10,10


 */
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        int sortedListArr[][] = {
                {1, 1, 2, 2, 2, 3, 3},
                {-2, -2, -1, -1, -1, 0, 0, 0, 1, 1, 98, 98},
                {1},
                {10, 10},
                {1, 2, 3, 4, 5},
                {4, 4, 4, 4, 4, 4, 4, 4},
                {}
        };
        RemoveDuplicateFromSortedList removeDuplicateListObject = new RemoveDuplicateFromSortedList();
        for (int i = 0; i < sortedListArr.length; i++) {

            Node list = Node.createLLWithManualEntryData(sortedListArr[i]);
            System.out.println("\n" + (i + 1) + ".Before removing duplicates");
            Node.printLL(list);
            System.out.println("\nAfter removing duplicates");
            Node.printLL(removeDuplicateListObject.removeDuplicatesFromList(list));


        }
    }

    public Node removeDuplicatesFromList(Node list) {
        if (list == null || list.link == null) {
            System.out.println("List has lessthan 2 nodes");
            return list;

        }

        Node currentNode = list, nextNode = null, nextToNextNode = null;
        while (currentNode.link != null) {
            if (currentNode.info == currentNode.link.info) {
                nextNode = currentNode.link;
                if (nextNode.link != null) {
                    nextToNextNode = nextNode.link;
                    currentNode.link = nextToNextNode;
                    nextNode.link = null;
                } else {

                    currentNode.link = null;
                }

            } else {
                currentNode = currentNode.link;
            }
        }
        return list;
    }
}
