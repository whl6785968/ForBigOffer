package TreeDemo;

import Structure.TreeNode;

public class Solution124 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if(root == null) return 0;

        int gainLeft = Math.max(maxGain(root.left),0);
        int gainRight = Math.max(maxGain(root.right),0);

        int gain = root.val + gainLeft + gainRight;

        maxSum = Math.max(gain,maxSum);

        return root.val + Math.max(gainLeft,gainRight);
    }
}
