import java.util.HashMap;

public class hashmap349 {
    /*自己的思路，感觉很冗长
    将最长的数组转为哈希表
    然后 用短的数组去迭代找出相同的1元素
    用另一个哈希表存储
    在将哈希表转为数组输出

     */
    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> site = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> tite =new HashMap<Integer, Integer>();
        int max=nums2.length;
        int min=nums1.length;
        int flag=0;
        if(nums1.length>nums2.length){max=nums1.length;flag=1;min=nums2.length;}
        for(int i=0;i<max;i++){
            if(flag==0){
                if(site.containsKey(nums2[i])){site.replace(nums2[i],site.get(nums2[i])+1);}
                else{site.put(nums2[i],1);}
            }
            else{if(site.containsKey(nums1[i])){site.replace(nums1[i],site.get(nums1[i])+1);}
            else{site.put(nums1[i],1);}}
        }

        for(int i=0;i<min;i++){
            if(flag==0){
                if(site.containsKey(nums1[i])&&!tite.containsKey(nums1[i])){tite.put(nums1[i],1);}
            }
            else{
                if(site.containsKey(nums2[i])&&!tite.containsKey(nums2[i])){tite.put(nums2[i],1);}
            }
        }
        int []a=new int[tite.size()];
        int count=0;
        for (Integer i : tite.keySet()) {
            a[count]=i;
            count++;
        }

        return a;
    }

}
/*官方题解的算法
用哈希集合，大体思路和自己的一样，只是它使用了哈希集合
哈希集合，该集合中不存在相同的元素
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }
}

 */
