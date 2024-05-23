import java.util.HashMap;

public class hashmap202 {
    /*
    * 自己的思路，先求和然后判断是否为1，不为1一直求和
    * 重点是题目说会无线迭代！！！
    * 无线迭代意味着会出现相同的数字！
    * */
    public int geqiuhe(int num){
        int sum=0;
        while(num!=0){
            int a=0;
            a = num%10;
            num=num/10;
            sum=sum+a*a;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int num=geqiuhe(n);
        if(num==1){return true;}
        HashMap<Integer,Integer> site = new HashMap<Integer,Integer>();
        while(num!=1){
            if(site.containsKey(num)){return false;}
            else{
                site.put(num,1);
                num=geqiuhe(num);
            }
        }
        return true;

    }
}
/*官方有个题解
采用快慢指针算法，会更快！快慢指针要记住
快指针走两次，慢指针走一次
如果两者相遇则说明有循环
然后判断循环是否为1，如果不是则不是快乐数
class Solution {
public:
    int bitSquareSum(int n) {
        int sum = 0;
        while(n > 0)
        {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }while(slow != fast);

        return slow == 1;
    }
};
这是cpp版本
 */
