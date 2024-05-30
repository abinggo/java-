import org.testng.annotations.Test;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//通过了，但是用时有点久
/*一些学到的语法巩固
！！！采用getOrDefault来解决问题
第二个基础扎实
site.entrySet()会将哈希表转为Map.Entry<Integer,Integer>
new ArrayList<>(site.entrySet()) 这行代码的意思是创建一个新的 ArrayList，
并将 HashMap（在这个例子中是 site）的所有键值对（也就是 entrySet）添加到这个新的 ArrayList 中。
entrySet() 方法返回 Map 的 Set 视图，其中包含了 Map 中的所有键值对。

这种方式的初始化 ArrayList 是一种常见的做法，
它可以让你快速地将一个集合（如 Set 或其他 Collection）的所有元素添加到一个新的 ArrayList 中。
还有几个方法，比如直接将keyset传到list中
Map<String, Integer> map = new HashMap<>();
map.put("One", 1);
map.put("Two", 2);
List<String> list = new ArrayList<>(map.keySet());
还有就是几个方法
Map.Entry.<Integer,Integer>comparingByValue().reversed()按值降序排列
记住中间有个点，说明是在调用方法时需要
* */
/*
代码随想录采用的是优先队列的方式，就是队列中保存着前k个元素，按照最小的在队头会方便一点
PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
解释下这行代码，队列中存储的是一个整数数组！ 后面传入了一个comparator用Lambda形式写的
Lambda 表达式 (pair1, pair2) -> pair1[1] - pair2[1] 是一个 Comparator，它比较两个 int[] 数组 pair1 和 pair2 中索引为 1 的元素的值，返回的结果决定了排序的顺序。
java中的Lambada表达式是一种简洁的表示匿名函数（即没有声明的函数）的方法，它可以用于接口中只有一个抽象方法的情况，
这种接口被称为函数式接口。Lambda 表达式的主要目的是定义在某些上下文中执行的代码。
Lambda 表达式的基本语法是：
(parameters) -> expression

没有参数的表达式：
() -> System.out.println("Hello World")
包含两个参数的表达式：
(int a, int b) -> a * b
对列表的每个元素执行操作：
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(e -> System.out.println(e));


for (var x : map.entrySet()) {
    System.out.println("Key: " + x.getKey() + ", Value: " + x.getValue());
}
var 只能用于方法内部的局部变量。你不能用它来声明类的字段，或者方法的参数。
var 只能用于初始化存在的变量。你不能使用 var 而不初始化变量，因为编译器无法推断出类型。例如，var str; 是不合法的。
var 不能用于 null 初始化的变量，因为编译器无法从 null 推断出类型。例如，var str = null; 是不合法的。
var 不是一个保留字，而是一个保留的类型名。这意味着你可以在旧的代码中使用 var 作为变量名、方法名或者包名，而不会引起错误。但是，为了避免混淆，建议不要这样做。
var 不能用于 lambda 表达式的参数类型。例如，(var x) -> x+1 是不合法的

大顶堆不弹出，小顶堆弹出
class Solution {
    //解法1：基于大顶堆实现
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        //在优先队列中存储二元组(num, cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) { //依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
    //解法2：基于小顶堆实现
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num, cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //小顶堆只需要维持k个元素有序
            if (pq.size() < k) { //小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) { //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll(); //弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
* */
@Test
public class stack347 {
    public void topKFrequent() {
        int [] nums={1,1,1,2,2,3};
        int k=2;
        HashMap<Integer,Integer> site = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            site.put(nums[i],site.getOrDefault(nums[i],0)+1);
        }
        int []out =new int[k];
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(site.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        Iterator<Map.Entry<Integer,Integer>> it = list.iterator();
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=it.next();
            out[i]=entry.getKey();

        }
    }
}
