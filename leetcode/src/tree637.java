import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
* 递归方法一般代表着深度搜索，为什么呢？
* 递归就是按照同一个顺序不断遍历下去
* 然后中间有记录层级信息
* 广度优先搜索一般代表着着用队列，非递归方法
* 先加同一层的信息
* class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<Double>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}

*/
public class tree637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ave = new ArrayList<>();
        if(root==null){return ave;}
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levellen = que.size();
            int templen = levellen;
            Double sum=0.0;
            while(levellen>0){
                TreeNode temp = que.remove();
                sum+=temp.val;
                if(temp.left!=null){que.add(temp.left);}
                if(temp.right!=null){que.add(temp.right);}
                levellen--;
            }
            sum/=templen;
            ave.add(sum);
        }
        return ave;

    }
}
