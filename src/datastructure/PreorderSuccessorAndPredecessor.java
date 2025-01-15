package datastructure;

public class PreorderSuccessorAndPredecessor {

    BinarySearchTree.Node predecessorNode=null;
    BinarySearchTree.Node successorNode=null;
    BinarySearchTree.Node previousNode=null;
    boolean isKeyFound=false;
    public void findPredecessorAndSuccessor(BinarySearchTree.Node node, int searchKey){

        if(node==null){
            return;
        }
        if(successorNode!=null){
            return;
        }
        if(node.data==searchKey){
            predecessorNode=previousNode;
            if(predecessorNode!=null) {
                System.out.println("predecessorNode:" + predecessorNode.data);
            }else{
                System.out.println("predecessorNode doesn't exist");
            }
            isKeyFound=true;
        } else if (isKeyFound) {
            successorNode=node;
            System.out.println("successorNode:"+successorNode.data);
            return;
        } else{
            previousNode=node;
        }
        findPredecessorAndSuccessor(node.leftChild,searchKey);
        findPredecessorAndSuccessor(node.rightChild,searchKey);

    }


    public static void main(String[] args) {
        BinarySearchTree.Node root=null;
        int[] arr = new int[]{1000,500,1500,250,750,1250,2000,150,850,1350,2500,200,800,1300,1400,2300,1330};
        //  int[] arr = new int[]{1000,500,1500,250,750,1300,2000};
        for (int nodeData : arr) {
            root = BinarySearchTree.inserElementIntoBinaryTree(nodeData);
        }
        PreorderSuccessorAndPredecessor findPredecessorAndSuccessor= new PreorderSuccessorAndPredecessor();
        //2300 last node in preorder traversal, successor will be absent
        // 1000 first node in preorder traversal, predecessor will be absent
        //200 -left sub tree leaf node
        //1400 right sub tree leaf node
        //750 key node with left child absent
        //250 key node with right child absent
        //1350 key node having both the children
        //key node which doesn't exist
        //1500 keynode which is immediate right child of root node - Testing because predecessor lies on left subtree of root node
        //800 keynode which is present in left sub tree from root but successor lies on right sub tree from root
        findPredecessorAndSuccessor.findPredecessorAndSuccessor(root,800);
        if(!findPredecessorAndSuccessor.isKeyFound){
            System.out.println("Key doesn't exist");
        }

        if(findPredecessorAndSuccessor.successorNode==null){
            System.out.println("successorNode doesn't exist");
        }
    }
}
