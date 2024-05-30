import java.util.ArrayList;
import java.util.List;

public class tree94_mid {
    //二叉树的中序遍历
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){return;}
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;

    }
    //二叉数的中序遍历非递归方法与前后遍历不太一样，原因在于，中序遍历，根结点在中间，先访问后处理，访问顺序和处理顺序不一致
    /*
    * 所以中序遍历会比较复杂
    * 需要借助指针来帮助访问节点
    *public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){return list;}
        TreeNode cur = root;//记录访问的结点的位置
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;//不断往左遍历 左
            }
            else{
                TreeNode temp = stack.pop();  中
                list.add(temp.val);
                cur=temp.right; 右

            }
        }
        return list;
    }
    * 还有另外一种迭代方法可以实现风格统一，但是比较不好理解
    * 但是可以统一代码风格，只需要更改读入的顺序左中右即可
    *关键要记住！递归方法！
    * 非递归方法建议记忆好记的
    * 就是用普通的栈就可以，加一个cur
    * 关键点在于碰到根结点的时候加入一个NULL以作区分
    *public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){return list;}
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp!=null){
                stack.pop();
                if(temp.right!=null){stack.push(temp.right);}
                stack.push(temp);
                stack.push(null);
                if(temp.left!=null){stack.push(temp.left);}
            }
            else{//准备输出，所以碰到空
                stack.pop();
                TreeNode rec = stack.pop();
                list.add(rec.val);
            }
        }
        return list;
    }
    *
    * */
}
