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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1), moreHead = new ListNode(-1);
        ListNode lesstail = lessHead, moretail = moreHead;
        ListNode Node = head;
        while (Node != null) {
            if (Node.val < x) {
                lesstail.next = Node;
                lesstail = Node;
            } else if (Node.val >= x) {
                moretail.next = Node;
                moretail = Node;
            }
            Node = Node.next;
        }
        lesstail.next = moreHead.next;
        moretail.next = null;
        return lessHead.next;
    }
}