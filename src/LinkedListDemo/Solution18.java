package LinkedListDemo;

import Structure.ListNode;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        return recur(head,val);
    }

    public ListNode recur(ListNode head,int val){
        if(head == null){
            return head;
        }

        if(head.val == val){
            return head.next;
        }

        head.next = recur(head.next,val);

        return head;
    }
}
