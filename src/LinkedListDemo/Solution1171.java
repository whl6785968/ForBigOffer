package LinkedListDemo;

import Structure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer,ListNode> map = new HashMap<>();

        int sum = 0;
        for(ListNode d = dummy;d != null;d = d.next){
            sum += d.val;
            map.put(sum,d);
        }

        sum = 0;
        for(ListNode d = dummy;d != null;d = d.next){
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution1171 solution1171 = new Solution1171();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode listNode = solution1171.removeZeroSumSublists(head);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
