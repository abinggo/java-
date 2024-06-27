public class tree100 {
    //参考第101道题，直接一分钟秒杀，采用递归。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){return true;}
        else if(p==null||q==null||p.val!=q.val){return false;}
        else{
            return(isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }

    }
}
