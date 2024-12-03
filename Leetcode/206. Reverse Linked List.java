/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode leftNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while(currNode!=null ){
            currNode.next = leftNode;
            leftNode = currNode;
            currNode = nextNode;
            if(nextNode!=null){
                nextNode = nextNode.next;
            }
            
        }
        return leftNode;
    }
}