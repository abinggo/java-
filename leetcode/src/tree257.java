import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/*
* 这题有点难！！！
* 一开始很没思路，参考了代码随想录的思路
*采用前序遍历加回溯
* 记住了递归和回溯是孪生兄弟，在哪里递归就在哪里回溯
* 这是写的比较明显好理解的方法，代码随想录有第二种方法
* 但是写的不太明显 相当于每次传入新的参数用于记录就相当于遍历到的时候 把前面的路径也作为参数传进来了！
* class Solution {
    /**
     * 迭代法
     */
/*public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null)
        return result;
    Stack<Object> stack = new Stack<>();
    // 节点和路径同时入栈
    stack.push(root);
    stack.push(root.val + "");
    while (!stack.isEmpty()) {
        // 节点和路径同时出栈
        String path = (String) stack.pop();
        TreeNode node = (TreeNode) stack.pop();
        // 若找到叶子节点
        if (node.left == null && node.right == null) {
            result.add(path);
        }
        //右子节点不为空
        if (node.right != null) {
            stack.push(node.right);
            stack.push(path + "->" + node.right.val);
        }
        //左子节点不为空
        if (node.left != null) {
            stack.push(node.left);
            stack.push(path + "->" + node.left.val);
        }
    }
    return result;
}
}
精简写法，以参数形式传递下去
class Solution {
private:

    void traversal(TreeNode* cur, string path, vector<string>& result) {
        path += to_string(cur->val); // 中
        if (cur->left == NULL && cur->right == NULL) {
            result.push_back(path);
            return;
        }
        if (cur->left) traversal(cur->left, path + "->", result); // 左
        if (cur->right) traversal(cur->right, path + "->", result); // 右
    }

public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        string path;
        if (root == NULL) return result;
        traversal(root, path, result);
        return result;

    }
};
 */
public class tree257 {
    public void order(TreeNode root,Stack<String> res, List<String> out){
        res.add(Integer.toString(root.val));
        if(root.left==null&&root.right==null){
            //则开始合成路径，这里可以用StringBuilder会更快
            String temp="";
            for(int i=0;i<res.size();i++){
                if(i==res.size()-1){temp+=res.get(i);}
                else{temp+=res.get(i)+"->";}
            }

            out.add(temp);
            return;
        }
        if(root.left!=null){
            order(root.left,res,out);
            res.pop();
        }
        if(root.right!=null){
            order(root.right,res,out);
            res.pop();
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new LinkedList<>();
        if(root==null){return out;}
        Stack<String> res = new Stack<>();
        order(root,res,out);
        return out;

    }
}
