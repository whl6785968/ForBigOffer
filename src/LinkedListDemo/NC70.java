package LinkedListDemo;

import Structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NC70 {
    public ListNode sortInList (ListNode head) {
        // write code here

        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        ListNode dummyNode = new ListNode(-1);
        head = new ListNode(list.get(0));
        dummyNode.next = head;

        for(int i = 1;i < list.size();i++){
            ListNode node = new ListNode(list.get(i));
            head.next = node;
            head = node;
        }

        return dummyNode.next;
    }

    public ListNode sortInList2(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(tmp);

        ListNode dummyNode = new ListNode(-1);
        ListNode h = dummyNode;
        while (left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }
            else{
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;

        return dummyNode.next;
    }
}
