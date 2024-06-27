import java.util.ArrayList;
import java.util.List;

public class tree98 {
    /*
    * 出现了一个问题，就是越级bug
    * 递归只能满足前两层符合条件，没办法管到第三层
    * 自己想了另外一个方法，引用额外的空间来存储节点值
    * 很冗长，因为每个后面的节点都要判断
    * 写的很乱，很糟糕，有点难度
    * 不用列表，给一个范围试试
    * 思路错了！！！
    * 中序遍历：左中右，符合搜索二叉树的条件，如果中序遍历是递增的就是搜索二叉树！
    *  */
    //思路被带偏了，中序遍历下的集合，如果是递增的就可以满足！！！
    /*
    * 设置边界的递归
    *  public boolean isValidBST(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }
    * // 简洁实现·中序遍历 记住左中右 最先访问最小的！！！
class Solution {
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= prev) { // 不满足二叉搜索树条件
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
    * */
    public void midorder(TreeNode root , List<Integer> list){
        if(root.left!=null){midorder(root.left,list);}
        list.add(root.val);
        if(root.right!=null){midorder(root.right,list);}
    }
    public boolean judge(List<Integer> list){
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){return false;}
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){return false;}
        List<Integer> list = new ArrayList<>();
        midorder(root,list);
        return judge(list);
    }
//    public boolean judge(int val, List<Integer> temp, int flag) {
//        if (flag == 0) {
//            for (Integer i : temp) {
//                if (val <= i) {
//                    return false;
//                }
//            }
//        }
//        if (flag == 1) {
//            for (Integer i : temp) {
//                if (val >= i) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//
//    public boolean helper(TreeNode root, List<Integer> temp, int flag) {
//
//        temp.add(root.val);
//        if (root.left == null && root.right != null) {
//            if (root.right.val <= root.val) {
//                return false;
//            } else if (!judge(root.right.val, temp, flag)) {
//                return false;
//            } else {
//                return helper(root.right, temp, flag);
//            }
//        }
//        else if(root.right==null&&root.left!=null)
//
//        {
//            if (root.left.val >= root.val) {
//                return false;
//            } else if (!judge(root.left.val, temp, flag)) {
//                return false;
//            } else
//                return helper(root.left, temp, flag);
//        }else if(root.left!=null&&root.right!=null)
//        {
//            if (root.left.val >= root.val || root.right.val <= root.val) {
//                return false;
//            } else
//                return (helper(root.left, temp, flag) && helper(root.right, temp, flag));
//        }else return true;
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        boolean le = true;
//        boolean ri = true;
//        if (root.left != null) {
//            List<Integer> left = new ArrayList<>();
//            le = helper(root.left, left,0);
//            if(!judge(root.val,left,0)){return false;}
//
//        }
//        if (root.right != null) {
//            List<Integer> right = new ArrayList<>();
//            ri = helper(root.right, right,1);
//            if(!judge(root.val,right,1)){return false;}
//
//        }
//
//        return ri && le;
//    }
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){return false;}
//        else if(root.left==null&&root.right!=null){
//            if(root.right.val<=root.val){return false;}
//            else return isValidBST(root.right);
//        }
//        else if(root.right==null&&root.left!=null){
//            if(root.left.val>=root.val){return false;}
//            else return isValidBST(root.left);
//        }
//        else if(root.left!=null&&root.right!=null){
//            if(root.left.val>=root.val||root.right.val<=root.val){return false;}
//            else return (isValidBST(root.left)&&isValidBST(root.right));
//        }
//        else return true;
//    }
}
