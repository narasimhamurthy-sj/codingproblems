package datastructure;

public class CheckBST_Balanced {

    public boolean isBalanced(BSTNode root) {

        if (root == null) {
            System.out.println("Empty tree");
            return false;
        }

        return checkHeightAndBalance(root) != -1;

    }


    public int checkHeightAndBalance(BSTNode root) {

        if (root == null)
            return 0;
        int leftHeight = checkHeightAndBalance(root.leftChild);
        if (leftHeight == -1)
            return -1;
        int rightHeight = checkHeightAndBalance(root.rightChild);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
