package LinkedListDemo;

import Structure.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;


        while (m > 1){
            pre = pre.next;
            m--;
            n--;
        }

        head = pre.next;

        while (n > 1){
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = pre.next;
            pre.next = next;
            n--;
        }

        return dummy.next;
    }

}
