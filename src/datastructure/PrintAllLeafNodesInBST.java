package datastructure;

public class PrintAllLeafNodesInBST {
    /*
    Post order traversal will be the good approach, as it checks first left and right child node.
    In case of leaf node, left and right node should be absent.



    Tests:
    1. all the leaf nodes at same level
    2. all the leaf nodes at different level
     */
    boolean isLeftNodeNotNull, isRightNodeNotNull;

    public static void main(String[] args) {
        BinarySearchTree.Node root = null;
        int[] leafNodesAtSamelevelArr = new int[]{1000, 500, 1500, 250, 750, 1250, 2000};
        int[] leafNodesAtdifferentlevelsArr = new int[]{1000, 500, 1500, 750, 2000, 600, 1750, 650, 1900, 1800};
        int[] leftSkewedArr = new int[]{1000, 500, 250, 150, 50, 10, 1};
        int[] rightSkewedArr = new int[]{1000, 1500, 2000, 2500, 3000, 35000, 4000};
        int[] leftandRightSkewedArr = new int[]{1000, 500, 250, 150, 50, 10, 1, 1500, 2000, 2500, 3000, 35000, 4000};
        for (int i = 0; i < leftandRightSkewedArr.length; i++) {
            root = BinarySearchTree.inserElementIntoBinaryTree(leftandRightSkewedArr[i]);
        }
        PrintAllLeafNodesInBST leafNodeTree = new PrintAllLeafNodesInBST();
        leafNodeTree.printLeafNodes(root);
    }

    public void printLeafNodes(BinarySearchTree.Node root) {

        if (root == null)
            return;
        /*isLeftNodeNotNull=*/
        printLeafNodes(root.leftChild);
        /*isRightNodeNotNull=*/
        printLeafNodes(root.rightChild);
        if (root.leftChild == null && root.rightChild == null) {
            System.out.println(root.data);
        }
//return ;
    }
}
