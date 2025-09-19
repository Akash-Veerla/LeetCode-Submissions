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
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        while (curr1 != null) {
            curr.next = curr1;
            curr1 = curr1.next;
            curr = curr.next;
        }
        while (curr2 != null) {
            curr.next = curr2;
            curr2 = curr2.next;
            curr = curr.next;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i + interval < n; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return n == 0 ? null : lists[0];
    }
}