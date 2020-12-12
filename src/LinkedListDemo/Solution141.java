package LinkedListDemo;

import Structure.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean flag = false;
        while(fast != null && fast.next != null){
            if(fast.val == slow.val){
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return flag;
    }
}
