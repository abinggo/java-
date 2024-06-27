public class tree404 {
    //题目要看清，题目要求的是左叶子，那么什么是左叶子就是关键
    //就是孩子为空，本身不为空
    //自己写的是用 递归
    /*
    官方题解的做法，分三段，判断是否是左叶子，左边需要判断加递归，右边直接递归
    * class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
这个是层序遍历，也是判断是否是叶子节点，再进行操作
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

*/
    public int sunmleft(TreeNode root,int sum){
        if(root==null){return sum;}
        //下面这个很关键，什么时候添加，满足左叶子就添加，不然就直接返回
        if(root.left!=null&&root.left.left==null&&root.left.right==null){sum+=root.left.val;}
        sum=sunmleft(root.left,sum);
        sum=sunmleft(root.right,sum);
        return sum;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        sum=sunmleft(root,sum);
        return sum;
    }

}
