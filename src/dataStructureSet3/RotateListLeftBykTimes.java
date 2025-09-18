package dataStructureset3;

import datastructureset2.Node;

/*
list:1,2,3,4,5,6
Approach:
1.Traverse list till end
    once node count reaches to k, keep node reference in node1
    store last node reference in node2
   END LOOP
 2.get next node from newHead=node1.link to make new head
 Also make node1.link=null to break the connection and to make it as last node for node rotation
3. Using node2 which is pointing to last node,  attach link with head/first node
 i.e., node2.link=head
 4.Make new head which we got from step 2
   head=newHead;


   Test Scenarios:
1. Test with single node list
2. Test with rotation count=1
3. Test with rotation count= mid of list. i.e.., if list size is 5,test with 5 rotations and check nodes re-arrangement
4. Test with rotation count= last node of list. In this case, no change in nodes arrangement(list size=rotation count)
5. Test with rotation count= greater than list size (Ex list size=8,rotation count=20)
6. Test with rotation count with -ve number
7.Test with empty list
 */
public class RotateListLeftBykTimes {
    public static void main(String[] args) {
        RotateListLeftBykTimes rotateLeft = new RotateListLeftBykTimes();
        Node list = Node.createLLWithManualEntryData(new int[]{1});
        System.out.println("Before rotate");
        Node.printLL(list);
        int k = 2;
        System.out.println("\nAfter rotate, k=" + k);
        Node.printLL(rotateLeft.rotateLeft(list, k));
    }

    public Node rotateLeft(Node list, int k) {
        if (list == null) {
            System.out.println("Empty list");
            return list;
        }
        if (list.link == null) {
            System.out.println("list has single node");
            return list;
        }
        Node node1 = null, node2 = list, lastNode = null;
        int nodeCount = 1;
        if (k <= 0) {
            System.out.println("Rotation count is less than or equal to 0");
            return list;
        }
        while (node2.link != null) {

            if (nodeCount == k) {
                node1 = node2;
                if (lastNode != null) break;
            }
            node2 = node2.link;
            nodeCount++;
            //Re-set if k > than total node count
            if (node2.link == null && nodeCount <= k) {
                System.out.println("nodeCount:" + nodeCount);
                lastNode = node2;
                k = k % nodeCount;
                System.out.println("k:" + k);
                node2 = list;
                nodeCount = 1;
            }

        }
        //k would be 0 if rotation count=total number of nodes post applying mod
        if (k != 0) {
            Node newHead = node1.link;
            node1.link = null;
            if (lastNode == null) {
                node2.link = list;
            } else {
                lastNode.link = list;
            }
            list = newHead;
        }
        return list;

    }

}
