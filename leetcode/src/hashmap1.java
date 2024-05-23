import java.util.HashMap;
/*经典的两数之和，但是自己第一次写的很糟糕
运用了哈希表，但是还是迭代容易出问题，特别是【3，3】这种情况
 */
public class hashmap1 {
    public int[] twoSum(int[] nums, int target) {
        int []a=new int[2];
        HashMap<Integer,Integer>site = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(site.containsKey(nums[i])){continue;}
            site.put(nums[i],i);
        }
        for(int i:site.keySet()){
            if(site.containsKey(target-i)){
                a[0]=site.get(i);
                for(int j=a[0]+1;j<nums.length;j++){
                    if(nums[j]==target-i){a[1]=j;return a;}
                }
            }
        }
        return null;
    }
}
/*官方题解
很简单，其实就是自己的思路反过来，我们是先全部插入到哈希表中
而官方是先检查表中是否有正确答案，没有就先将自己插入，这样就不会有一直困扰我的自己匹配自己的问题
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

 */