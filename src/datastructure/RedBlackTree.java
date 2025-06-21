package datastructure;

/*
Properties of a Red-Black Tree
The root of the tree is always black.

Red nodes cannot have red children (i.e., no two red nodes can be adjacent).
A red node must have two black child nodes

Every path from a node to its descendant NIL nodes must have the same number of black nodes.
This count is called the black-height of the node.

R-R adjacent: 1.check  whether uncle has red color,
    if so just re-color parent and uncle to black
    if grand parent is present but not root node, then recolor grand parent to red
 2. If uncle is black or not present,perform rotation
    From rotation, Before making new node as parent, check any left or right is root node
    If so, make current parent node as root(check parent or grandparent is root)
    re-color parent and grand parent

if parent is black, no need of any actions
//---------------------------------------------------------------------------------------
LL rotation:
  //on same side
        ancestorNode=grandParent.parent
        grandParent.parent=parent
        parent.rightChild=grandParent
        grandParent.leftChild=null;

        if( ancestorNode !=null)
        ancestorNode.leftChild=parent

        parent.parent=ancestorNode


       if( isNodeRoot)
       root=parent
//---------------------------------------------------------------------------------------
RR rotation:
  //on same side
       ancestorNode=grandParent.parent
       parent.leftChild=grandParent
       grandParent.rightChild=null
       grandParent.parent=parent
       parent.parent=ancestor
       ancestor.rightChild=parent

       if( isNodeRoot)
       root=parent

//---------------------------------------------------------------------------------------
rotation: root,parent,grandParent,newNode

     //check whether adjacent node is root
     if(grandParent==root or parent==root)
            isNodeRoot=true

     //check on same line/side:RR rotation
     if grandParent.rightChild==parent && parent.rightChild==newNode
        //on same side
       call RR rotation
       call - color change

     //check on same line/side:LL rotation
     if grandParent.leftChild==parent && parent.leftChild==newNode
        //on same side
       call LL rotation
       call - color change
 else
 // This case could be LR or RL rotation

     //If RL rotation
     if grandParent.rightChild==parent && parent.leftChild==newNode
          if(newNode.rightChild!=null)
             newNode.rightChild=parent
             childRightNode=newNode.rightChild
          if(newNode.leftChild!=null)
            childLeftNode=newNode.leftChild
     grandParent.rightChild=newNode
     newNode.parent=grandParent
     parent.parent=newNode


     call RR rotation
     call - color change(Pass proper args because child and parent will interchange positio)

     // If LR rotation
     if grandParent.leftChild==parent && parent.rightChild==newNode
     parent.rightChild=null
     grandParent.leftChild=newNode
     if(newNode.leftChild!=null)
        childLeftNode=newNode.leftChild
        newNode.leftChild=parent
     if(newNode.rightChild!=null)
        childRightNode=newNode.rightChild

     newNode.parent=grandParent
     parent.parent=newNode
     newNode.parent=grandParent

     call LL rotation
     call color change(Pass proper args because child and parent will interchange position)









//---------------------------------------------------------------------------------------
color:args- parent  uncle and grandParent
    parentNode.color='black'

    if uncle!=null
    uncleNode.color='black'

    if grandParent!=root
    grandParent.color=red


//---------------------------------------------------------------------------------------
convertToRedBlackTree
params: root,parent,grandParent,newNode

if
if  parent!=null && parent.color is red

            if grandParent.rightChild==parent
            uncleNode=grandParent.leftChild
            else
            uncleNode=grandParent.rightChild

            if(uncleNode==null or uncleNode.color equal to 'Black')
            //rotation

            call rotation




            else{
            //uncle exists and is red
            //color parent  uncle and grandParent
            call changeColor()
            // after color, check ancestor and grand parent whether in red
            ancester=grandParent.parent;
            if ancestor.color equals to Red && parent.color equals to Red
                call convertToRedBlackTree

            }




//---------------------------------------------------------------------------------------
if root null
    newNode.color=black
    root=newNode
    root.parent=null;

currentNode=root
 Iterate tree

 parent=currentNode;
     check newNode data is less than current node

          currentNode=currenNode.leftChild;

     check newNode data is greater than current node
          currentNode=currenNode.rightChild;

      if currentNode!=null
      grandParent=parent


      if currentNode is null
      currentNode=newNode
      currentNode.parent=parent
      break

   //End of loop


 call convertToRedBlackTree





 */
public class RedBlackTree {

    class Node {
        Node leftChild;
        Node rightChild;
        String color = "";

        int nodeData;

        Node(int nodeData) {
            leftChild = null;
            rightChild = null;
            color = "red";
            this.nodeData = nodeData;
        }
    }
}
