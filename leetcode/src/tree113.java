import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//记录几个关键问题
/**
 * 首先，在运用最后out.add(inner)的时候如果此时不新建一个数组保存，那么他做的是引用传动
 * 会随着值的改变而影响
 *   List<Integer> in = new ArrayList<>(inner);
 *   这个可以直接复制！！ 这是ArrayList的构造方法之一
 *                 out.add(in);
 *  所以不能直接out.add(inner)；
 *
 *  第二点，运用ArrayList比用Stack快
 *  但是不太科学，具体可能是leetcode的原因，因为时间复杂度应该是一样的
 *
 */

public class tree113 {
    public void recuesive(TreeNode root, List<Integer>inner, List<List<Integer>> out,int sum,int targetSum){
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==targetSum){
                //问题在这，这里的Out是绑定的
                //ArrayList可以绑定！！直接复制旧的数组
                List<Integer> in = new ArrayList<>(inner);
                out.add(in);
            }
        }
        if(root.left!=null){
            inner.add(root.left.val);
            recuesive(root.left,inner,out,sum,targetSum);
            inner.remove(inner.size()-1);}
        if(root.right!=null){
            inner.add(root.right.val);
            recuesive(root.right,inner,out,sum,targetSum);
            inner.remove(inner.size()-1);

        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> out = new ArrayList<>();
        if(root==null){return out;}
        List<Integer> inner = new Stack<>();
        inner.add(root.val);
        recuesive(root,inner,out,0,targetSum);
        return out;

    }
}
