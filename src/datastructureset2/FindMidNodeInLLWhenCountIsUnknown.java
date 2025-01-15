package datastructureset2;

public class FindMidNodeInLLWhenCountIsUnknown {

    /*
    Keep 2 pointers, p1 and p2,traverse p2 first and p1 as the previous point
     Traverse in mutiples of 2 i.e., 2,4,8,16,32

     */

    /*
    List: 1,2,3,4,5,6,7,8,9
    Mid- 5

  Approach: will maitain 2 pointers p1 and p2. P1 always point to half length of p2.
  will shift p1 to p2 position, if p2 doesn't encounter last node. This position changing will do in the order of 1,2,4,8,16,32th positions etc..
  i.e. when p2 at 2,p1 will be at 1
  when p2 at 4, p1 will be at 2
  when p2 at 8, p1 will be at 4 so on...
  Once P2 is nearer to the end node or finds no node, will declare p1 as mid node

   Steps:
   1. SET P1 and P2 as first node in linked list
   Traverse till end of node using P2 pointer with the help of loop
   Lets create currentposition and p1nodePosition variables to track position of the  nodes in the linked list and SET default value as 1
   Lets create currentNode and temporaryMidNode
   2  Until P2 reaches last node keep on visiting each node in linked list

      2.1      currentPosition is equla to P1position*2
            temporaryMidNode=currentNode
      2.2  Check  currentposition is equal to twiceOfP1Nodeposition(P1position*2)*2
          2.2.1 Shift the P1  position to next mid position
                 p1Position=p1Position*2
          2.2.2  make p1 node as mid node
                 P1NOde=temporaryMidNode
      2.3  SET P2 node as next node in list
           P2Node=P2Node.link;
      2.4 Increment currentPosition by one
          currentPosition++
    3. END LOOP
    4. END
*/

public static Node findMidNode(Node head){
    Node p1Node,p2Node,temporaryMidNode=null,temporaryMidNode2=null;
    int currentIterationPosition, p1NodePosition,p2NodePosition;
    p1Node=head;
    p2Node=head;
    currentIterationPosition=1;
    p1NodePosition=1;
    p2NodePosition=2;
    int p1nodeNextPos=1;
    while(p2Node!=null){

       // p1nodeNextPos=p1nodeNextPos*2;
        if(currentIterationPosition==(p1NodePosition*2)){
            if(currentIterationPosition==((p2NodePosition*2))){
                temporaryMidNode2=p2Node;
            }else{
                temporaryMidNode=p2Node;
            }
            p1NodePosition=p1NodePosition*2;
        }
        if (currentIterationPosition==((p2NodePosition*2)) ){//&& (p2Node.link!=null)


            p1Node=temporaryMidNode;
            p2NodePosition=p2NodePosition*2;
            temporaryMidNode=temporaryMidNode2;

        }
        p2Node=p2Node.link;
        currentIterationPosition++;
    }

    System.out.println("\n P2 Node Position:" + p2NodePosition);
    System.out.println("Mid Node Position:" + p1NodePosition);
    System.out.println(" Total Nodes:" + (currentIterationPosition-1));
    if((currentIterationPosition-1)%2==0) {
        System.out.println(" Mid node:" + p1Node.info);
    }else{
        p1Node=p1Node.link;
        System.out.println(" Mid node:" + p1Node.info);
    }
    return p1Node;

}










    public static void midNode(FindIntersectionNodeInLL.Node linkedList){

        FindIntersectionNodeInLL.Node pointer1=linkedList;
        FindIntersectionNodeInLL.Node pointer2=linkedList;

        while(pointer2.link!=null){

            pointer1=pointer1.link;
            if(pointer2.link.link==null) {
                break;

            }else{
                pointer2 = pointer2.link.link;
            }

        }

        System.out.println("\n Mid Node: "+pointer1.info);
    }

    public static void main(String[] args) {
        FindIntersectionNodeInLL.Node list1= FindIntersectionNodeInLL.createLL(100);
        FindIntersectionNodeInLL.printLL(list1);
        midNode(list1);

      //  Node.createLL(5);
       /* Node ll=Node.createLL(14);
        System.out.println("\n List: ");
        Node.printLL(ll);
        findMidNode(ll);
*/
    }
}
