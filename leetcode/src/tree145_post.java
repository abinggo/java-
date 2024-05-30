import java.util.ArrayList;
import java.util.List;

public class tree145_post {
    //二叉树的后序遍历
    public void postorder(TreeNode root, List<Integer> list){
        if(root==null){return;}
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;

    }
    //二叉树后续遍历非递归
    //与前序递归一样，前序是中左右，后续可以先写成中右左，然后在倒叙输出就是左右中
    /*
    用法记住：
    翻转ArrayList
    Collections.reverse(Arrraylist);
    Collections.reverse()->接收一个List对象
    Collections 类提供了很多静态方法来操作和管理集合。以下是一些常用的 Collections 方法：

sort(List<T> list): 对列表中的元素进行排序。元素的类型需要实现 Comparable 接口。

sort(List<T> list, Comparator<? super T> c): 使用定制的 Comparator 对列表中的元素进行排序。

binarySearch(List<? extends Comparable<? super T>> list, T key): 在已排序的列表中搜索指定的元素。返回搜索结果的索引，如果未找到元素则返回负值。

max(Collection<? extends T> coll): 返回集合中的最大元素。元素的类型需要实现 Comparable 接口。

min(Collection<? extends T> coll): 返回集合中的最小元素。元素的类型需要实现 Comparable 接口。

shuffle(List<?> list): 使用默认的随机源对列表中的元素进行随机排列。

swap(List<?> list, int i, int j): 交换列表中两个指定位置的元素。

fill(List<? super T> list, T obj): 使用指定的元素替换列表中所有的元素。

copy(List<? super T> dest, List<? extends T> src): 将源列表中的所有元素复制到目标列表。如果目标列表的长度小于源列表，会抛出 IndexOutOfBoundsException。

rotate(List<?> list, int distance): 循环移动列表中的元素。元素被向前移动指定的距离（如果距离为负，则向后移动）。
    * public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root==null){return list;}
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode temp = stack.pop();
        list.add(temp.val);
        if(temp.left!=null){
            stack.push(temp.left);
        }
        if(temp.right!=null){
            stack.push(temp.right);
        }
    }
        Collections.reverse(list);
        return list;

    }*/
}
