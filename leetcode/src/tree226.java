import java.util.LinkedList;
import java.util.Queue;
//自己主要卡在处理最后那两个节点上，就是有一个非空，一个有空那种特殊情况
/*
* 递归DFS
*  /**
 * 前后序遍历都可以
 * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
 *

public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    invertTree(root.left);
    invertTree(root.right);
    swapChildren(root);
    return root;
}

private void swapChildren(TreeNode root) {
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
}
/**
     * 层序遍历方式反转
     */
//不用写狠多没用的递归，直接遍历左边右边入队列就行
//public TreeNode invertTreeByQueue(TreeNode root) {
//    if (root == null) {
//        return null;
//    }
//    Queue<TreeNode> queue = new ArrayDeque<>();
//    queue.offer(root);
//    while (!queue.isEmpty()) {
//        TreeNode node = queue.poll();
//        TreeNode temp = node.left;
//        node.left = node.right;
//        node.right = temp;
//        if (node.left != null) {
//            queue.offer(node.left);
//        }
//        if (node.right != null) {
//            queue.offer(node.right);
//        }
//    }
//    return root;
//}



public class tree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){return root;}
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            while(len>0){
                TreeNode temproot = que.remove();

                if(temproot.left!=null&&temproot.right!=null)
                {TreeNode temp = temproot.left;
                    temproot.left = temproot.right;
                    temproot.right = temp;
                    que.add(temproot.left);
                    que.add(temproot.right);}
                if(temproot.left!=null&&temproot.right==null){
                    temproot.right=temproot.left;
                    temproot.left=null;
                    que.add(temproot.right);
                    len--;continue;
                }
                if(temproot.left==null&&temproot.right!=null){
                    temproot.left=temproot.right;
                    temproot.right=null;
                    que.add(temproot.left);
                    len--;
                    continue;
                }
                len--;
            }

        }

        return root;
    }
}
