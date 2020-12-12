package LinkedListDemo;

import Structure.ListNode;

public class Solution0204 {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        head = head.next;

        //3-5-8-5-10-2-1
        while (head != null){
            if(head.val < x){
                pre.next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = pre.next;
            }
            else{
                pre = pre.next;
                head = head.next;
            }

        }

        return dummy.next;
    }

    public void show(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution0204 solution0204 = new Solution0204();
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        ListNode partition = solution0204.partition(head, 5);

        solution0204.show(partition);
    }
}
