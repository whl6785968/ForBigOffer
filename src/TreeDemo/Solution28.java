package TreeDemo;

import Structure.TreeNode;

public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode l,TreeNode r){
        if(l == null && r == null) return true;

        if(l.val != r.val) return false;

        return recur(l.left,r.right) && recur(l.right,r.left);
    }
}
