import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//本题自己采用了 层序遍历的递归方法，记住关键点就是
/*
* 层序遍历的关键就是
* 要记录下层数，当采用递归的时候
* 利用层数来界定条件
* 类似模板
* 就是利用depth来判断执行条件，每一层需要做些什么
* 比如普通的层序遍历就是利用depth来判断是否需要扩容
* 这一题则是判断是否需要写入数据以及是否需要扩容
* 官方有一个非递归题解
* 关键点也是记录一下层的信息，同时按照层序遍历的方式取出每一层的最后一个元素，即可
*  public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

                if (poll.left != null) {
                    que.addLast(poll.left);
                }
                if (poll.right != null) {
                    que.addLast(poll.right);
                }

                if (i == levelSize - 1) {
                    list.add(poll.val);
                }
            }
        }

        return list;
    }
* */
public class tree199 {
public void leverorderright(TreeNode root,List<Integer> list, int depth){
    if(root == null) {return ;}
    depth++;
    if(list.size()<depth)
    {list.add(root.val);}

    if(root.right!=null){
        leverorderright(root.right,list,depth);
    }
    if(root.left!=null){
        leverorderright(root.left,list,depth);
    }
    return ;

}
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null){return list;}
    leverorderright(root,list,0);
    return list;


}}
