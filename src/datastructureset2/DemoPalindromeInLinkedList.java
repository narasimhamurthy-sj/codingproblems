package datastructureset2;

public class DemoPalindromeInLinkedList {

    void xyz(){
        abc();
        System.out.println("xyz");
    }
    void abc(){

        System.out.println("abc");
    }

static Node tempNode;
    boolean isNodeDataMatching;
    boolean isPalindrome;
  static  boolean result=false;
    boolean isLinkedListPalindrome(Node node){
        if(node==null)
            return true;

        isPalindrome=isLinkedListPalindrome(node.link);

        if(isPalindrome==false)
            return false;


        if(tempNode.info==node.info){
            isNodeDataMatching=true;

            if(tempNode==node){
                System.out.println("Linked is Palindrome");
                result=true;
               // new RuntimeException("We are mid node,no need of further node comparision");
                return false;
            }
        }else{
            isNodeDataMatching=false;
        }

        tempNode=tempNode.link;

return isNodeDataMatching;
    }

    public static void main(String[] args) {
        new DemoPalindromeInLinkedList().xyz();

      Node head=  Node.createLLWithManualEntryData(new int[]{60,70,60});
      tempNode=head;

 new DemoPalindromeInLinkedList().isLinkedListPalindrome(head);
 if(result){

 }else{
     
 }

    }

}
