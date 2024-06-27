
    //采用了上递归
    /*
    我们是采用了前序递归，采用自顶向下递归的话会导致Height被重复利用
    时间复杂度会更高
    采用后序遍历时间复杂度会更低
    * 一个方法递归深度用来判断高度差
    * 一个方法用来判断是否遍历完所有节点*/
    //通过记录访问过的数据置为-1，避免多次重复计算
    /*class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }*/
    public class tree110 {
    public int deep(TreeNode root,int depth){
        if(root==null){return depth;}
        depth++;
        int le = deep(root.left,depth);
        int ri = deep(root.right,depth);
        if(le>ri){return le;}
        return ri;}

    public boolean isBalanced(TreeNode root) {
        if(root==null){return true;}
        else{int le =0,ri = 0;
            le=deep(root.left,1);
            ri = deep(root.right,1);
            if(le-ri>1||ri-le>1){return false;}
        }
        return(isBalanced(root.left)&&isBalanced(root.right));

    }
}
