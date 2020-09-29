// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node prevNode = head;
        Node currNode = head.next;
        
        while(currNode!=head){
            if(prevNode.val <= currNode.val){
                if(prevNode.val < insertVal && insertVal <= currNode.val){
                    break;
                }
            }
            else{
                if(prevNode.val < insertVal || insertVal <= currNode.val){
                    break;
                }
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = newNode;
        newNode.next = currNode;
        return head;
    }
}