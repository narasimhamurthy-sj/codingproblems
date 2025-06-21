package dataStructureSet3;

import datastructure.BSTNode;

import static datastructure.BSTNode.root;


/*
The diameter of a binary tree is the length of the longest path between any two nodes
in the tree. This path may or may not pass through the root.

The length is measured in terms of the number of edges between the nodes.

Not the number of nodes, but the edges between them.


         1
        / \
       2   3
      / \
     4   5
     Longest path: 4 -> 2 -> 1 -> 3

Number of edges: 3

So, diameter = 3
 */
public class DiameterOfBST {

    int diamtr = 0;

    public static void main(String[] args) {

        DiameterOfBST diameter = new DiameterOfBST();

        int[] nodesArr = {50, 100, 150, 200};
        for (int nodeData : nodesArr) {
            diameter.insert(nodeData);
        }
        diameter.inorderTraversal(root);
        diameter.calculateDiatemeter(root);
        System.out.print("\ndiameter:" + diameter.diamtr);
    }

    // BSTNode node=new BSTNode()
    public BSTNode insert(int data) {

        BSTNode curNode = null;

        if (root == null) {

            root = new BSTNode(data);

        } else {
            curNode = root;
            while (true) {
                if (data <= curNode.nodeData) {
                    if (curNode.leftChild == null) {
                        curNode.leftChild = new BSTNode(data);
                        break;
                    }

                    curNode = curNode.leftChild;
                } else {
                    if (curNode.rightChild == null) {
                        curNode.rightChild = new BSTNode(data);
                        break;
                    }

                    curNode = curNode.rightChild;
                }
            }
        }
        return root;
    }

    public int calculateDiatemeter(BSTNode node) {
        if (node == null)
            return 0;

        int leftHeight = calculateDiatemeter(node.leftChild);
        int rightHeight = calculateDiatemeter(node.rightChild);
        diamtr = Math.max(diamtr, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void inorderTraversal(BSTNode node) {

        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.print(node.nodeData + "  ");
            inorderTraversal(node.rightChild);
        }
    }

}
