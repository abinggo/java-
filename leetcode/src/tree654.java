import java.util.HashMap;
/*
* 一遍过，但是时间复杂度有点高
* 问题可能出在求最大值这里
* 代码随想录也是这种思路，所以时间复制度不太对
*  public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {// 没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {// 只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }*/
public class tree654 {
    HashMap<Integer,Integer> map;
    public int getmax(int []nums, int begin,int end){
        int max=0;
        for(int i=begin;i<end;i++){
            if(nums[i]>max){max=nums[i];}
        }
        return max;
    }
    public TreeNode helper(int[] nums,HashMap<Integer,Integer>map,int begin,int end){
        TreeNode root = new TreeNode();
        //记住是左闭右开
        if(begin>=end){root=null;return root;}
        int max=getmax(nums,begin,end);
        int temp = map.get(max);//记录下最大值的位置
        root.val = max;
        root.left=helper(nums,map,begin,temp);
        root.right=helper(nums,map,temp+1,end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        return helper(nums,map,0,nums.length);
    }
}
