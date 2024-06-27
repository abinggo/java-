import java.util.HashSet;

public class tree112 {
    //但是事件复杂度有点高，因为每一条都遍历了
//    public void recursive(TreeNode root, int sum, HashSet<Integer> set){
//        sum+=root.val;
//        if(root.left==null&&root.right==null){
//            set.add(sum);
//        }
//        if(root.left!=null){
//            recursive(root.left,sum,set);
//        }
//        if(root.right!=null){
//            recursive(root.right,sum,set);
//        }
//    }
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        //思路：回溯递归求解每条路线的和，然后存储在哈希集合中，然后查找
//        if(root==null){return false;}
//        HashSet<Integer>set = new HashSet<>();
//        recursive(root,0,set);
//        return set.contains(targetSum);
//    }
    //思路二 ： 不用哈希集合 直接判断，找到就停止回溯，节省时间

    private int flag=0;
    public void recursive(TreeNode root, int sum, int target){
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==target){flag=1;return;}
        }
        if(root.left!=null){
            recursive(root.left,sum,target);
        }
        if(root.right!=null){
            recursive(root.right,sum,target);
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //思路：回溯递归求解每条路线的和，然后存储在哈希集合中，然后查找
        if(root==null){return false;}
        recursive(root,0,targetSum);
        if(flag==1){return true;}
        return false;
    }
}
