package LinkedListDemo;

import Structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution06 {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;

        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        List<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(head.val);
            head = head.next;
        }

        int[] arr = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            arr[i] = list.get(i);
        }

        return arr;
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null){
            stack.push(head.val);
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            arr[i++] = stack.pop();
        }

        return arr;
    }
}
