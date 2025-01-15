package datastructure;

public class FindMinAndMaxValueInBST {

    public void rootNodeValidations(BinarySearchTree.Node root) {
        if (root == null) {
            System.out.println("Empty BST");
            return;
        }
        if (root.leftChild == null && root.rightChild == null) {
            System.out.println("BST has single root");
            return;
        }
    }

    public int findMinValueInBST(BinarySearchTree.Node root) {

        rootNodeValidations(root);

        BinarySearchTree.Node node = root;
        int minValue=0;
        while (node != null) {
            if (node.leftChild == null) {
                minValue = node.data;
            }
            node = node.leftChild;
        }
        System.out.println("minValue:"+minValue);

        return minValue;
    }


    public int findMaxValueInBST(BinarySearchTree.Node root) {

        rootNodeValidations(root);

        BinarySearchTree.Node node = root;
        int maxValue=0;
        while (node != null) {
            if (node.rightChild == null) {
                maxValue = node.data;
            }
            node = node.rightChild;
        }
        System.out.println("maxValue:"+maxValue);
        return maxValue;
    }

    public static void main(String[] args) {
       // int[] arr = new int[]{500,400,600,350,450,550,700,300,430,470,370,440,460,435,445};

      //   int[] arr = new int[]{1000,800};
       // int[] arr = new int[]{1000,1200};

       // int[] arr = new int[]{1000};

      //  int[] arr = new int[]{};
      //  int[] arr = new int[]{1000,800,1200,900};

        int[] arr = new int[]{1000,800,1200,600,900,1100,1400,400,700,1050,1150,1300,1600};

        BinarySearchTree.Node root=null;
        for (int i = 0; i < arr.length; i++) {
             root=BinarySearchTree.inserElementIntoBinaryTree(arr[i]);
        }
        new FindMinAndMaxValueInBST().findMinValueInBST(root);
        new FindMinAndMaxValueInBST().findMaxValueInBST(root);
    }
}
