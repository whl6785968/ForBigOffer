package TreeDemo;

import Structure.TreeNode;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;

        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean recur(TreeNode A,TreeNode B){
        if(B == null) return true;

        if(A != null && A.val != B.val){
            return false;
        }

        return recur(A.left,B.left) && recur(A.right,B.right);

    }
}
