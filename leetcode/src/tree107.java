import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//就普通的翻转就行，采用递归
//4, 5, 6, 7]
//[2, 3]
//[1]
//这样叫做层序遍历 同一层在一起
public class tree107 {
    public void leverorder(TreeNode root , int depth , List<List<Integer>> outer){
        if(root==null){return;}
        depth++;
        if(outer.size()<depth){
            List<Integer> inner = new ArrayList<>();
            outer.add(inner);
        }
        outer.get(depth-1).add(root.val);
        leverorder(root.left, depth , outer);
        leverorder(root.right, depth , outer);


    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        leverorder(root,0,outer);
        Collections.reverse(outer);
        return outer;
    }
}
