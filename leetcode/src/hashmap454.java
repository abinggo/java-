import java.util.HashMap;

public class hashmap454 {
    /*自己写的第一版，看了一会代码随想录的思路
    就是计算两个数组的求和，用哈希表存储值和次数
    这样就可以不断二分下去
    记得最后计算的时候是概率统计中的乘法原则
    但是时间复杂度很高，毕竟下面用了双重循环
     */
    /*官方解答其实思路和自己一样
    只是不用在建立额外的哈希表，而是直接在原有的基础上继续计算是否有，有则扣除
    class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
     */
    public HashMap<Integer,Integer>twosum(int []nums1,int []nums2){
        HashMap<Integer,Integer>site=new HashMap<Integer,Integer>();

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(!site.containsKey(nums1[i]+nums2[j])){
                    site.put(nums1[i]+nums2[j],1);
                }
                else{site.replace(nums1[i]+nums2[j],site.get(nums1[i]+nums2[j])+1);}//学到一个好方法，这个可以用getordefault来决定（site.getordefault(nums1[i]+nums2[j],0）+1
            }
        }

        return site;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer>site1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer>site2=new HashMap<Integer,Integer>();
        site1=twosum(nums1,nums2);
        site2=twosum(nums3,nums4);
        int count=0;
        for(Integer i:site1.keySet()){
            if(site2.containsKey(-i)){count=count+site1.get(i)*site2.get(-i);}
        }
        return count;
    }

}
