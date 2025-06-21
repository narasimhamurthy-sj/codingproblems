package datastructureset2;

public class FindLoopInLinkedList {


    public static Node createLoop(int nodePosition) {

        //FindIntersectionNodeInLL.Node list1= FindIntersectionNodeInLL.createLL(5);
        //  Node list1=Node.createLL(4);
        Node list1 = Node.createLLWithManualEntryData(new int[]{1, 2, 3});
        System.out.println("\n Before loop");
        Node.printLL(list1);

        System.out.println("\n after loop");
        Node cur = list1;
        int i = 1;
        while (cur != null && i < nodePosition) {
            cur = cur.link;
            i++;


        }

        //Two temporary nodes
        Node cycleNode1 = new Node(1111);
        Node cycleNode2 = new Node(2222);
        cur.link = cycleNode1;
        cycleNode1.link = cycleNode2;
        cycleNode2.link = cur;

//        System.out.println("\n Post loop formation");
//        FindIntersectionNodeInLL.printLL(list1);


        return list1;
    }

    public static boolean isLoop(FindIntersectionNodeInLL.Node linkedList) {

        FindIntersectionNodeInLL.Node cur = linkedList;
        boolean loopPresence = false;

        System.out.print("\n Checking Loop\n");
        while (cur != null) {

            System.out.print(cur.info + "   ");
            if (!cur.visited) {
                cur.visited = true;
            } else {
                System.out.print(" \n Found loop at:" + cur.info + "   \n");
                loopPresence = true;
                break;
            }

            cur = cur.link;

        }
        return loopPresence;
    }

/*
Problem statement: Usually we can traverse each node till the end of last node in linked list.If in case any node points
to already traversed node again. Then it creates a loop in the linked list. We will not be able to reach last node as we are keep on visiting these
same nodes.

  Ex: Linked list without loop- 1,2,3,4
      Linked list with loop -  1,2,3,2,3,4
      Here Node 3 is ponting again to Node 2. Now it creates loop -1,2,3,2,3,2,3,2,3  and so on...
      It never ends. It keeps on traversing the same nodes 2 and 3. will never be able to reach last node or complete linked list elements.

Approach:
There are many solutions to solve this problem. I will try to show the easiest approach.
While creating node, will maintain a flag "isVisited" and will SET default value as false.As node is just created, no traversal happened. Hence will set value as false.
 To test whether linked list
 has a loop, while traverse each node and check this
 flag "isVisited".   As we are visting each node first time, this flag will be false and let's set this value as true by marking visited.
 Keep on traversing nodes till end of node. If there is a loop, we encouter already visited node. Check for the flag isVisited,
 if we found with the value - true then linked list has a loop.

 Steps:
 1. While creating node, will create linked list properties data/info, link/address. Along with this, create  a flag "isVisited"  and SET false
    Sample:
    Node {
      NODE data,
      Node link,
      isVisited=false;
    }
2. Now let's go for finding whether list has a loop
   Traverse each node till end of linked list.
   2.1 SET current Node as head or first Node
   2.2 Until current node reaches to end of list keep on traversing using loop.
       Check whether current node flag is  Visited or Not on each iteration
       2.2.1 IF Node is not visited, SET true by marking it as now visited
       ELSE
       2.2.1 We found the loop, as we are visiting one more time the same Node.
             Break the loop


 */

    //@param head - First node of linked list
    public static boolean doesLinkedListHasLoop(Node head) {
        // Making currentNode as head/first node
        Node currentNode = head;
        boolean isloopFound = false;
        //Check whether given linked list is empty
        if (head == null) {
            System.out.print("Empty List");
            return isloopFound;
        }
        // Traverse till end of node. last node link/address contains null
        while (currentNode != null) {
            //if current node is not visited,mark it as visited
            if (!currentNode.visited) {
                currentNode.visited = true;
            } else {
                System.out.print(" \n Found loop at:" + currentNode.info + "   \n");
                //We found already visited node. Hence mark loop is found in linked list
                isloopFound = true;
                break;
            }
            //As we have done with current node inspection. Let's check for next node. SET current node as next node
            currentNode = currentNode.link;

        }
        return isloopFound;
    }



    /*
    1. Check whether your code throws correct output if linked list has loop at  mid node of linked list
    2. Check whether your code throws correct output if linked list has loop at  first node of linked list
    3. Check whether your code throws correct output if linked list has loop at  last node of linked list
    4. Check whether your code throws correct output if linked list has single node and it has loop to itself
    5. Check whether your code throws correct output if linked list has no loop
    6. Check whether your code throws correct output if linked list has no nodes


     */


    public static void twoPointersApproachToFindCycle(FindIntersectionNodeInLL.Node linkedList) {

        FindIntersectionNodeInLL.Node cur = linkedList;
        FindIntersectionNodeInLL.Node p1 = cur;
        System.out.print(" \n first node:" + p1.info + "   \n");
        FindIntersectionNodeInLL.Node next = cur.link;
        System.out.print("Second node:" + next.info + "   ");
        boolean loopPresence = false;
        while (p1 != null) {


            //if(p1.link!=null) {
            next = next.link.link;
            System.out.print(" Next node:" + next.info + "   \n");
            //}

            if (p1 == next) {
                System.out.print("  Found loop    \n");
                loopPresence = true;
                break;
            }


            p1 = p1.link;
            System.out.print("  Current node:" + p1.info + "   \n");

        }

    }

    public static void main(String[] args) {
        //createLoop(4);
        /*isLoop(createLoop(4));

        FindIntersectionNodeInLL.Node list1= FindIntersectionNodeInLL.createLL(5);
        if(isLoop(list1)){
            System.out.print(" \n Found loop ");
        }else{
            System.out.print(" \n loop not Found  ");
        }
*/
        System.out.print(" \n Checking  via two pointer ");
        /* twoPointersApproachToFindCycle(createLoop(6));

         */
        //doesLinkedListHasLoop(createLoop(3));

        Node n1 = new Node(10);
        Node n2 = n1;
        n1.link = n2;

        System.out.print("\n doesLinkedListHasLoop" + doesLinkedListHasLoop(n1));
    }
}
