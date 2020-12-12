package TreeDemo;

import Structure.TreeNode;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;

        return recur(root);
    }

    public TreeNode recur(TreeNode x){
        if(x == null) return null;

        TreeNode left = recur(x.right);
        TreeNode right = recur(x.left);

        x.left = left;
        x.right = right;

        return x;
    }
}
