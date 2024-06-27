import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree102_raw {
    //层序遍历有点类似于广度优先遍历
    //关键点借助 队列来实现
    //队列 先进先出 符合广度优先遍历
    //栈 先进后出 符合深度优先遍历
    //这是采用非递归，采用迭代的算法，借助了队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outter = new ArrayList();
        Queue<TreeNode> que = new LinkedList<>();
        if(root==null){return outter;}
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            int len = que.size();
            while(len>0){
                TreeNode cur = que.remove();
                if(cur.left!=null){que.add(cur.left);}
                if(cur.right!=null){que.add(cur.right);}
                inner.add(cur.val);
                len--;
            }
            outter.add(inner);
        }
        return outter;

    }
    //递归的方法
    //记录下每个节点的层数，然后再对应的层数添加进去
    /*
    如果当前还未保存内部数组，则会创建
     public void inorder(TreeNode cur , int depth , List<List<Integer>> outter){
        if(cur == null) {return;}
        depth++;
        if(outter.size()<depth){
            List<Integer> inner = new ArrayList<>();
            outter.add(inner);
        }
        outter.get(depth-1).add(cur.val);
        inorder(cur.left,depth,outter);
        inorder(cur.right,depth,outter);

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outter = new ArrayList<>();
        inorder(root,0,outter);

        return outter;
    }
    * */
}
