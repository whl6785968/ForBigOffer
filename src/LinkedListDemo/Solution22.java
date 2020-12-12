package LinkedListDemo;

import Structure.ListNode;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;

        while (k-- > 0){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
