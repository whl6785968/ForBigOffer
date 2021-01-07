package TreeDemo;

import Structure.TreeNode;

public class Solution62 {
    boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return false;
        recur(root);
        return flag;
    }

    public int recur(TreeNode x){
        if(x == null) return 0;

        int left = 1;
        int right = 1;

        left += recur(x.left);
        right += recur(x.right);

        if(Math.abs(left - right) > 1){
            flag = false;
        }

        return Math.max(left,right);
    }
}
