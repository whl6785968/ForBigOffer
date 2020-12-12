package LinkedListDemo;

import Structure.ListNode;

public class SolutionNC25 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here

        ListNode cur = head;

        while (cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }

    public ListNode recurVersion(ListNode head){
        if(head == null || head.next == null) return head;

        head.next = recurVersion(head.next);
        if(head.val == head.next.val){
            return head.next;
        }
        else {
            return head;
        }
    }

    public static void main(String[] args) {
        SolutionNC25 solutionNC25 = new SolutionNC25();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        ListNode listNode = solutionNC25.deleteDuplicates(head);

    }
}
