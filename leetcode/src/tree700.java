import java.util.LinkedList;
import java.util.Queue;
/*
* 一遍过，但是事件复杂度有点高了
* 问题出现在，题目中的树是二叉搜索树！
* 二叉搜索树是一个有序树：
若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
它的左、右子树也分别为二叉搜索树
* 但是应该就是O（N）
*发现是二叉搜索树之后，直接决定采用递归
* 一下子直接解决！
* */
public class tree700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val){return root;}
        else if(root.val<val&&root.right!=null){
            return searchBST(root.right,val);
        }
        else if(root.val>val&&root.left!=null){
            return searchBST(root.left,val);
        }
        else{return null;}
    }
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root==null){return null;}
//        Queue<TreeNode> que = new LinkedList<>();
//        que.add(root);
//        while(!que.isEmpty()){
//            int len = que.size();
//            while(len>0){
//                TreeNode temp = new TreeNode();
//                temp = que.remove();
//                if(temp.val==val){return temp;}
//                if(temp.left!=null){que.add(temp.left);}
//                if(temp.right!=null){que.add(temp.right);}
//                len--;
//            }
//        }
//        return null;
//    }
}
