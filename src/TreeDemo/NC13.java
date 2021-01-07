package TreeDemo;

import Structure.TreeNode;

public class NC13 {

    int maxDepth = 0;

    public int maxDepth (TreeNode root) {
        // write code here
        recur(root,1);
        return maxDepth;
    }

    public void recur(TreeNode root,int depth){
        if(root == null){
            maxDepth = Math.max(maxDepth,depth - 1);
            return;
        }

        recur(root.left,depth + 1);
        recur(root.right,depth + 1);

    }
}
