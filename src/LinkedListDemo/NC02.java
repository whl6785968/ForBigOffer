package LinkedListDemo;

import Structure.ListNode;

public class NC02 {
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode middle = getMiddle(head);

        ListNode right = middle.next;
        middle.next = null;

        right = reverse(right);

        while (right != null){
            ListNode next = right.next;
            right.next = head.next;
            head.next = right;
            head = right.next;
            right = next;
        }
    }

    public ListNode getMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;

        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
