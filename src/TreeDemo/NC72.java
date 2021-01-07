package TreeDemo;

import Structure.TreeNode;

public class NC72 {
    public void Mirror(TreeNode root) {
        recur(root);
    }

    public TreeNode recur(TreeNode root){
        if(root == null) return null;

        TreeNode left = recur(root.right);
        TreeNode right = recur(root.left);

        root.left = left;
        root.right = right;

        return root;
    }
}
