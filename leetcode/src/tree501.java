import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
* 几个问题：
* 第一，复杂度相当的高
* 第二，map.getOrDefault(key,0)这个忘记了
* 第三,map.keySet（），前面的k是小写
* 第四，Queue转数组转的是对象数组，就是Integer,String等
* 转为我们需要的数组还需要一步循环
* 或者这样
* 在Java中，list.stream().mapToInt(Integer::intValue).toArray()的确可以将一个包含Integer的List直接转换为一个int数组，但不能直接转为Integer数组。
* 要将List<Integer>转换为Integer[]，可以使用toArray方法并传入一个类型为Integer的数组。
*  int[] o = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            o[i] = integerArray[i];
        }
影响时间复杂度的几个问题，首先中序递归后的种种操作太冗余了，第二如何有效的寻找众数，也是关键
* java用map统计频率，把频率排个序，最后取前面高频的元素的集合。
*  Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 将频率Map转换为列表并排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 降序排序

        // 取出高频元素的集合
        int topN = 3; // 取前N个高频元素
        Set<Integer> topFrequencyElements = new HashSet<>();
        for (int i = 0; i < Math.min(topN, entryList.size()); i++) {
            topFrequencyElements.add(entryList.get(i).getKey());
        }
        * Lambda表达式：

(a, b) -> b.getValue().compareTo(a.getValue())
* 记忆：a,b 如果按照ab顺序就是从小到大，按照ba就是倒叙从大到小
这里的a和b是Map.Entry<Integer, Integer>类型的元素。
getValue()方法返回该条目的值，即频率。
compareTo方法：
b.getValue().compareTo(a.getValue()) 调用的是Integer类的compareTo方法。
compareTo方法返回一个整数，表示调用对象与传入对象的比较结果：
如果调用对象小于传入对象，返回负值。
如果调用对象等于传入对象，返回零。
如果调用对象大于传入对象，返回正值。
排序逻辑：

在排序过程中，sort方法会使用比较器来确定元素的顺序。
由于我们在比较器中写的是 b.getValue().compareTo(a.getValue())，这意味着：
如果b的值大于a的值，compareTo返回正值，因此b会排在a的前面。
反之，如果b的值小于a的值，compareTo返回负值，因此a会排在b的前面。
因此，列表按频率从高到低排序，即降序排序。
*
*
* 但这是普通做法，还是没有考虑到有序这个关键信息
* 统计前面节点的信息！会更快速
* class Solution {
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;

        findMode1(root.right);
    }
}
* */
public class tree501 {
    public void middorder(TreeNode root, LinkedList<TreeNode> list){
        if(root==null){return;}
        if(root.left!=null){middorder(root.left,list);}
        list.add(root);
        if(root.right!=null){middorder(root.right,list);}
    }
    public int[] findMode(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        middorder(root,list);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            int temp = list.get(i).val;
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        Queue<Integer> out = new LinkedList<>();
        //keySet key是小谢
        for(Integer i:map.keySet()){
            if(out.isEmpty()){out.add(i);}
            else{
                while(map.get(i)>map.get(out.peek())){
                    out.remove();
                    if(out.isEmpty()){out.add(i);break;}
                }
                if(map.get(i)==map.get(out.peek())&&i!=out.peek()){
                    out.add(i);
                }

            }
        }
        // 将队列转换为Integer数组
        Integer[] integerArray = out.toArray(new Integer[0]);

        // 将Integer数组转换为int数组
        int[] o = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            o[i] = integerArray[i];
        }
        return o;
    }
}
