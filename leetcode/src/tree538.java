import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* 这道题感觉很难的。但是还是一次就通过，值得肯定
* 自己的思路是 三步走战略
* 中序排序 求和 更新
* 美中不足的是 时间复杂度有点高
* 现在 开始修改一点
* 首先 求和的时候不用每次都去遍历，可以采用迭代求和法感觉
* 但是问题是从后往前 hhh 但是还是用时很长
*
* 还是代码随想录 聪明
* 二叉搜索树 左中右是递增的
* 然后现在累加是不是要倒序
* 所以就是右中左 遍历 累加就可以了！
* 用一个指针记录前一个的数值就可以，不用太过麻烦
* class Solution {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
*
*
* */
public class tree538 {
    public void midorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        midorder(root.left,list);
        list.add(root.val);
        midorder(root.right,list);
    }
    public int sum(List<Integer> list,int start){
        int out=0;
        for(int i = start;i<list.size();i++){
            out+=list.get(i);
        }
        return out;
    }
    public HashMap<Integer,Integer> helper(List<Integer> list){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),sum(list,i));
        }
        return map;

    }
    /*
    * public HashMap<Integer, Integer> helper(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = list.size()-1; i >= 0; i--) {
            if (i == list.size()-1) {
                map.put(list.get(i), list.get(i));
            } else {
                map.put(list.get(i), map.get(list.get(i + 1)) + list.get(i));
            }

        }
        return map;

    }*/
    public void update(TreeNode root , HashMap<Integer,Integer> map){
        if(root==null){return;}
        root.val = map.get(root.val);
        update(root.left,map);
        update(root.right,map);
    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midorder(root,list);
        HashMap<Integer,Integer> map = helper(list);
        update(root,map);
        return root;
    }
}
