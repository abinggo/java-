public class tree530 {
    /*
    * 一开始还是没通过，因为没有考虑到越级问题
    * 关于搜索二叉树一定要注意！！！
    * 想到搜索二叉树一定要首先关注中序遍历
    * 因为它是递增的顺序，然后就可以设置全局变量来访问了*/
    private int min = Integer.MAX_VALUE;
    private TreeNode prev=null;
    public void minmi(TreeNode root){
        if(root==null){return;}
        if(root.left!=null){
            minmi(root.left);
        }
        if(prev!=null){min=Math.min(min,Math.abs(root.val-prev.val));}
        prev=root;
        if(root.right!=null){
            minmi(root.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        TreeNode prev = null;
        minmi(root);
        return min;
    }
}
