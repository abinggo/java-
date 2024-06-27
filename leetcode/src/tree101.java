import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/*
* 判断是否对称
* 自己采用的是双端队列加普通队列
* 双端队列用来判断是否是对称的，普通队列用来判断是否遍历到了每一个节点
* 感觉时间复杂度和空间复杂度都会比较高
* 代码随想录算法，递归后续遍历
* 判断是否对称，一个是左右中，一个是右左中
* 自己根据它的思路写了一遍
*  public boolean compare(TreeNode left, TreeNode right){
        if(left==null&&right==null){return true;}
        else if(left==null||right==null){return false;}
        else if(left.val!=right.val){return false;}
        else{
            //左子树外侧，右子树内侧，左子树内侧，右子树外侧
            return(compare(left.right,right.left)&&compare(left.left,right.right));
        }
    }
    public boolean isSymmetric(TreeNode root) {
       if(root==null){return false;}
       return compare(root.left,root.right);
    }
* 自己的思路有点死板了，其实不用按照顺序加入队列的，新思路可以按照题目需要加入顺序进行比较
* 所以还是外侧外侧，内侧内侧
*  public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }*/
public class tree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
        {return true;}
        Queue<TreeNode> que = new LinkedList<>();
        Deque<Integer> deq = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            while(!deq.isEmpty()){
                int templeft = deq.removeFirst();
                int tempright = deq.removeLast();
                if(templeft!=tempright){return false;}
            }
            while(len>0){
                TreeNode temp = que.remove();
                if(temp.left!=null){deq.add(temp.left.val);}
                else{deq.add(999);}
                if(temp.right!=null){deq.add(temp.right.val);}
                else{deq.add(999);}
                if(temp.left!=null){que.add(temp.left);}
                if(temp.right!=null){que.add(temp.right);}
                len--;
            }
        }
        return true;

    }
}
