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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node helps handle insertion at the head easily
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // Save the next node to process in the input list
            ListNode nextNode = curr.next;

            // Start searching for the insertion position from the dummy head
            ListNode prev = dummy;
            
            // Find the position where curr.val fits (prev.next.val >= curr.val)
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original list
            curr = nextNode;
        }

        return dummy.next;
    }
}
