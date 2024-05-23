import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
终于通过了
借鉴三数之和，双重循环下套用双指针
难点在于去重！！！
因为双重循环，相当于两个捆绑在一起，所以要考虑第一个元素的去重和第二个元素的去重
加油！算法思路和代码随想录的一样
 */
public class hashmap18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> outside=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){continue;}//第一个元素的去重
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[i]>0&&nums[i]+nums[j]>target){return outside;}//防止越界
                int left=j+1;
                int right=nums.length-1;
                if(nums[j]==nums[j-1]&&j>1){continue;}//第二个元素的去重
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum<target){left++;}
                    if(sum>target){right--;}
                    if(sum==target){
                        List<Integer>temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        outside.add(temp);
                        while(left<right&&nums[left]==nums[left+1]){left++;}
                        while(left<right&&nums[right]==nums[right-1]){right--;}
                        left++;right--;
                    }
                }
            }

        }
        return outside;
    }
}
