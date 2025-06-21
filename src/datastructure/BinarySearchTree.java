package datastructure;

import java.util.ArrayList;

public class BinarySearchTree {


    static Node root;


    public static Node insertElementsIntoNonBST(int data) {
        // System.out.println("insertElementsIntoNonBST");
        ArrayList<Node> nodesList = new ArrayList<>();
        int countOfCompleteTree = 0;
        Node leftChild = null;
        Node rightChild = null;

        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            Node curNode;
            nodesList.add(root);
            while (true) {

                curNode = nodesList.get(countOfCompleteTree);
                //check left child is empty
                if (curNode.leftChild == null) {
                    curNode.leftChild = new Node(data);
                    return root;
                } else {
                    leftChild = curNode.leftChild;
                    nodesList.add(leftChild);
                }
                //check right child is empty
                if (curNode.rightChild == null) {
                    curNode.rightChild = new Node(data);
                    return root;
                } else {
                    rightChild = curNode.rightChild;
                    nodesList.add(rightChild);
                    countOfCompleteTree++;
                }

            }

        }


    }


    public static Node inserElementIntoBinaryTree(int data) {

        Node currentNode;
        if (root == null) {

            root = new Node(data);
        } else {
            currentNode = root;

            while (currentNode != null) {

                if (data < currentNode.data) {

                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(data);
                        break;
                    }
                    currentNode = currentNode.leftChild;
                }

                if (data > currentNode.data) {

                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(data);
                        break;
                    }
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return root;
    }

    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "   ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);

    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + "   ");
        inOrderTraversal(node.rightChild);

    }

    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
        System.out.print(node.data + "   ");

    }


    /* JAVA code
      @param node is ROOT node */
    public static void printLevelOrder(Node node) {
        ArrayList<Node> nodesInArrayList = new ArrayList<>();
        if (node == null) {
            System.out.println("Empty binary search tree");
        } else {

            System.out.print("Printing level order:");
            //Store ROOT node in ArrayList
            nodesInArrayList.add(node);

            //Until ArrayList has nodes,run the loop. Once ArrayList is empty stop iterating loop
            while (nodesInArrayList.size() != 0) {
                //Print first node info
                System.out.print(nodesInArrayList.get(0).data + "  ");

                //If left child is present, store it in ArrayList
                if (nodesInArrayList.get(0).leftChild != null) {
                    nodesInArrayList.add(nodesInArrayList.get(0).leftChild);
                }
                //If right child is present, store it in ArrayList
                if (nodesInArrayList.get(0).rightChild != null) {
                    nodesInArrayList.add(nodesInArrayList.get(0).rightChild);
                }
                /* Delete first node to reduce space complexity as there is no operations involved with this node. We have got
                   information of left and right child nodes of this node. Child node of Deleted node positioned as first node.
                */
                nodesInArrayList.remove(0);
            }
        }
    }


    /*
PSEUDO STEPS:
    1. Traverse each node in binary search tree. While traversing, store each node in ArrayList
    2. As we have to start traversal from root node, initially store root node in ArrayList as first node
       nodesInArrayList.add(rootNode)
    3. Check whether root node which is stored in ArrayList has left or right child.
       If so, store those in next subsequent position in ArrayList.
       Execute this in a loop as we have to traverse all the nodes.
       Once children existence check is done for a node(First node in ArrayList).
       Delete that node from ArrayList to improve space complexity.
       Post deleting first node, next subsequent node will act as first node
       and again repeat same steps until ArrayList hasn't left with any node.

        LOOP:  while nodesInArrayList size is not zero
                 3.1 Print the first node from nodesInArrayList
                 3.2 Check if left child exists, if so,add/store it in Arraylist
                     nodesInArrayList.add(leftChild)
                 3.3 Check if right child exists, if so, add/store it in Arraylist
                     nodesInArrayList.add(rightChild)
                 3.4 As we are already checked whether parent node (which is first node or index 0th node in ArrayList) has children,
                     delete from Arraylist to save space and improve space complexity.

                      nodesInArrayList.remove(0)

                      By deleting first node, left or right child of deleted node will be positioned as first node in ArrayList based on
                      respective node presence. Again left and right child of newly positioned node existence will be checked using loop
                      and this will be continued until all the nodes are visited

        END OF WHILE LOOP

     */

    public static void main(String[] args) {

        //   int[] arr = new int[]{10, 5, 20, 3, 8, 15, 25, 1, 9, 13, 30};

        //int[] arr = new int[]{20, 10, 40, 5,  15, 30, 50, 3, 18};
        int[] arr = new int[]{500, 400, 600, 350, 450, 550, 700, 300, 430, 470, 370, 440, 460, 435, 445};
        for (int i = 0; i < arr.length; i++) {
            inserElementIntoBinaryTree(arr[i]);
        }

        //output:10   5   3   1   8   9   20   15   13   25   30
        /*System.out.println(" preOrderTraversal");
        preOrderTraversal(root);
        System.out.println("\ninOrderTraversal");
        inOrderTraversal(root);
        System.out.println("\npostOrderTraversal");
        postOrderTraversal(root);
*/
        System.out.println(" \n printLevelOrder");
        //  printLevelOrder(root);
        new BinarySearchTree().printLevelOrderInRecursive(root);
        /*//Search
        System.out.println(" \n Search key: 15");

        System.out.println(" Search result: " + (BinaryTreeOperations.searchValueInBSTIterative(root, 15)));

*/

        /*System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,3));
        System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,18));
        System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,3));
        System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,30));
        System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,50));
        System.out.println("\n Search result: " +new BinaryTreeOperations().searchViaRecursiveApproach(root,100));
*/


        // new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,20));
        //  new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,40));
        //new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,10));
        //  new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,3));
        //  new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,15));

        //new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,18));
        //new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,30));
        //   new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,50));
        //  new BinarySearchTree().printLevelOrderInRecursive(BinaryTreeOperations.deleteNodeIterative(root,880));


        //LowestCommonAncestor.findLowestCommonAncestor(root,435,445);
        //LowestCommonAncestor.findLowestCommonAncestor(root,500,600);
        //LowestCommonAncestor.findLowestCommonAncestor(root,400,600);
        // LowestCommonAncestor.findLowestCommonAncestor(root,350,550);
        // LowestCommonAncestor.findLowestCommonAncestor(root,370,460);
        // LowestCommonAncestor.findLowestCommonAncestor(root,435,700);
        LowestCommonAncestor.findLowestCommonAncestor(root, 450, 435);

    }

    public int heightOfBinaryTree(Node node) {

        if (node == null) {
            return -1;
        } else {

            int leftHeight = heightOfBinaryTree(node.leftChild);
            int rightHeight = heightOfBinaryTree(node.rightChild);

            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    public void levelWisePrint(int level, Node node) {

        if (node == null) {
            return;
        }
        if (level == 0) {

            System.out.print(node.data + "  ");


        } else {
            levelWisePrint(level - 1, node.leftChild);
            levelWisePrint(level - 1, node.rightChild);
        }
    }

    public void printLevelOrderInRecursive(Node node) {

        if (node == null) {
            return;
        }
        // System.out.println(node.data);
        int heightOfTree = heightOfBinaryTree(node);
        System.out.println("heightOfTree:" + heightOfTree);
        for (int i = 0; i <= heightOfTree; i++) {
            levelWisePrint(i, node);
        }

    }

    public static class Node {
        public Node leftChild;
        public Node rightChild;

        public int data;

        public Node(int data) {
            leftChild = null;
            rightChild = null;
            this.data = data;
        }
    }
}
