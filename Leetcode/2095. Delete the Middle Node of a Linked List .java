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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next ==null) {
            return null;
        }
        ListNode firstPointer=head;
        ListNode secondPointer=head;
        ListNode prev=head;
        while(secondPointer.next!=null && secondPointer.next.next !=null){
            prev = firstPointer;
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next.next;
        }
        if(secondPointer.next!=null){
            prev = firstPointer;
            firstPointer=firstPointer.next;
        }
        prev.next=firstPointer.next;
        return head;
    }
}