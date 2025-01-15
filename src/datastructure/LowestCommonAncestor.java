package datastructure;

import java.util.ArrayList;

public class LowestCommonAncestor {

/*
Steps:
1.Search for given node 1
   1.1 while searching, store the nodes in ArrayList as we traverse the path
2. Search for given node 2 and repeat the steps as in 1.1
3.Pick up ArrayList node which has less nodes or smaller in size
   node1 and node2 path may not be same. Sometimes node1 path may be too long compare to node2 or vice versa.
   Hence will consider node with shorter path to reduce the time for comparision.
4. In a loop, iterate till size of shorter arraylist,
   Let's say node1 ArrayList has shorter path compared to  node2 ArrayList
   4.1 Now start checking each node of node1 ArrayList available in node2 ArrayList.
       We are performing this step to find common parent for node1 and node 2.
   4.2 If node is available, we found a common ancestor and store it in commonParentNode.

        IF node2ArrayList contains nodeFrom_node1ArrayList
        commonParentNode=node2 ArrayList

   Repeat this step until end of node1ArrayList size

   END OF LOOP

   5. Print commonParentNode. Tha latest value assigned to this node will be the lowest common ancestor


 */

    public static ArrayList<BinarySearchTree.Node> searchAndStoreNodePathInArrayList(int searchKey,BinarySearchTree.Node root){
        ArrayList<BinarySearchTree.Node> searchKeyPathNodeList=new ArrayList<>();
        BinarySearchTree.Node currentNode=root;
        boolean isSearchKeyFound=false;

        while(currentNode!=null){

            if(currentNode.data==searchKey){
                searchKeyPathNodeList.add(currentNode);
                System.out.println("Search key found:"+currentNode.data);
                isSearchKeyFound=true;
                break;
            }else if(searchKey<currentNode.data){
                searchKeyPathNodeList.add(currentNode);
                currentNode=currentNode.leftChild;
            }else{
                searchKeyPathNodeList.add(currentNode);
                currentNode=currentNode.rightChild;
            }
        }

        if(!isSearchKeyFound) {
            System.out.println("Given search key not found");
        }
        return searchKeyPathNodeList;
    }

    public static BinarySearchTree.Node findCommonParent(ArrayList<BinarySearchTree.Node> smallerPathList,ArrayList<BinarySearchTree.Node> biggerPathList){

        BinarySearchTree.Node commonParent=null;
        for (int i = 0; i < smallerPathList.size(); i++) {

            if(biggerPathList.contains(smallerPathList.get(i))){
                commonParent=smallerPathList.get(i);
            }
        }
       return commonParent;

    }
    public static BinarySearchTree.Node findLowestCommonAncestor(BinarySearchTree.Node root,int node1Data,int node2Data){

        ArrayList<BinarySearchTree.Node> traversedNodeListOfNode1=searchAndStoreNodePathInArrayList(node1Data,root);
        ArrayList<BinarySearchTree.Node> traversedNodeListOfNode2=searchAndStoreNodePathInArrayList(node2Data,root);
        BinarySearchTree.Node leastCommonParent=null;

        if(traversedNodeListOfNode1.size()<traversedNodeListOfNode2.size()){
            leastCommonParent=findCommonParent(traversedNodeListOfNode1,traversedNodeListOfNode2);
        }else{
            leastCommonParent=findCommonParent(traversedNodeListOfNode2,traversedNodeListOfNode1);
        }

        System.out.println("Least common parent: "+leastCommonParent.data);

        return leastCommonParent;
    }

    /*
    Node lowestCommonAncestor(Node root, Node p, Node q) {
	    if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		Node leftSubtree = lowestCommonAncestor(root.left, p, q);
		Node rightSubtree = lowestCommonAncestor(root.right, p, q);
		if (leftSubtree == null) {
			return rightSubtree;
		}
		if (rightSubtree == null) {
			return leftSubtree;
		}
		return root;
	}
}


     */

}
