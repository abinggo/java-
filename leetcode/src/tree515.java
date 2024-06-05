import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){return list;}
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levellen = que.size();
            int max = que.peek().val;
            while(levellen>0){
                TreeNode temp = que.remove();
                if(temp.val>max){max=temp.val;}
                if(temp.left!=null){que.add(temp.left);}
                if(temp.right!=null){que.add(temp.right);}
                levellen--;
            }
            list.add(max);
        }
        return list;
    }
}
