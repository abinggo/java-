public class tree104 {
    //求二叉数的最大深度
    /*
    * 与深度相关就采用深度优先遍历
    * 也是是采用递归
    * 递归的话，重点是判断结束条件，还有递归内容
    * 每次返回的都是该节点的最大深度就可以！
    * 递归如果自己递归进去难的，关键是从简单的入手看返回值和逻辑
    * 代码随想录的递归
    * 就直接先求解左子树的最大层数，右子数的最大层数加1
    * 与我们的思路类似
    * public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

*/
    public int deep(TreeNode root, int depth){
        if(root==null){return depth;}
        depth++;
        int le=deep(root.left,depth);
        int ri=deep(root.right,depth);
        if(ri>le){return ri;}
        return le;
    }

    public int maxDepth(TreeNode root) {
        int max=deep(root,0);
        return max;
    }
}
