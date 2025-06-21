package repeatpractice;

import java.util.ArrayList;

/*
1.if we know the total count of nodes, traverse LL and if count crosses total nodes. Then loop is there
2. If we have control on create node code, add attribute isVisited=false while creating as default value.
   During traversal,check this attribute, if not visited,make this attribute as true. If this found as true,
   then it has a loop.

 3.Traverse each node and store in arraylist. Before storing,check whether node is present in list.
   if so,it's cycle.

 4. Famous one: Apply Floyd’s Cycle Detection algorithm. Use 2 poniters
    first pointer will tarverse one by one
    whereas second pointer will traverse/jump 2 nodes from current node.
    secondP=cureentNode.next.next;

    At some point in loop traversal, both will meet at the same node if list has cycle.


 */
public class DetectCycleInLL {

    //Floyd’s Cycle Detection algorithm
    public static boolean hasCycle(Node head) {

        Node jump1StepNode = head, jump2StepsNode = head;

        if (head == null || head.link == null) {
            return false;
        }

        while (jump2StepsNode.link != null && jump2StepsNode.link.link != null) {

            jump1StepNode = jump1StepNode.link;
            jump2StepsNode = jump2StepsNode.link.link;

            if (jump1StepNode == jump2StepsNode) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int nodesCount = 5;
        Node[] nodes = new Node[nodesCount];
        nodes[0] = new Node(1);
        Node head = nodes[0];

        DetectCycleInLL cycle = new DetectCycleInLL();

        for (int i = 1; i < nodesCount; i++) {
            nodes[i] = new Node(i + 1);
            nodes[i - 1].link = nodes[i];

        }
        //first node self loop
       /* nodes[0].link=nodes[0];
        System.out.println( hasCycle(nodes[0]));
*/

        //5 cases
        for (int i = 0; i < nodesCount; i++) {
            //create loop in list
            // System.out.println("Checking current node:"+nodes[i].data);
            nodes[nodesCount - 1].link = nodes[i];
            //  System.out.println( hasCycle(nodes[0]));
            //    cycle.checkForCycleAndFindLoopCausedNode(nodes[0]);
        }

        //After above code, multiple nodes will have loop and check for output
        // System.out.println( hasCycle(nodes[0]));
        //System.out.println("Checking current node:"+nodes[i].data);
        cycle.checkForCycleAndFindLoopCausedNode(nodes[0]);


        nodes[1].link = nodes[0];
        cycle.checkForCycleAndFindLoopCausedNode(nodes[0]);

        // Node2 has already loop. Output should through as Node2,eventhough Node3 has loop
        nodes[2].link = nodes[1];
        cycle.checkForCycleAndFindLoopCausedNode(nodes[0]);


    }

    public Node checkForCycleAndFindLoopCausedNode(Node head) {

        ArrayList<Node> visitedList = new ArrayList<>();
        Node currentNode = head, previousNode = null;

        if (head == null || head.link == null) {

            return null;
        }
        while (currentNode != null) {


            if (visitedList.contains(currentNode)) {
                System.out.println("Checking current node:" + currentNode.data);
                System.out.println("LL has cycle. Culprit Node:" + previousNode.data + " This Node link has been wrongly connected to Node:" + currentNode.data);
                return previousNode;
            } else {
                visitedList.add(currentNode);
            }
            previousNode = currentNode;
            currentNode = currentNode.link;
        }
        return null;
    }

    static class Node {
        Node link;
        int data;

        Node(int nodeData) {
            link = null;
            this.data = nodeData;
        }

    }

}
