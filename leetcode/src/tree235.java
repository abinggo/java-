import java.util.HashMap;

public class tree235 {
    /*
    * 时间复杂度还是有点高，其实大致思路很对，但是有一些步骤多余了，就是中序遍历和建立哈希表
    * 因为直接用值去替代就可以了，不用取数组的位置，还是没有充分利用二叉搜索树的特点
    * 二叉搜索树，中序遍历递增同时，递增的是值！！！
    * */
    /*
    直接搞定！！！
    *  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if((p.val<=root.val&&q.val>=root.val)||(p.val>=root.val&&q.val<=root.val)){
            return root;
        }
        else if(p.val<root.val&&q.val<root.val){return lowestCommonAncestor(root.left,p,q);}
        else return lowestCommonAncestor(root.right,p,q);
    }*/

    private int flag=0;
    public void midorder(TreeNode root, HashMap<Integer,Integer> map){
        if(root==null){return;}
        midorder(root.left,map);
        map.put(root.val,flag);
        flag++;
        midorder(root.right,map);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer,Integer> map = new HashMap<>();
        midorder(root,map);
        int roottemp = map.get(root.val);
        int ptemp = map.get(p.val);
        int qtemp = map.get(q.val);
        if((ptemp<=roottemp&&qtemp>=roottemp)||(ptemp>=roottemp&&qtemp<=roottemp)){
            return root;
        }
        else if(ptemp<roottemp&&qtemp<roottemp){return lowestCommonAncestor(root.left,p,q);}
        else return lowestCommonAncestor(root.right,p,q);
    }
}
