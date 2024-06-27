public class tree222 {
    /*
    * class Solution {
    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     左右循环递归
     最后一定会出现慢二叉树，然后用公式解决！
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}*/
    //采用递归计算
    public int countNodes(TreeNode root) {
        int le=0,ri=0,out=0;
        if(root==null){return out;}
        if(root.left!=null){ le = countNodes(root.left);}
        if(root.right!=null){ ri = countNodes(root.right);}
        out = le+ri+1;
        return out;
    }
}
