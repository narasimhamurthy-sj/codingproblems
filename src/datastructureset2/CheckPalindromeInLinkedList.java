package datastructureset2;

public class CheckPalindromeInLinkedList {
    boolean isPalindrome;
    boolean doesSameNodesDataMatching;
   //  static Node head;
     static Node tmpNode;
    public boolean areNodesPalindrome(Node right){

        if(right==null)
            return true;
        isPalindrome=areNodesPalindrome(right.link);
        if(isPalindrome==false)
            return false;

        if(tmpNode.info== right.info) {
            doesSameNodesDataMatching = true;
            if(tmpNode==right){
                throw new RuntimeException("List is Palindrome and ending execution");

            }
        }else{
            doesSameNodesDataMatching = false;
        }
        tmpNode=tmpNode.link;

        return doesSameNodesDataMatching;
    }



    boolean ip;
    boolean isNodeInfoSame;
    public boolean areNodesInLinkedlistPalinrome(Node node){

        if(node==null){
            return true;
        }
       ip= areNodesInLinkedlistPalinrome(node.link);

        if(ip==false){
            return false;
        }

        if(tmpNode.info==node.info){
            isNodeInfoSame=true;

            if(tmpNode==node){
              throw  new RuntimeException("We have reached mid node. No further comparision is required. Will come out from recursive call. Given list is Palindrome");
            }
        }else{
            isNodeInfoSame=false;
        }
        tmpNode=tmpNode.link;
        return isNodeInfoSame;
    }

    public static void main(String[] args) {
      Node  head= Node.createLLWithManualEntryData(new int[]{6,4,6});
        tmpNode=head;
       Node.printLL(head);
       boolean result=new CheckPalindromeInLinkedList().areNodesPalindrome(head);
        System.out.println("\n result:"+result);
    }
}
