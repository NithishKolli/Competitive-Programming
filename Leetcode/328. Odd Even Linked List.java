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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next==null){
            return head;
        }
        ListNode evenRightPointer = head.next;
        ListNode evenLeftPointer = head.next;
        ListNode oddRightPointer = head;
        while(evenRightPointer!= null && evenRightPointer.next != null) {
            ListNode newOddNode = evenRightPointer.next;
            evenRightPointer.next = newOddNode.next;
            evenRightPointer = evenRightPointer.next;
            oddRightPointer.next= newOddNode;
            oddRightPointer = newOddNode;
        }
        oddRightPointer.next = evenLeftPointer;
        return head;
    }
}