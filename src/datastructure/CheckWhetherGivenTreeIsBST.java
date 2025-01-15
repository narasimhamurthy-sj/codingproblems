package datastructure;





/*



 */
public class CheckWhetherGivenTreeIsBST {

boolean isBinarySearchTree=true;
    public boolean isBST(BinarySearchTree.Node root, boolean isLeftTraversal,int previousNodeData){

        if(root==null) {
            return true;
        }

        if(isLeftTraversal){
           if( root.data>previousNodeData){
               isBinarySearchTree=false;
               return isBinarySearchTree;
           }
        }else{
            if( root.data<previousNodeData){
                isBinarySearchTree=false;
                return isBinarySearchTree;

            }
        }


        previousNodeData= root.data;

        isBST(root.leftChild,true,previousNodeData);
        isBST(root.rightChild,false,previousNodeData);

        return isBinarySearchTree;
    }

    static BinarySearchTree.Node root;
    public static void main(String[] args) {

       // BinarySearchTree bst=new BinarySearchTree();

        int[] arr = new int[]{1000,800,1900,600,900,1700,2100,400,700,850,950,1500,1800,2000,2300};
        for (int i = 0; i < arr.length; i++) {
             root= BinarySearchTree.insertElementsIntoNonBST(arr[i]);
          //  root= BinarySearchTree.inserElementIntoBinaryTree(arr[i]);
        }

        BinarySearchTree.printLevelOrder(root);

        boolean isBinarySearchTree=new CheckWhetherGivenTreeIsBST().isBST(root,true,root.data);
        System.out.println("\n Is Binary search tree:"+isBinarySearchTree);

    }






}
