public class tree669 {
    /*
    * 不要忘记函数的返回值是根结点！！！
    * 这就是关键
    * 也是采用递归，符合就保留，不符合就剔除
    * //iteration
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        while(root != null && (root.val < low || root.val > high)){
            if(root.val < low)
                root = root.right;
            else
                root = root.left;
        }

        TreeNode curr = root;

        //deal with root's left sub-tree, and deal with the value smaller than low.
        while(curr != null){
            while(curr.left != null && curr.left.val < low){
                curr.left = curr.left.right;
            }
            curr = curr.left;
        }
        //go back to root;
        curr = root;

        //deal with root's righg sub-tree, and deal with the value bigger than high.
        while(curr != null){
            while(curr.right != null && curr.right.val > high){
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }
        return root;
    }
    * 这是java的迭代法，看一遍也能够顺过去，只是没怎么想的到*/
    public TreeNode trimBST(TreeNode root, int low, int high) {

            if (root == null) {
                return root;
            }
            if (root.val <= high && root.val >= low) {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
            } else if (root.val > high) {
                root = root.left;
                trimBST(root, low, high);
            } else if (root.val < low) {
                root = root.right;
                trimBST(root, low, high);
            }
            return root;
        }
    }

