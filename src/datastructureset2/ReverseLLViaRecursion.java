package datastructureset2;

public class ReverseLLViaRecursion {

    /*
    LL: 10,20,30

    1. Traverse till end of node
    2.if last node
      make last node as head
      return node (in this case, returns  last node and breaks recursion call)
    3. To traverse as mentioned in step 1, call recusrively method
       3.1 pass node.link as argument to move to next node in LL
       3.2 The method should catch node information on each recursive call. So that we can re-aassign link connection in reverse order.
        Hence store it in a node reference variable

    nodeRecievedfromeachcall=methodRecurse(node.link)

    4. nodeRecievedfromeachcall contains previously method returned node information. Lets say last node
       and current method stack call contains last but one as reursive call is stopped from base condition and function call is traversing back
       4.1 assign current node as link to recieved node
       nodeRecievedfromeachcall.link=node
       4.2 set current node link which is pointing to next node as null
       nodeRecievedfromeachcall.link=null
       4.3 return current node


     */



   static FindIntersectionNodeInLL.Node head;
    public FindIntersectionNodeInLL.Node recusiveLL(FindIntersectionNodeInLL.Node node){


        if(node.link==null){
            head=node;
            return node;
        }
        FindIntersectionNodeInLL.Node nodeReceivedFromEachFunctionCall= recusiveLL(node.link);
        nodeReceivedFromEachFunctionCall.link=node;
        node.link=null;
        return node;

    }


    public static void main(String[] args) {
        FindIntersectionNodeInLL.Node ll = FindIntersectionNodeInLL.createLL(3);
        FindIntersectionNodeInLL.printLL(ll);

        System.out.println("\n after reverse");

        new ReverseLLViaRecursion().recusiveLL(ll);
        FindIntersectionNodeInLL.printLL(head);

    }
}
