import java.util.LinkedList;
import java.util.Queue;
//本题采用了层次遍历思想，只要保存每一层的最左边这个，然后不断替换就可以
/*
* class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) q.add(node.right);
            if (node.left != null)  q.add(node.left);
        }
        return node.val;
    }
}

题解思路差不多，就是只用单层循环就可以，先添加每一层的右儿子，再添加左儿子
* 这样最后一个剩下的就是最底层的左儿子*/
public class tree513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int out=0;
        while(!que.isEmpty()){
            int len = que.size();
            out = que.peek().val;
            while(len>0){
                TreeNode temp = que.remove();
                if(temp.left!=null){que.add(temp.left);}
                if(temp.right!=null){que.add(temp.right);}
                len--;
            }
        }
        return out;
    }
}
