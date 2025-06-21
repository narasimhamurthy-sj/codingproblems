package datastructure;

import java.util.ArrayList;

public class InoderSuccessorAndPredecessor {


    ArrayList<Integer> dataStoredAsInorderTraversal = new ArrayList<>();
    int nodeCount = 0;
    boolean keyFound = false;
    int counfAfterKeyFound = 0;
    BinarySearchTree.Node successorNode = null;
    BinarySearchTree.Node predecessorNode = null;
    BinarySearchTree.Node traverseNodeLeft = null;
    BinarySearchTree.Node traverseNodeRight = null;

    public static void main(String[] args) {
        BinarySearchTree.Node root = null;
        int[] arr = new int[]{1000, 500, 1500, 250, 750, 1250, 2000, 150, 850, 1350, 2500, 200, 800, 1300, 1400, 2300, 1330};
        //  int[] arr = new int[]{1000,500,1500,250,750,1300,2000};
        for (int nodeData : arr) {
            root = BinarySearchTree.inserElementIntoBinaryTree(nodeData);
        }
        InoderSuccessorAndPredecessor objectOfSuccessorAndPredecessor = new InoderSuccessorAndPredecessor();
/*

        objectOfSuccessorAndPredecessor.inorderTraversalWithOptimizedArrayListSize(root,1000);
        System.out.println("dataStoredAsInorderTraversal size: "+*//*new InoderSuccessorAndPredecessor().*//*objectOfSuccessorAndPredecessor.dataStoredAsInorderTraversal.size());
        objectOfSuccessorAndPredecessor.findSuccessorAndPredecessorNodes(1000);*/

        // test for root node
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 1000);

        // test for first node in the inorder traversal order, predecessor will be null/doesn't exist
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 150);

        // test for last node in the inorder traversal, successor will be null/doesn't exist
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 2500);

        // test for any leaf node which is present under left sub tree of root node
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 200);

        //  test for any leaf node which is present under right sub tree of root node
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 2300);

        // test for node in which left child is absent in the BST
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 750);

        // test for node in which right child is absent in the BST
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 250);

        // test for node having both the children in the BST
        new InoderSuccessorAndPredecessor().searchPredecessorAndSuccessorNode(root, 1350);


    }

    public void findSuccessorAndPredecessorNodes(int key) {

        if (dataStoredAsInorderTraversal.contains(key)) {

            int indexOfNode = dataStoredAsInorderTraversal.indexOf(key);
            if (indexOfNode == 0) {
                System.out.println("Predecessor node not present");
                System.out.println("Successor node :" + dataStoredAsInorderTraversal.get(indexOfNode + 1));
            } else if (indexOfNode == dataStoredAsInorderTraversal.size() - 1) {
                System.out.println("Successor node not present in the tree, as key is found at the end");
                System.out.println("Predecessor node :" + dataStoredAsInorderTraversal.get(indexOfNode - 1));
            } else {
                System.out.println("Predecessor node :" + dataStoredAsInorderTraversal.get(indexOfNode - 1));
                System.out.println("Successor node :" + dataStoredAsInorderTraversal.get(indexOfNode + 1));

            }
        } else {
            System.out.println("Node not found");

        }
        // As dataStoredAsInorderTraversal global variable, clear off existing data to avoid storing new data on top of existing data

        dataStoredAsInorderTraversal.clear();
    }

    public void inorderTraversal(BinarySearchTree.Node node) {

        if (node == null) {
            return;
        }

        inorderTraversal(node.leftChild);
        dataStoredAsInorderTraversal.add(node.data);
        inorderTraversal(node.rightChild);

    }

    public void inorderTraversalWithOptimizedArrayListSize(BinarySearchTree.Node node, int key) {

        if (nodeCount > counfAfterKeyFound && keyFound) {
            return;
        }
        if (node == null) {
            return;
        }

        inorderTraversalWithOptimizedArrayListSize(node.leftChild, key);
        ++nodeCount;
        if (!keyFound) {
            dataStoredAsInorderTraversal.add(node.data);
            //return;
        }
        //  dataStoredAsInorderTraversal.add(node.data);

        if (key == node.data) {
            keyFound = true;
            counfAfterKeyFound = nodeCount + 1;
        } else {
            if ((dataStoredAsInorderTraversal.size() > 1) && (!keyFound)) {

                dataStoredAsInorderTraversal.removeFirst();
            }
        }

        if (nodeCount == counfAfterKeyFound) {
            dataStoredAsInorderTraversal.add(node.data);
        }

        inorderTraversalWithOptimizedArrayListSize(node.rightChild, key);

    }

    public void searchPredecessorAndSuccessorNode(BinarySearchTree.Node node, int key) {

        if (node.data == key) {

            //From left sub-tree,find max value among all nodes but it should be nearer and below the key node value
            //to find predecessor node
            if (node.leftChild != null) {
                //Go to left child of key node and traverse right sub-tree
                traverseNodeLeft = node.leftChild;
                //We can get bigger value if we traverse right subtree from key node
                while (traverseNodeLeft.rightChild != null)
                    traverseNodeLeft = traverseNodeLeft.rightChild;

                //Traversed Node which we found is the bigger value among all nodes from key node
                // and this is going to be predecessor node to the key node
                predecessorNode = traverseNodeLeft;

            }

            //From right sub tree,find min value among all nodes but it should be nearer and above the key node value
            //to find successor node
            if (node.rightChild != null) {
                //Go to right child of key node and traverse left sub tree
                traverseNodeRight = node.rightChild;
                //We can get the smallest value if we traverse left subtree from key node
                while (traverseNodeRight.leftChild != null)
                    traverseNodeRight = traverseNodeRight.leftChild;

                //Traversed Node which we found is the smallest value among all nodes from key node
                // and this is going to be successor node to the key node
                successorNode = traverseNodeRight;


            }
            if (predecessorNode != null) {
                System.out.println("predecessor Node:" + predecessorNode.data);
            } else {
                System.out.println("predecessor Node not present");
            }

            if (successorNode != null) {
                System.out.println("successor Node:" + successorNode.data);
            } else {
                System.out.println("successor Node not present");
            }

            //As we found key node,predecessorNode and successorNode, stop the recursive call
            return;
        } else if (key < node.data) {
            //There could be possibility that if we encounter key node as leaf node/ any other
            // node not having left or right child node. Then current node could be successor node
            // before we travese it's left child
            successorNode = node;

            // Shift search to the left sub-tree with recursive call if key node value is lesser than root/sub-sequent tree node
            searchPredecessorAndSuccessorNode(node.leftChild, key);

        } else {
            //There could be possibility that if we encounter key node as leaf node/ any other
            // node  which is not having left or right child node. Then current node could be predecessor node
            //  before we travese it's right child
            predecessorNode = node;

            // Shift search to the right sub-tree with recursive call if key node value is greater than root/sub-sequent tree node
            searchPredecessorAndSuccessorNode(node.rightChild, key);
        }
    }


}
