package TreeDemo;

import Structure.TreeNode;

public class NC58 {
    int[] res = new int[2];
    int pre = Integer.MIN_VALUE;
    public int[] findError (TreeNode root) {
        // write code here
        dfs(root);
        return res;
    }

    public void dfs(TreeNode x){
        if(x == null) return;

        dfs(x.left);

        if(x.val < pre){
            res[0] = x.val;
            res[1] = pre;
        }
        else{
            pre = x.val;
        }

        dfs(x.right);
    }
}
