package dataStructureset3;

import datastructureset2.Node;

/*
Approach:
Traverse list by K times,keep reference point as node1
In new loop, traverse list.
   continue node1 wherever left from previous i.,e k times
   start new node - node2 from starting node/head
   continue till node1 reaches end of node
   END Loop
At this point, node2 would be the last node based on k times rotation and make node2.link=null
node1 is pointing to last node, link with first node using head
Now make node1 as new head.

Test Scenarios:
1. Test with single node list
2. Test with rotation count=1
3. Test with rotation count= mid of list. i.e.., if list size is 5,test with 5 rotations and check nodes re-arrangement
4. Test with rotation count= last node of list. In this case, no change in nodes arrangement(list size=rotation count)
5. Test with rotation count= greater than list size (Ex list size=8,rotation count=20)
6. Test with rotation count with -ve number
7.Test with empty list

 */
public class RotateNodesRightByKTimes {

    public static void main(String[] args) {
        RotateNodesRightByKTimes rotate = new RotateNodesRightByKTimes();
        Node list = Node.createLLWithManualEntryData(new int[]{1, 2});
        System.out.println("Before rotate");
        Node.printLL(list);
        int k = -122;
        System.out.println("\nAfter rotate, k=" + k);
        Node.printLL(rotate.rotateRightBykTimes(list, k));

    }

    public Node rotateRightBykTimes(Node list, int k) {

        if (k <= 0) {
            System.out.println("K value is less than or equal to 0");
            return list;
        }
        if (list == null) {
            System.out.println("list is empty");
            return list;
        }
        if (list.link == null) {
            System.out.println("list has single node");
            return list;
        }
        Node node1 = list, node2 = list;
        int nodeCount = 1;
        //move node1 for k times
        int i = 1;
        while (i <= k) {
            if (node1.link != null) {
                node1 = node1.link;
                nodeCount++;
            } else {
                node1 = list;
                k = k % nodeCount;
                System.out.println("k:" + k);
                i = 0;
                nodeCount = 1;
            }

            i++;
        }
        if (k > 0) {
            //move node2 until node1 reaches end
            while (node1.link != null) {
                node1 = node1.link;
                node2 = node2.link;
            }
            Node newHead = node2.link;
            node2.link = null;
            node1.link = list;
            list = newHead;
        }
        return list;
    }
}
