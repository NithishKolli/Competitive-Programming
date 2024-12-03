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
    public int pairSum(ListNode head) {
        if (head == null){
            return 0;
        }
        if(head.next.next == null) {
            return head.val + head.next.val;
        }
        ListNode leftPointer = head;
        ListNode rightPointer = head.next;
        Stack<Integer> firstHalf = new Stack<>();
        int maxSum = 0;
        while(rightPointer.next != null){
            firstHalf.push(leftPointer.val);
            leftPointer = leftPointer.next;
                rightPointer = rightPointer.next.next;
        }
        firstHalf.push(leftPointer.val);
        leftPointer = leftPointer.next;
        while(leftPointer != null) {
            maxSum = Math.max(maxSum, leftPointer.val+firstHalf.pop());
            leftPointer = leftPointer.next;
        }
        return maxSum;
    }
}