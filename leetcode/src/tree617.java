public class tree617 {
    /*
    * 一遍过，采用递归的形式
    * 代码随想录有采用迭代的形式
    * 还是可以理解的，就是比较繁琐一点
    * class Solution {
    // 使用队列迭代
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 ==null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}*/
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if(root1==null&&root2==null){return null;}
        if(root1==null){root=root2;}
        if(root2==null){root=root1;}
        if(root1!=null&&root2!=null){
            root.val=root1.val+root2.val;
            root.left=mergeTrees(root1.left,root2.left);
            root.right=mergeTrees(root1.right,root2.right);
        }
        return root;
    }
}
