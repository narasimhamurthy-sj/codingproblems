package datastructure;


public class BinaryTreeOperations {


    public static boolean searchValueInBSTIterative(BinarySearchTree.Node node, int searchKey) {

        boolean found = false;
        if (node == null) {
            return false;
        }
        while (node != null) {
            if (node.data == searchKey) {
                System.out.println("searchKey Found");
                found = true;
                break;
            } else if (searchKey < node.data) {

                node = node.leftChild;
            } else {

                node = node.rightChild;
            }
        }

        return found;
    }

    public static BinarySearchTree.Node deleteNodeIterative(BinarySearchTree.Node node, int deleteNodeData) {
        BinarySearchTree.Node parentNode = null;
        BinarySearchTree.Node rootNode = node;
        BinarySearchTree.Node leftNode = null;
        BinarySearchTree.Node rightNode = null;
        BinarySearchTree.Node currentNode = null;
        BinarySearchTree.Node tempNode = null;
        BinarySearchTree.Node childNodeLeft = null;
        Boolean isDeletableNodeAvailable=false;
        if (node == null) {
            System.out.println("Empty tree");
            return null;
        }
        if (rootNode.data == deleteNodeData) {

            isDeletableNodeAvailable=true;
            //Single node
            if (rootNode.leftChild == null && rootNode.rightChild == null) {
                rootNode = null;
            } else if (rootNode.leftChild == null && rootNode.rightChild != null) {   //left child doesn't exist
                currentNode = rootNode.rightChild;
                rootNode.rightChild = null;
                rootNode = currentNode;
            } else if (rootNode.leftChild != null && rootNode.rightChild == null) {        //right child doesn't exist
                currentNode = rootNode.leftChild;
                rootNode.leftChild = null;
                rootNode = currentNode;
            } else {        //both children exist
                leftNode = rootNode.leftChild;
                rootNode.leftChild = null;
                rightNode = rootNode.rightChild;
                rootNode.rightChild = null;
                //New root node
                rootNode = leftNode;

                if (leftNode.rightChild != null) {
                    currentNode = leftNode.rightChild;

                    while (currentNode.rightChild != null) {
                        currentNode = currentNode.rightChild;
                    }
                    currentNode.rightChild = rightNode;

                } else {
                    //if right child  is obsent for newly becoming root, then attach previous root node right child
                    rootNode.rightChild = rightNode;
                }
            }
        } else { //other than root node to be deleted

            currentNode = rootNode;
            //traverse until node is found and delete
            while (currentNode != null) {

                if (currentNode.data == deleteNodeData) {

                    System.out.println("Found delatable node:" + currentNode.data);
                    isDeletableNodeAvailable=true;
                    rightNode = currentNode.rightChild;
                    leftNode = currentNode.leftChild;
                    //leaf node deletion
                    if (currentNode.rightChild == null && currentNode.leftChild == null) {
                        System.out.println("Deleting leaf node:" + currentNode.data);
                        //leaf node left deletion
                        if (parentNode.rightChild == currentNode) {
                            parentNode.rightChild = null;
                            //leaf node right deletion
                        } else {
                            parentNode.leftChild = null;
                        }
                       // break;
                    } else if (currentNode.leftChild == null && currentNode.rightChild != null) {    //left child is obsent and right child is present is deletablenode is right of it's parent node
                        if (parentNode.rightChild == currentNode) {
                            parentNode.rightChild = rightNode;
                            //removing reference for deleted node
                            currentNode.rightChild=null;
                        } else {  //is deletablenode  left of it's parent node        (parentNode.leftChild==currentNode)
                            parentNode.leftChild = rightNode;
                        }
                        //break;
                    } else if (currentNode.leftChild != null && currentNode.rightChild == null) {    //right child is obsent and left child is present
                        //is deletablenode is right of it's parent node
                        if (parentNode.rightChild == currentNode) {
                            parentNode.rightChild = leftNode;

                        } else {  //is deletablenode  left of it's parent node        (parentNode.leftChild==currentNode)
                            parentNode.leftChild = leftNode;
                            currentNode.leftChild=null;
                        }
                        //break;
                    } else {
                        //when both children exist and is not root node
                        //make delete node as null and remove other links to children
                        currentNode.leftChild = currentNode.rightChild = null;
                        //right child of deletable node is leaf node
                        if (rightNode.rightChild == null && rightNode.leftChild == null) {
                            parentNode.rightChild = rightNode;
                            rightNode.leftChild = leftNode;
                        } else {

                            if(currentNode==parentNode.rightChild) {
                                //Re-assigning parent node right child to deletable node right child
                                parentNode.rightChild = rightNode;
                            }else{
                                parentNode.leftChild = rightNode;
                            }
                            //As we are deleting node,set deltable left and right child as null
                            currentNode.leftChild = currentNode.rightChild = null;
                            //As we have to give link connection of end of node to sub-sequent next left node,traverse till end of left node
                            tempNode = leftNode;
                            while (tempNode.leftChild != null) {
                                tempNode = tempNode.leftChild;
                            }
                            if (rightNode.leftChild != null) {
                                childNodeLeft = rightNode.leftChild;
                                rightNode.leftChild = leftNode;
                                tempNode.leftChild = childNodeLeft;
                            } else {
                                rightNode.leftChild = leftNode;
                            }
                            //deleteNodechild=rightNode;

                        }
                        //break;
                    }

                    break;

                } else if (deleteNodeData < currentNode.data) {

                    //Keep track of parent node to give link to subsequent node post deleting desired node
                    parentNode = currentNode;
                    currentNode = currentNode.leftChild;

                } else {

                    //Keep track of parent node to give link to subsequent node post deleting desired node
                    parentNode = currentNode;
                    currentNode = currentNode.rightChild;
                }
            }


        }

        if(!isDeletableNodeAvailable){
           System.out.println("Given node not found");
        }else{

            System.out.println("Given node is deleted");
        }
        return rootNode;
    }

    public boolean searchViaRecursiveApproach(BinarySearchTree.Node node, int searchKey) {

        if (node == null) {
            return false;
        }

        if (node.data == searchKey) {
            return true;
        } else if (searchKey < node.data) {
            return searchViaRecursiveApproach(node.leftChild, searchKey);

        } else {
            return searchViaRecursiveApproach(node.rightChild, searchKey);
        }
    }
}