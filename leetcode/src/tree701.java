public class tree701 {
    /*
    * 特别棒，一次过，还战胜100%
    * 自己的思路是不断递归
    * 找到合适的位置直接插进去就行
    *
    * 迭代法：
    * public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
    }
    * */
    public void change(TreeNode root, int val){
        if(val>root.val){
            if(root.right!=null){change(root.right,val);}
            else{root.right=new TreeNode(val);}}
        else {
            if(root.left!=null){change(root.left,val);}
            else{root.left = new TreeNode(val);}
        }}
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){root=new TreeNode(val);return root;}
        change(root,val);


        return root;
    }
}
