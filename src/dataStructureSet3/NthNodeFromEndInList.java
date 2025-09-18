package dataStructureset3;

import datastructureset2.Node;

import java.util.ArrayList;

/*
Given a singly linked list and an integer N, find the Nth node from the end of the linked list.

If N = 1 → return the last node.

If N = length of the list → return the head node.

If N > length of the list → return null or indicate “Not Found”.
Example 1:
Input: 1 → 2 → 3 → 4 → 5, N = 2
Output: 4 (2nd node from the end is 4).

Example 2:
Input: 10 → 20 → 30 → 40 → 50, N = 5
Output: 10 (5th node from the end = head).

Approach 1:
Use 2 poniters. One with slow and other with fast.
Slow pointer jumps 1 node and fast pointer jumps 2 nodes.
Using this find the count of nodes in list.
At the same time, store slow pointer nodes in array before it jumps to next node.
Once loop ends, we will be having total count of nodes and slow pointer will be pointing at mid of list.
Now check -> given n node from end. substract it from total node count.
traveseNodeCnt=totalNode-n
if(traveseNodeCnt<totalNode/2)
  from array ->just fetch node
else
take slow pointer which is pointing to mid node
From there,iterate further to reach traveseNodeCnt

Approach 2(optimized):
Take two pointers node1 and node2.
Using node1 traverse list till count (input n)
Now node1 points to the node which is present after input n steps
Ex: if there are 6 nodes in list,given n=3. Traverse node1 to 3 steps. 1->2->3->4
    i.e., node1 points to 4

At this point, take node2 initialized with first node  and node1 which points to as per input n traversal node.
Traverse till node1 reaches to null along with  point node2 to next node in each iteration

Once traversal completes, node2 points to required node ie., nth node from last and print node data
Scenarios:
Ex: Nodes 1,2,3,4,5,6,7,8
1.Test first node from last
    8
2.Test mid node from last
    4
3.Test last node from last
    1
4.Test a node position which does not exist
    13
5.Test a list with single node and input n=1
   Ex: list -100
   o/p=100
6.Test a list with 2 nodes and input n=1
   Ex: list -100,200
   o/p=200
7.Test with empty list
8.Test list  with n<=0
    o/p:Error message should be displayed

 */
public class NthNodeFromEndInList {
    public static void main(String[] args) {
        Node list = Node.createLL(2);
        Node.printLL(list);
        NthNodeFromEndInList nthNodeListObject = new NthNodeFromEndInList();
        nthNodeListObject.findNodeFromLast(list, 0);
        nthNodeListObject.optimizedSoln(list, 0);
    }

    public Node optimizedSoln(Node list, int n) {
        Node node1 = list, node2 = list;
        int nIterations = 1;
        if (n <= 0) {
            System.out.println("Onvalid input:" + n);
            return null;
        }
        //traverse first pointer based on given n steps
        while (nIterations <= n) {
            try {
                node1 = node1.link;
                nIterations++;
            } catch (NullPointerException e) {
                System.out.println("\nInvalid input:" + n + ",list doesn't have such lengthy nodes");
                return null;
            }
        }
        while (node1 != null) {
            node1 = node1.link;
            node2 = node2.link;
        }
        System.out.println("\nNode details:" + node2.info);
        return node2;

    }

    public Node findNodeFromLast(Node list, int nthNodeFromlast) {
        Node node1 = list, node2 = list;
        int totalNodeCount = 1;
        ArrayList<Node> listArray = new ArrayList<>();

        if (list == null) {
            System.out.println("Empty list");
            return null;
        } else if (nthNodeFromlast <= 0) {
            System.out.println("Invalid input:" + nthNodeFromlast);
            return null;
        }
        //find total node count
        while (node2.link != null && node2.link.link != null) {
            node2 = node2.link.link;
            listArray.add(node1);
            node1 = node1.link;
            totalNodeCount += 2;
        }
        if (node2.link != null) {
            totalNodeCount++;
        }
        System.out.println("\ntotalNodeCount:" + totalNodeCount);

        if (totalNodeCount == 1) {
            listArray.add(node1);
        } else if (totalNodeCount == 2) {
            listArray.add(node1);
            listArray.add(node1.link);
        }
        if (nthNodeFromlast > totalNodeCount) {
            System.out.println("\nInvalid input:" + nthNodeFromlast + ",list doesn't have such lengthy nodes");
            return null;
        }
        int nthNodePosition = totalNodeCount - nthNodeFromlast;
        int midOfList, numOfIterations = 0;
        if (totalNodeCount % 2 != 0) {
            midOfList = (totalNodeCount / 2) + 1;
        } else {
            midOfList = (totalNodeCount / 2);
        }
        if (nthNodePosition <= midOfList) {
            System.out.println("nthNodePosition:" + listArray.get(nthNodePosition).info);
        } else {
            System.out.println("Node1 data before iteration:" + node1.info);
            if (totalNodeCount % 2 != 0) {
                numOfIterations = nthNodePosition - (totalNodeCount / 2) - 1;
            } else {
                numOfIterations = nthNodePosition - (totalNodeCount / 2);
            }
            int i = 0;
            while (i <= numOfIterations) {
                node1 = node1.link;
                i++;
            }
            System.out.println("nthNodePosition:" + node1.info);
        }
        return node1;
    }


}
