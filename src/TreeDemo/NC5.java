package TreeDemo;

import Structure.ListNode;
import Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NC5 {

    List<Integer> list;

    public int sumNumbers (TreeNode root) {
        // write code here
        list = new ArrayList<>();

        int res = 0;

        recur("",root);

        for(int num : list){
            res += num;
        }

        return res;
    }

    public void recur(String cur,TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            list.add(Integer.valueOf(cur + root.val));
            return;
        }

        recur(cur + root.val,root.left);
        recur(cur + root.val,root.right);
    }

    public static void main(String[] args) {
        NC5 nc5 = new NC5();
        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(0);
        int i = nc5.sumNumbers(root);
        System.out.println(i);
    }
}
