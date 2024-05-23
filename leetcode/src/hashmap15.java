import java.lang.reflect.Array;
import java.util.*;

//三指针法虽然能够正常运行，但是还是会超出限制，我猜测问题出在Arraylist的contains中
//所以没有调用contains，去重逻辑思考，如果第二个元素与第一个相同，则跳过，记住是判断【i-1】与i，
//因为如果判断后面的话，那-1 -1 2就没了，还有就是左边和右边如果相同则跳过


public class hashmap15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tites=new ArrayList<>();
        List<Integer> n=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            n.add(nums[i]);
        }
        Collections.sort(n);

        for(int i=0;i<n.size()-2;i++){
            if(i>0&& (n.get(i)==n.get(i - 1))){continue;}
            int left=i+1;
            int right=n.size()-1;
            while(left<right){
                List<Integer> ins = new ArrayList<>();
                int sum=n.get(i)+n.get(left)+n.get(right);
                if(sum==0){
                    ins.add(n.get(i));ins.add(n.get(left));ins.add(n.get(right));
                    //if(!tites.contains(ins)){tites.add(ins);}
                    tites.add(ins);
                    while(right>left&&(n.get(left)==n.get(left+1))){left++;}
                    while(right>left&&(n.get(right)==n.get(right-1))){right--;}
                    left++;
                    }
                if(sum>0){right--;}
                if(sum<0){left++;}
            }
        }
        return tites;
    }
}
/*
 * class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
	// 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
	    // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
		    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
 */