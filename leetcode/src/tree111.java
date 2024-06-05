public class tree111 {
    //这个也是普通递归重点在于，控制输出
    //就是会出现几种异常情况，就是单列子树的问题
    /*
    * class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
*/
    public int minDepth(TreeNode root) {
        if(root==null){return 0;}
        int le = minDepth(root.left);
        int ri = minDepth(root.right);
        if(ri==0){return le+1;}
        if(le==0||ri<le){return ri+1;}
        return le+1;
    }
}
