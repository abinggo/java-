import java.util.ArrayList;
import java.util.List;
//二叉树的前序遍历递归方式
public class tree144_pre {

    public void preorder(TreeNode root, List<Integer> list){
        if(root==null){return;}
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;

    }
    //二叉树的非递归方式，运用栈，注意空不入栈！
    /*
    * public List<Integer> preorderTraversal(TreeNode root) {
           Stack<TreeNode> stack = new Stack<>();
           List<Integer> list = new ArrayList<>();
           if(root == null){return list;}
           stack.push(root);
           while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            list.add(temp.val);
            if(temp.right!=null)
            {stack.push(temp.right);}
            if(temp.left!=null)
            {stack.push(temp.left);}
           }
           return list;
    }*/
}
