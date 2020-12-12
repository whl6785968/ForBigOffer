package LinkedListDemo;

import Structure.ListNode;

import java.util.List;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2){
            n1 = headA == null ? headB : headA.next;
            n2 = headB == null ? headA : headB.next;
        }

        return n1;
    }
}
