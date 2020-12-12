package LinkedListDemo;

import Structure.Node;

public class Solution36 {

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        head.left = pre;
        pre.right = head;

        return head;
    }

    public void dfs(Node x){
        if(x == null) return;

        dfs(x.left);

        if(head == null){
            head = x;
        }
        else{
            pre.right = x;
        }

        x.left = pre;
        pre = x;

        dfs(x.right);
    }
}
