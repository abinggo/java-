import java.util.LinkedList;
import java.util.Queue;
//第一版 超时了
//第二版 还是超时了
public class stack239 {
    public int max(Queue<Integer> i){
        int max=i.peek();
        for(Integer o:i){
            if(o>max){max=o;}
        }
        return max;
    }
    public int[] maxSlidingWindowv1(int[] nums, int k) {
        int[] outs=new int[nums.length-k+1];
        Queue<Integer> record=new LinkedList<>();
        int i=0;
        int temp=0;
        for(;i<k;i++){
            record.add(nums[i]);

        }
        outs[temp]=max(record);
        temp++;
        for(;i<nums.length;i++){
            record.remove();
            record.add(nums[i]);
            outs[temp]=max(record);
            temp++;
        }

        return outs;
    }
    public int[] maxSlidingWindowv2(int[] nums, int k) {
        int[] outs=new int[nums.length-k+1];
        Queue<Integer> record=new LinkedList<>();
        int i=0;
        int temp=0;
        if(k==1){return nums;}
        for(;i<k;i++){
            record.add(nums[i]);
        }
        outs[temp]=max(record);
        temp++;
        for(;i<nums.length;i++){
            int del=record.remove();
            record.add(nums[i]);
            if(outs[temp-1]==del){
                outs[temp]=max(record);temp++;
            }
            else if(nums[i]>outs[temp-1]){outs[temp]=nums[i];temp++;}
            else{
                outs[temp]=outs[temp-1];temp++;
            }

        }

        return outs;
    }
}
