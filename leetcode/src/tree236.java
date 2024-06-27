import java.util.HashMap;
/*
* 自己写的但是超时了
* 递归中序遍历，而且其实每次都创建，有点浪费，不需要每次都中序遍历
* 自己的思路是中序遍历，判断位置
* 所以一次创建，次次查询就OK了，通过了
* 代码随想录是采用后序遍历，自底向上，然后递归回溯
* 看下它的图会很好理解
* class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
}
*
* */
public class tree236 {
    private int flag=0;
    HashMap<Integer,Integer> midmap = new HashMap<>();
    public void midorder(TreeNode root, HashMap<Integer,Integer>midmap){
        if(root==null){return;}
        midorder(root.left,midmap);
        midmap.put(root.val,flag);
        flag++;
        midorder(root.right,midmap);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(flag==0){midorder(root,midmap);}
        int roottemp = midmap.get(root.val);
        int ptemp = midmap.get(p.val);
        int qtemp = midmap.get(q.val);
        if((ptemp<=roottemp&&qtemp>=roottemp)||((ptemp>=roottemp)&&(qtemp<=roottemp))){return root;}
        else if(ptemp<roottemp&&qtemp<roottemp){
            return lowestCommonAncestor(root.left,p,q);}
        else{return lowestCommonAncestor(root.right,p,q);}

    }

}
