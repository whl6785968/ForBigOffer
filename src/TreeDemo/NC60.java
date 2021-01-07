package TreeDemo;

import Structure.TreeNode;

public class NC60 {
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if(root == null) return new boolean[]{false,false};
        Info info = judgeInfo(root);
        return new boolean[]{info.isSearch,info.isAll};
    }

    public Info judgeInfo(TreeNode node){
        if(node == null) return new Info(true,true,null,null,null);

        Info leftInfo = judgeInfo(node.left);
        Info rightInfo = judgeInfo(node.right);

        boolean isSearch = leftInfo.isSearch && rightInfo.isSearch;
        boolean isAll = leftInfo.isAll && rightInfo.isAll;

        if(leftInfo.val == null && rightInfo.val != null){
            isAll = false;
        }

        if(leftInfo.val != null){
            isSearch = isSearch && leftInfo.val <= node.val;
            if(leftInfo.rightVal != null){
                isSearch = isSearch && leftInfo.rightVal <= node.val;
            }
        }

        if(rightInfo.val != null){
            isSearch = isSearch && rightInfo.val >= node.val;
            if(rightInfo.leftVal != null){
                isSearch = isSearch && rightInfo.leftVal >= node.val;
            }
        }

        return new Info(isSearch,isAll,node.val,leftInfo.val == null ? null : leftInfo.val,
                rightInfo.val == null ? null : rightInfo.val);
    }

    class Info{
        boolean isSearch;
        boolean isAll;
        Integer val;
        Integer leftVal;
        Integer rightVal;

        public Info(boolean isSearch,boolean isAll,Integer val,Integer leftVal,Integer rightVal){
            this.isSearch = isSearch;
            this.isAll = isAll;
            this.val = val;
            this.leftVal = leftVal;
            this.rightVal = rightVal;
        }
    }
}
